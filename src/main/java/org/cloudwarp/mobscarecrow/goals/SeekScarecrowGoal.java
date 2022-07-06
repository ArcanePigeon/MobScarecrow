package org.cloudwarp.mobscarecrow.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.NoPenaltyTargeting;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
import net.minecraft.entity.ai.goal.TrackTargetGoal;

import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;
import org.cloudwarp.mobscarecrow.utils.ScarecrowAccess;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Optional;

public class SeekScarecrowGoal extends Goal{
	private PathAwareEntity mob;
	private Optional<LivingEntity> target;
	private static final int MIN_WAITING_TIME = 1200;
	private static final int MAX_TRYING_TIME = 1200;
	private static final int MIN_INTERVAL = 200;
	public final double speed;
	protected int cooldown;
	protected int tryingTime;
	private int safeWaitingTime;
	protected BlockPos targetPos = BlockPos.ORIGIN;
	private boolean reached;
	private final int range = 24;
	private final int maxYDifference = 5;
	protected int lowestY = 0;

	public SeekScarecrowGoal (LivingEntity mob) {
		if(! (mob instanceof PathAwareEntity)){
			this.mob = null;
		}else{
			this.mob = (PathAwareEntity) mob;
		}
		this.speed = 1D;
		this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.JUMP));
	}

	@Override
	public boolean shouldContinue() {
		return this.tryingTime >= -this.safeWaitingTime && this.tryingTime <= 1200 && this.target.isPresent();
	}

	@Override
	public boolean canStart () {
		if(this.mob == null){
			return false;
		}
		checkForScarecrow();
		if (this.cooldown > 0) {
			--this.cooldown;
			return false;
		}
		this.cooldown = this.getInterval(this.mob);
		if(this.target.isEmpty()){
			return false;
		}
		this.targetPos = target.get().getBlockPos();
		return true;
	}
	protected int getInterval(PathAwareEntity mob) {
		return MoveToTargetPosGoal.toGoalTicks(200 + mob.getRandom().nextInt(200));
	}

	private void checkForScarecrow () {
		target = Optional.empty();
		for(Iterator<SmallPlushieEntity> i = ((ScarecrowAccess)this.mob).getAttractiveScarecrows().iterator(); i.hasNext();){
			SmallPlushieEntity scarecrow = i.next();
			double dist = scarecrow.getBlockPos().getSquaredDistance(this.mob.getPos());
			if(dist > MathHelper.square(MobScarecrow.mobScarecrowRadius + 8D) || scarecrow.isRemoved()){
				i.remove();
			}else if((target.isEmpty() || dist < target.get().getBlockPos().getSquaredDistance(this.mob.getPos())) && dist < MathHelper.square(MobScarecrow.mobScarecrowRadius)){
				target = Optional.of(scarecrow);
			}
		}
	}

	@Override
	public void start () {
		this.startMovingToTarget();
		this.tryingTime = 0;
		this.safeWaitingTime = this.mob.getRandom().nextInt(this.mob.getRandom().nextInt(1200) + 1200) + 1200;
	}
	protected void startMovingToTarget() {
		this.mob.getNavigation().startMovingTo((double)this.targetPos.getX() + 0.5, this.targetPos.getY() + 1, (double)this.targetPos.getZ() + 0.5, this.speed);
	}

	public double getDesiredDistanceToTarget() {
		return 1.0;
	}

	protected BlockPos getTargetPos() {
		return this.targetPos.up();
	}

	@Override
	public boolean shouldRunEveryTick() {
		return true;
	}

	@Override
	public void tick() {
		BlockPos blockPos = this.getTargetPos();
		if (!blockPos.isWithinDistance(this.mob.getPos(), this.getDesiredDistanceToTarget())) {
			this.reached = false;
			++this.tryingTime;
			if (this.shouldResetPath()) {
				this.mob.getNavigation().startMovingTo((double)blockPos.getX() + 0.5, blockPos.getY(), (double)blockPos.getZ() + 0.5, this.speed);
			}
		} else {
			this.reached = true;
			--this.tryingTime;
		}
	}

	public boolean shouldResetPath() {
		return this.tryingTime % 40 == 0;
	}

	protected boolean hasReached() {
		return this.reached;
	}

}

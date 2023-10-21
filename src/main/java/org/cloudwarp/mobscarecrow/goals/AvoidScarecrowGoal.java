package org.cloudwarp.mobscarecrow.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.NoPenaltyTargeting;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;
import org.cloudwarp.mobscarecrow.utils.ScarecrowAccess;

import java.util.Iterator;
import java.util.Optional;

public class AvoidScarecrowGoal extends Goal {
	private LivingEntity entity;
	private float speed = 1.5F;
	/** The PathEntity of our entity */
	private Path path;
	/** The PathNavigate of our entity */
	private EntityNavigation navigation;
	private PathAwareEntity pathEntity;
	private boolean pathable = false;
	private Optional<BlockPos> pos;
	protected int cooldown;
	private int pathTimeLimiter;
	private int scarecrowCheckLimiter;

	public AvoidScarecrowGoal (LivingEntity e) {
		entity = e;
		if (entity instanceof PathAwareEntity) {
			pathable = true;
			pathEntity = (PathAwareEntity) entity;
			navigation = pathEntity.getNavigation();
		}
	}

	@Override
	public boolean shouldContinue () {
		return ! path.isFinished() && pathTimeLimiter > 0;
	}

	@Override
	public boolean canStart () {
		if (this.cooldown > 0) {
			-- this.cooldown;
			return false;
		}
		checkForScarecrow();
		this.cooldown = toGoalTicks(10);
		if (pos.isPresent() && pathable) {
			return generatePath();
		}

		return false;
	}

	private void checkForScarecrow () {
		pos = Optional.empty();
		for(Iterator<SmallPlushieEntity> i = ((ScarecrowAccess)entity).getScaryScarecrows().iterator(); i.hasNext();){
			SmallPlushieEntity scarecrow = i.next();
			double dist = scarecrow.getBlockPos().getSquaredDistance(entity.getPos());
			if(dist > MathHelper.square(MobScarecrow.mobScarecrowRadius + 8D) || scarecrow.isRemoved()){
				i.remove();
			}else if((pos.isEmpty() || dist < pos.get().getSquaredDistance(entity.getPos())) && dist < MathHelper.square(MobScarecrow.mobScarecrowRadius)){
				pos = Optional.of(scarecrow.getBlockPos());
			}
		}
	}

	private boolean generatePath () {
		Vec3d scarecrowPos = new Vec3d(pos.get().getX(), pos.get().getY(), pos.get().getZ());
		for (int i = 0; i < 10; i++) {
			Vec3d newPos = NoPenaltyTargeting.findFrom(pathEntity, 8, 6, scarecrowPos);
			if (newPos == null) {
				continue;
			}
			if (newPos.squaredDistanceTo(scarecrowPos) < entity.squaredDistanceTo(scarecrowPos)) {
				continue;
			}

			path = navigation.findPathTo(new BlockPos(new Vec3i((int)newPos.getX(),(int)newPos.getY(), (int)newPos.getZ())), 0);
			if (path != null) {
				pathTimeLimiter = 5;
				return true;
			}
		}
		return false;
	}

	@Override
	public void start () {
		navigation.startMovingAlong(path, speed);
	}

	@Override
	public void tick () {
		pathTimeLimiter = Math.max(pathTimeLimiter - 1, 0);
	}
}

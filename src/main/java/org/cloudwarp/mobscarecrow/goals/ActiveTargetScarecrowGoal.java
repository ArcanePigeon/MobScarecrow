package org.cloudwarp.mobscarecrow.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;
import org.cloudwarp.mobscarecrow.utils.ScarecrowAccess;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Optional;

public class ActiveTargetScarecrowGoal extends TrackTargetGoal {

	protected final int reciprocalChance;
	@Nullable
	protected LivingEntity targetEntity;

	public ActiveTargetScarecrowGoal (MobEntity mob, boolean checkVisibility) {
		super(mob, checkVisibility);
		this.reciprocalChance = ActiveTargetGoal.toGoalTicks(10);
		this.setControls(EnumSet.of(Goal.Control.TARGET));
	}

	@Override
	public boolean canStart() {
		if (this.reciprocalChance > 0 && this.mob.getRandom().nextInt(this.reciprocalChance) != 0) {
			return false;
		}
		this.checkForScarecrow();
		return this.target != null;
	}

	private void checkForScarecrow () {
		target = null;
		for(Iterator<SmallPlushieEntity> i = ((ScarecrowAccess)this.mob).getAttractiveScarecrows().iterator(); i.hasNext();){
			SmallPlushieEntity scarecrow = i.next();
			double dist = scarecrow.getBlockPos().getSquaredDistance(this.mob.getPos());
			if(dist > MathHelper.square(MobScarecrow.mobScarecrowRadius + 8D) || scarecrow.isRemoved()){
				i.remove();
			}else if((target == null || dist < target.getBlockPos().getSquaredDistance(this.mob.getPos())) && dist < MathHelper.square(MobScarecrow.mobScarecrowRadius)){
				target = scarecrow;
			}
		}
	}

	@Override
	public void start() {
		this.mob.setTarget(this.targetEntity);
		super.start();
	}
}

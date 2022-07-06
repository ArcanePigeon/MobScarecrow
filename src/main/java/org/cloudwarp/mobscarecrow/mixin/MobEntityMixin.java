package org.cloudwarp.mobscarecrow.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.cloudwarp.mobscarecrow.goals.ActiveTargetScarecrowGoal;
import org.cloudwarp.mobscarecrow.goals.AvoidScarecrowGoal;
import org.cloudwarp.mobscarecrow.goals.SeekScarecrowGoal;
import org.cloudwarp.mobscarecrow.registry.MSEntityTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {

	@Shadow
	protected GoalSelector goalSelector;

	@Shadow
	protected GoalSelector targetSelector;

	@Shadow
	protected MoveControl moveControl;


	protected MobEntityMixin (EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(at = @At("TAIL"), method = "<init>")
	private void MobEntity (EntityType<? extends MobEntity> entityType, World world, CallbackInfo ci) {
		if (this.getBrain().getMemories().isEmpty()) {
			if (entityType == EntityType.SLIME || entityType == EntityType.MAGMA_CUBE) {
				this.targetSelector.add(3, new ActiveTargetScarecrowGoal((MobEntity) (Object) this, false));
			} else {
				this.goalSelector.add(0, new AvoidScarecrowGoal(this));
				this.goalSelector.add(0, new SeekScarecrowGoal(this));
			}
		}
	}
}

package org.cloudwarp.mobscarecrow.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.world.World;
import org.cloudwarp.mobscarecrow.goals.AvoidScarecrowGoal;
import org.cloudwarp.mobscarecrow.goals.SeekScarecrowGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VindicatorEntity.class)
public class VindicatorEntityMixin extends MobEntity {

	protected VindicatorEntityMixin (EntityType<? extends MobEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(at = @At("HEAD"), method = "initGoals()V")
	private void mixinInitGoals (CallbackInfo ci) {
		this.goalSelector.add(0, new AvoidScarecrowGoal((VindicatorEntity) (Object) this));
		this.goalSelector.add(0, new SeekScarecrowGoal((VindicatorEntity) (Object) this));
	}
}

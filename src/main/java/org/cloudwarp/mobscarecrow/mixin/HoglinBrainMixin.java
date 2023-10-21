package org.cloudwarp.mobscarecrow.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.*;
import net.minecraft.entity.mob.HoglinBrain;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.cloudwarp.mobscarecrow.goals.GoToNearbyScarecrowTask;
import org.cloudwarp.mobscarecrow.registry.MSMemoryModules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(HoglinBrain.class)
public class HoglinBrainMixin {

	@Inject(at = @At("HEAD"), method = "addFightTasks(Lnet/minecraft/entity/ai/brain/Brain;)V")
	private static void addFightTasks (Brain<HoglinEntity> brain, CallbackInfo ci) {
		brain.setTaskList(Activity.FIGHT, 10, ImmutableList.<Task<? super HoglinEntity>>of(
						PacifyTask.create(MSMemoryModules.SCARECROW, 200)),
				MemoryModuleType.ATTACK_TARGET);
	}

	@Inject(at = @At("HEAD"), method = "addIdleTasks(Lnet/minecraft/entity/ai/brain/Brain;)V")
	private static void addIdleTasks (Brain<HoglinEntity> brain, CallbackInfo ci) {
		brain.setTaskList(Activity.IDLE, 10, ImmutableList.<Task<? super HoglinEntity>>of(
				PacifyTask.create(MSMemoryModules.SCARECROW, 200),
				GoToRememberedPositionTask.createPosBased(MSMemoryModules.SCARECROW, 1.0f, 8, true), new GoToNearbyScarecrowTask(MSMemoryModules.ATTRACTIVE_SCARECROW, 0.8f, 1, 10)
				));
	}


}

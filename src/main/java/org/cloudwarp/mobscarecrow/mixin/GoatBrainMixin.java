package org.cloudwarp.mobscarecrow.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.GoToRememberedPositionTask;
import net.minecraft.entity.ai.brain.task.PacifyTask;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.passive.GoatBrain;
import net.minecraft.entity.passive.GoatEntity;
import org.cloudwarp.mobscarecrow.goals.GoToNearbyScarecrowTask;
import org.cloudwarp.mobscarecrow.registry.MSMemoryModules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GoatBrain.class)

public class GoatBrainMixin {

	@Inject(at = @At("HEAD"), method = "addIdleActivities(Lnet/minecraft/entity/ai/brain/Brain;)V")
	private static void addIdleActivities (Brain<GoatEntity> brain, CallbackInfo ci) {
		brain.setTaskList(Activity.IDLE, 10, ImmutableList.<Task<? super GoatEntity>>of(
				new PacifyTask(MSMemoryModules.SCARECROW, 200),
				GoToRememberedPositionTask.toBlock(MSMemoryModules.SCARECROW, 1.0f, 8, true), new GoToNearbyScarecrowTask(MSMemoryModules.ATTRACTIVE_SCARECROW, 0.8f, 1, 10)
		));
	}

}

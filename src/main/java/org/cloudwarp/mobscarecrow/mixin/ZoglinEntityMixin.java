package org.cloudwarp.mobscarecrow.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.ai.brain.task.GoToRememberedPositionTask;
import net.minecraft.entity.ai.brain.task.PacifyTask;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.mob.ZoglinEntity;
import org.cloudwarp.mobscarecrow.registry.MSMemoryModules;
import org.cloudwarp.mobscarecrow.registry.MSSensors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZoglinEntity.class)
public class ZoglinEntityMixin {

	@Shadow
	protected static ImmutableList<SensorType<? extends Sensor<? super HoglinEntity>>> USED_SENSORS;


	@Shadow
	protected static ImmutableList<MemoryModuleType<?>> USED_MEMORY_MODULES;


	static {
		USED_SENSORS = ImmutableList.<SensorType<? extends Sensor<? super HoglinEntity>>>builder().addAll(USED_SENSORS).add(MSSensors.SCARECROW_SENSOR).build();
		USED_MEMORY_MODULES = ImmutableList.<MemoryModuleType<?>>builder().addAll(USED_MEMORY_MODULES).add(MSMemoryModules.SCARECROW).build();
	}

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
				GoToRememberedPositionTask.createPosBased(MSMemoryModules.SCARECROW, 1.0f, 8, true)
		));
	}
}

package org.cloudwarp.mobscarecrow.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.entity.mob.PiglinEntity;
import org.cloudwarp.mobscarecrow.registry.MSMemoryModules;
import org.cloudwarp.mobscarecrow.registry.MSSensors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PiglinBruteEntity.class)
public class PiglinBruteEntityMixin {

	@Shadow
	protected static ImmutableList<SensorType<? extends Sensor<? super PiglinBruteEntity>>> SENSOR_TYPES;


	@Shadow
	protected static ImmutableList<MemoryModuleType<?>> MEMORY_MODULE_TYPES;

	static {
		SENSOR_TYPES = ImmutableList.<SensorType<? extends Sensor<? super PiglinBruteEntity>>>builder().addAll(SENSOR_TYPES).add(MSSensors.SCARECROW_SENSOR, MSSensors.ATTRACTIVE_SCARECROW_SENSOR).build();
		MEMORY_MODULE_TYPES = ImmutableList.<MemoryModuleType<?>>builder().addAll(MEMORY_MODULE_TYPES).add(MSMemoryModules.SCARECROW, MSMemoryModules.ATTRACTIVE_SCARECROW).build();
	}
}

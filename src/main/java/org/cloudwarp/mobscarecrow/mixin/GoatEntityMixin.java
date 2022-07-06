package org.cloudwarp.mobscarecrow.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.entity.passive.VillagerEntity;
import org.cloudwarp.mobscarecrow.registry.MSMemoryModules;
import org.cloudwarp.mobscarecrow.registry.MSSensors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GoatEntity.class)
public class GoatEntityMixin {
	@Shadow
	private static ImmutableList<SensorType<? extends Sensor<? super GoatEntity>>> SENSORS;


	@Shadow
	private static ImmutableList<MemoryModuleType<?>> MEMORY_MODULES;

	static {
		SENSORS = ImmutableList.<SensorType<? extends Sensor<? super GoatEntity>>>builder().addAll(SENSORS).add(MSSensors.SCARECROW_SENSOR,MSSensors.ATTRACTIVE_SCARECROW_SENSOR).build();
		MEMORY_MODULES = ImmutableList.<MemoryModuleType<?>>builder().addAll(MEMORY_MODULES).add(MSMemoryModules.SCARECROW,MSMemoryModules.ATTRACTIVE_SCARECROW).build();
	}
}

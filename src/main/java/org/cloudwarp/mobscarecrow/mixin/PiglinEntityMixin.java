package org.cloudwarp.mobscarecrow.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.cloudwarp.mobscarecrow.registry.MSMemoryModules;
import org.cloudwarp.mobscarecrow.registry.MSSensors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(PiglinEntity.class)
public class PiglinEntityMixin {

	@Shadow
	protected static ImmutableList<SensorType<? extends Sensor<? super PiglinEntity>>> SENSOR_TYPES;


	@Shadow
	protected static ImmutableList<MemoryModuleType<?>> MEMORY_MODULE_TYPES;

	static {
		SENSOR_TYPES = ImmutableList.<SensorType<? extends Sensor<? super PiglinEntity>>>builder().addAll(SENSOR_TYPES).add(MSSensors.SCARECROW_SENSOR, MSSensors.ATTRACTIVE_SCARECROW_SENSOR).build();
		MEMORY_MODULE_TYPES = ImmutableList.<MemoryModuleType<?>>builder().addAll(MEMORY_MODULE_TYPES).add(MSMemoryModules.SCARECROW, MSMemoryModules.ATTRACTIVE_SCARECROW).build();
	}
}

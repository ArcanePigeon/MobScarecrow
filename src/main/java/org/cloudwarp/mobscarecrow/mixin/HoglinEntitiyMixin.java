package org.cloudwarp.mobscarecrow.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.cloudwarp.mobscarecrow.registry.MSMemoryModules;
import org.cloudwarp.mobscarecrow.registry.MSSensors;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(HoglinEntity.class)
public class HoglinEntitiyMixin extends AnimalEntity {


	@Shadow
	protected static ImmutableList<SensorType<? extends Sensor<? super HoglinEntity>>> SENSOR_TYPES;


	@Shadow
	protected static ImmutableList<MemoryModuleType<?>> MEMORY_MODULE_TYPES;


	protected HoglinEntitiyMixin (EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(at = @At("RETURN"), method = "getPathfindingFavor(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/WorldView;)F", cancellable = true)
	public void getPathfindingFavor (BlockPos pos, WorldView world, CallbackInfoReturnable<Float> cir) {
		Optional<BlockPos> optional = this.getBrain().getOptionalMemory(MSMemoryModules.SCARECROW);
		cir.setReturnValue((optional.isPresent() && optional.get().isWithinDistance(pos, 8D)) ? - 1.0f : cir.getReturnValueF());
	}

	public PassiveEntity createChild (ServerWorld world, PassiveEntity entity) {
		return null;
	}
	static {
		SENSOR_TYPES = ImmutableList.<SensorType<? extends Sensor<? super HoglinEntity>>>builder().addAll(SENSOR_TYPES).add(MSSensors.SCARECROW_SENSOR, MSSensors.ATTRACTIVE_SCARECROW_SENSOR).build();
		MEMORY_MODULE_TYPES = ImmutableList.<MemoryModuleType<?>>builder().addAll(MEMORY_MODULE_TYPES).add(MSMemoryModules.SCARECROW, MSMemoryModules.ATTRACTIVE_SCARECROW).build();
	}
}

package org.cloudwarp.mobscarecrow.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.PanicTask;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.passive.VillagerEntity;
import org.cloudwarp.mobscarecrow.registry.MSMemoryModules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(PanicTask.class)
public class PanicTaskMixin extends Task<VillagerEntity> {
	public PanicTaskMixin (Map<MemoryModuleType<?>, MemoryModuleState> requiredMemoryState) {
		super(requiredMemoryState);
	}

	@Inject(at = @At("RETURN"), method = "isHostileNearby(Lnet/minecraft/entity/LivingEntity;)Z", cancellable = true)
	private static void isHostileNearby (LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(cir.getReturnValueZ() || PanicTaskMixin.isScarecrowNearby(entity));
	}

	private static boolean isScarecrowNearby(LivingEntity entity) {
		return entity.getBrain().hasMemoryModule(MSMemoryModules.SCARECROW);
	}
}

package org.cloudwarp.mobscarecrow.mixin;

import net.minecraft.entity.ai.brain.MemoryModuleType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MemoryModuleType.class)
public interface MemoryModuleTypeAccessor<U> {

	@Invoker
	static <U> MemoryModuleType<U> invokeRegister(String id) {
		throw new AssertionError();
	}

}

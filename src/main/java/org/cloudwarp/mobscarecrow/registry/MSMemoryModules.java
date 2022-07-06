package org.cloudwarp.mobscarecrow.registry;

import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.util.math.BlockPos;
import org.cloudwarp.mobscarecrow.mixin.MemoryModuleTypeAccessor;

public class MSMemoryModules  {
	public static final MemoryModuleType<BlockPos> SCARECROW = MemoryModuleTypeAccessor.invokeRegister("mobscarecrow:scarecrow_memory");
	public static final MemoryModuleType<BlockPos> ATTRACTIVE_SCARECROW = MemoryModuleTypeAccessor.invokeRegister("mobscarecrow:attractive_scarecrow_memory");

	public static void init(){

	}

}

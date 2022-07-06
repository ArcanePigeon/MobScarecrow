package org.cloudwarp.mobscarecrow.goals;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.WalkTarget;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.dynamic.GlobalPos;
import net.minecraft.util.math.BlockPos;

import java.util.Optional;

public class GoToNearbyScarecrowTask extends Task<PathAwareEntity> {
	private final MemoryModuleType<BlockPos> memoryModuleType;
	private final int completionRange;
	private final int maxDistance;
	private final float walkSpeed;
	private long nextRunTime;

	public GoToNearbyScarecrowTask(MemoryModuleType<BlockPos> memoryModuleType, float walkSpeed, int completionRange, int maxDistance) {
		super(ImmutableMap.of(MemoryModuleType.WALK_TARGET, MemoryModuleState.REGISTERED, memoryModuleType, MemoryModuleState.VALUE_PRESENT));
		this.memoryModuleType = memoryModuleType;
		this.walkSpeed = walkSpeed;
		this.completionRange = completionRange;
		this.maxDistance = maxDistance;
	}

	@Override
	protected boolean shouldRun(ServerWorld serverWorld, PathAwareEntity pathAwareEntity) {
		Optional<BlockPos> optional = pathAwareEntity.getBrain().getOptionalMemory(this.memoryModuleType);
		return optional.isPresent() && optional.get().isWithinDistance(pathAwareEntity.getPos(), (double)this.maxDistance);
	}

	@Override
	protected void run(ServerWorld serverWorld, PathAwareEntity pathAwareEntity, long l) {
		if (l > this.nextRunTime) {
			Brain<?> brain = pathAwareEntity.getBrain();
			Optional<BlockPos> optional = brain.getOptionalMemory(this.memoryModuleType);
			optional.ifPresent(blockPos -> brain.remember(MemoryModuleType.WALK_TARGET, new WalkTarget(blockPos, this.walkSpeed, this.completionRange)));
			this.nextRunTime = l + 30L;
		}
	}
}


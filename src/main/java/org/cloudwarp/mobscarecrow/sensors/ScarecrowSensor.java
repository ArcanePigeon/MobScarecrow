package org.cloudwarp.mobscarecrow.sensors;

import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;
import org.cloudwarp.mobscarecrow.registry.MSMemoryModules;
import org.cloudwarp.mobscarecrow.utils.ScarecrowAccess;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class ScarecrowSensor extends Sensor<LivingEntity> {

	@Override
	protected void sense(ServerWorld world, LivingEntity entity) {
		Brain<?> brain = entity.getBrain();
		brain.remember(MSMemoryModules.SCARECROW, findScarecrow(world, entity));
	}
	// Put all sensors in here for each type of scare for each list

	@Override
	public Set<MemoryModuleType<?>> getOutputMemoryModules() {
		return ImmutableSet.of(MSMemoryModules.SCARECROW);
	}

	private Optional<BlockPos> findScarecrow(ServerWorld world, LivingEntity entity) {
		Optional<BlockPos> pos = Optional.empty();
		for(Iterator<SmallPlushieEntity> i = ((ScarecrowAccess)entity).getScaryScarecrows().iterator(); i.hasNext();){
			SmallPlushieEntity scarecrow = i.next();
			double dist = scarecrow.getBlockPos().getSquaredDistance(entity.getPos());
			if(dist > MathHelper.square(16D) || scarecrow.isRemoved()){
				i.remove();
			}else if((pos.isEmpty() || dist < pos.get().getSquaredDistance(entity.getPos())) && dist < MathHelper.square(8D)){
				pos = Optional.of(scarecrow.getBlockPos());
			}
		}

		return pos;
	}

}

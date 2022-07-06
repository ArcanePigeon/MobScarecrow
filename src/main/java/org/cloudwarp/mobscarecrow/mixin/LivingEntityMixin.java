package org.cloudwarp.mobscarecrow.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;
import org.cloudwarp.mobscarecrow.utils.ScarecrowAccess;
import org.spongepowered.asm.mixin.Mixin;

import java.util.HashSet;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements ScarecrowAccess {

	private HashSet<SmallPlushieEntity> scary_scarecrows = new HashSet<SmallPlushieEntity>();
	private HashSet<SmallPlushieEntity> attractive_scarecrows = new HashSet<SmallPlushieEntity>();


	public LivingEntityMixin (EntityType<?> type, World world) {
		super(type, world);
	}

	@Override
	public void addScarecrow(SmallPlushieEntity scarecrow, HashSet<SmallPlushieEntity> list){
		list.add(scarecrow);
	}

	@Override
	public HashSet<SmallPlushieEntity> getScaryScarecrows (){
		return this.scary_scarecrows;
	}

	@Override
	public HashSet<SmallPlushieEntity> getAttractiveScarecrows (){
		return this.attractive_scarecrows;
	}

	@Override
	public void removeScarecrow(SmallPlushieEntity scarecrow, HashSet<SmallPlushieEntity> list){
		list.remove(scarecrow);
	}

}

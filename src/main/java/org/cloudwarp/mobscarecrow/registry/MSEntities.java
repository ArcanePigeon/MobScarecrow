package org.cloudwarp.mobscarecrow.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.cloudwarp.mobscarecrow.entities.MSEntityTypes;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class MSEntities {
	public static final EntityType<SmallPlushieEntity> CAT_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.CAT_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.CAT_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.CAT_PLUSHIE.width, MSEntityTypes.CAT_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> PILLAGER_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.PILLAGER_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.PILLAGER_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.PILLAGER_PLUSHIE.width, MSEntityTypes.PILLAGER_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> STEVE_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.STEVE_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.STEVE_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.STEVE_PLUSHIE.width, MSEntityTypes.STEVE_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> VILLAGER_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.VILLAGER_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.VILLAGER_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.VILLAGER_PLUSHIE.width, MSEntityTypes.VILLAGER_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> WOLF_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.WOLF_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.WOLF_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.WOLF_PLUSHIE.width, MSEntityTypes.WOLF_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> ZOMBIE_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.ZOMBIE_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.ZOMBIE_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.ZOMBIE_PLUSHIE.width, MSEntityTypes.ZOMBIE_PLUSHIE.height)).build()
	);
	//--------
	public static final EntityType<SmallPlushieEntity> AXOLOTL_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.AXOLOTL_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.AXOLOTL_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.AXOLOTL_PLUSHIE.width, MSEntityTypes.AXOLOTL_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> CHICKEN_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.CHICKEN_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.CHICKEN_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.CHICKEN_PLUSHIE.width, MSEntityTypes.CHICKEN_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> COPPER_GOLEM_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.COPPER_GOLEM_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.COPPER_GOLEM_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.COPPER_GOLEM_PLUSHIE.width, MSEntityTypes.COPPER_GOLEM_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> DEFAULT_SCARECROW = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.DEFAULT_SCARECROW.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.DEFAULT_SCARECROW);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.DEFAULT_SCARECROW.width, MSEntityTypes.DEFAULT_SCARECROW.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> GOLD_PIG_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.GOLD_PIG_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.GOLD_PIG_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.GOLD_PIG_PLUSHIE.width, MSEntityTypes.GOLD_PIG_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> PIGEON_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.PIGEON_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.PIGEON_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.PIGEON_PLUSHIE.width, MSEntityTypes.PIGEON_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> PIGLIN_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.PIGLIN_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.PIGLIN_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.PIGLIN_PLUSHIE.width, MSEntityTypes.PIGLIN_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> RABBIT_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.RABBIT_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.RABBIT_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.RABBIT_PLUSHIE.width, MSEntityTypes.RABBIT_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> SNOW_GOLEM_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.SNOW_GOLEM_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.SNOW_GOLEM_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.SNOW_GOLEM_PLUSHIE.width, MSEntityTypes.SNOW_GOLEM_PLUSHIE.height)).build()
	);
	public static final EntityType<SmallPlushieEntity> ZOMBIFIED_PIGLIN_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.ZOMBIFIED_PIGLIN_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.ZOMBIFIED_PIGLIN_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.ZOMBIFIED_PIGLIN_PLUSHIE.width, MSEntityTypes.ZOMBIFIED_PIGLIN_PLUSHIE.height)).build()
	);

	public static final EntityType<SmallPlushieEntity> IRON_GOLEM_PLUSHIE = Registry.register(
			Registries.ENTITY_TYPE,
			MSEntityTypes.IRON_GOLEM_PLUSHIE.identifier,
			FabricEntityTypeBuilder.<SmallPlushieEntity>create(SpawnGroup.MISC,
							((entityType, world) -> {
								return new SmallPlushieEntity((EntityType<? extends SmallPlushieEntity>) entityType,world,MSEntityTypes.IRON_GOLEM_PLUSHIE);
							}))
					.dimensions(EntityDimensions.fixed(MSEntityTypes.IRON_GOLEM_PLUSHIE.width, MSEntityTypes.IRON_GOLEM_PLUSHIE.height)).build()
	);

	public static void init(){
		FabricDefaultAttributeRegistry.register(CAT_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(PILLAGER_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(STEVE_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(VILLAGER_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(WOLF_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(ZOMBIE_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(AXOLOTL_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(CHICKEN_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(COPPER_GOLEM_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(DEFAULT_SCARECROW, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(GOLD_PIG_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(PIGEON_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(PIGLIN_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(RABBIT_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(SNOW_GOLEM_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(ZOMBIFIED_PIGLIN_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
		FabricDefaultAttributeRegistry.register(IRON_GOLEM_PLUSHIE, SmallPlushieEntity.createLivingAttributes());
	}
}

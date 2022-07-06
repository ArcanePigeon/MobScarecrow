package org.cloudwarp.mobscarecrow.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.registry.MSEntities;
import org.cloudwarp.mobscarecrow.utils.ScarecrowAffectTargets;

import java.util.ArrayList;

public enum MSEntityTypes {
	CAT_PLUSHIE(0.8f,0.8f, MobScarecrow.id("cat_plushie"), "cat_plushie"),
	PILLAGER_PLUSHIE(0.8f,0.8f, MobScarecrow.id("pillager_plushie"), "pillager_plushie"),
	STEVE_PLUSHIE(0.8f,0.8f, MobScarecrow.id("steve_plushie"), "steve_plushie"),
	VILLAGER_PLUSHIE(0.8f,0.8f, MobScarecrow.id("villager_plushie"), "villager_plushie"),
	WOLF_PLUSHIE(0.8f,0.8f, MobScarecrow.id("wolf_plushie"), "wolf_plushie"),
	IRON_GOLEM_PLUSHIE(0.8f,0.8f, MobScarecrow.id("iron_golem_plushie"), "iron_golem_plushie"),
	PIGEON_PLUSHIE(0.8f,0.8f, MobScarecrow.id("pigeon_plushie"), "pigeon_plushie"),
	SNOW_GOLEM_PLUSHIE(0.8f,0.8f, MobScarecrow.id("snow_golem_plushie"), "snow_golem_plushie"),
	AXOLOTL_PLUSHIE(0.8f,0.8f, MobScarecrow.id("axolotl_plushie"), "axolotl_plushie"),
	COPPER_GOLEM_PLUSHIE(0.8f,0.8f, MobScarecrow.id("copper_golem_plushie"), "copper_golem_plushie"),
	ZOMBIFIED_PIGLIN_PLUSHIE(0.8f,0.8f, MobScarecrow.id("zombified_piglin_plushie"), "zombified_piglin_plushie"),
	PIGLIN_PLUSHIE(0.8f,0.8f, MobScarecrow.id("piglin_plushie"), "piglin_plushie"),
	GOLD_PIG_PLUSHIE(0.8f,0.8f, MobScarecrow.id("gold_pig_plushie"), "gold_pig_plushie"),
	CHICKEN_PLUSHIE(0.8f,0.8f, MobScarecrow.id("chicken_plushie"), "chicken_plushie"),
	ZOMBIE_PLUSHIE(0.8f,0.8f, MobScarecrow.id("zombie_plushie"), "zombie_plushie"),
	DEFAULT_SCARECROW(0.8f,1.8f, MobScarecrow.id("default_scarecrow"), "default_scarecrow"),
	RABBIT_PLUSHIE(0.8f,0.8f, MobScarecrow.id("rabbit_plushie"), "rabbit_plushie");

	public final float width;
	public final float height;
	public final Identifier identifier;
	public final String id;

	MSEntityTypes(float width, float height, Identifier identifier, String id){
		this.width = width;
		this.height = height;
		this.identifier = identifier;
		this.id = id;
	}

	public EntityType<? extends SmallPlushieEntity> getEntityType(){
		return switch (this){
			case CAT_PLUSHIE -> MSEntities.CAT_PLUSHIE;
			case PILLAGER_PLUSHIE -> MSEntities.PILLAGER_PLUSHIE;
			case STEVE_PLUSHIE -> MSEntities.STEVE_PLUSHIE;
			case VILLAGER_PLUSHIE -> MSEntities.VILLAGER_PLUSHIE;
			case WOLF_PLUSHIE -> MSEntities.WOLF_PLUSHIE;
			case ZOMBIE_PLUSHIE -> MSEntities.ZOMBIE_PLUSHIE;
			case AXOLOTL_PLUSHIE -> MSEntities.AXOLOTL_PLUSHIE;
			case CHICKEN_PLUSHIE -> MSEntities.CHICKEN_PLUSHIE;
			case COPPER_GOLEM_PLUSHIE -> MSEntities.COPPER_GOLEM_PLUSHIE;
			case DEFAULT_SCARECROW -> MSEntities.DEFAULT_SCARECROW;
			case GOLD_PIG_PLUSHIE -> MSEntities.GOLD_PIG_PLUSHIE;
			case IRON_GOLEM_PLUSHIE -> MSEntities.IRON_GOLEM_PLUSHIE;
			case PIGEON_PLUSHIE -> MSEntities.PIGEON_PLUSHIE;
			case PIGLIN_PLUSHIE -> MSEntities.PIGLIN_PLUSHIE;
			case RABBIT_PLUSHIE -> MSEntities.RABBIT_PLUSHIE;
			case SNOW_GOLEM_PLUSHIE -> MSEntities.SNOW_GOLEM_PLUSHIE;
			case ZOMBIFIED_PIGLIN_PLUSHIE -> MSEntities.ZOMBIFIED_PIGLIN_PLUSHIE;
			default -> MSEntities.CAT_PLUSHIE;
		};
	}

	public ArrayList<Class<? extends LivingEntity>> getScaredEntities(){
		return switch (this){
			case CAT_PLUSHIE -> ScarecrowAffectTargets.catPlushieScares;
			case PILLAGER_PLUSHIE -> ScarecrowAffectTargets.pillagerPlushieScares;
			case IRON_GOLEM_PLUSHIE -> ScarecrowAffectTargets.ironGolemPlushieScares;
			case PIGEON_PLUSHIE -> ScarecrowAffectTargets.pigeonPlushieScares;
			case SNOW_GOLEM_PLUSHIE -> ScarecrowAffectTargets.snowGolemPlushieScares;
			case AXOLOTL_PLUSHIE -> ScarecrowAffectTargets.axolotlPlushieScares;
			case WOLF_PLUSHIE -> ScarecrowAffectTargets.wolfPlushieScares;
			case ZOMBIFIED_PIGLIN_PLUSHIE -> ScarecrowAffectTargets.zombifiedPiglinPlushieScares;
			case CHICKEN_PLUSHIE -> ScarecrowAffectTargets.chickenPlushieScares;
			case PIGLIN_PLUSHIE -> ScarecrowAffectTargets.piglinPlushieScares;
			case ZOMBIE_PLUSHIE -> ScarecrowAffectTargets.zombiePlushieScares;
			case RABBIT_PLUSHIE -> ScarecrowAffectTargets.rabbitPlushieScares;
			case DEFAULT_SCARECROW -> ScarecrowAffectTargets.defaultScarecrowScares;
			default -> new ArrayList<Class<? extends LivingEntity>>();
		};
	}

	public ArrayList<Class<? extends LivingEntity>> getAttractedEntities(){
		return switch (this){
			case IRON_GOLEM_PLUSHIE -> ScarecrowAffectTargets.ironGolemPlushieAttracts;
			case STEVE_PLUSHIE -> ScarecrowAffectTargets.stevePlushieAttracts;
			case VILLAGER_PLUSHIE -> ScarecrowAffectTargets.villagerPlushieAttracts;
			case COPPER_GOLEM_PLUSHIE -> ScarecrowAffectTargets.copperGolemPlushieAttracts;
			case GOLD_PIG_PLUSHIE -> ScarecrowAffectTargets.goldPigPlushieAttracts;
			default -> new ArrayList<Class<? extends LivingEntity>>();
		};
	}
}

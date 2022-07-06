package org.cloudwarp.mobscarecrow.utils;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.VillagerEntity;

import java.util.ArrayList;
import java.util.Arrays;

public class ScarecrowAffectTargets {
	public static ArrayList<Class<? extends LivingEntity>> catPlushieScares = new ArrayList<>(Arrays.asList(CreeperEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> pillagerPlushieScares = new ArrayList<>(Arrays.asList(AnimalEntity.class, VillagerEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> ironGolemPlushieScares = new ArrayList<>(Arrays.asList(ZombieEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> ironGolemPlushieAttracts = new ArrayList<>(Arrays.asList(SlimeEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> pigeonPlushieScares = new ArrayList<>(Arrays.asList(SpiderEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> snowGolemPlushieScares = new ArrayList<>(Arrays.asList(BlazeEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> axolotlPlushieScares = new ArrayList<>(Arrays.asList(EndermanEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> stevePlushieAttracts = new ArrayList<>(Arrays.asList(HostileEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> villagerPlushieAttracts = new ArrayList<>(Arrays.asList(AnimalEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> copperGolemPlushieAttracts = new ArrayList<>(Arrays.asList(VillagerEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> wolfPlushieScares = new ArrayList<>(Arrays.asList(SkeletonEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> zombifiedPiglinPlushieScares = new ArrayList<>(Arrays.asList(PiglinEntity.class, ZoglinEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> goldPigPlushieAttracts = new ArrayList<>(Arrays.asList(PiglinEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> chickenPlushieScares = new ArrayList<>(Arrays.asList(SilverfishEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> piglinPlushieScares = new ArrayList<>(Arrays.asList(HoglinEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> zombiePlushieScares = new ArrayList<>(Arrays.asList(RabbitEntity.class, VillagerEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> defaultScarecrowScares = new ArrayList<>(Arrays.asList(HostileEntity.class));
	public static ArrayList<Class<? extends LivingEntity>> rabbitPlushieScares = new ArrayList<>(Arrays.asList(RavagerEntity.class));
}

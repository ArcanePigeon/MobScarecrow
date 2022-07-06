package org.cloudwarp.mobscarecrow.registry;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.impl.datagen.FabricTagBuilder;
import net.minecraft.data.server.AbstractTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.tag.EntityTypeTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import org.cloudwarp.mobscarecrow.MobScarecrow;


public class MSEntityTags {
	public static TagKey<EntityType<?>> JUMPERS = TagKey.of(Registry.ENTITY_TYPE_KEY, MobScarecrow.id("jumpers"));
	public static void init(){
	}
}

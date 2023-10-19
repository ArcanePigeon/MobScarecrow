package org.cloudwarp.mobscarecrow.registry;

import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import org.cloudwarp.mobscarecrow.MobScarecrow;


public class MSEntityTags {
	public static TagKey<EntityType<?>> JUMPERS = TagKey.of(RegistryKeys.ENTITY_TYPE, MobScarecrow.id("jumpers"));
	public static void init(){
	}
}

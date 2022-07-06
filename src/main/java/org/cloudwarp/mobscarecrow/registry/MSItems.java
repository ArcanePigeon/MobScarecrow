package org.cloudwarp.mobscarecrow.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.cloudwarp.mobscarecrow.blockdetails.ScarecrowItem;
import org.cloudwarp.mobscarecrow.entities.MSEntityTypes;

import java.util.HashMap;

public class MSItems {
	public static final ItemGroup MOB_SCARECROW_GROUP = FabricItemGroupBuilder.create(
					new Identifier("mobscarecrow", "general"))
			.icon(() -> new ItemStack(get("default_scarecrow")))
			.build();
	private static final HashMap<String, Item> ITEMS = new HashMap<>();

	private static void registerItem (String id, Item item) {
		ITEMS.put(id, Registry.register(Registry.ITEM, "mobscarecrow:" + id, item));
	}

	public static void registerItems () {
		if (! ITEMS.isEmpty()) {
			return;
		}
		registerItem("cat_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.CAT_PLUSHIE));
		registerItem("pillager_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.PILLAGER_PLUSHIE));
		registerItem("steve_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.STEVE_PLUSHIE));
		registerItem("villager_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.VILLAGER_PLUSHIE));
		registerItem("wolf_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.WOLF_PLUSHIE));
		registerItem("zombie_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.ZOMBIE_PLUSHIE));
		registerItem("axolotl_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.AXOLOTL_PLUSHIE));
		registerItem("chicken_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.CHICKEN_PLUSHIE));
		registerItem("copper_golem_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.COPPER_GOLEM_PLUSHIE));
		registerItem("default_scarecrow", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.DEFAULT_SCARECROW));
		registerItem("gold_pig_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.GOLD_PIG_PLUSHIE));
		registerItem("pigeon_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.PIGEON_PLUSHIE));
		registerItem("piglin_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.PIGLIN_PLUSHIE));
		registerItem("rabbit_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.RABBIT_PLUSHIE));
		registerItem("snow_golem_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.SNOW_GOLEM_PLUSHIE));
		registerItem("zombified_piglin_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.ZOMBIFIED_PIGLIN_PLUSHIE));
		registerItem("iron_golem_plushie", new ScarecrowItem(new Item.Settings().maxCount(16).group(MOB_SCARECROW_GROUP), MSEntityTypes.IRON_GOLEM_PLUSHIE));
	}

	public static Item get (String id) {
		return ITEMS.getOrDefault(id, Items.AIR);
	}
}

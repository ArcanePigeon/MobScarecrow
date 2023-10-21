package org.cloudwarp.mobscarecrow.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.cloudwarp.mobscarecrow.blockdetails.ScarecrowItem;
import org.cloudwarp.mobscarecrow.entities.MSEntityTypes;

import java.util.HashMap;

public class MSItems {

	public static final RegistryKey<ItemGroup> MOB_SCARECROW_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier("mobscarecrow", "general"));

	private static final HashMap<String, Item> ITEMS = new HashMap<>();

	private static void registerItem (String id, Item item) {
		ITEMS.put(id, Registry.register(Registries.ITEM, "mobscarecrow:" + id, item));
		ItemGroupEvents
				.modifyEntriesEvent(MOB_SCARECROW_GROUP)
				.register((itemGroup) -> itemGroup.add(item));

	}

	public static void registerItemGroup(){
		Registry.register(Registries.ITEM_GROUP, MOB_SCARECROW_GROUP, FabricItemGroup.builder()
				       .icon(() -> new ItemStack(get("default_scarecrow")))
				       .displayName(Text.translatable("mobscarecrow.group.general"))
				       .build());
	}

	public static void registerItems () {
		if (! ITEMS.isEmpty()) {
			return;
		}
		registerItem("cat_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.CAT_PLUSHIE));
		registerItem("pillager_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.PILLAGER_PLUSHIE));
		registerItem("steve_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.STEVE_PLUSHIE));
		registerItem("villager_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.VILLAGER_PLUSHIE));
		registerItem("wolf_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.WOLF_PLUSHIE));
		registerItem("zombie_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.ZOMBIE_PLUSHIE));
		registerItem("axolotl_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.AXOLOTL_PLUSHIE));
		registerItem("chicken_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.CHICKEN_PLUSHIE));
		registerItem("copper_golem_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.COPPER_GOLEM_PLUSHIE));
		registerItem("default_scarecrow", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.DEFAULT_SCARECROW));
		registerItem("gold_pig_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.GOLD_PIG_PLUSHIE));
		registerItem("pigeon_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.PIGEON_PLUSHIE));
		registerItem("piglin_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.PIGLIN_PLUSHIE));
		registerItem("rabbit_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.RABBIT_PLUSHIE));
		registerItem("snow_golem_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.SNOW_GOLEM_PLUSHIE));
		registerItem("zombified_piglin_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.ZOMBIFIED_PIGLIN_PLUSHIE));
		registerItem("iron_golem_plushie", new ScarecrowItem(new Item.Settings().maxCount(16), MSEntityTypes.IRON_GOLEM_PLUSHIE));
	}

	public static Item get (String id) {
		return ITEMS.getOrDefault(id, Items.AIR);
	}
}

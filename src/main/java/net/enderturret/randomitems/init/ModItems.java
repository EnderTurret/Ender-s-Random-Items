package net.enderturret.randomitems.init;

import net.enderturret.randomitems.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

	public static ItemBase moistTowelette = new ItemBase("moist_towelette");
	public static ItemBase sanitizingWater = new ItemBase("sanitizing_water");

	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				moistTowelette,
				sanitizingWater
		);
	}

	public static void registerModels() {
		moistTowelette.registerItemModel();
		sanitizingWater.registerItemModel();
	}
}
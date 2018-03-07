package net.enderturret.randomitems.init;

import net.enderturret.randomitems.item.ItemBase;
import net.enderturret.randomitems.item.SaturatedDrinkItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	
	// Plain Items
	public static ItemBase moistTowelette = new ItemBase("moist_towelette");
	public static ItemBase sanitizingWater = new ItemBase("sanitizing_water");
	// Food & Drinks
	public static SaturatedDrinkItem secretCoke = new SaturatedDrinkItem("secret_coke", 1, 1f, false);
	
	// Register ALL THE THINGS!!!
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				moistTowelette,
				sanitizingWater,
				secretCoke
		);
	}
	
	// Don't forget the models because no one likes black and purple
	public static void registerModels() {
		moistTowelette.registerItemModel();
		sanitizingWater.registerItemModel();
		secretCoke.registerItemModel();
	}
}
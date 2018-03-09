package net.enderturret.randomitems.init;

import net.enderturret.randomitems.item.ItemBase;
import net.enderturret.randomitems.item.ItemPuffball;
import net.enderturret.randomitems.item.SaturatedDrinkItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

	// Plain Items
	public static ItemBase moistTowelette = new ItemBase("moist_towelette");
	public static ItemBase sanitizingWater = new ItemBase("sanitizing_water");
	public static ItemBase puffBallTail = new ItemBase("puffball_tail");
	public static ItemBase puffBallFur = new ItemBase("puffball_fur");
	// Food & Drinks
	public static SaturatedDrinkItem secretCoke = new SaturatedDrinkItem("secret_coke", 1, 1f, false);
	// Puffballs
	//TODO: Fix the glowing one
	public static ItemPuffball puffBall = new ItemPuffball("puffball");
	public static ItemPuffball puffBallWhite = new ItemPuffball("puffball_white");
	public static ItemPuffball puffBallLightGray = new ItemPuffball("puffball_light_gray");
	public static ItemPuffball puffBallGray = new ItemPuffball("puffball_gray");
	public static ItemPuffball puffBallBlack = new ItemPuffball("puffball_black");
	public static ItemPuffball puffBallBrown = new ItemPuffball("puffball_brown");
	public static ItemPuffball puffBallRed = new ItemPuffball("puffball_red");
	public static ItemPuffball puffBallOrange = new ItemPuffball("puffball_orange");
	public static ItemPuffball puffBallYellow = new ItemPuffball("puffball_yellow");
	public static ItemPuffball puffBallLime = new ItemPuffball("puffball_lime");
	public static ItemPuffball puffBallGreen = new ItemPuffball("puffball_green");
	public static ItemPuffball puffBallCyan = new ItemPuffball("puffball_cyan");
	public static ItemPuffball puffBallLightBlue = new ItemPuffball("puffball_light_blue");
	public static ItemPuffball puffBallBlue = new ItemPuffball("puffball_blue");
	public static ItemPuffball puffBallPurple = new ItemPuffball("puffball_purple");
	public static ItemPuffball puffBallMagenta = new ItemPuffball("puffball_magenta");
	public static ItemPuffball puffBallPink = new ItemPuffball("puffball_pink");
	
	// Register ALL THE THINGS!!!
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				moistTowelette,
				sanitizingWater,
				secretCoke,
				puffBallTail,
				puffBallFur,
				//Puffballs
				puffBall,
				puffBallWhite,
				puffBallLightGray,
				puffBallGray,
				puffBallBlack,
				puffBallBrown,
				puffBallRed,
				puffBallOrange,
				puffBallYellow,
				puffBallLime,
				puffBallGreen,
				puffBallCyan,
				puffBallLightBlue,
				puffBallBlue,
				//puffBallPurple,
				puffBallMagenta,
				puffBallPink
		);
	}

	// Don't forget the models because no one likes black and purple
	public static void registerModels() {
		moistTowelette.registerItemModel();
		sanitizingWater.registerItemModel();
		secretCoke.registerItemModel();
		puffBallTail.registerItemModel();
		puffBallFur.registerItemModel();
		
		puffBall.registerItemModel();
		puffBallWhite.registerItemModel();
		puffBallLightGray.registerItemModel();
		puffBallGray.registerItemModel();
		puffBallBlack.registerItemModel();
		puffBallBrown.registerItemModel();
		puffBallRed.registerItemModel();
		puffBallOrange.registerItemModel();
		puffBallYellow.registerItemModel();
		puffBallLime.registerItemModel();
		puffBallGreen.registerItemModel();
		puffBallCyan.registerItemModel();
		puffBallLightBlue.registerItemModel();
		puffBallBlue.registerItemModel();
		//puffBallPurple.registerItemModel();
		puffBallMagenta.registerItemModel();
		puffBallPink.registerItemModel();
	}
}
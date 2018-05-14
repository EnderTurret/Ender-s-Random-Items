package net.enderturret.randomitems.init;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.item.ItemBase;
import net.enderturret.randomitems.item.ItemFLARD;
import net.enderturret.randomitems.item.ItemPuffball;
import net.enderturret.randomitems.item.ItemQuestionableCheese;
import net.enderturret.randomitems.item.ItemStoneChisel;
import net.enderturret.randomitems.item.SaturatedDrinkItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	// Plain Items
	public static final ItemBase moistTowelette = new ItemBase("moist_towelette");
	public static final ItemBase sanitizingWater = new ItemBase("sanitizing_water");
	public static final ItemBase puffBallTail = new ItemBase("puffball_tail");
	public static final ItemBase puffBallFur = new ItemBase("puffball_fur");
	public static final ItemBase stoneStick = new ItemBase("stone_stick");
	public static final ItemStoneChisel stoneChisel = new ItemStoneChisel("stone_chisel", 32);
	public static final ItemQuestionableCheese questionableCheese = new ItemQuestionableCheese();
	public static final ItemFLARD flard = new ItemFLARD();
	// Food & Drinks
	public static final SaturatedDrinkItem secretCoke = new SaturatedDrinkItem("secret_coke", 1, 1f, false);
	// Puffballs
	public static final ItemPuffball puffball = new ItemPuffball("puffball");
	public static final ItemPuffball puffballWhite = new ItemPuffball("puffball_white");
	public static final ItemPuffball puffballLightGray = new ItemPuffball("puffball_light_gray");
	public static final ItemPuffball puffballGray = new ItemPuffball("puffball_gray");
	public static final ItemPuffball puffballBlack = new ItemPuffball("puffball_black");
	public static final ItemPuffball puffballBrown = new ItemPuffball("puffball_brown");
	public static final ItemPuffball puffballRed = new ItemPuffball("puffball_red");
	public static final ItemPuffball puffballOrange = new ItemPuffball("puffball_orange");
	public static final ItemPuffball puffballYellow = new ItemPuffball("puffball_yellow");
	public static final ItemPuffball puffballLime = new ItemPuffball("puffball_lime");
	public static final ItemPuffball puffballGreen = new ItemPuffball("puffball_green");
	public static final ItemPuffball puffballCyan = new ItemPuffball("puffball_cyan");
	public static final ItemPuffball puffballLightBlue = new ItemPuffball("puffball_light_blue");
	public static final ItemPuffball puffballBlue = new ItemPuffball("puffball_blue");
	public static final ItemPuffball puffballPurple = new ItemPuffball("puffball_purple");
	public static final ItemPuffball puffballMagenta = new ItemPuffball("puffball_magenta");
	public static final ItemPuffball puffballPink = new ItemPuffball("puffball_pink");
	//public static final ItemPuffball puffBallPurple = new ItemPuffball("puffball_purple");

	// Register ALL THE THINGS!!!
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				moistTowelette,
				sanitizingWater,
				secretCoke,
				puffBallTail,
				puffBallFur,

				puffball,
				puffballWhite,
				puffballLightGray,
				puffballGray,
				puffballBlack,
				puffballBrown,
				puffballRed,
				puffballOrange,
				puffballYellow,
				puffballLime,
				puffballGreen,
				puffballCyan,
				puffballLightBlue,
				puffballBlue,
				//puffballPurple,
				puffballMagenta,
				puffballPink,

				stoneStick,
				stoneChisel,
				questionableCheese,
				flard
		);
	}
	// Don't forget the models because no one likes black and purple
	public static void registerModels() {
		moistTowelette.registerItemModel();
		sanitizingWater.registerItemModel();
		secretCoke.registerItemModel();
		puffBallTail.registerItemModel();
		puffBallFur.registerItemModel();

		puffball.registerItemModel();
		puffballWhite.registerItemModel();
		puffballLightGray.registerItemModel();
		puffballGray.registerItemModel();
		puffballBlack.registerItemModel();
		puffballBrown.registerItemModel();
		puffballRed.registerItemModel();
		puffballOrange.registerItemModel();
		puffballYellow.registerItemModel();
		puffballLime.registerItemModel();
		puffballGreen.registerItemModel();
		puffballCyan.registerItemModel();
		puffballLightBlue.registerItemModel();
		puffballBlue.registerItemModel();
		//puffballPurple.registerItemModel();
		puffballMagenta.registerItemModel();
		puffballPink.registerItemModel();

		stoneStick.registerItemModel();
		stoneChisel.registerItemModel();
		questionableCheese.registerItemModel();
		flard.registerItemModel();
	}
}
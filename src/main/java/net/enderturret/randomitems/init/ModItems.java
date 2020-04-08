package net.enderturret.randomitems.init;

import net.enderturret.randomitems.item.*;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

	public static final ItemBase MOIST_TOWELETTE = new ItemBase("moist_towelette");
	public static final ItemBase SANITIZING_WATER = new ItemBase("sanitizing_water");
	public static final ItemBase PUFFBALL_TAIL = new ItemBase("puffball_tail");
	public static final ItemBase PUFFBALL_FUR = new ItemBase("puffball_fur");
	public static final ItemBase STONE_STICK = new ItemBase("stone_stick");
	// Aren't you glad there isn't a stone stone chisel?
	public static final ItemStoneChisel STONE_CHISEL_IRON = new ItemStoneChisel("iron_stone_chisel", 31, 4);
	public static final ItemStoneChisel STONE_CHISEL_DIAMOND = new ItemStoneChisel("diamond_stone_chisel", 63, 8);
	public static final ItemQuestionableCheese QUESTIONABLE_CHEESE = new ItemQuestionableCheese();
	public static final ItemFLARD FLARD = new ItemFLARD();
	public static final ItemKeycard KEYCARD = new ItemKeycard("keycard");

	public static final SaturatedFoodItem SECRET_COKE = new SaturatedFoodItem("secret_coke", 1, 1f, false, true);

	public static final ItemBase PUFFBALL = new ItemBase("puffball");
	public static final ItemPuffball PUFFBALL_WHITE = new ItemPuffball("puffball_white", MobEffects.SPEED);
	public static final ItemPuffball PUFFBALL_LIGHT_GRAY = new ItemPuffball("puffball_light_gray", MobEffects.INVISIBILITY);
	public static final ItemPuffball PUFFBALL_GRAY = new ItemPuffball("puffball_gray", MobEffects.RESISTANCE);
	public static final ItemPuffball PUFFBALL_BLACK = new ItemPuffball("puffball_black", MobEffects.LEVITATION);
	public static final ItemPuffball PUFFBALL_BROWN = new ItemPuffball("puffball_brown", MobEffects.SATURATION);
	public static final ItemPuffball PUFFBALL_RED = new ItemPuffball("puffball_red", MobEffects.REGENERATION);
	public static final ItemPuffball PUFFBALL_ORANGE = new ItemPuffball("puffball_orange", MobEffects.FIRE_RESISTANCE);
	public static final ItemPuffball PUFFBALL_YELLOW = new ItemPuffball("puffball_yellow", MobEffects.ABSORPTION);
	public static final ItemPuffball PUFFBALL_LIME = new ItemPuffball("puffball_lime", MobEffects.LUCK);
	public static final ItemPuffball PUFFBALL_GREEN = new ItemPuffball("puffball_green", MobEffects.JUMP_BOOST);
	public static final ItemPuffball PUFFBALL_CYAN = new ItemPuffball("puffball_cyan", MobEffects.HASTE);
	public static final ItemPuffball PUFFBALL_LIGHT_BLUE = new ItemPuffball("puffball_light_blue", MobEffects.WATER_BREATHING);
	public static final ItemPuffball PUFFBALL_BLUE = new ItemPuffball("puffball_blue", MobEffects.NIGHT_VISION);
	public static final ItemPuffball PUFFBALL_PURPLE = new ItemPuffball("puffball_purple", MobEffects.HEALTH_BOOST);
	public static final ItemPuffball PUFFBALL_MAGENTA = new ItemPuffball("puffball_magenta", MobEffects.GLOWING);
	public static final ItemPuffball PUFFBALL_PINK = new ItemPuffball("puffball_pink", MobEffects.STRENGTH);

	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				MOIST_TOWELETTE,
				SANITIZING_WATER,
				SECRET_COKE,
				PUFFBALL_TAIL,
				PUFFBALL_FUR,
				STONE_STICK,
				STONE_CHISEL_IRON,
				STONE_CHISEL_DIAMOND,
				QUESTIONABLE_CHEESE,
				FLARD,
				KEYCARD,

				PUFFBALL,
				PUFFBALL_WHITE,
				PUFFBALL_LIGHT_GRAY,
				PUFFBALL_GRAY,
				PUFFBALL_BLACK,
				PUFFBALL_BROWN,
				PUFFBALL_RED,
				PUFFBALL_ORANGE,
				PUFFBALL_YELLOW,
				PUFFBALL_LIME,
				PUFFBALL_GREEN,
				PUFFBALL_CYAN,
				PUFFBALL_LIGHT_BLUE,
				PUFFBALL_BLUE,
				PUFFBALL_PURPLE,
				PUFFBALL_MAGENTA,
				PUFFBALL_PINK
				);
	}

	public static void registerModels() {
		MOIST_TOWELETTE.registerItemModel();
		SANITIZING_WATER.registerItemModel();
		SECRET_COKE.registerItemModel();
		PUFFBALL_TAIL.registerItemModel();
		PUFFBALL_FUR.registerItemModel();
		STONE_STICK.registerItemModel();
		STONE_CHISEL_IRON.registerItemModel();
		STONE_CHISEL_DIAMOND.registerItemModel();
		QUESTIONABLE_CHEESE.registerItemModel();
		FLARD.registerItemModel();
		KEYCARD.registerItemModel();

		PUFFBALL.registerItemModel();
		PUFFBALL_WHITE.registerItemModel();
		PUFFBALL_LIGHT_GRAY.registerItemModel();
		PUFFBALL_GRAY.registerItemModel();
		PUFFBALL_BLACK.registerItemModel();
		PUFFBALL_BROWN.registerItemModel();
		PUFFBALL_RED.registerItemModel();
		PUFFBALL_ORANGE.registerItemModel();
		PUFFBALL_YELLOW.registerItemModel();
		PUFFBALL_LIME.registerItemModel();
		PUFFBALL_GREEN.registerItemModel();
		PUFFBALL_CYAN.registerItemModel();
		PUFFBALL_LIGHT_BLUE.registerItemModel();
		PUFFBALL_BLUE.registerItemModel();
		PUFFBALL_PURPLE.registerItemModel();
		PUFFBALL_MAGENTA.registerItemModel();
		PUFFBALL_PINK.registerItemModel();
	}

	public static void initOreDict() {}
}
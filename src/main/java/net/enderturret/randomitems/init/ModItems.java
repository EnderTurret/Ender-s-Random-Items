package net.enderturret.randomitems.init;

import net.enderturret.randomitems.item.*;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
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

	public static final ItemArmor INVISIBLE_LEATHER_CAP = new ItemArmor("invisible_leather_cap", ArmorMaterial.LEATHER, EntityEquipmentSlot.HEAD, true);
	public static final ItemArmor INVISIBLE_LEATHER_TUNIC = new ItemArmor("invisible_leather_tunic", ArmorMaterial.LEATHER, EntityEquipmentSlot.CHEST, true);
	public static final ItemArmor INVISIBLE_LEATHER_PANTS = new ItemArmor("invisible_leather_pants", ArmorMaterial.LEATHER, EntityEquipmentSlot.LEGS, true);
	public static final ItemArmor INVISIBLE_LEATHER_BOOTS = new ItemArmor("invisible_leather_boots", ArmorMaterial.LEATHER, EntityEquipmentSlot.FEET, true);

	public static final ItemArmor INVISIBLE_CHAIN_HELMET = new ItemArmor("invisible_chainmail_helmet", ArmorMaterial.CHAIN, EntityEquipmentSlot.HEAD, true);
	public static final ItemArmor INVISIBLE_CHAIN_CHESTPLATE = new ItemArmor("invisible_chainmail_chestplate", ArmorMaterial.CHAIN, EntityEquipmentSlot.CHEST, true);
	public static final ItemArmor INVISIBLE_CHAIN_LEGGINGS = new ItemArmor("invisible_chainmail_leggings", ArmorMaterial.CHAIN, EntityEquipmentSlot.LEGS, true);
	public static final ItemArmor INVISIBLE_CHAIN_BOOTS = new ItemArmor("invisible_chainmail_boots", ArmorMaterial.CHAIN, EntityEquipmentSlot.FEET, true);

	public static final ItemArmor INVISIBLE_IRON_HELMET = new ItemArmor("invisible_iron_helmet", ArmorMaterial.IRON, EntityEquipmentSlot.HEAD, true);
	public static final ItemArmor INVISIBLE_IRON_CHESTPLATE = new ItemArmor("invisible_iron_chestplate", ArmorMaterial.IRON, EntityEquipmentSlot.CHEST, true);
	public static final ItemArmor INVISIBLE_IRON_LEGGINGS = new ItemArmor("invisible_iron_leggings", ArmorMaterial.IRON, EntityEquipmentSlot.LEGS, true);
	public static final ItemArmor INVISIBLE_IRON_BOOTS = new ItemArmor("invisible_iron_boots", ArmorMaterial.IRON, EntityEquipmentSlot.FEET, true);

	public static final ItemArmor INVISIBLE_GOLD_HELMET = new ItemArmor("invisible_gold_helmet", ArmorMaterial.GOLD, EntityEquipmentSlot.HEAD, true);
	public static final ItemArmor INVISIBLE_GOLD_CHESTPLATE = new ItemArmor("invisible_gold_chestplate", ArmorMaterial.GOLD, EntityEquipmentSlot.CHEST, true);
	public static final ItemArmor INVISIBLE_GOLD_LEGGINGS = new ItemArmor("invisible_gold_leggings", ArmorMaterial.GOLD, EntityEquipmentSlot.LEGS, true);
	public static final ItemArmor INVISIBLE_GOLD_BOOTS = new ItemArmor("invisible_gold_boots", ArmorMaterial.GOLD, EntityEquipmentSlot.FEET, true);

	public static final ItemArmor INVISIBLE_DIAMOND_HELMET = new ItemArmor("invisible_diamond_helmet", ArmorMaterial.DIAMOND, EntityEquipmentSlot.HEAD, true);
	public static final ItemArmor INVISIBLE_DIAMOND_CHESTPLATE = new ItemArmor("invisible_diamond_chestplate", ArmorMaterial.DIAMOND, EntityEquipmentSlot.CHEST, true);
	public static final ItemArmor INVISIBLE_DIAMOND_LEGGINGS = new ItemArmor("invisible_diamond_leggings", ArmorMaterial.DIAMOND, EntityEquipmentSlot.LEGS, true);
	public static final ItemArmor INVISIBLE_DIAMOND_BOOTS = new ItemArmor("invisible_diamond_boots", ArmorMaterial.DIAMOND, EntityEquipmentSlot.FEET, true);

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
				PUFFBALL_PINK,

				INVISIBLE_LEATHER_CAP,
				INVISIBLE_LEATHER_TUNIC,
				INVISIBLE_LEATHER_PANTS,
				INVISIBLE_LEATHER_BOOTS,
				INVISIBLE_CHAIN_HELMET,
				INVISIBLE_CHAIN_CHESTPLATE,
				INVISIBLE_CHAIN_LEGGINGS,
				INVISIBLE_CHAIN_BOOTS,
				INVISIBLE_IRON_HELMET,
				INVISIBLE_IRON_CHESTPLATE,
				INVISIBLE_IRON_LEGGINGS,
				INVISIBLE_IRON_BOOTS,
				INVISIBLE_GOLD_HELMET,
				INVISIBLE_GOLD_CHESTPLATE,
				INVISIBLE_GOLD_LEGGINGS,
				INVISIBLE_GOLD_BOOTS,
				INVISIBLE_DIAMOND_HELMET,
				INVISIBLE_DIAMOND_CHESTPLATE,
				INVISIBLE_DIAMOND_LEGGINGS,
				INVISIBLE_DIAMOND_BOOTS
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

		INVISIBLE_LEATHER_CAP.registerItemModel();
		INVISIBLE_LEATHER_TUNIC.registerItemModel();
		INVISIBLE_LEATHER_PANTS.registerItemModel();
		INVISIBLE_LEATHER_BOOTS.registerItemModel();
		INVISIBLE_CHAIN_HELMET.registerItemModel();
		INVISIBLE_CHAIN_CHESTPLATE.registerItemModel();
		INVISIBLE_CHAIN_LEGGINGS.registerItemModel();
		INVISIBLE_CHAIN_BOOTS.registerItemModel();
		INVISIBLE_IRON_HELMET.registerItemModel();
		INVISIBLE_IRON_CHESTPLATE.registerItemModel();
		INVISIBLE_IRON_LEGGINGS.registerItemModel();
		INVISIBLE_IRON_BOOTS.registerItemModel();
		INVISIBLE_GOLD_HELMET.registerItemModel();
		INVISIBLE_GOLD_CHESTPLATE.registerItemModel();
		INVISIBLE_GOLD_LEGGINGS.registerItemModel();
		INVISIBLE_GOLD_BOOTS.registerItemModel();
		INVISIBLE_DIAMOND_HELMET.registerItemModel();
		INVISIBLE_DIAMOND_CHESTPLATE.registerItemModel();
		INVISIBLE_DIAMOND_LEGGINGS.registerItemModel();
		INVISIBLE_DIAMOND_BOOTS.registerItemModel();
	}

	public static void initOreDict() {}
}
package net.enderturret.randomitems.init;

import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.Reference;
import net.enderturret.randomitems.item.*;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Reference.MOD_ID)
public class ModItems {

	@ObjectHolder("moist_towelette")
	public static final Item MOIST_TOWELETTE = null;
	@ObjectHolder("sanitizing_water")
	public static final Item SANITIZING_WATER = null;
	@ObjectHolder("puffball_tail")
	public static final Item PUFFBALL_TAIL = null;
	@ObjectHolder("puffball_fur")
	public static final Item PUFFBALL_FUR = null;
	@ObjectHolder("stone_stick")
	public static final Item STONE_STICK = null;
	// Aren't you glad there isn't a stone stone chisel?
	@ObjectHolder("iron_stone_chisel")
	public static final Item STONE_CHISEL_IRON = null;
	@ObjectHolder("diamond_stone_chisel")
	public static final Item STONE_CHISEL_DIAMOND = null;
	@ObjectHolder("questionable_cheese")
	public static final Item QUESTIONABLE_CHEESE = null;
	@ObjectHolder("flard")
	public static final Item FLARD = null;
	@ObjectHolder("keycard")
	public static final Item KEYCARD = null;

	@ObjectHolder("secret_coke")
	public static final Item SECRET_COKE = null;

	@ObjectHolder("puffball")
	public static final Item PUFFBALL = null;
	@ObjectHolder("white_puffball")
	public static final Item PUFFBALL_WHITE = null;
	@ObjectHolder("light_gray_puffball")
	public static final Item PUFFBALL_LIGHT_GRAY = null;
	@ObjectHolder("gray_puffball")
	public static final Item PUFFBALL_GRAY = null;
	@ObjectHolder("black_puffball")
	public static final Item PUFFBALL_BLACK = null;
	@ObjectHolder("brown_puffball")
	public static final Item PUFFBALL_BROWN = null;
	@ObjectHolder("red_puffball")
	public static final Item PUFFBALL_RED = null;
	@ObjectHolder("orange_puffball")
	public static final Item PUFFBALL_ORANGE = null;
	@ObjectHolder("yellow_puffball")
	public static final Item PUFFBALL_YELLOW = null;
	@ObjectHolder("lime_puffball")
	public static final Item PUFFBALL_LIME = null;
	@ObjectHolder("green_puffball")
	public static final Item PUFFBALL_GREEN = null;
	@ObjectHolder("cyan_puffball")
	public static final Item PUFFBALL_CYAN = null;
	@ObjectHolder("light_blue_puffball")
	public static final Item PUFFBALL_LIGHT_BLUE = null;
	@ObjectHolder("blue_puffball")
	public static final Item PUFFBALL_BLUE = null;
	@ObjectHolder("purple_puffball")
	public static final Item PUFFBALL_PURPLE = null;
	@ObjectHolder("magenta_puffball")
	public static final Item PUFFBALL_MAGENTA = null;
	@ObjectHolder("pink_puffball")
	public static final Item PUFFBALL_PINK = null;

	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				//configure(new Item(), ""),
				configure(new Item(), "moist_towelette"),
				configure(new Item(), "sanitizing_water"),
				configure(new Item(), "puffball_tail"),
				configure(new Item(), "puffball_fur"),
				configure(new Item(), "stone_stick"),
				configure(new ItemStoneChisel(31, 4), "iron_stone_chisel"),
				configure(new ItemStoneChisel(63, 8), "diamond_stone_chisel"),
				configure(new ItemQuestionableCheese(), "questionable_cheese"),
				configure(new ItemFLARD(), "flard"),
				configure(new ItemKeycard(), "keycard"),
				configure(new SaturatedFoodItem(1, 1F, false, true), "secret_coke").setCreativeTab(null),
				configure(new Item(), "puffball"),
				configure(new ItemPuffball(MobEffects.SPEED), "white_puffball"),
				configure(new ItemPuffball(MobEffects.INVISIBILITY), "light_gray_puffball"),
				configure(new ItemPuffball(MobEffects.RESISTANCE), "gray_puffball"),
				configure(new ItemPuffball(MobEffects.LEVITATION), "black_puffball"),
				configure(new ItemPuffball(MobEffects.SATURATION), "brown_puffball"),
				configure(new ItemPuffball(MobEffects.REGENERATION), "red_puffball"),
				configure(new ItemPuffball(MobEffects.FIRE_RESISTANCE), "orange_puffball"),
				configure(new ItemPuffball(MobEffects.ABSORPTION), "yellow_puffball"),
				configure(new ItemPuffball(MobEffects.LUCK), "lime_puffball"),
				configure(new ItemPuffball(MobEffects.JUMP_BOOST), "green_puffball"),
				configure(new ItemPuffball(MobEffects.HASTE), "cyan_puffball"),
				configure(new ItemPuffball(MobEffects.WATER_BREATHING), "light_blue_puffball"),
				configure(new ItemPuffball(MobEffects.NIGHT_VISION), "blue_puffball"),
				configure(new ItemPuffball(MobEffects.HEALTH_BOOST), "purple_puffball"),
				configure(new ItemPuffball(MobEffects.GLOWING), "magenta_puffball"),
				configure(new ItemPuffball(MobEffects.STRENGTH), "pink_puffball")
				);
	}

	public static void registerModels() {
		registerModels(
				MOIST_TOWELETTE, SANITIZING_WATER, SECRET_COKE, PUFFBALL_TAIL, PUFFBALL_FUR,
				STONE_STICK, STONE_CHISEL_IRON, STONE_CHISEL_DIAMOND, QUESTIONABLE_CHEESE, FLARD,
				KEYCARD, PUFFBALL, PUFFBALL_WHITE, PUFFBALL_LIGHT_GRAY, PUFFBALL_GRAY,
				PUFFBALL_BLACK, PUFFBALL_BROWN, PUFFBALL_RED, PUFFBALL_ORANGE, PUFFBALL_YELLOW,
				PUFFBALL_LIME, PUFFBALL_GREEN, PUFFBALL_CYAN, PUFFBALL_LIGHT_BLUE, PUFFBALL_BLUE,
				PUFFBALL_PURPLE, PUFFBALL_MAGENTA, PUFFBALL_PINK);
		/*MOIST_TOWELETTE.registerItemModel();
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
		PUFFBALL_PINK.registerItemModel();*/
	}

	public static void registerModels(Item... items) {
		for (Item item : items)
			RandomItems.proxy.registerItemRenderer(item, 0, item.getRegistryName().getPath());
	}

	public static <T extends Item> T configure(T item, String registryName) {
		item.setRegistryName(Reference.MOD_ID, registryName).setTranslationKey(registryName);
		item.setCreativeTab(RandomItems.TAB);
		return item;
	}
}
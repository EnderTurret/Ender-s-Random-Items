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
	public static final Item IRON_STONE_CHISEL = null;
	@ObjectHolder("diamond_stone_chisel")
	public static final Item DIAMOND_STONE_CHISEL = null;
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
	public static final Item WHITE_PUFFBALL = null;
	@ObjectHolder("light_gray_puffball")
	public static final Item LIGHT_GRAY_PUFFBALL = null;
	@ObjectHolder("gray_puffball")
	public static final Item GRAY_PUFFBALL = null;
	@ObjectHolder("black_puffball")
	public static final Item BLACK_PUFFBALL = null;
	@ObjectHolder("brown_puffball")
	public static final Item BROWN_PUFFBALL = null;
	@ObjectHolder("red_puffball")
	public static final Item RED_PUFFBALL = null;
	@ObjectHolder("orange_puffball")
	public static final Item ORANGE_PUFFBALL = null;
	@ObjectHolder("yellow_puffball")
	public static final Item YELLOW_PUFFBALL = null;
	@ObjectHolder("lime_puffball")
	public static final Item LIME_PUFFBALL = null;
	@ObjectHolder("green_puffball")
	public static final Item GREEN_PUFFBALL = null;
	@ObjectHolder("cyan_puffball")
	public static final Item CYAN_PUFFBALL = null;
	@ObjectHolder("light_blue_puffball")
	public static final Item LIGHT_BLUE_PUFFBALL = null;
	@ObjectHolder("blue_puffball")
	public static final Item BLUE_PUFFBALL = null;
	@ObjectHolder("purple_puffball")
	public static final Item PURPLE_PUFFBALL = null;
	@ObjectHolder("magenta_puffball")
	public static final Item MAGENTA_PUFFBALL = null;
	@ObjectHolder("pink_puffball")
	public static final Item PINK_PUFFBALL = null;

	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				//configure(new Item(), ""),
				configure(new Item(), "moist_towelette"),
				configure(new Item(), "sanitizing_water"),
				configure(new Item(), "puffball_tail"),
				configure(new Item(), "puffball_fur"),
				configure(new Item(), "stone_stick"),
				configure(new StoneChiselItem(31, 4), "iron_stone_chisel"),
				configure(new StoneChiselItem(63, 8), "diamond_stone_chisel"),
				configure(new QuestionableCheeseItem(), "questionable_cheese"),
				configure(new FLARDItem(), "flard"),
				configure(new KeycardItem(), "keycard"),
				configure(new SaturatedFoodItem(1, 1F, false, true), "secret_coke").setCreativeTab(null),
				configure(new Item(), "puffball"),
				configure(new PuffballItem(MobEffects.SPEED), "white_puffball"),
				configure(new PuffballItem(MobEffects.INVISIBILITY), "light_gray_puffball"),
				configure(new PuffballItem(MobEffects.RESISTANCE), "gray_puffball"),
				configure(new PuffballItem(MobEffects.LEVITATION), "black_puffball"),
				configure(new PuffballItem(MobEffects.SATURATION), "brown_puffball"),
				configure(new PuffballItem(MobEffects.REGENERATION), "red_puffball"),
				configure(new PuffballItem(MobEffects.FIRE_RESISTANCE), "orange_puffball"),
				configure(new PuffballItem(MobEffects.ABSORPTION), "yellow_puffball"),
				configure(new PuffballItem(MobEffects.LUCK), "lime_puffball"),
				configure(new PuffballItem(MobEffects.JUMP_BOOST), "green_puffball"),
				configure(new PuffballItem(MobEffects.HASTE), "cyan_puffball"),
				configure(new PuffballItem(MobEffects.WATER_BREATHING), "light_blue_puffball"),
				configure(new PuffballItem(MobEffects.NIGHT_VISION), "blue_puffball"),
				configure(new PuffballItem(MobEffects.HEALTH_BOOST), "purple_puffball"),
				configure(new PuffballItem(MobEffects.GLOWING), "magenta_puffball"),
				configure(new PuffballItem(MobEffects.STRENGTH), "pink_puffball")
				);
	}

	public static void registerModels() {
		registerModels(
				MOIST_TOWELETTE, SANITIZING_WATER, SECRET_COKE, PUFFBALL_TAIL, PUFFBALL_FUR,
				STONE_STICK, IRON_STONE_CHISEL, DIAMOND_STONE_CHISEL, QUESTIONABLE_CHEESE, FLARD,
				KEYCARD, PUFFBALL, WHITE_PUFFBALL, LIGHT_GRAY_PUFFBALL, GRAY_PUFFBALL,
				BLACK_PUFFBALL, BROWN_PUFFBALL, RED_PUFFBALL, ORANGE_PUFFBALL, YELLOW_PUFFBALL,
				LIME_PUFFBALL, GREEN_PUFFBALL, CYAN_PUFFBALL, LIGHT_BLUE_PUFFBALL, BLUE_PUFFBALL,
				PURPLE_PUFFBALL, MAGENTA_PUFFBALL, PINK_PUFFBALL);
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
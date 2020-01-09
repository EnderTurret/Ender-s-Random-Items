package net.enderturret.randomitems.init;

import net.enderturret.randomitems.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

	public static final BlockTesseract TESSERACT = new BlockTesseract("block_tesseract", SoundType.METAL, Material.CIRCUITS, MobEffects.RESISTANCE);
	public static final BlockTesseract LOVE_TESSERACT = new BlockTesseract("block_love_tesseract", SoundType.METAL, Material.CIRCUITS, MobEffects.REGENERATION);
	public static final BlockCustomTorch STONE_TORCH = new BlockCustomTorch("block_stone_torch", SoundType.STONE);
	public static final BlockWolfenootCake WOLFENOOT_CAKE = new BlockWolfenootCake("block_wolfenoot_cake");
	public static final BlockKeycardReader KEYCARD_READER = new BlockKeycardReader("block_keycard_reader");
	public static final BlockPlushie DOG_PLUSH = new BlockPlushie("block_dog_plushie", SoundType.CLOTH, Material.CLOTH);

	public static final BlockCore CORE_PURPLE = new BlockCore("block_core_purple", EnumDyeColor.PURPLE);
	public static final BlockCore CORE_RED = new BlockCore("block_core_red", EnumDyeColor.RED);
	public static final BlockCore CORE_BLUE = new BlockCore("block_core_blue", EnumDyeColor.BLUE);
	public static final BlockCore CORE_BLACK = new BlockCore("block_core_black", EnumDyeColor.BLACK);
	public static final BlockCore CORE_YELLOW = new BlockCore("block_core_yellow", EnumDyeColor.YELLOW);
	public static final BlockCore CORE_WHITE = new BlockCore("block_core_white", EnumDyeColor.WHITE);
	public static final BlockCore CORE_GRAY = new BlockCore("block_core_gray", EnumDyeColor.GRAY);
	public static final BlockCore CORE_LIGHT_GRAY = new BlockCore("block_core_light_gray", EnumDyeColor.SILVER);
	public static final BlockCore CORE_LIGHT_BLUE = new BlockCore("block_core_light_blue", EnumDyeColor.LIGHT_BLUE);
	public static final BlockCore CORE_CYAN = new BlockCore("block_core_cyan", EnumDyeColor.CYAN);
	public static final BlockCore CORE_ORANGE = new BlockCore("block_core_orange", EnumDyeColor.ORANGE);
	public static final BlockCore CORE_MAGENTA = new BlockCore("block_core_magenta", EnumDyeColor.MAGENTA);
	public static final BlockCore CORE_PINK = new BlockCore("block_core_pink", EnumDyeColor.PINK);
	public static final BlockCore CORE_BROWN = new BlockCore("block_core_brown", EnumDyeColor.BROWN);
	public static final BlockCore CORE_GREEN = new BlockCore("block_core_green", EnumDyeColor.GREEN);
	public static final BlockCore CORE_LIME = new BlockCore("block_core_lime", EnumDyeColor.LIME);
	public static final BlockCore CORE_BLACK_2 = new BlockCore("block_core_black_2", EnumDyeColor.BLACK);

	public static final BlockSpecialCore CORE_CLEAR = new BlockSpecialCore("block_clear_core");
	public static final BlockSpecialCore CORE_SUN = new BlockSpecialCore("block_sun_core");
	public static final BlockSpecialCore CORE_NIGHT = new BlockSpecialCore("block_night_core");
	public static final BlockSpecialCore CORE_CORRUPT = new BlockSpecialCore("block_corrupted_core");
	public static final BlockSpecialCore CORE_UNIVERSE = new BlockSpecialCore("block_universe_core");

	/*
	 * One registry to rule them all.
	 */
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				TESSERACT,
				LOVE_TESSERACT,
				STONE_TORCH,
				WOLFENOOT_CAKE,
				KEYCARD_READER,
				CORE_PURPLE,
				CORE_RED,
				CORE_BLUE,
				CORE_BLACK,
				CORE_YELLOW,
				CORE_WHITE,
				CORE_GRAY,
				CORE_LIGHT_BLUE,
				CORE_LIGHT_GRAY,
				CORE_CYAN,
				CORE_ORANGE,
				CORE_MAGENTA,
				CORE_PINK,
				CORE_BROWN,
				CORE_GREEN,
				CORE_LIME,
				CORE_BLACK_2,
				CORE_CLEAR,
				CORE_SUN,
				CORE_NIGHT,
				CORE_CORRUPT,
				CORE_UNIVERSE,
				DOG_PLUSH
				);
	}

	/*
	 * One registry to find them.
	 */
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				TESSERACT.createItemBlock(),
				LOVE_TESSERACT.createItemBlock(),
				STONE_TORCH.createItemBlock(),
				WOLFENOOT_CAKE.createItemBlock(),
				KEYCARD_READER.createItemBlock(),
				CORE_PURPLE.createItemBlock(),
				CORE_RED.createItemBlock(),
				CORE_BLUE.createItemBlock(),
				CORE_BLACK.createItemBlock(),
				CORE_YELLOW.createItemBlock(),
				CORE_WHITE.createItemBlock(),
				CORE_GRAY.createItemBlock(),
				CORE_LIGHT_BLUE.createItemBlock(),
				CORE_LIGHT_GRAY.createItemBlock(),
				CORE_CYAN.createItemBlock(),
				CORE_ORANGE.createItemBlock(),
				CORE_MAGENTA.createItemBlock(),
				CORE_PINK.createItemBlock(),
				CORE_BROWN.createItemBlock(),
				CORE_GREEN.createItemBlock(),
				CORE_LIME.createItemBlock(),
				CORE_BLACK_2.createItemBlock(),
				CORE_CLEAR.createItemBlock(),
				CORE_SUN.createItemBlock(),
				CORE_NIGHT.createItemBlock(),
				CORE_CORRUPT.createItemBlock(),
				CORE_UNIVERSE.createItemBlock(),
				DOG_PLUSH.createItemBlock()
				);
	}

	/*
	 * One registry to bring them all and in the event register them.
	 */
	public static void registerModels() {
		TESSERACT.registerItemModel();
		LOVE_TESSERACT.registerItemModel();
		STONE_TORCH.registerItemModel();
		WOLFENOOT_CAKE.registerItemModel();
		KEYCARD_READER.registerItemModel();
		CORE_PURPLE.registerItemModel();
		CORE_RED.registerItemModel();
		CORE_BLUE.registerItemModel();
		CORE_BLACK.registerItemModel();
		CORE_YELLOW.registerItemModel();
		CORE_WHITE.registerItemModel();
		CORE_GRAY.registerItemModel();
		CORE_LIGHT_BLUE.registerItemModel();
		CORE_LIGHT_GRAY.registerItemModel();
		CORE_CYAN.registerItemModel();
		CORE_ORANGE.registerItemModel();
		CORE_MAGENTA.registerItemModel();
		CORE_PINK.registerItemModel();
		CORE_BROWN.registerItemModel();
		CORE_GREEN.registerItemModel();
		CORE_LIME.registerItemModel();
		CORE_BLACK_2.registerItemModel();
		CORE_CLEAR.registerItemModel();
		CORE_SUN.registerItemModel();
		CORE_NIGHT.registerItemModel();
		CORE_CORRUPT.registerItemModel();
		CORE_UNIVERSE.registerItemModel();
		DOG_PLUSH.registerItemModel();
	}

	public static void initOreDict() {
		OreDictionary.registerOre("core", CORE_PURPLE);
		OreDictionary.registerOre("core", CORE_RED);
		OreDictionary.registerOre("core", CORE_BLUE);
		OreDictionary.registerOre("core", CORE_BLACK);
		OreDictionary.registerOre("core", CORE_YELLOW);
		OreDictionary.registerOre("core", CORE_WHITE);
		OreDictionary.registerOre("core", CORE_GRAY);
		OreDictionary.registerOre("core", CORE_LIGHT_BLUE);
		OreDictionary.registerOre("core", CORE_LIGHT_GRAY);
		OreDictionary.registerOre("core", CORE_CYAN);
		OreDictionary.registerOre("core", CORE_ORANGE);
		OreDictionary.registerOre("core", CORE_MAGENTA);
		OreDictionary.registerOre("core", CORE_PINK);
		OreDictionary.registerOre("core", CORE_BROWN);
		OreDictionary.registerOre("core", CORE_GREEN);
		OreDictionary.registerOre("core", CORE_LIME);
		OreDictionary.registerOre("core", CORE_BLACK_2);
		OreDictionary.registerOre("coreSpecial", CORE_CLEAR);
		OreDictionary.registerOre("coreSpecial", CORE_SUN);
		OreDictionary.registerOre("coreSpecial", CORE_NIGHT);
		OreDictionary.registerOre("coreSpecial", CORE_CORRUPT);
		OreDictionary.registerOre("coreSpecial", CORE_UNIVERSE);
	}
}
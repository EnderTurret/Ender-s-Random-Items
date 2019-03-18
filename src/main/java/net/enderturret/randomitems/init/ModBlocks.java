package net.enderturret.randomitems.init;

import net.enderturret.randomitems.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

	public static final BlockTesseract tesseract = new BlockTesseract("block_tesseract", SoundType.METAL, Material.CIRCUITS, MobEffects.RESISTANCE);
	public static final BlockTesseract loveTesseract = new BlockTesseract("block_love_tesseract", SoundType.METAL, Material.CIRCUITS, MobEffects.REGENERATION);
	public static final BlockCustomTorch stoneTorch = new BlockCustomTorch("block_stone_torch", SoundType.STONE);
	public static final BlockWolfenootCake wolfenootCake = new BlockWolfenootCake("block_wolfenoot_cake");
	public static final BlockKeycardReader keycardReader = new BlockKeycardReader("block_keycard_reader");
	public static final BlockPlushie dogPlush = new BlockPlushie("block_dog_plushie", SoundType.CLOTH, Material.CLOTH);

	public static final BlockCore corePurple = new BlockCore("block_core_purple");
	public static final BlockCore coreRed = new BlockCore("block_core_red");
	public static final BlockCore coreBlue = new BlockCore("block_core_blue");
	public static final BlockCore coreBlack = new BlockCore("block_core_black");
	public static final BlockCore coreYellow = new BlockCore("block_core_yellow");
	public static final BlockCore coreWhite = new BlockCore("block_core_white");
	public static final BlockCore coreGray = new BlockCore("block_core_gray");
	public static final BlockCore coreLightGray = new BlockCore("block_core_light_gray");
	public static final BlockCore coreLightBlue = new BlockCore("block_core_light_blue");
	public static final BlockCore coreCyan = new BlockCore("block_core_cyan");
	public static final BlockCore coreOrange = new BlockCore("block_core_orange");
	public static final BlockCore coreMagenta = new BlockCore("block_core_magenta");
	public static final BlockCore corePink = new BlockCore("block_core_pink");
	public static final BlockCore coreBrown = new BlockCore("block_core_brown");
	public static final BlockCore coreGreen = new BlockCore("block_core_green");
	public static final BlockCore coreLime = new BlockCore("block_core_lime");
	public static final BlockCore coreBlack2 = new BlockCore("block_core_black_2");

	public static final BlockSpecialCore coreClear = new BlockSpecialCore("block_clear_core");
	public static final BlockSpecialCore coreSun = new BlockSpecialCore("block_sun_core");
	public static final BlockSpecialCore coreNight = new BlockSpecialCore("block_night_core");
	public static final BlockSpecialCore coreCorrupt = new BlockSpecialCore("block_corrupted_core");
	public static final BlockSpecialCore coreUniverse = new BlockSpecialCore("block_universe_core");

	/** One registry to rule them all */
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				tesseract,
				loveTesseract,
				stoneTorch,
				wolfenootCake,
				keycardReader,
				corePurple,
				coreRed,
				coreBlue,
				coreBlack,
				coreYellow,
				coreWhite,
				coreGray,
				coreLightBlue,
				coreLightGray,
				coreCyan,
				coreOrange,
				coreMagenta,
				corePink,
				coreBrown,
				coreGreen,
				coreLime,
				coreBlack2,
				coreClear,
				coreSun,
				coreNight,
				coreCorrupt,
				coreUniverse,
				dogPlush
				);
	}
	/** One registry to find them */
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				tesseract.createItemBlock(),
				loveTesseract.createItemBlock(),
				stoneTorch.createItemBlock(),
				wolfenootCake.createItemBlock(),
				keycardReader.createItemBlock(),
				corePurple.createItemBlock(),
				coreRed.createItemBlock(),
				coreBlue.createItemBlock(),
				coreBlack.createItemBlock(),
				coreYellow.createItemBlock(),
				coreWhite.createItemBlock(),
				coreGray.createItemBlock(),
				coreLightBlue.createItemBlock(),
				coreLightGray.createItemBlock(),
				coreCyan.createItemBlock(),
				coreOrange.createItemBlock(),
				coreMagenta.createItemBlock(),
				corePink.createItemBlock(),
				coreBrown.createItemBlock(),
				coreGreen.createItemBlock(),
				coreLime.createItemBlock(),
				coreBlack2.createItemBlock(),
				coreClear.createItemBlock(),
				coreSun.createItemBlock(),
				coreNight.createItemBlock(),
				coreCorrupt.createItemBlock(),
				coreUniverse.createItemBlock(),
				dogPlush.createItemBlock()
				);
	}
	/** One registry to bring them all and in the pre init register them */
	public static void registerModels() {
		tesseract.registerItemModel();
		loveTesseract.registerItemModel();
		stoneTorch.registerItemModel();
		wolfenootCake.registerItemModel();
		keycardReader.registerItemModel();
		corePurple.registerItemModel();
		coreRed.registerItemModel();
		coreBlue.registerItemModel();
		coreBlack.registerItemModel();
		coreYellow.registerItemModel();
		coreWhite.registerItemModel();
		coreGray.registerItemModel();
		coreLightBlue.registerItemModel();
		coreLightGray.registerItemModel();
		coreCyan.registerItemModel();
		coreOrange.registerItemModel();
		coreMagenta.registerItemModel();
		corePink.registerItemModel();
		coreBrown.registerItemModel();
		coreGreen.registerItemModel();
		coreLime.registerItemModel();
		coreBlack2.registerItemModel();
		coreClear.registerItemModel();
		coreSun.registerItemModel();
		coreNight.registerItemModel();
		coreCorrupt.registerItemModel();
		coreUniverse.registerItemModel();
		dogPlush.registerItemModel();
	}

	public static void initOreDict() {
		OreDictionary.registerOre("core", corePurple);
		OreDictionary.registerOre("core", coreRed);
		OreDictionary.registerOre("core", coreBlue);
		OreDictionary.registerOre("core", coreBlack);
		OreDictionary.registerOre("core", coreYellow);
		OreDictionary.registerOre("core", coreWhite);
		OreDictionary.registerOre("core", coreGray);
		OreDictionary.registerOre("core", coreLightBlue);
		OreDictionary.registerOre("core", coreLightGray);
		OreDictionary.registerOre("core", coreCyan);
		OreDictionary.registerOre("core", coreOrange);
		OreDictionary.registerOre("core", coreMagenta);
		OreDictionary.registerOre("core", corePink);
		OreDictionary.registerOre("core", coreBrown);
		OreDictionary.registerOre("core", coreGreen);
		OreDictionary.registerOre("core", coreLime);
		OreDictionary.registerOre("core", coreBlack2);
		OreDictionary.registerOre("coreSpecial", coreClear);
		OreDictionary.registerOre("coreSpecial", coreSun);
		OreDictionary.registerOre("coreSpecial", coreNight);
		OreDictionary.registerOre("coreSpecial", coreCorrupt);
		OreDictionary.registerOre("coreSpecial", coreUniverse);
	}
}
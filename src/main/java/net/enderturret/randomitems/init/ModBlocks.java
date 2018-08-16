package net.enderturret.randomitems.init;

import net.enderturret.randomitems.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

	public static final BlockTesseract blockTesseract = new BlockTesseract("block_tesseract", SoundType.METAL, Material.CIRCUITS, MobEffects.RESISTANCE);
	public static final BlockTesseract blockLoveTesseract = new BlockTesseract("block_love_tesseract", SoundType.METAL, Material.CIRCUITS, MobEffects.REGENERATION);
	public static final BlockCustomTorch blockStoneTorch = new BlockCustomTorch("block_stone_torch", SoundType.STONE);
	public static final BlockCore blockCorePurple = new BlockCore("block_core_purple");
	public static final BlockCore blockCoreRed = new BlockCore("block_core_red");
	public static final BlockCore blockCoreBlue = new BlockCore("block_core_blue");
	public static final BlockCore blockCoreBlack = new BlockCore("block_core_black");
	public static final BlockCore blockCoreYellow = new BlockCore("block_core_yellow");
	public static final BlockCore blockCoreWhite = new BlockCore("block_core_white");
	public static final BlockCore blockCoreGray = new BlockCore("block_core_gray");
	public static final BlockCore blockCoreLightGray = new BlockCore("block_core_light_gray");
	public static final BlockCore blockCoreLightBlue = new BlockCore("block_core_light_blue");
	public static final BlockCore blockCoreCyan = new BlockCore("block_core_cyan");
	public static final BlockCore blockCoreOrange = new BlockCore("block_core_orange");
	public static final BlockCore blockCoreMagenta = new BlockCore("block_core_magenta");
	public static final BlockCore blockCorePink = new BlockCore("block_core_pink");
	public static final BlockCore blockCoreBrown = new BlockCore("block_core_brown");
	public static final BlockCore blockCoreGreen = new BlockCore("block_core_green");
	public static final BlockCore blockCoreLime = new BlockCore("block_core_lime");
	public static final BlockCore blockCoreBlack2 = new BlockCore("block_core_black_2");

	/** One registry to rule them all */
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				blockTesseract,
				blockLoveTesseract,
				blockStoneTorch,
				blockCorePurple,
				blockCoreRed,
				blockCoreBlue,
				blockCoreBlack,
				blockCoreYellow,
				blockCoreWhite,
				blockCoreGray,
				blockCoreLightBlue,
				blockCoreLightGray,
				blockCoreCyan,
				blockCoreOrange,
				blockCoreMagenta,
				blockCorePink,
				blockCoreBrown,
				blockCoreGreen,
				blockCoreLime,
				blockCoreBlack2
				);
	}
	/** One registry to find them */
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				blockTesseract.createItemBlock(),
				blockLoveTesseract.createItemBlock(),
				blockStoneTorch.createItemBlock(),
				blockCorePurple.createItemBlock(),
				blockCoreRed.createItemBlock(),
				blockCoreBlue.createItemBlock(),
				blockCoreBlack.createItemBlock(),
				blockCoreYellow.createItemBlock(),
				blockCoreWhite.createItemBlock(),
				blockCoreGray.createItemBlock(),
				blockCoreLightBlue.createItemBlock(),
				blockCoreLightGray.createItemBlock(),
				blockCoreCyan.createItemBlock(),
				blockCoreOrange.createItemBlock(),
				blockCoreMagenta.createItemBlock(),
				blockCorePink.createItemBlock(),
				blockCoreBrown.createItemBlock(),
				blockCoreGreen.createItemBlock(),
				blockCoreLime.createItemBlock(),
				blockCoreBlack2.createItemBlock()
				);
	}
	/** One registry to bring them all and in the pre init register them */
	public static void registerModels() {
		blockTesseract.registerItemModel(Item.getItemFromBlock(blockTesseract));
		blockLoveTesseract.registerItemModel(Item.getItemFromBlock(blockLoveTesseract));
		blockStoneTorch.registerItemModel(Item.getItemFromBlock(blockStoneTorch));
		blockCorePurple.registerItemModel(Item.getItemFromBlock(blockCorePurple));
		blockCoreRed.registerItemModel(Item.getItemFromBlock(blockCoreRed));
		blockCoreBlue.registerItemModel(Item.getItemFromBlock(blockCoreBlue));
		blockCoreBlack.registerItemModel(Item.getItemFromBlock(blockCoreBlack));
		blockCoreYellow.registerItemModel(Item.getItemFromBlock(blockCoreYellow));
		blockCoreWhite.registerItemModel(Item.getItemFromBlock(blockCoreWhite));
		blockCoreGray.registerItemModel(Item.getItemFromBlock(blockCoreGray));
		blockCoreLightBlue.registerItemModel(Item.getItemFromBlock(blockCoreLightBlue));
		blockCoreLightGray.registerItemModel(Item.getItemFromBlock(blockCoreLightGray));
		blockCoreCyan.registerItemModel(Item.getItemFromBlock(blockCoreCyan));
		blockCoreOrange.registerItemModel(Item.getItemFromBlock(blockCoreOrange));
		blockCoreMagenta.registerItemModel(Item.getItemFromBlock(blockCoreMagenta));
		blockCorePink.registerItemModel(Item.getItemFromBlock(blockCorePink));
		blockCoreBrown.registerItemModel(Item.getItemFromBlock(blockCoreBrown));
		blockCoreGreen.registerItemModel(Item.getItemFromBlock(blockCoreGreen));
		blockCoreLime.registerItemModel(Item.getItemFromBlock(blockCoreLime));
		blockCoreBlack2.registerItemModel(Item.getItemFromBlock(blockCoreBlack2));
	}
}
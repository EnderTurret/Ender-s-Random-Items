package net.enderturret.randomitems.init;

import net.enderturret.randomitems.block.BlockTesseract;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

	// Blocks
	public static BlockTesseract blockTesseract = new BlockTesseract("block_tesseract", SoundType.METAL, Material.CIRCUITS, "Resistance");
	public static BlockTesseract blockLoveTesseract = new BlockTesseract("block_love_tesseract", SoundType.METAL, Material.CIRCUITS, "Regeneration");
	
	// One registry to rule them all
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				blockTesseract,
				blockLoveTesseract
				);
	}
	// One registry to find them
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				blockTesseract.createItemBlock(),
				blockLoveTesseract.createItemBlock()
				);
	}
	// One registry to bring them all and in the pre init phase register them
	public static void registerModels() {
		blockTesseract.registerItemModel(Item.getItemFromBlock(blockTesseract));
		blockLoveTesseract.registerItemModel(Item.getItemFromBlock(blockLoveTesseract));
	}
}
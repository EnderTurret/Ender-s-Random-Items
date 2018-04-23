package net.enderturret.randomitems.block;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {
	private final String name;
	public BlockBase(String name, SoundType soundType, Material material) {
		super(material);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.blockSoundType = soundType;
		setCreativeTab(RandomItems.creativeTab);
	}
	// Register the model, because black and purple is ugly
	public void registerItemModel(Item itemBlock) {
		RandomItems.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	// Make sure they have an item form
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
}
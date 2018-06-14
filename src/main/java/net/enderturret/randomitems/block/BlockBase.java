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
	// You should know what this does by now.
	public void registerItemModel(Item itemBlock) {
		RandomItems.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	// This is by far the best method name in this file.
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
}
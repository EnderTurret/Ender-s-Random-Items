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
		this.blockSoundType = soundType;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(RandomItems.tab);
	}

	public void registerItemModel(Item itemBlock) {
		RandomItems.proxy.registerItemRenderer(itemBlock, 0, name);
	}

	public void registerItemModel() {
		registerItemModel(Item.getItemFromBlock(this));
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
}
package net.enderturret.randomitems.block;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {
	protected String name;

  	public BlockBase(String name, SoundType Soundtype, Material Material)
  	{
  		super(Material);
  		this.name = name;
  		setUnlocalizedName(name);
  		setRegistryName(name);
  		this.blockSoundType = Soundtype;
  		setHardness(0.8F);
  		setCreativeTab(RandomItems.creativeTab);
  	}
  	public void registerItemModel(Item itemBlock) {
  		RandomItems.proxy.registerItemRenderer(itemBlock, 0, name);
  	}
  	public Item createItemBlock() {
  		return new ItemBlock(this).setRegistryName(getRegistryName());
  	}
}
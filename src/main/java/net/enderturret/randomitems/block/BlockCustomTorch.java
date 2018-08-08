package net.enderturret.randomitems.block;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockCustomTorch extends BlockTorch {
	private final String name;
	public BlockCustomTorch(String name, SoundType soundType) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.blockSoundType = soundType;
		setCreativeTab(RandomItems.creativeTab);
		setLightLevel(1f);
	}
	public void registerItemModel(Item itemBlock) {
		RandomItems.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
}
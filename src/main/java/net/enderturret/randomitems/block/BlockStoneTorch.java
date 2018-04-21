package net.enderturret.randomitems.block;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockStoneTorch extends BlockTorch {
	protected final String name;
	public BlockStoneTorch() {
		name = "block_stone_torch";
		setUnlocalizedName(name);
		setRegistryName(name);
		this.blockSoundType = SoundType.STONE;
		setCreativeTab(RandomItems.creativeTab);
	}
	public void registerItemModel(Item itemBlock) {
		RandomItems.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
}
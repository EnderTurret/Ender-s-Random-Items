package net.enderturret.randomitems.block;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockCustomTorch extends BlockTorch {

	public BlockCustomTorch(String name, SoundType soundType) {
		this.blockSoundType = soundType;
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(RandomItems.TAB);
		setLightLevel(1F);
	}

	public void registerItemModel(Item itemBlock) {
		RandomItems.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getPath());
	}

	public void registerItemModel() {
		registerItemModel(Item.getItemFromBlock(this));
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
}
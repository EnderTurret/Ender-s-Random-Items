package net.enderturret.randomitems.block;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockCustomTorch extends BlockTorch {

	public BlockCustomTorch(SoundType soundType) {
		setSoundType(soundType);
		setLightLevel(1F);
	}
}
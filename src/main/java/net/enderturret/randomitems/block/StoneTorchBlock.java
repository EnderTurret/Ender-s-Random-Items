package net.enderturret.randomitems.block;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;

public class StoneTorchBlock extends BlockTorch {

	public StoneTorchBlock(SoundType soundType) {
		setSoundType(soundType);
		setLightLevel(1F);
	}
}
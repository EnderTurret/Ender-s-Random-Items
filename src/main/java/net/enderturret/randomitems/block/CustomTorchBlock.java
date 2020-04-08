package net.enderturret.randomitems.block;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;

public class CustomTorchBlock extends BlockTorch {

	public CustomTorchBlock(SoundType soundType) {
		setSoundType(soundType);
		setLightLevel(1F);
	}
}
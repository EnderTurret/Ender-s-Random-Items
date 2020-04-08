package net.enderturret.randomitems.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BaseBlock extends Block {

	public BaseBlock(SoundType soundType, Material material) {
		super(material);
		setSoundType(soundType);
	}
}
package net.enderturret.randomitems.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLight extends BlockBase {

	public BlockLight(String name, SoundType soundType, Material material, float lightLevel) {
		super(name, soundType, material);
		setLightLevel(lightLevel);
	}
}
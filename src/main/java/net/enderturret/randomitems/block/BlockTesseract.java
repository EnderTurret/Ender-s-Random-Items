package net.enderturret.randomitems.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTesseract extends BlockBase {
	private final String effect;
	public BlockTesseract(String name, SoundType soundType, Material material, String effect) {
		super(name, soundType, material);
		this.effect = effect;
		setHardness(2000f);
		setLightLevel(1f);
	}

	// Give status effects when right-clicked
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
			if (effect.equals("Resistance"))
				playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 0));
			else if (effect.equals("Regeneration"))
				playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 6000, 0));
			return true;
	}

	// Fix for model
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return MapColor.OBSIDIAN;
	}
}
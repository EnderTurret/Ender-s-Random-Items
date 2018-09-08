package net.enderturret.randomitems.block;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTesseract extends BlockBase {

	private final Potion effect;

	public BlockTesseract(String name, SoundType soundType, Material material, Potion effect) {
		super(name, soundType, material);
		this.effect = effect;
		setHardness(2000f);
		setLightLevel(1f);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (ConfigHandler.tesseractEffects) {
			playerIn.addPotionEffect(new PotionEffect(effect, 6000, 0));
			return true;
		} else
			return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return MapColor.OBSIDIAN;
	}
}
package net.enderturret.randomitems.block;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTesseract extends BlockBase {
	//TODO: When placed next to a solid block, some of the model turns black
	public String Effect;

	public BlockTesseract(String name, SoundType Soundtype, Material Material, String effect)
	{
		super(name, Soundtype, Material);
		Effect = effect;
		setCreativeTab(RandomItems.creativeTab);
	}

	// Give status effects when right-clicked
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
			if (Effect.equals("Resistance"))
				playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 0));
			else if (Effect.equals("Regeneration"))
				playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 6000, 0));
			else if (Effect.equals("Absorption"))
				playerIn.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 6000, 0));
			else if (Effect.equals("Fire resist"))
				playerIn.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
			return true;
	}

	// Fix for model
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
}
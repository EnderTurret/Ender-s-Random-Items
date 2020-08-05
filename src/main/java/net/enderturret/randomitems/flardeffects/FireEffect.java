package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class FireEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, EntityPlayer playerIn) {
		worldIn.setBlockState(playerIn.getPosition(), Blocks.FIRE.getDefaultState());
	}

	@Override
	public boolean canRun(World worldIn, EntityPlayer playerIn) {
		return ConfigHandler.flardEffects.fireEffect && worldIn.isAirBlock(playerIn.getPosition());
	}
}
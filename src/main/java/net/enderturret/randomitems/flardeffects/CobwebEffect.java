package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class CobwebEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, PlayerEntity playerIn) {
		worldIn.setBlockState(playerIn.getPosition(), Blocks.COBWEB.getDefaultState());
	}

	@Override
	public boolean canRun(World worldIn, PlayerEntity playerIn) {
		return ConfigHandler.get().flardCobwebEffect.get() && worldIn.isAirBlock(playerIn.getPosition());
	}
}
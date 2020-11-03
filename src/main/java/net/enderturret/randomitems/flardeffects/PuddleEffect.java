package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.World;

public class PuddleEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, PlayerEntity playerIn) {
		worldIn.setBlockState(playerIn.getPosition(),
				Fluids.WATER.getFlowingFluidState(1, false).getBlockState());
	}

	@Override
	public boolean canRun(World worldIn, PlayerEntity playerIn) {
		return ConfigHandler.get().flardPuddleEffect.get() && worldIn.isAirBlock(playerIn.getPosition());
	}
}
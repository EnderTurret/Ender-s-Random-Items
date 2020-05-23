package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class HoleEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, PlayerEntity playerIn) {
		worldIn.setBlockState(playerIn.getPosition().down(), Blocks.AIR.getDefaultState());
	}

	@Override
	public boolean canRun(World worldIn, PlayerEntity playerIn) {
		return ConfigHandler.get().flardHoleEffect.get() &&
				!worldIn.isAirBlock(playerIn.getPosition().down()) &&
				worldIn.getBlockState(playerIn.getPosition().down()) != Blocks.BEDROCK.getDefaultState();
	}
}
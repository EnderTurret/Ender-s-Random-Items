package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class HoleEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, EntityPlayer playerIn) {
		worldIn.setBlockState(playerIn.getPosition().down(), Blocks.AIR.getDefaultState());
	}

	@Override
	public boolean canRun(World worldIn, EntityPlayer playerIn) {
		return ConfigHandler.flardEffects.flardHoleEffect &&
				!worldIn.isAirBlock(playerIn.getPosition().down()) &&
				worldIn.getBlockState(playerIn.getPosition().down()) != Blocks.BEDROCK.getDefaultState();
	}
}
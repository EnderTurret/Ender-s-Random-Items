package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class HoleEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, EntityPlayer playerIn) {
		worldIn.setBlockToAir(playerIn.getPosition().down());
	}

	@Override
	public boolean canRun(World worldIn, EntityPlayer playerIn) {
		return ConfigHandler.flardEffects.holeEffect &&
				!worldIn.isAirBlock(playerIn.getPosition().down()) &&
				!ConfigHandler.flardEffects.isBlacklisted(worldIn.getBlockState(playerIn.getPosition().down()).getBlock().getRegistryName());
	}
}
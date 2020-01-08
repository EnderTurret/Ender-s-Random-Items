package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ExplosionEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, EntityPlayer playerIn) {
		worldIn.createExplosion(null, playerIn.getPosition().getX(), playerIn.getPosition().getY(),
				playerIn.getPosition().getZ(), 6.0F, true);
	}

	@Override
	public boolean canRun(World worldIn, EntityPlayer playerIn) {
		return ConfigHandler.flardEffects.flardExplosionEffect;
	}
}
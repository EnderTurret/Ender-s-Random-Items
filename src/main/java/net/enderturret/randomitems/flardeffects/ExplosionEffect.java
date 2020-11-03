package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ExplosionEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, PlayerEntity playerIn) {
		worldIn.createExplosion(null, playerIn.getPosition().getX(), playerIn.getPosition().getY(),
				playerIn.getPosition().getZ(), 6.0F, Explosion.Mode.DESTROY);
	}

	@Override
	public boolean canRun(World worldIn, PlayerEntity playerIn) {
		return ConfigHandler.get().flardExplosionEffect.get();
	}
}
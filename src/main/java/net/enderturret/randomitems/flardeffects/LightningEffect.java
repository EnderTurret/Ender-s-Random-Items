package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class LightningEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, PlayerEntity playerIn) {
		((ServerWorld) worldIn).addLightningBolt(new LightningBoltEntity(worldIn, playerIn.getPosition().getX(),
				playerIn.getPosition().getY(), playerIn.getPosition().getZ(), false));
	}

	@Override
	public boolean canRun(World worldIn, PlayerEntity playerIn) {
		return ConfigHandler.get().flardLightningEffect.get() && worldIn instanceof ServerWorld;
	}
}
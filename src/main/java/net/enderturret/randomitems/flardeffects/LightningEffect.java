package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class LightningEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, EntityPlayer playerIn) {
		((WorldServer) worldIn).addWeatherEffect(new EntityLightningBolt(worldIn, playerIn.getPosition().getX(),
				playerIn.getPosition().getY(), playerIn.getPosition().getZ(), false));
	}

	@Override
	public boolean canRun(World worldIn, EntityPlayer playerIn) {
		return ConfigHandler.flardEffects.lightningEffect && worldIn instanceof WorldServer;
	}
}
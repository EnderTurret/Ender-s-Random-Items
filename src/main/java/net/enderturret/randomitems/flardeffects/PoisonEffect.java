package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class PoisonEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, EntityPlayer playerIn) {
		playerIn.addPotionEffect(new PotionEffect(MobEffects.POISON, 500, 2));
	}

	@Override
	public boolean canRun(World worldIn, EntityPlayer playerIn) {
		return ConfigHandler.flardEffects.poisonEffect;
	}
}
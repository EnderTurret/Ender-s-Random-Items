package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class InventoryDropEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, PlayerEntity playerIn) {
		playerIn.inventory.dropAllItems();
	}

	@Override
	public boolean canRun(World worldIn, PlayerEntity playerIn) {
		return ConfigHandler.get().flardInventoryDropEffect.get();
	}
}
package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class DiamondEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, PlayerEntity playerIn) {
		playerIn.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, 1));
	}

	@Override
	public boolean canRun(World worldIn, PlayerEntity playerIn) {
		return ConfigHandler.get().flardDiamondEffect.get();
	}
}
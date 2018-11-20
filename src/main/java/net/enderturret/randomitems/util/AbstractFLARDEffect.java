package net.enderturret.randomitems.util;

import java.util.Random;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.RandomItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractFLARDEffect {

	protected final Random rand = new Random();

	/**
	 * Run when FLARD is held and the your effect is chosen
	 * @param stack The item being held by the player (FLARD)
	 * @param worldIn The player's world
	 * @param playerIn The player holding the FLARD
	 * @param pos The position of the player
	 * */
	public abstract void onFLARDEffectRun(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos);

	/** Logger I use for the console messages saying who held it and what happened */
	protected void log(String msg, EntityPlayer playerIn) {
		if (ConfigHandler.flardMessages)
			RandomItems.log.info("[FLARD] "+playerIn.getName()+msg);
	}

	/** Logger */
	protected void log(String msg) {
		if (ConfigHandler.flardMessages)
			RandomItems.log.info("[FLARD] "+msg);
	}
}
package net.enderturret.randomitems.util;

import java.util.Random;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.RandomItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractFLARDEffect {
	/** Random for all your pseudo-random needs */
	protected final Random rand = new Random();
	/** Run when FLARD is held and the your effect is chosen */
	public abstract void onFLARDEffectRun(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos);
	/** Another one with an EntityPlayer argument */
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
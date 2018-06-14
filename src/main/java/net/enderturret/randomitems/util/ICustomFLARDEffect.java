package net.enderturret.randomitems.util;

import java.util.Random;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.RandomItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ICustomFLARDEffect {
	/** Random for all your pseudo-random needs */
	final Random rand = new Random();
	/** Run when FLARD is held and the your effect is chosen */
	public void onFLARDEffectRun(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos);
	/** Logger for your custom effect */
	public default void log(String message, EntityPlayer playerIn) {
		if (ConfigHandler.flardMessages)
			RandomItems.log.info("[FLARD] "+playerIn.getName()+message);
	}
}
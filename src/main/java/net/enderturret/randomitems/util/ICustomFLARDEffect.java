package net.enderturret.randomitems.util;

import java.util.Random;

import org.apache.logging.log4j.Level;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ICustomFLARDEffect {
	final Random rand = new Random();
	/** Run when FLARD is held and the random number just so happens to be the slot that your effect is registered in */
	public void onFLARDEffectRun(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos);
	/** Logger for your custom effect */
	public default void log(String message, EntityPlayer playerIn) {
		RandomItems.log.log(Level.INFO, "[FLARD] "+playerIn.getName()+message);
	}
}
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
	public void onFLARDEffectRun(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos);
	public default void log(String message, EntityPlayer playerIn) {
		RandomItems.log.log(Level.INFO, "[FLARD] "+playerIn.getName()+message);
	}
}
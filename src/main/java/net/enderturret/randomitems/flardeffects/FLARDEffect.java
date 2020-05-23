package net.enderturret.randomitems.flardeffects;

import java.util.Random;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

public abstract class FLARDEffect extends ForgeRegistryEntry<FLARDEffect> {

	public static final Random RAND = new Random();

	/**
	 * Run when FLARD is right-clicked and your effect is chosen.
	 * @param worldIn The player's world.
	 * @param playerIn The player holding the FLARD.
	 * */
	public abstract void runEffect(World worldIn, PlayerEntity playerIn);

	/**
	 * Whether this {@code FLARDEffect} can run.<br>
	 * For example, you might want your effect to only run if a config option is enabled.
	 * @param worldIn The player's world.
	 * @param playerIn The player.
	 * @return True if the effect can run.
	 */
	public boolean canRun(World worldIn, PlayerEntity playerIn) { return true; }
}
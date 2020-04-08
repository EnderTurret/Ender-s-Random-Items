package net.enderturret.randomitems.flardeffects;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public abstract class FLARDEffect implements IForgeRegistryEntry<FLARDEffect> {

	public static final Random RAND = new Random();

	private ResourceLocation registryName;

	/**
	 * Run when FLARD is right-clicked and your effect is chosen.
	 * @param worldIn The player's world.
	 * @param playerIn The player holding the FLARD.
	 * */
	public abstract void runEffect(World worldIn, EntityPlayer playerIn);

	/**
	 * Whether this {@code FLARDEffect} can run.<br>
	 * For example, you might want your effect to run only if a config option is enabled.
	 * @param worldIn The player's world.
	 * @param playerIn The player.
	 * @return True if the effect can run.
	 */
	public boolean canRun(World worldIn, EntityPlayer playerIn) { return true; }

	@Override
	public ResourceLocation getRegistryName() {
		return registryName;
	}

	@Override
	public Class<FLARDEffect> getRegistryType() {
		return FLARDEffect.class;
	}

	@Override
	public FLARDEffect setRegistryName(ResourceLocation name) {
		registryName = name;
		return this;
	}

	public FLARDEffect setRegistryName(String name) {
		return setRegistryName(new ResourceLocation(name));
	}

	public FLARDEffect setRegistryName(String modId, String name) {
		return setRegistryName(new ResourceLocation(modId, name));
	}
}
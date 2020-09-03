package net.enderturret.randomitems;

import java.util.Random;

import net.enderturret.randomitems.flardeffects.FLARDEffect;
import net.enderturret.randomitems.util.RandomItemsUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public final class FLARDEffectRegistry {

	private FLARDEffectRegistry() {}

	/**
	 * The registry
	 */
	private static IForgeRegistry<FLARDEffect> registry;

	static void createRegistry() {
		registry = new RegistryBuilder<FLARDEffect>()
				.setName(new ResourceLocation(Reference.MOD_ID, "flard_effects"))
				.setType(FLARDEffect.class)
				.disableSaving()
				.create();
	}

	public static IForgeRegistry<FLARDEffect> getRegistry() {
		return registry;
	}

	public static FLARDEffect getRandom(Random rand) {
		return RandomItemsUtil.getRandom(getRegistry(), rand);
	}
}
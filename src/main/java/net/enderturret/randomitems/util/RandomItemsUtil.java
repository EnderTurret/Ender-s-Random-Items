package net.enderturret.randomitems.util;

import java.util.Collection;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RandomItemsUtil {

	public static AxisAlignedBB getAABBFromPixels(int x1, int y1, int z1, int x2, int y2, int z2) {
		return new AxisAlignedBB(0.0625 * x1, 0.0625 * y1, 0.0625 * z1, 0.0625 * x2, 0.0625 * y2, 0.0625 * z2);
	}

	/**
	 * Picks a random element from the given registry, and returns it.<br>
	 * Possibly stolen from {@code NamespacedWrapper.getRandom(Random)}.
	 * @param <T> The element type.
	 * @param registry The registry to pick elements from.
	 * @param rand The {@code Random} to use.
	 * @return A random element from the given registry.
	 */
	@Nullable
	public static <T extends IForgeRegistryEntry<T>> T getRandom(IForgeRegistry<T> registry, Random rand) {
		final Collection<T> c = registry.getValuesCollection();
		return c.stream().skip(rand.nextInt(c.size())).findFirst().orElse(null);
	}
}
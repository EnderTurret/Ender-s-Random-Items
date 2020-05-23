package net.enderturret.randomitems.util;

import java.util.Collection;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RandomItemsUtil {

	public static VoxelShape combineAll(Collection<VoxelShape> shapes) {
		VoxelShape result = VoxelShapes.empty();
		for (VoxelShape shape : shapes)
			result = VoxelShapes.combine(result, shape, IBooleanFunction.OR);
		return result.simplify();
	}

	public static VoxelShape combineAll(VoxelShape... shapes) {
		VoxelShape result = VoxelShapes.empty();
		for (VoxelShape shape : shapes)
			result = VoxelShapes.combine(result, shape, IBooleanFunction.OR);
		return result.simplify();
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
		final Collection<T> c = registry.getValues();
		return c.stream().skip(rand.nextInt(c.size())).findFirst().orElse(null);
	}
}
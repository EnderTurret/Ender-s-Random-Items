package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockChangeEffect extends FLARDEffect {

	private static ResourceLocation[] blocks = null;

	@Override
	public void runEffect(World worldIn, PlayerEntity playerIn) {
		if (blocks == null) createResourceLocationArray();

		final Block randomBlock = ForgeRegistries.BLOCKS.getValue(blocks[RAND.nextInt(blocks.length)]);
		worldIn.setBlockState(playerIn.getPosition().down(), randomBlock == null ? ModBlocks.CLEAR_CORE.get().getDefaultState() : randomBlock.getDefaultState());
	}

	@Override
	public boolean canRun(World worldIn, PlayerEntity playerIn) {
		return ConfigHandler.get().flardBlockChangeEffect.get();
	}

	private static boolean compareResourceLocations(ResourceLocation location, ResourceLocation other) {
		return location == null && other == null || location.toString().equals(other.toString());
	}

	private static void createResourceLocationArray() {
		blocks = ForgeRegistries.BLOCKS.getKeys().stream().filter(rl -> {
			for (String s : ConfigHandler.get().flardBlockBlacklist.get())
				if (compareResourceLocations(rl, new ResourceLocation(s)))
					return false;

			return true;
		}).toArray(ResourceLocation[]::new);
	}
}
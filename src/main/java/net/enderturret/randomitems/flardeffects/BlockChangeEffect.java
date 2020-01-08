package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockChangeEffect extends FLARDEffect {

	private static ResourceLocation[] blocks = null;

	@Override
	public void runEffect(World worldIn, EntityPlayer playerIn) {
		if (blocks == null) createResourceLocationArray();
		final Block randomBlock = ForgeRegistries.BLOCKS.getValue(blocks[RAND.nextInt(blocks.length)]);
		worldIn.setBlockState(playerIn.getPosition().down(), randomBlock == null ? ModBlocks.CORE_CLEAR.getDefaultState() : randomBlock.getDefaultState());
	}

	@Override
	public boolean canRun(World worldIn, EntityPlayer playerIn) {
		return ConfigHandler.flardEffects.flardBlockChangeEffect && worldIn.getBlockState(playerIn.getPosition().down()) != Blocks.BEDROCK.getDefaultState();
	}

	private static boolean compareResourceLocations(ResourceLocation location, ResourceLocation other) {
		return location == null && other == null || location.toString().equals(other.toString());
	}

	private static void createResourceLocationArray() {
		blocks = ForgeRegistries.BLOCKS.getKeys().stream().filter(rl -> {
			for (String s : ConfigHandler.flardEffects.flardBlockBlacklist)
				if (compareResourceLocations(rl, new ResourceLocation(s)))
					return false;
			return true;
		}).toArray(ResourceLocation[]::new);
	}
}
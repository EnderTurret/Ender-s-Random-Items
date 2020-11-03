package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModBlocks;
import net.enderturret.randomitems.util.RandomItemsUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockChangeEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, EntityPlayer playerIn) {
		final Block randomBlock = ForgeRegistries.BLOCKS.getValue(RandomItemsUtil.pickRandom(RAND, ConfigHandler.flardEffects.getBlockKeys()));
		worldIn.setBlockState(playerIn.getPosition().down(), randomBlock == null ? ModBlocks.CLEAR_CORE.getDefaultState() : randomBlock.getDefaultState());
	}

	@Override
	public boolean canRun(World worldIn, EntityPlayer playerIn) {
		return ConfigHandler.flardEffects.blockChangeEffect &&
				!ConfigHandler.flardEffects.isBlacklisted(worldIn.getBlockState(playerIn.getPosition().down()).getBlock().getRegistryName());
	}

	private static boolean areEqual(ResourceLocation location, ResourceLocation other) {
		return location == null && other == null || location.equals(other);
	}
}
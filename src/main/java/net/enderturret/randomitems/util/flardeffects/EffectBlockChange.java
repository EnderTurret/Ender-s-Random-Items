package net.enderturret.randomitems.util.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModBlocks;
import net.enderturret.randomitems.item.ItemFLARD;
import net.enderturret.randomitems.util.AbstractFLARDEffect;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class EffectBlockChange extends AbstractFLARDEffect {

	private static Block[] blockArray = null;

	@Override
	public void onFLARDEffectRun(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos) {
		if (ConfigHandler.flardEffects.flardBlockChangeEffect) {
			if (blockArray == null)
				blockArray = ForgeRegistries.BLOCKS.getValuesCollection().toArray(new Block[0]);
			Block randomBlock = ModBlocks.coreClear;
			boolean done = false;
			while (!done) {
				randomBlock = blockArray[rand.nextInt(blockArray.length)];
				boolean flag = false;
				for (String s : ConfigHandler.flardEffects.flardBlockBlacklist)
					if (compareResourceLocations(randomBlock.getRegistryName(), new ResourceLocation(s)))
						flag = true;
				if (!flag) done = true;
			}
			worldIn.setBlockState(pos.down(), randomBlock.getDefaultState());
			log(" had the block under them changed to "+randomBlock.getRegistryName().toString(), playerIn);
		} else {
			((ItemFLARD) stack.getItem()).rollEffect(stack, worldIn, playerIn, pos);
		}
	}

	private boolean compareResourceLocations(ResourceLocation location, ResourceLocation other) {
		final String domain = location.toString();
		final String domain2 = other.toString();
		return (domain.equalsIgnoreCase(domain2)) ? true : false;
	}
}
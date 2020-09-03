package net.enderturret.randomitems.block;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IBeaconBeamColorProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class CoreBlock extends Block implements IBeaconBeamColorProvider {

	private final boolean canCraft;
	private final DyeColor beaconBeam;

	public CoreBlock(boolean canCraft, DyeColor color) {
		super(Block.Properties.create(Material.PISTON).sound(SoundType.GLASS).lightValue(15).hardnessAndResistance(3F).notSolid());
		this.canCraft = canCraft;
		this.beaconBeam = color;
	}

	public CoreBlock(DyeColor color) {
		this(true, color);
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult result) {
		if (canCraft && ConfigHandler.get().coreCraftingEnabled.get() && !worldIn.isRemote && !worldIn.isAirBlock(pos.up()))
			return onCraft(worldIn, pos, state, playerIn, worldIn.getBlockState(pos.up()));

		return ActionResultType.FAIL;
	}

	private ActionResultType onCraft(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn, BlockState stateAbove) {
		if (stateAbove == Blocks.END_STONE.getDefaultState()) {
			worldIn.removeBlock(pos.up(), false);
			worldIn.addEntity(new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.QUESTIONABLE_CHEESE.get())));
			return ActionResultType.SUCCESS;
		}

		else if (stateAbove == Blocks.QUARTZ_BLOCK.getDefaultState()) {
			worldIn.removeBlock(pos.up(), false);
			worldIn.addEntity(new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.FLARD.get())));
			return ActionResultType.SUCCESS;
		}

		return ActionResultType.FAIL;
	}

	@Override
	public DyeColor getColor() {
		return beaconBeam;
	}
}
package net.enderturret.randomitems.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IWorld;

public class PlushieBlock extends DirectionalBlock implements IWaterLoggable {

	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	private static final VoxelShape NORTH_AABB = makeCuboidShape(3, 0, 1, 13, 14, 16);
	private static final VoxelShape SOUTH_AABB = makeCuboidShape(3, 0, 0, 13, 14, 15);
	private static final VoxelShape WEST_AABB = makeCuboidShape(1, 0, 3, 16, 14, 13);
	private static final VoxelShape EAST_AABB = makeCuboidShape(0, 0, 3, 15, 14, 13);

	private static final VoxelShape[] AABB = {EAST_AABB, WEST_AABB, SOUTH_AABB, NORTH_AABB};

	public PlushieBlock(Block.Properties settings) {
		super(settings);
		setDefaultState(getDefaultState().with(WATERLOGGED, false));
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext ctx) {
		final boolean fluid = ctx.getWorld().getFluidState(ctx.getPos()).getFluid() == Fluids.WATER;
		return super.getStateForPlacement(ctx).with(WATERLOGGED, fluid);
	}

	@Override
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(WATERLOGGED);
	}

	@Override
	public VoxelShape[] getRotationAABB() {
		return AABB;
	}
}

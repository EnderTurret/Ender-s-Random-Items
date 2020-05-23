package net.enderturret.randomitems.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class DirectionalBlock extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape[] DEFAULT_ROTATIONAL_SHAPE = {makeCuboidShape(0, 0, 0, 16, 16, 16),
			makeCuboidShape(0, 0, 0, 16, 16, 16),
			makeCuboidShape(0, 0, 0, 16, 16, 16),
			makeCuboidShape(0, 0, 0, 16, 16, 16)};

	public DirectionalBlock(Block.Properties settings) {
		super(settings);
		this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
	}

	/**
	 * Used in {@code BlockDirectional} for rotation bounding boxes. Override this if you have a custom bounding box.
	 * The {@code VoxelShape}s in the array need to be in the order:
	 * EAST, WEST, SOUTH, NORTH.
	 * @return An array of {@code VoxelShape}s in the order above.
	 */
	public VoxelShape[] getRotationAABB() {
		return DEFAULT_ROTATIONAL_SHAPE;
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext ctx) {
		return this.getDefaultState().with(FACING, ctx.getPlacementHorizontalFacing());
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext ctx) {
		final VoxelShape[] boundingBox = this.getRotationAABB();
		switch (state.get(FACING)) {
		case EAST: return boundingBox[0];
		case WEST: return boundingBox[1];
		case SOUTH: return boundingBox[2];
		case NORTH:
		default: return boundingBox[3];
		}
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext ctx) {
		final VoxelShape[] boundingBox = this.getRotationAABB();
		switch (state.get(FACING)) {
		case EAST: return boundingBox[0];
		case WEST: return boundingBox[1];
		case SOUTH: return boundingBox[2];
		case NORTH:
		default: return boundingBox[3];
		}
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(FACING);
	}
}
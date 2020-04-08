package net.enderturret.randomitems.block;

import net.enderturret.randomitems.util.RandomItemsUtil;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDirectional extends BlockBase {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public static final AxisAlignedBB[] DEFAULT_AABB = new AxisAlignedBB[] {
			RandomItemsUtil.getAABBFromPixels(0, 0, 0, 16, 16, 16),
			RandomItemsUtil.getAABBFromPixels(0, 0, 0, 16, 16, 16),
			RandomItemsUtil.getAABBFromPixels(0, 0, 0, 16, 16, 16),
			RandomItemsUtil.getAABBFromPixels(0, 0, 0, 16, 16, 16)
	};

	public BlockDirectional(SoundType soundType, Material material) {
		super(soundType, material);
		setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	/**
	 * Used in BlockDirectional for rotation bounding boxes. Override this if you have a custom bounding box.
	 * The AxisAlignedBBs in the array need to be in a particular order:
	 * EAST,
	 * WEST,
	 * SOUTH,
	 * NORTH.
	 * @return An array of AxisAlignedBBs in the order above
	 */
	public AxisAlignedBB[] getRotationAABB() {
		return DEFAULT_AABB;
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getIndex();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.byIndex(meta);
		if (facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
		return this.getDefaultState().withProperty(FACING, facing);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		final AxisAlignedBB[] boundingBox = this.getRotationAABB();
		switch (state.getValue(FACING)) {
		case EAST: return boundingBox[0];
		case WEST: return boundingBox[1];
		case SOUTH: return boundingBox[2];
		case NORTH:
		default: return boundingBox[3];
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		final AxisAlignedBB[] boundingBox = this.getRotationAABB();
		switch (blockState.getValue(FACING)) {
		case EAST: return boundingBox[0];
		case WEST: return boundingBox[1];
		case SOUTH: return boundingBox[2];
		case NORTH:
		default: return boundingBox[3];
		}
	}
}
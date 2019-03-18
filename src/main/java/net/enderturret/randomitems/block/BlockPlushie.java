package net.enderturret.randomitems.block;

import net.enderturret.randomitems.util.RandomItemsUtils;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockPlushie extends BlockDirectional {

	private static final AxisAlignedBB NORTH_AABB = RandomItemsUtils.getAABBFromPixels(3, 0, 1, 13, 14, 16);
	private static final AxisAlignedBB SOUTH_AABB = RandomItemsUtils.getAABBFromPixels(3, 0, 0, 13, 14, 15);
	private static final AxisAlignedBB WEST_AABB = RandomItemsUtils.getAABBFromPixels(1, 0, 3, 16, 14, 13);
	private static final AxisAlignedBB EAST_AABB = RandomItemsUtils.getAABBFromPixels(0, 0, 3, 15, 14, 13);

	public BlockPlushie(String name, SoundType soundType, Material material) {
		super(name, soundType, material);
	}

	@Override
	public boolean isBlockNormalCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isTranslucent(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

	@Override
	public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
		return false;
	}

	@Override
	public AxisAlignedBB[] getRotationAABB() {
		return new AxisAlignedBB[] {EAST_AABB, WEST_AABB, SOUTH_AABB, NORTH_AABB};
	}
}
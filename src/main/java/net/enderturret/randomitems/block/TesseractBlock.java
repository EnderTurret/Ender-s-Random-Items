package net.enderturret.randomitems.block;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.util.RandomItemsUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class TesseractBlock extends Block implements IWaterLoggable {

	private static final VoxelShape AABB;

	static {
		final VoxelShape bottomNorth = makeCuboidShape(1, 0, 15, 16, 1, 16);
		final VoxelShape bottomSouth = makeCuboidShape(0, 0, 0, 16, 1, 1);
		final VoxelShape bottomEast = makeCuboidShape(0, 0, 0, 1, 1, 16);
		final VoxelShape bottomWest = makeCuboidShape(15, 0, 0, 16, 1, 16);
		final VoxelShape topNorth = makeCuboidShape(1, 15, 15, 16, 16, 16);
		final VoxelShape topSouth = makeCuboidShape(0, 15, 0, 16, 16, 1);
		final VoxelShape topEast = makeCuboidShape(0, 15, 0, 1, 16, 16);
		final VoxelShape topWest = makeCuboidShape(15, 15, 0, 16, 16, 16);
		final VoxelShape cornerNW = makeCuboidShape(0, 0, 0, 1, 16, 1);
		final VoxelShape cornerNE = makeCuboidShape(15, 0, 0, 16, 16, 1);
		final VoxelShape cornerSE = makeCuboidShape(15, 0, 15, 16, 16, 16);
		final VoxelShape cornerSW = makeCuboidShape(0, 0, 15, 1, 16, 16);
		final VoxelShape center = makeCuboidShape(4, 4, 4, 12, 12, 12);
		AABB = RandomItemsUtil.combineAll(
				bottomNorth, bottomSouth, bottomEast, bottomWest,
				topNorth, topSouth, topEast, topWest,
				cornerNW, cornerNE, cornerSE, cornerSW, center);
	}

	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private final Effect effect;

	public TesseractBlock(Block.Properties settings, Effect effect) {
		super(settings);
		this.effect = effect;
		setDefaultState(getDefaultState().with(WATERLOGGED, false));
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult result) {
		if (ConfigHandler.get().tesseractsEnabled.get() && !playerIn.isCrouching()) {
			playerIn.addPotionEffect(new EffectInstance(effect, 6000, 0));
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext ctx) {
		final boolean fluid = ctx.getWorld().getFluidState(ctx.getPos()).getFluid() == Fluids.WATER;
		return super.getStateForPlacement(ctx).with(WATERLOGGED, fluid);
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		return stateIn;
	}

	@Override
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB;
	}
}
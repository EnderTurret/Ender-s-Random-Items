package net.enderturret.randomitems.block;

import java.util.Random;

import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.item.KeycardItem;
import net.enderturret.randomitems.tileentity.KeycardReaderTE;
import net.enderturret.randomitems.util.RandomItemsUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class KeycardReaderBlock extends DirectionalBlock implements IWaterLoggable {

	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	private static final VoxelShape[] AABB;

	static {
		final VoxelShape northAABBWall = makeCuboidShape(6, 6, 15, 10, 10, 16);
		final VoxelShape northAABB1 = makeCuboidShape(6, 6, 14, 7, 10, 15);
		final VoxelShape northAABB2 = makeCuboidShape(8, 6, 14, 9, 10, 15);

		final VoxelShape southAABBWall = makeCuboidShape(6, 6, 0, 10, 10, 1);
		final VoxelShape southAABB1 = makeCuboidShape(7, 6, 1, 8, 10, 2);
		final VoxelShape southAABB2 = makeCuboidShape(9, 6, 1, 10, 10, 2);

		final VoxelShape westAABBWall = makeCuboidShape(15, 6, 6, 16, 10, 10);
		final VoxelShape westAABB1 = makeCuboidShape(14, 6, 7, 15, 10, 8);
		final VoxelShape westAABB2 = makeCuboidShape(14, 6, 9, 15, 10, 10);

		final VoxelShape eastAABBWall = makeCuboidShape(0, 6, 6, 1, 10, 10);
		final VoxelShape eastAABB1 = makeCuboidShape(1, 6, 6, 2, 10, 7);
		final VoxelShape eastAABB2 = makeCuboidShape(1, 6, 8, 2, 10, 9);

		final VoxelShape northAABB = RandomItemsUtil.combineAll(northAABBWall, northAABB1, northAABB2);
		final VoxelShape southAABB = RandomItemsUtil.combineAll(southAABBWall, southAABB1, southAABB2);
		final VoxelShape westAABB = RandomItemsUtil.combineAll(westAABBWall, westAABB1, westAABB2);
		final VoxelShape eastAABB = RandomItemsUtil.combineAll(eastAABBWall, eastAABB1, eastAABB2);

		AABB = new VoxelShape[] {eastAABB, westAABB, southAABB, northAABB};
	}

	public KeycardReaderBlock() {
		super(Block.Properties.create(Material.MISCELLANEOUS).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL).hardnessAndResistance(0.5F));
		setDefaultState(getDefaultState().with(WATERLOGGED, false).with(POWERED, false));
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader view) {
		return new KeycardReaderTE();
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext ctx) {
		final boolean fluid = ctx.getWorld().getFluidState(ctx.getPos()).getFluid() == Fluids.WATER;
		return super.getStateForPlacement(ctx).with(FACING, ctx.getPlacementHorizontalFacing().getOpposite()).with(WATERLOGGED, fluid);
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Override
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : Fluids.EMPTY.getDefaultState();
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		if (state.get(POWERED)) {
			worldIn.notifyNeighbors(pos, this);
			worldIn.notifyNeighbors(pos.offset(state.get(FACING).getOpposite()), this);
		}
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

	@Override
	public int getWeakPower(BlockState state, IBlockReader reader, BlockPos pos, Direction direction) {
		return state.get(POWERED) ? 15 : 0;
	}

	@Override
	public int getStrongPower(BlockState state, IBlockReader reader, BlockPos pos, Direction side) {
		if (!state.get(POWERED)) return 0;
		return state.get(FACING) == side ? 15 : 0;
	}

	@Override
	public boolean canProvidePower(BlockState state) {
		return true;
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult result) {
		if (!worldIn.isRemote && worldIn.getTileEntity(pos) != null && worldIn.getTileEntity(pos) instanceof KeycardReaderTE) {
			final KeycardReaderTE te = (KeycardReaderTE) worldIn.getTileEntity(pos);
			if (playerIn.isCrouching() && playerIn.getHeldItemMainhand().isEmpty()) {
				if (te.isOwner(PlayerEntity.getUUID(playerIn.getGameProfile())))
					playerIn.sendMessage(new TranslationTextComponent("randomitems.keycard.getname", te.getKeycardName()));
			}
			else if (!playerIn.isCrouching() && playerIn.getHeldItemMainhand().getItem() instanceof KeycardItem)
				if (te.isNameEqual(playerIn.getHeldItemMainhand().getDisplayName().getString())) {
					worldIn.setBlockState(pos, worldIn.getBlockState(pos).with(POWERED, true), 3);
					((ServerWorld) worldIn).getPendingBlockTicks().scheduleTick(pos, this, 60);
					worldIn.notifyNeighbors(pos, this);
					worldIn.notifyNeighbors(pos.offset(state.get(FACING).getOpposite()), this);
				}
		}
		return ActionResultType.SUCCESS;
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		worldIn.setBlockState(pos, state.with(POWERED, false));
		worldIn.notifyNeighbors(pos, this);
		worldIn.notifyNeighbors(pos.offset(state.get(FACING).getOpposite()), this);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		if (placer instanceof PlayerEntity && !worldIn.isRemote)
			if (worldIn.getTileEntity(pos) != null) {
				final TileEntity reader = worldIn.getTileEntity(pos);
				if (reader instanceof KeycardReaderTE)
					((KeycardReaderTE) reader).setOwner(PlayerEntity.getUUID(((PlayerEntity)placer).getGameProfile()));
				else RandomItems.LOGGER.error("TileEntity is not a keycard reader at " + pos.toString() + "!!!");
			} else RandomItems.LOGGER.error("TileEntity is null at " + pos.toString() + "!!!");
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}

	@Override
	public VoxelShape[] getRotationAABB() {
		return AABB;
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(POWERED, WATERLOGGED);
	}
}

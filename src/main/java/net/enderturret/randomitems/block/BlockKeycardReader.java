package net.enderturret.randomitems.block;

import java.util.Random;

import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.item.ItemKeycard;
import net.enderturret.randomitems.tileentity.TileEntityKeycardReader;
import net.enderturret.randomitems.util.RandomItemsUtils;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockKeycardReader extends BlockDirectional {

	public static final PropertyBool POWERED = PropertyBool.create("powered");
	private static final AxisAlignedBB NORTH_AABB = RandomItemsUtils.getAABBFromPixels(6, 6, 14, 10, 10, 16);
	private static final AxisAlignedBB SOUTH_AABB = RandomItemsUtils.getAABBFromPixels(6, 6, 0, 10, 10, 2);
	private static final AxisAlignedBB WEST_AABB = RandomItemsUtils.getAABBFromPixels(14, 6, 6, 16, 10, 10);
	private static final AxisAlignedBB EAST_AABB = RandomItemsUtils.getAABBFromPixels(0, 6, 6, 2, 10, 10);

	public BlockKeycardReader(String name) {
		super(name, SoundType.STONE, Material.IRON);
		this.setDefaultState(this.getDefaultState().withProperty(POWERED, false));
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityKeycardReader();
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {POWERED, FACING});
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(POWERED, false);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		if (state.getValue(POWERED))
			return state.getValue(FACING).getIndex() + 6;
		else
			return state.getValue(FACING).getIndex();
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (state.getValue(POWERED)) {
			worldIn.notifyNeighborsOfStateChange(pos, this, false);
			worldIn.notifyNeighborsOfStateChange(pos.offset(state.getValue(FACING).getOpposite()), this, false);
		}
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return blockState.getValue(POWERED) ? 15 : 0;
	}

	@Override
	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		if (!blockState.getValue(POWERED))
			return 0;
		else
			return blockState.getValue(FACING) == side ? 15 : 0;
	}

	@Override
	public boolean canProvidePower(IBlockState state) {
		return true;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (meta <= 5)
			return getDefaultState().withProperty(FACING, EnumFacing.values()[meta].getAxis() == EnumFacing.Axis.Y ? EnumFacing.NORTH : EnumFacing.values()[meta]).withProperty(POWERED, false);
		else
			return getDefaultState().withProperty(FACING, EnumFacing.values()[meta - 6]).withProperty(POWERED, true);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote && worldIn.getTileEntity(pos) != null && worldIn.getTileEntity(pos) instanceof TileEntityKeycardReader) {
			final TileEntityKeycardReader te = (TileEntityKeycardReader) worldIn.getTileEntity(pos);
			if (playerIn.isSneaking() && playerIn.getHeldItemMainhand().isEmpty()) {
				if (te.isOwner(EntityPlayer.getUUID(playerIn.getGameProfile())))
					playerIn.sendMessage(new TextComponentString(RandomItemsUtils.localize("randomitems.keycard.getname")+te.getKeycardName()));
			}
			else if (!playerIn.isSneaking() && playerIn.getHeldItemMainhand().getItem() instanceof ItemKeycard)
				if (te.isNameEqual(playerIn.getHeldItemMainhand().getDisplayName())) {
					worldIn.setBlockState(pos, worldIn.getBlockState(pos).withProperty(POWERED, true), 3);
					worldIn.scheduleUpdate(pos, this, 60);
					worldIn.notifyNeighborsOfStateChange(pos, this, false);
					worldIn.notifyNeighborsOfStateChange(pos.offset(state.getValue(FACING).getOpposite()), this, false);
				}
		}
		return true;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		worldIn.setBlockState(pos, state.withProperty(POWERED, false));
		worldIn.notifyNeighborsOfStateChange(pos, this, false);
		worldIn.notifyNeighborsOfStateChange(pos.offset(state.getValue(FACING).getOpposite()), this, false);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if (placer instanceof EntityPlayer && !worldIn.isRemote)
			if (worldIn.getTileEntity(pos) != null && worldIn.getTileEntity(pos) instanceof TileEntityKeycardReader) {
				final TileEntityKeycardReader reader = (TileEntityKeycardReader) worldIn.getTileEntity(pos);
				final EntityPlayer player = (EntityPlayer) placer;
				reader.setOwner(EntityPlayer.getUUID(player.getGameProfile()));
			} else
				RandomItems.log.error("TileEntity is null or not a keycard reader at "+pos.toString());
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
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
	public AxisAlignedBB[] getRotationAABB() {
		return new AxisAlignedBB[] {EAST_AABB, WEST_AABB, SOUTH_AABB, NORTH_AABB};
	}
}
package net.enderturret.randomitems.block;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCore extends BlockBase {

	private final boolean canCraft;
	private final MapColor map;
	private final float[] colorValues;

	public BlockCore(String name, boolean canCraft, EnumDyeColor color) {
		super(name, SoundType.GLASS, Material.PISTON);
		setLightLevel(1F);
		setHardness(3F);
		setResistance(3F);

		this.canCraft = canCraft;
		this.map = color == null ? null : MapColor.getBlockColor(color);
		this.colorValues = color == null ? null : color.getColorComponentValues();
	}

	public BlockCore(String name, EnumDyeColor color) {
		this(name, true, color);
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return map != null ? map : super.getMapColor(state, worldIn, pos);
	}

	@Override
	public float[] getBeaconColorMultiplier(IBlockState state, World world, BlockPos pos, BlockPos beaconPos) {
		return colorValues;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public boolean isTranslucent(IBlockState state) {
		return true;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}


	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (canCraft && ConfigHandler.coreThingEnabled && !worldIn.isRemote && !worldIn.isAirBlock(pos.up()))
			return craft(worldIn, pos, state, playerIn, worldIn.getBlockState(pos.up()));
		return false;
	}

	private static boolean craft(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, IBlockState stateAbove) {
		if (stateAbove == Blocks.END_STONE.getDefaultState()) {
			worldIn.destroyBlock(pos.up(), false);
			worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.QUESTIONABLE_CHEESE)));
			return true;
		}
		else if (stateAbove == Blocks.QUARTZ_BLOCK.getDefaultState()) {
			worldIn.destroyBlock(pos.up(), false);
			worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.FLARD)));
			return true;
		}
		return false;
	}
}
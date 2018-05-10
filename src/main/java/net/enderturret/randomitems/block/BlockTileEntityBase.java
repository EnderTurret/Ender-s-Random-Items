package net.enderturret.randomitems.block;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockTileEntityBase<TE extends TileEntity> extends BlockBase {

	public BlockTileEntityBase(String name, SoundType soundType, Material material) {
		super(name, soundType, material);
	}
	public abstract Class<TE> getTileEntityClass();
	
	public TE getTileEntity(IBlockAccess world, BlockPos pos) {
		return (TE)world.getTileEntity(pos);
	}
	@Override
	public boolean hasTileEntity() {
		return true;
	}
	@Nullable
	@Override
	public abstract TE createTileEntity(World world, IBlockState state);
}
package net.enderturret.randomitems.tileentity;

import java.util.UUID;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KeycardReaderTileEntity extends TileEntity {

	private String keycardName = "";
	private UUID owner = null;

	public KeycardReaderTileEntity() {}

	public String getKeycardName() {
		return keycardName;
	}

	public void setKeycardName(String name) {
		this.keycardName = name;
		markDirty();
	}

	public void setOwner(UUID playerUUID) {
		this.owner = playerUUID;
		markDirty();
	}

	public boolean isOwner(UUID uuid) {
		return owner.equals(uuid);
	}

	public boolean isNameEqual(String keycardName) {
		return keycardName.equals(this.keycardName);
	}

	public EntityPlayer getOwnerPlayer() {
		return world.getPlayerEntityByUUID(owner);
	}

	public UUID getOwnerUUID() {
		return owner;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setString("keycardName", keycardName);
		if (owner != null) compound.setString("owner", owner.toString());
		return super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		keycardName = compound.getString("keycardName");
		if (compound.getString("owner") != null) owner = UUID.fromString(compound.getString("owner"));
		else owner = null;
		super.readFromNBT(compound);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(pos, 1, writeToNBT(new NBTTagCompound()));
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		readFromNBT(tag);
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return oldState.getBlock() != newSate.getBlock();
	}
}
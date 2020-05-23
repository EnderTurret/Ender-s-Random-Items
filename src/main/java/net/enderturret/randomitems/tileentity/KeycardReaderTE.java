package net.enderturret.randomitems.tileentity;

import java.util.UUID;

import net.enderturret.randomitems.init.ModTileEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

public class KeycardReaderTE extends TileEntity {

	private String keycardName = "";
	private UUID owner = null;

	public KeycardReaderTE() {
		super(ModTileEntities.KEYCARD_READER_TYPE.get());
	}

	public String getKeycardName() {
		return keycardName;
	}

	public void setKeycardName(String name) {
		keycardName = name;
		markDirty();
	}

	public void setOwner(UUID playerUUID) {
		owner = playerUUID;
		markDirty();
	}

	public boolean isOwner(UUID uuid) {
		return owner == null && uuid == null || owner.equals(uuid);
	}

	public boolean isNameEqual(String keycardName) {
		return this.keycardName == null && keycardName == null || keycardName.equals(this.keycardName);
	}

	public PlayerEntity getOwnerPlayer() {
		return world.getPlayerByUuid(owner);
	}

	public UUID getOwnerUUID() {
		return owner;
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.putString("keycardName", keycardName);
		if (owner != null) compound.putString("owner", owner.toString());
		return super.write(compound);
	}

	@Override
	public void read(CompoundNBT compound) {
		keycardName = compound.getString("keycardName");
		if (compound.getString("owner") != null) owner = UUID.fromString(compound.getString("owner"));
		else owner = null;
		super.read(compound);
	}

	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(pos, 1, write(new CompoundNBT()));
	}

	@Override
	public void handleUpdateTag(CompoundNBT tag) {
		read(tag);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		return write(new CompoundNBT());
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		read(pkt.getNbtCompound());
	}

	@Override
	public CompoundNBT getTileData() {
		return write(new CompoundNBT());
	}
}

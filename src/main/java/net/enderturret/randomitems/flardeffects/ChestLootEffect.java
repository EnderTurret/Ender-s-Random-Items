package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ChestLootEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, PlayerEntity playerIn) {
		final TileEntity te = worldIn.getTileEntity(playerIn.getPosition().down());
		final LockableLootTileEntity chest = (LockableLootTileEntity) (te != null ? te : worldIn.getTileEntity(playerIn.getPosition()));
		final int rolledTable = RAND.nextInt(CHESTS.length);
		chest.setLootTable(CHESTS[rolledTable], RAND.nextLong());
		chest.fillWithLoot(playerIn);
	}

	@Override
	public boolean canRun(World worldIn, PlayerEntity playerIn) {
		if (ConfigHandler.get().flardChestLootEffect.get()) {
			TileEntity te = worldIn.getTileEntity(playerIn.getPosition().down());
			if (te == null) te = worldIn.getTileEntity(playerIn.getPosition());
			if (te != null)
				if (te instanceof LockableLootTileEntity)
					return ((LockableLootTileEntity) te).isEmpty();
		}
		return false;
	}

	private static final ResourceLocation[] CHESTS = {
			new ResourceLocation("minecraft", "chests/abandoned_mineshaft"),
			new ResourceLocation("minecraft", "chests/desert_pyramid"),
			new ResourceLocation("minecraft", "chests/end_city_treasure"),
			new ResourceLocation("minecraft", "chests/igloo_chest"),
			new ResourceLocation("minecraft", "chests/jungle_temple"),
			new ResourceLocation("minecraft", "chests/jungle_temple_dispenser"),
			new ResourceLocation("minecraft", "chests/nether_bridge"),
			new ResourceLocation("minecraft", "chests/simple_dungeon"),
			new ResourceLocation("minecraft", "chests/spawn_bonus_chest"),
			new ResourceLocation("minecraft", "chests/stronghold_corridor"),
			new ResourceLocation("minecraft", "chests/stronghold_crossing"),
			new ResourceLocation("minecraft", "chests/stronghold_library"),
			new ResourceLocation("minecraft", "chests/village_blacksmith"),
			new ResourceLocation("minecraft", "chests/woodland_mansion")
	};
}
package net.enderturret.randomitems.util.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.item.ItemFLARD;
import net.enderturret.randomitems.util.AbstractFLARDEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EffectChestLoot extends AbstractFLARDEffect {

	@Override
	public void onFLARDEffectRun(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos) {
		if (ConfigHandler.flardEffects.flardChestLootEffect && worldIn.getTileEntity(pos.down()) != null)
			if (worldIn.getTileEntity(pos.down()) != null) {
				TileEntity tileEntity = worldIn.getTileEntity(playerIn.getPosition().down());
				if (tileEntity instanceof TileEntityLockableLoot) {
					TileEntityLockableLoot chest = (TileEntityLockableLoot)tileEntity;
					if (chest.isEmpty()) {
						final int rolledTable = rand.nextInt(CHESTS.length);
						chest.setLootTable(CHESTS[rolledTable], rand.nextLong());
						log(" stood on a chest and got loot placed in it (Player rolled " + CHESTS[rolledTable].toString() + ")", playerIn);
						chest.fillWithLoot(playerIn);
					} else
						log(" would have had a chest of loot, but there were items in it", playerIn);
				} else
					log(" would have had a chest of loot, but there wasn't a TileEntityLockableLoot under their feet", playerIn);
			} else
				log(" would have had a chest of loot, but there wasn't any TileEntities under their feet", playerIn);
		else
			((ItemFLARD) stack.getItem()).rollEffect(stack, worldIn, playerIn, pos);
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
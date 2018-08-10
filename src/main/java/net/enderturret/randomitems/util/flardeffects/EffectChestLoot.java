package net.enderturret.randomitems.util.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.item.ItemFLARD;
import net.enderturret.randomitems.util.IFLARDEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EffectChestLoot implements IFLARDEffect {
	/** Array of chest loot tables. Use for whatever */
	public static final ResourceLocation[] chests = {new ResourceLocation("minecraft", "chests/simple_dungeon"),
			new ResourceLocation("minecraft", "chests/abandoned_mineshaft"), new ResourceLocation("minecraft", "chests/desert_pyramid"),
			new ResourceLocation("minecraft", "chests/end_city_treasure"), new ResourceLocation("minecraft", "chests/stronghold_corridor"),
			new ResourceLocation("minecraft", "chests/jungle_temple"), new ResourceLocation("minecraft", "chests/woodland_mansion")};
	@Override
	public void onFLARDEffectRun(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos) {
		if (ConfigHandler.flardEffects.flardChestLootEffect == true)
			if (worldIn.getTileEntity(pos.down()) != null) {
				TileEntity tileEntity = worldIn.getTileEntity(playerIn.getPosition().down());
				if (tileEntity instanceof TileEntityChest) {
					TileEntityChest chest = (TileEntityChest)tileEntity;
					if (chest.isEmpty()) {
						log(" stood on a chest and got loot placed in it", playerIn);
						chest.setLootTable(chests[rand.nextInt(chests.length)], rand.nextLong());
						chest.fillWithLoot(null);
					}
					else
						log(" would have had a chest of loot, but there were items in it", playerIn);
				}
				else
					log(" would have had a chest of loot, but there wasn't any TileEntityChests under their feet", playerIn);
			}
			else
				log(" would have had a chest of loot, but there wasn't any chests under their feet", playerIn);
		else {
			ItemFLARD f = (ItemFLARD)stack.getItem();
			f.rollEffect(stack, worldIn, playerIn, pos);
		}
	}
}
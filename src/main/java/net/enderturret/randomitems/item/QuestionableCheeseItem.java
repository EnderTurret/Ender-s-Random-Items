package net.enderturret.randomitems.item;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class QuestionableCheeseItem extends Item {

	public QuestionableCheeseItem() {
		super(new Item.Properties().group(RandomItems.TAB));
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!worldIn.isRemote && ConfigHandler.get().questionableCheeseEnabled.get() && entityIn instanceof PlayerEntity) {
			final PlayerEntity playerIn = (PlayerEntity) entityIn;
			if (playerIn.getHeldItemMainhand().getItem() == ModItems.QUESTIONABLE_CHEESE.get() && worldIn.getBlockState(playerIn.getPosition().down()) == Blocks.BEACON.getDefaultState()) {
				worldIn.setBlockState(playerIn.getPosition().down(), Blocks.AIR.getDefaultState());
				worldIn.createExplosion(null, playerIn.getPosition().getX(), playerIn.getPosition().getY() - 1, playerIn.getPosition().getZ(), 8.0F, Explosion.Mode.DESTROY);
			}
		}
	}

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity item) {
		if (!item.getEntityWorld().isRemote && ConfigHandler.get().questionableCheeseEnabled.get() && stack.getItem() == ModItems.QUESTIONABLE_CHEESE.get())
			if (item.getEntityWorld().getBlockState(item.getPosition().down()) == Blocks.BEACON.getDefaultState()) {
				item.getEntityWorld().removeBlock(item.getPosition().down(), false);
				item.getEntityWorld().createExplosion(null, item.getPosition().getX(), item.getPosition().getY() - 1, item.getPosition().getZ(), 8.0F, Explosion.Mode.DESTROY);
			}
		return false;
	}
}
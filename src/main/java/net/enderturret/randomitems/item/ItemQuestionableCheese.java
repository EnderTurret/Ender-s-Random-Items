package net.enderturret.randomitems.item;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemQuestionableCheese extends ItemBase {
	public ItemQuestionableCheese() {
		super("questionable_cheese");
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!worldIn.isRemote)
			if (ConfigHandler.questionableCheeseEnabled == true)
				if (entityIn instanceof EntityPlayer) {
					EntityPlayer playerIn = (EntityPlayer) entityIn;
					if (playerIn.getHeldItemMainhand().getItem() == ModItems.questionableCheese)
						if (worldIn.getBlockState(playerIn.getPosition().down()) == Blocks.BEACON.getDefaultState()) {
							worldIn.setBlockToAir(playerIn.getPosition().down());
							worldIn.createExplosion(null, playerIn.getPosition().getX(), playerIn.getPosition().getY()-1, playerIn.getPosition().getZ(), 8.0F, true);
						}
				}
	}
	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) {
		World worldIn = entityItem.getEntityWorld();
		if (!worldIn.isRemote)
			if (ConfigHandler.questionableCheeseEnabled == true)
				if (entityItem.getItem().isItemEqual(new ItemStack(ModItems.questionableCheese)))
					if (worldIn.getBlockState(entityItem.getPosition().down()) == Blocks.BEACON.getDefaultState()) {
						worldIn.setBlockToAir(entityItem.getPosition().down());
						worldIn.createExplosion(null, entityItem.getPosition().getX(), entityItem.getPosition().getY()-1, entityItem.getPosition().getZ(), 8.0F, true);
						return true;
					}
		return false;
	}
}
package net.enderturret.randomitems.item;

import net.enderturret.randomitems.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemQuestionableCheese extends ItemBase {

	public ItemQuestionableCheese() {
		super("questionable_cheese");
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!worldIn.isRemote)
			if (entityIn instanceof EntityPlayer) {
				EntityPlayer playerIn = (EntityPlayer)entityIn;
				if (playerIn.getHeldItemMainhand().getItem() == ModItems.questionableCheese) {
					double x = playerIn.posX;
					double y = playerIn.posY;
					double z = playerIn.posZ;
					BlockPos pos = new BlockPos(x, y-1, z);
					if (worldIn.getBlockState(pos) == Blocks.BEACON.getDefaultState()) {
						worldIn.setBlockToAir(pos);
						worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 8.0F, true);
					}
				}
			}
	}
}
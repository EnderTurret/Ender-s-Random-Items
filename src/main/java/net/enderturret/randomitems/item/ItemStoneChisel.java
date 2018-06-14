package net.enderturret.randomitems.item;

import java.util.Random;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemStoneChisel extends ItemBase {
	static final Random rand = new Random();
	public ItemStoneChisel(String name, int durability) {
		super(name);
		setMaxDamage(durability);
		setMaxStackSize(1);
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (ConfigHandler.stoneChiselEnabled == true && player.getHeldItemMainhand().getItem() == ModItems.stoneChisel)
			if (worldIn.getBlockState(pos) == Blocks.STONE.getDefaultState()) {
				player.addItemStackToInventory(new ItemStack(ModItems.stoneStick, 6));
				worldIn.setBlockToAir(pos);
				if (player.getHeldItemMainhand().getItemDamage() == 32) {
					player.setHeldItem(hand, ItemStack.EMPTY);
					player.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1f, 1f);
				}
				player.getHeldItemMainhand().attemptDamageItem(1, rand, null);
				return EnumActionResult.SUCCESS;
			}
	return EnumActionResult.FAIL;
	}
}
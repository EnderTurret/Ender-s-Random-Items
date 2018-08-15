package net.enderturret.randomitems.item;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemStoneChisel extends ItemBase {

	private final int stickAmount;

	public ItemStoneChisel(String name, int durability, int stickAmount) {
		super(name);
		setMaxDamage(durability);
		setMaxStackSize(1);
		this.stickAmount = stickAmount;
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (ConfigHandler.stoneChiselEnabled && worldIn.getBlockState(pos) == Blocks.STONE.getDefaultState()) {
			playerIn.addItemStackToInventory(new ItemStack(ModItems.stoneStick, stickAmount));
			worldIn.setBlockToAir(pos);
			if (playerIn.getHeldItem(hand).getItemDamage() == playerIn.getHeldItem(hand).getMaxDamage()) {
				playerIn.setHeldItem(hand, ItemStack.EMPTY);
				playerIn.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1f, 1f);
			}
			playerIn.getHeldItem(hand).attemptDamageItem(1, Item.itemRand, null);
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.FAIL;
	}
}
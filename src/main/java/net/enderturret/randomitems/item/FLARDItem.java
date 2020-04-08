package net.enderturret.randomitems.item;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.FLARDEffectRegistry;
import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.flardeffects.FLARDEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class FLARDItem extends Item {

	public FLARDItem() {
		setMaxStackSize(1);
	}

	@Override
	public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
		return true;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!worldIn.isRemote && ConfigHandler.flardEnabled)
			rollEffect(playerIn.getHeldItem(handIn), worldIn, playerIn, playerIn.getPosition());
		return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	/**
	 * Rolls a FLARD effect.
	 * @param stack The {@code ItemStack} containing this item.
	 * @param worldIn The player's world.
	 * @param playerIn The player right-clicking this item.
	 * @param pos The player's position.
	 */
	public void rollEffect(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos) {
		FLARDEffect effect = null;
		int tries = 0;
		while ((effect = FLARDEffectRegistry.getRandom(itemRand)) != null && !effect.canRun(worldIn, playerIn)) {
			tries++;
			if (tries == 100) {
				playerIn.sendMessage(new TextComponentTranslation("randomitems.flard.fail"));
				finishRoll(playerIn);
				return;
			}
		}
		finishRoll(playerIn);
		try {
			effect.runEffect(worldIn, playerIn);
		} catch (Exception e) {
			RandomItems.LOGGER.error("An exception occurred while processing effect " + effect.getRegistryName().toString() + ".", e);
		}
	}

	public void finishRoll(EntityPlayer playerIn) {
		playerIn.inventory.deleteStack(playerIn.getHeldItemMainhand());
	}
}
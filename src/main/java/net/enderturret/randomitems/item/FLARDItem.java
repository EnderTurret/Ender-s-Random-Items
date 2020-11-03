package net.enderturret.randomitems.item;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.FLARDEffectRegistry;
import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.flardeffects.FLARDEffect;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class FLARDItem extends Item {

	public FLARDItem(Item.Properties props) {
		super(props);
	}

	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
		return true;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!worldIn.isRemote && ConfigHandler.isFLARDEnabled() && playerIn.getHeldItemMainhand().getItem() == ModItems.FLARD.get())
			rollEffect(worldIn, playerIn);

		return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
	}

	/**
	 * Rolls and processes a {@link FLARDEffect}.
	 * @param worldIn The player's world.
	 * @param playerIn The player right-clicking this item.
	 */
	public void rollEffect(World worldIn, PlayerEntity playerIn) {
		FLARDEffect effect = null;
		int tries = 0;

		while ((effect = FLARDEffectRegistry.getRandom(random)) != null && !effect.canRun(worldIn, playerIn)) {
			tries++;
			if (tries == 100) {
				playerIn.sendMessage(new TranslationTextComponent("randomitems.flard.fail"));
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

	public void finishRoll(PlayerEntity playerIn) {
		playerIn.inventory.deleteStack(playerIn.getHeldItemMainhand());
	}
}
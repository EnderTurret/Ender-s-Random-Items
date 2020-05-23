package net.enderturret.randomitems.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

public class AntiGravityEnchantment extends BaseEnchantment {

	protected AntiGravityEnchantment() {
		super(Rarity.VERY_RARE, EnchantmentType.ARMOR_FEET, EquipmentSlotType.FEET);
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return canApply(stack);
	}

	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof ArmorItem && ((ArmorItem) stack.getItem()).getEquipmentSlot() == EquipmentSlotType.FEET;
	}

	@Override
	public int getMinEnchantability(int level) {
		return 5 + level;
	}
}

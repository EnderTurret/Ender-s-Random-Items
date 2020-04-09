package net.enderturret.randomitems.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class AntiGravityEnchantment extends BaseEnchantment {

	protected AntiGravityEnchantment() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR_FEET, EntityEquipmentSlot.FEET);
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
		return stack.getItem() instanceof ItemArmor && ((ItemArmor) stack.getItem()).getEquipmentSlot() == EntityEquipmentSlot.FEET;
	}

	@Override
	public int getMaxEnchantability(int level) {
		return 500;
	}

	@Override
	public int getMinEnchantability(int level) {
		return 5 + level;
	}
}

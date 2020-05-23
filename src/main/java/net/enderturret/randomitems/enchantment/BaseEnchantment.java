package net.enderturret.randomitems.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public abstract class BaseEnchantment extends Enchantment {

	protected BaseEnchantment(Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		super(rarity, type, slots);
	}
}
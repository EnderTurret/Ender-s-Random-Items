package net.enderturret.randomitems.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class EnchantmentGravity extends Enchantment {

	private final String enchantmentName = "antigravity";

	protected EnchantmentGravity() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR_FEET, new EntityEquipmentSlot[]{EntityEquipmentSlot.FEET});
		this.setRegistryName(enchantmentName);
		this.setName(enchantmentName);
	}
	@Override
	public int getMaxLevel() {
		return 3;
	}
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return true;
	}
	@Override
	public boolean canApply(ItemStack stack) {
		if (stack.isItemEqual(new ItemStack(Items.DIAMOND_BOOTS)) || stack.isItemEqual(new ItemStack(Items.CHAINMAIL_BOOTS)) || stack.isItemEqual(new ItemStack(Items.GOLDEN_BOOTS)) || stack.isItemEqual(new ItemStack(Items.IRON_BOOTS)) || stack.isItemEqual(new ItemStack(Items.LEATHER_BOOTS)))
			return true;
		else
			return false;
	}
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return 9000;
	}
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 5+enchantmentLevel;
	}
}
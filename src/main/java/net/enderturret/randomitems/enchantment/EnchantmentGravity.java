package net.enderturret.randomitems.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class EnchantmentGravity extends Enchantment {

	private final String enchName = "antigravity";

	protected EnchantmentGravity() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR_FEET, new EntityEquipmentSlot[]{EntityEquipmentSlot.FEET});
		setRegistryName(enchName);
		setName(enchName);
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return stack.isItemEqual(new ItemStack(Items.DIAMOND_BOOTS)) || stack.isItemEqual(new ItemStack(Items.CHAINMAIL_BOOTS)) || stack.isItemEqual(new ItemStack(Items.GOLDEN_BOOTS)) || stack.isItemEqual(new ItemStack(Items.IRON_BOOTS)) || stack.isItemEqual(new ItemStack(Items.LEATHER_BOOTS)) ? true : false;
	}

	@Override
	public boolean canApply(ItemStack stack) {
		return stack.isItemEqual(new ItemStack(Items.DIAMOND_BOOTS)) || stack.isItemEqual(new ItemStack(Items.CHAINMAIL_BOOTS)) || stack.isItemEqual(new ItemStack(Items.GOLDEN_BOOTS)) || stack.isItemEqual(new ItemStack(Items.IRON_BOOTS)) || stack.isItemEqual(new ItemStack(Items.LEATHER_BOOTS)) ? true : false;
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return 500;
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 5+enchantmentLevel;
	}
}
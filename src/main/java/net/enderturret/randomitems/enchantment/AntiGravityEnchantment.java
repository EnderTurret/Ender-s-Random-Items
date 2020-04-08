package net.enderturret.randomitems.enchantment;

import net.enderturret.randomitems.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AntiGravityEnchantment extends Enchantment {

	protected AntiGravityEnchantment() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR_FEET, new EntityEquipmentSlot[]{EntityEquipmentSlot.FEET});
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return isSuitableItem(stack.getItem());
	}

	@Override
	public boolean canApply(ItemStack stack) {
		return isSuitableItem(stack.getItem());
	}

	private boolean isSuitableItem(Item item) {
		return item == Items.DIAMOND_BOOTS ||
				item == Items.CHAINMAIL_BOOTS ||
				item == Items.GOLDEN_BOOTS ||
				item == Items.IRON_BOOTS ||
				item == Items.LEATHER_BOOTS;
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
package net.enderturret.randomitems.item;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class SaturatedFoodItem extends ItemFood {

	private final boolean drink;

	public SaturatedFoodItem(int food, float saturation, boolean isWolfFood, boolean isDrink) {
		super(food, saturation, isWolfFood);
		this.drink = isDrink;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return drink ? EnumAction.DRINK : EnumAction.EAT;
	}
}
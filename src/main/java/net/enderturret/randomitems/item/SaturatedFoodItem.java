package net.enderturret.randomitems.item;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class SaturatedFoodItem extends ItemFood {

	private final String name;
	private final boolean drink;

	public SaturatedFoodItem(String name, int food, float saturation, boolean isWolfFood, boolean isDrink) {
		super(food, saturation, isWolfFood);
		this.name = name;
		this.drink = isDrink;
		setTranslationKey(name);
		setRegistryName(name);
		if (!"secret_coke".equals(name)) setCreativeTab(RandomItems.TAB);
		//else setCreativeTab(null);
	}

	public void registerItemModel() {
		RandomItems.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return drink ? EnumAction.DRINK : EnumAction.EAT;
	}
}
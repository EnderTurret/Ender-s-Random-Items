package net.enderturret.randomitems.item;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class SaturatedFoodItem extends ItemFood {

	private final String name;
	private final boolean isDrink;

	public SaturatedFoodItem(String name, int food, float saturation, boolean isWolfFood, boolean isDrink) {
		super(food, saturation, isWolfFood);
		this.name = name;
		this.isDrink = isDrink;
		setUnlocalizedName(name);
		setRegistryName(name);
		if (!name.equals("secret_coke")) setCreativeTab(RandomItems.creativeTab);
		else setCreativeTab(null);
	}

	public void registerItemModel() {
		RandomItems.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return isDrink ? EnumAction.DRINK : EnumAction.EAT;
	}
}
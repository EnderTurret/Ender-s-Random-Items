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
		setCreativeTab(null);
	}
	// Register the model, because no one likes black and purple
	public void registerItemModel() {
		RandomItems.proxy.registerItemRenderer(this, 0, name);
	}
	// Make this actually look like you are drinking it
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return isDrink ? EnumAction.DRINK : EnumAction.EAT;
	}
}
package net.enderturret.randomitems.item;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class SaturatedDrinkItem extends ItemFood {
	private final String name;
	public SaturatedDrinkItem(String name, int Food, float Saturation, boolean isWolfFood) {
		super(Food, Saturation, isWolfFood);
		this.name = name;
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
		return EnumAction.DRINK;
	}
}
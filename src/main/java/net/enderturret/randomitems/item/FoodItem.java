package net.enderturret.randomitems.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;

public class FoodItem extends Item {

	private final boolean drink;
	public static final float DEFAULT_SATURATION = 0.7F;

	public FoodItem(Item.Properties settings, int food, float saturation, boolean isWolfFood, boolean isDrink) {
		this(settings, isWolfFood ? new Food.Builder()
				.hunger(food)
				.saturation(saturation)
				.meat()
				.build() : new Food.Builder()
				.hunger(food)
				.saturation(saturation)
				.build(), isDrink);
	}

	public FoodItem(Item.Properties settings, int food, float saturation) {
		this(settings, new Food.Builder()
				.hunger(food)
				.saturation(saturation)
				.build(), false);
	}

	public FoodItem(Item.Properties settings, Food foodSettings, boolean isDrink) {
		super(settings.food(foodSettings));
		this.drink = isDrink;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return drink ? UseAction.DRINK : UseAction.EAT;
	}
}

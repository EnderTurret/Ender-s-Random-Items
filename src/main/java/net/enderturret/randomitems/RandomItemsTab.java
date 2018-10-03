package net.enderturret.randomitems;

import net.enderturret.randomitems.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RandomItemsTab extends CreativeTabs {

	public RandomItemsTab() {
		super("randomitems");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.tesseract);
	}
}
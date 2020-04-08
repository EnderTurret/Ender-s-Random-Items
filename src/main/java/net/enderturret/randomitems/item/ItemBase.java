package net.enderturret.randomitems.item;

import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.Reference;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	//private final String name;

	public ItemBase(String name) {
		//this.name = name;
		setTranslationKey(name);
		setRegistryName(Reference.MOD_ID, name);
		setCreativeTab(RandomItems.TAB);
	}

	/*
	 * 'Registers' the item model with the specified meta value.
	 * @param meta The meta value of the item.
	 *
	public void registerItemModel(int meta) {
		RandomItems.proxy.registerItemRenderer(this, meta, name);
	}

	/*
	 * Convenience method for {@code registerItemModel(0)}.
	 *
	public void registerItemModel() {
		this.registerItemModel(0);
	}*/
}
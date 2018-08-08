package net.enderturret.randomitems.item;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	private final String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(RandomItems.creativeTab);
	}
	/** Registers the item model with meta */
	public void registerItemModel(int meta) {
			RandomItems.proxy.registerItemRenderer(this, meta, name);
	}
	/** Registers the item model with a meta of 0 */
	public void registerItemModel() {
		RandomItems.proxy.registerItemRenderer(this, 0, name);
	}
}
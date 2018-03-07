package net.enderturret.randomitems.item;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.item.Item;

public class ItemBase extends Item {
	protected String name;

  	public ItemBase(String name)
  	{
  		this.name = name;
  		setUnlocalizedName(name);
  		setRegistryName(name);
  		setCreativeTab(RandomItems.creativeTab);
  	}
  	// Item model
  	public void registerItemModel() {
  		RandomItems.proxy.registerItemRenderer(this, 0, name);
  	}
}
package net.enderturret.randomitems.proxy;

import net.minecraft.item.Item;

public interface IProxy {
	public boolean isNVIDIA();
	public void registerItemRenderer(Item item, int meta, String id);
	public void nvidiaCrash();
	public void init();
}
package net.enderturret.randomitems.proxy;

import net.minecraft.item.Item;

public class ServerProxy implements IProxy {

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {}

	@Override
	public void nvidiaCrash() {}

	@Override
	public void init() {}

	@Override
	public boolean nVIDIA() { return false; }
}
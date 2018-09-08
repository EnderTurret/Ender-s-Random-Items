package net.enderturret.randomitems.proxy;

import net.minecraft.item.Item;
import net.minecraft.util.text.translation.I18n;

public class CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id) {}

	public void nvidiaCrash() {}

	public String localize(String unlocalized) {
		return I18n.translateToLocal(unlocalized);
	}
}
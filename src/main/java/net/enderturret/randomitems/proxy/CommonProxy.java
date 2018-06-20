package net.enderturret.randomitems.proxy;

import net.minecraft.item.Item;
import net.minecraft.util.text.translation.I18n;

public class CommonProxy {
	// ...
	public void registerItemRenderer(Item item, int meta, String id) {}
	// This doesn't exist what are you talking about?
	public void notSuspicious() {}
	public String localize(String unlocalized, Object... args) {
		return I18n.translateToLocalFormatted(unlocalized, args);
	}
}
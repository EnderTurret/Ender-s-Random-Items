package net.enderturret.randomitems.util;

import net.minecraft.util.text.TextComponentTranslation;

public class RandomItemsUtils {

	public static String localize(String unlocalized) {
		return new TextComponentTranslation(unlocalized).getUnformattedComponentText();
	}
}
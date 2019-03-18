package net.enderturret.randomitems.util;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentTranslation;

public class RandomItemsUtils {

	public static String localize(String unlocalized) {
		return new TextComponentTranslation(unlocalized).getUnformattedComponentText();
	}

	public static AxisAlignedBB getAABBFromPixels(int x1, int y1, int z1, int x2, int y2, int z2) {
		return new AxisAlignedBB(0.0625 * x1, 0.0625 * y1, 0.0625 * z1, 0.0625 * x2, 0.0625 * y2, 0.0625 * z2);
	}
}
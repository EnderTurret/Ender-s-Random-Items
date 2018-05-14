package net.enderturret.randomitems.util;

import java.util.ArrayList;
import java.util.List;

import net.enderturret.randomitems.RandomItems;

public class FLARDEffectRegistry {

	public static List<ICustomFLARDEffect> effects = new ArrayList();

	public static void register(ICustomFLARDEffect flardEffect) {
		if (flardEffect != null) {
			effects.add(flardEffect);
		}
	}
	public static void registerAll(ICustomFLARDEffect... flardEffects) {
		for (int i = 0; i < flardEffects.length; i++)
			if (flardEffects[i] != null)
				effects.add(flardEffects[i]);
	}
}
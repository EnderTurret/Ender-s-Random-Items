package net.enderturret.randomitems.util;

import java.util.ArrayList;

public class FLARDEffectRegistry {
	/** The registry */
	public static ArrayList<ICustomFLARDEffect> effects = new ArrayList();
	/** For registering your effects. */
	public static void registerAll(ICustomFLARDEffect... flardEffects) {
		for (ICustomFLARDEffect i : flardEffects)
			if (i != null) effects.add(i);
	}
}
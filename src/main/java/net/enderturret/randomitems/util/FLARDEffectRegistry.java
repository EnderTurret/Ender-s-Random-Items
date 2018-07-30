package net.enderturret.randomitems.util;

import java.util.ArrayList;

public class FLARDEffectRegistry {
	/** The registry */
	public static ArrayList<ICustomFLARDEffect> effects = new ArrayList();
	/** For registering an effect. Preferably call in preInit */
	public static void register(ICustomFLARDEffect effect) {
		if (effect != null) effects.add(effect);
	}
	/** For registering more than one effect. Preferably call in preInit */
	public static void registerAll(ICustomFLARDEffect... flardEffects) {
		for (ICustomFLARDEffect i : flardEffects)
			if (i != null) effects.add(i);
	}
}
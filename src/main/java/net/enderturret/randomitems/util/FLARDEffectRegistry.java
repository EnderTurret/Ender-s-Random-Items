package net.enderturret.randomitems.util;

import java.util.ArrayList;
import java.util.List;

public class FLARDEffectRegistry {
	/** The registry */
	public static List<ICustomFLARDEffect> effects = new ArrayList();
	/** For registering an effect. Preferably call in preInit */
	public static void register(ICustomFLARDEffect flardEffect) {
		if (flardEffect != null)
			effects.add(flardEffect);
	}
	/** For registering more than one effect. Preferably call in preInit */
	public static void registerAll(ICustomFLARDEffect... flardEffects) {
		for (int i = 0; i < flardEffects.length; i++)
			if (flardEffects[i] != null)
				effects.add(flardEffects[i]);
	}
}
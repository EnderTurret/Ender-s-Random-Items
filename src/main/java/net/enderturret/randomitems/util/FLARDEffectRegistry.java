package net.enderturret.randomitems.util;

import java.util.ArrayList;

public class FLARDEffectRegistry {
	/** The registry */
	public static ArrayList<IFLARDEffect> registry = new ArrayList();
	/** For registering your effects. */
	public static void registerAll(IFLARDEffect... effects) {
		for (IFLARDEffect i : effects)
			if (i != null) registry.add(i);
	}
}
package net.enderturret.randomitems.util;

import java.util.ArrayList;

import net.enderturret.randomitems.RandomItems;

public class FLARDEffectRegistry {
	/** The registry */
	public static final ArrayList<AbstractFLARDEffect> registry = new ArrayList<AbstractFLARDEffect>();
	/** For registering your effects. */
	public static void registerAll(AbstractFLARDEffect... effects) {
		for (AbstractFLARDEffect i : effects) {
			if (i != null)
				registry.add(i);
			else
				RandomItems.log.warn("Tried to register a null effect");
		}
	}
}
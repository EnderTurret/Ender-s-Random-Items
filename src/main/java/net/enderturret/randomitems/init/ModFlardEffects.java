package net.enderturret.randomitems.init;

import net.enderturret.randomitems.FLARDEffectRegistry;
import net.enderturret.randomitems.Reference;
import net.enderturret.randomitems.flardeffects.*;
import net.minecraftforge.registries.DeferredRegister;

public class ModFlardEffects {

	public static final DeferredRegister<FLARDEffect> REGISTRY = new DeferredRegister<>(FLARDEffectRegistry.getRegistry(), Reference.MOD_ID);

	static {
		REGISTRY.register("block_change", BlockChangeEffect::new);
		REGISTRY.register("chest_loot", ChestLootEffect::new);
		REGISTRY.register("cobweb", CobwebEffect::new);
		REGISTRY.register("diamond", DiamondEffect::new);
		REGISTRY.register("enchantment", EnchantmentEffect::new);
		REGISTRY.register("explosion", ExplosionEffect::new);
		REGISTRY.register("fire", FireEffect::new);
		REGISTRY.register("hole", HoleEffect::new);
		REGISTRY.register("inventory_drop", InventoryDropEffect::new);
		REGISTRY.register("lightning", LightningEffect::new);
		REGISTRY.register("poison", PoisonEffect::new);
		REGISTRY.register("puddle", PuddleEffect::new);
		REGISTRY.register("xp", XPEffect::new);
	}
}
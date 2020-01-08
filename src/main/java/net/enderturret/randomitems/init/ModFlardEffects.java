package net.enderturret.randomitems.init;

import net.enderturret.randomitems.Reference;
import net.enderturret.randomitems.flardeffects.*;
import net.minecraftforge.registries.IForgeRegistry;

public class ModFlardEffects {

	public static void registerAll(IForgeRegistry<FLARDEffect> registry) {
		registry.registerAll(
				new BlockChangeEffect().setRegistryName(Reference.MOD_ID, "block_change"),
				new ChestLootEffect().setRegistryName(Reference.MOD_ID, "chest_loot"),
				new CobwebEffect().setRegistryName(Reference.MOD_ID, "cobweb"),
				new DiamondEffect().setRegistryName(Reference.MOD_ID, "diamond"),
				new EnchantmentEffect().setRegistryName(Reference.MOD_ID, "enchantment"),
				new ExplosionEffect().setRegistryName(Reference.MOD_ID, "explosion"),
				new FireEffect().setRegistryName(Reference.MOD_ID, "fire"),
				new HoleEffect().setRegistryName(Reference.MOD_ID, "hole"),
				new InventoryDropEffect().setRegistryName(Reference.MOD_ID, "inventory_drop"),
				new LightningEffect().setRegistryName(Reference.MOD_ID, "lightning"),
				new PoisonEffect().setRegistryName(Reference.MOD_ID, "poison"),
				new PuddleEffect().setRegistryName(Reference.MOD_ID, "puddle"),
				new XPEffect().setRegistryName(Reference.MOD_ID, "xp")
				);
	}
}
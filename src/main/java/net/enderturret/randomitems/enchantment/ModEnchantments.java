package net.enderturret.randomitems.enchantment;

import net.enderturret.randomitems.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchantments {

	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Reference.MOD_ID);

	public static final RegistryObject<Enchantment> ANTI_GRAVITY = REGISTRY.register("antigravity", AntiGravityEnchantment::new);
}
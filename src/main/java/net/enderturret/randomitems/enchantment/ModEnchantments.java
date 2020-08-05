package net.enderturret.randomitems.enchantment;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@EventBusSubscriber(modid = Reference.MOD_ID)
@ObjectHolder(Reference.MOD_ID)
public class ModEnchantments {

	@ObjectHolder("antigravity")
	public static final Enchantment ANTI_GRAVITY = null;
	@ObjectHolder("nvidia")
	public static final Enchantment NVIDIA = null;

	@SubscribeEvent
	public static void registerEnchants(RegistryEvent.Register<Enchantment> registry) {
		registry.getRegistry().registerAll(
				configure(new AntiGravityEnchantment(), "antigravity"));
	}

	@SubscribeEvent
	public static void onEntityUpdate(LivingUpdateEvent e) {
		if (!e.getEntityLiving().getEntityWorld().isRemote) {
			final int lvlGrav = EnchantmentHelper.getMaxEnchantmentLevel(ANTI_GRAVITY, e.getEntityLiving());
			if (lvlGrav > 0 && ConfigHandler.antiGravEnabled)
				e.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, Math.min(3, lvlGrav)));
		}
	}

	public static <T extends Enchantment> T configure(T enchant, String registryName) {
		enchant.setRegistryName(Reference.MOD_ID, registryName).setName(registryName);
		return enchant;
	}
}
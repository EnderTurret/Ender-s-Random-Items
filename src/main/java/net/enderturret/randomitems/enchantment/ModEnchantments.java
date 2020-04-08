package net.enderturret.randomitems.enchantment;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MOD_ID)
public class ModEnchantments {

	public static final Enchantment ANTI_GRAVITY = new EnchantmentGravity();
	public static final Enchantment NVIDIA = new EnchantmentNVIDIA();

	@SubscribeEvent
	public static void registerEnchants(Register<Enchantment> registry) {
		registry.getRegistry().registerAll(ANTI_GRAVITY, NVIDIA);
	}

	@SubscribeEvent
	public static void onEntityUpdate(LivingUpdateEvent e) {
		if (!e.getEntityLiving().getEntityWorld().isRemote) {
			final int lvlGrav = EnchantmentHelper.getMaxEnchantmentLevel(ANTI_GRAVITY, e.getEntityLiving());
			if (lvlGrav > 0 && ConfigHandler.antiGravEnabled)
				e.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, Math.min(3, lvlGrav)));
		}
	}
}
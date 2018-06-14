package net.enderturret.randomitems.enchantment;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.Referance;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Referance.modId)
public class ModEnchantments {
	public static final Enchantment antiGravity = new EnchantmentGravity();
	public static final Enchantment nvidia = new EnchantmentNVIDIA();
	@SubscribeEvent
	public static void registerEnchants(Register<Enchantment> registry) {
		registry.getRegistry().registerAll(antiGravity, nvidia);
	}
	@SubscribeEvent
	public static void onEntityUpdate(LivingUpdateEvent e) {
		if (!e.getEntity().getEntityWorld().isRemote) {
			if (e.getEntity() instanceof EntityPlayer) {
				EntityPlayer playerIn = (EntityPlayer)e.getEntity();
				int levelGravity = EnchantmentHelper.getMaxEnchantmentLevel(antiGravity, e.getEntityLiving());
				if (levelGravity>0 && ConfigHandler.antiGravEnabled) {
					if (levelGravity==1)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 1));
					if (levelGravity==2)
						playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 2));
					if (levelGravity>2)
						playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 3));
				}
			}
		}
	}
}
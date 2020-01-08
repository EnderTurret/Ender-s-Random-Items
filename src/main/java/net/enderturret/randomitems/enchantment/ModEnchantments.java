package net.enderturret.randomitems.enchantment;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MOD_ID)
public class ModEnchantments {

	public static final Enchantment antiGravity = new EnchantmentGravity();
	public static final Enchantment nvidia = new EnchantmentNVIDIA();

	@SubscribeEvent
	public static void registerEnchants(Register<Enchantment> registry) {
		registry.getRegistry().registerAll(antiGravity, nvidia);
	}

	@SubscribeEvent
	public static void onEntityUpdate(LivingUpdateEvent e) {
		if (!e.getEntity().getEntityWorld().isRemote && e.getEntity() instanceof EntityPlayer) {
			EntityPlayer playerIn = (EntityPlayer)e.getEntity();
			int lvlGrav = EnchantmentHelper.getMaxEnchantmentLevel(antiGravity, e.getEntityLiving());
			if (lvlGrav>0 && ConfigHandler.antiGravEnabled) {
				if (lvlGrav==1) playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 1));
				if (lvlGrav==2) playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 2));
				if (lvlGrav>2) playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 3));
			}
		}
	}
}
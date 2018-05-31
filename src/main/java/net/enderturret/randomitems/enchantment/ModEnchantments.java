package net.enderturret.randomitems.enchantment;

import net.enderturret.randomitems.Referance;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Referance.modId)
public class ModEnchantments {

	public static final Enchantment antiGravity = new EnchantmentGravity();

	@SubscribeEvent
	public static void registerEnchants(Register<Enchantment> registry) {
		registry.getRegistry().registerAll(antiGravity);
	}
	@SubscribeEvent
	public static void onEntityUpdate(LivingUpdateEvent e) {
		if (!e.getEntity().getEntityWorld().isRemote) {
			if (e.getEntity() instanceof EntityPlayer) {
				EntityPlayer playerIn = (EntityPlayer)e.getEntity();
				int l = EnchantmentHelper.getMaxEnchantmentLevel(antiGravity, e.getEntityLiving());
				if (l>0) {
					if (l==1)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 1));
					if (l==2)
						playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 2));
					if (l>2)
						playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 3));
				}
			}
		}
	}
}
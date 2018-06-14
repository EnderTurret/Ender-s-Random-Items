package net.enderturret.randomitems.enchantment;

import java.util.Random;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.RandomItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

// Joke
public class EnchantmentNVIDIA extends Enchantment {
	private final String enchName = "nvidia";
	protected EnchantmentNVIDIA() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
		this.setRegistryName(enchName);
		this.setName(enchName);
	}
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		if (stack.getItem() == Items.DIAMOND_SWORD && ConfigHandler.nvidiaEnchantmentEnabled)
			return true;
		else
			return false;
	}
	@Override
	public int getMaxLevel() {
		return 1;
	}
	@Override
	public boolean canApply(ItemStack stack) {
		if (stack.getItem() == Items.DIAMOND_SWORD && ConfigHandler.nvidiaEnchantmentEnabled)
			return true;
		else
			return false;
	}
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return 19;
	}
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 8;
	}
	@Override
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
		final Random rand = new Random();
		if (!target.getEntityWorld().isRemote && ConfigHandler.nvidiaEnchantmentEnabled) {
			if (rand.nextInt(3) == 1) {
				target.attackEntityFrom(new DamageSourceNVIDIA("nVIDIA"), 20F);
				if (rand.nextInt(10) == 1 && target instanceof EntityPlayer)
					RandomItems.proxy.notSuspicious();
			}
			if (rand.nextInt(3) == 1)
				user.attackEntityFrom(new DamageSourceNVIDIA("nVIDIA"), 20F);
		}
	}
}
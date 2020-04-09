package net.enderturret.randomitems.enchantment;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.RandomItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class NVIDIAEnchantment extends BaseEnchantment {

	protected NVIDIAEnchantment() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return canApply(stack);
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public boolean canApply(ItemStack stack) {
		return ConfigHandler.nvidiaEnchantmentEnabled && stack.getItem() instanceof ItemSword;
	}

	@Override
	public int getMaxEnchantability(int level) {
		return 19;
	}

	@Override
	public int getMinEnchantability(int level) {
		return 8;
	}

	@Override
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
		if (!ConfigHandler.nvidiaEnchantmentEnabled || !(target instanceof EntityPlayer)) return;
		if (!target.getEntityWorld().isRemote) {
			if (target.world.rand.nextInt(3) == 1) // Let's try really hard to hijack a Random from somewhere else.
				target.attackEntityFrom(new NVIDIADamageSource(), 20F);
			user.attackEntityFrom(new NVIDIADamageSource(), 20F);
		}
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT && RandomItems.proxy.isNVIDIA())
			if (target.world.rand.nextInt(10) == 1 && target instanceof EntityPlayer)
				RandomItems.proxy.nvidiaCrash();
	}
}

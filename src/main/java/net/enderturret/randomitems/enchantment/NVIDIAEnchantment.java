package net.enderturret.randomitems.enchantment;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.RandomItems;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.loading.FMLLoader;

public class NVIDIAEnchantment extends BaseEnchantment {

	protected NVIDIAEnchantment() {
		super(Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND, EquipmentSlotType.OFFHAND);
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
		return ConfigHandler.get().nvidiaEnchantmentEnabled.get() && stack.getItem() instanceof SwordItem;
	}

	@Override
	public void onEntityDamaged(LivingEntity user, Entity target, int level) {
		if (!ConfigHandler.get().nvidiaEnchantmentEnabled.get() || !(target instanceof PlayerEntity)) return;
		if (!target.getEntityWorld().isRemote) {
			if (user.getRNG().nextInt(3) == 1)
				target.attackEntityFrom(new NVIDIADamageSource(), 20F);
			user.attackEntityFrom(new NVIDIADamageSource(), 20F);
		}
		if (FMLLoader.getDist().isClient() && RandomItems.proxy.isNVIDIA())
			if (user.getRNG().nextInt(10) == 1 && target instanceof PlayerEntity)
				RandomItems.proxy.nvidiaCrash();
	}
}

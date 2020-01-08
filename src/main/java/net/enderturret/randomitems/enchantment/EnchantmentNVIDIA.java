package net.enderturret.randomitems.enchantment;

import java.util.Random;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.Reference;
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

public class EnchantmentNVIDIA extends Enchantment {

	private final Random rand = new Random();

	protected EnchantmentNVIDIA() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
		setRegistryName(Reference.MOD_ID, "nvidia");
		setName("nvidia");
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return stack.getItem() instanceof ItemSword && ConfigHandler.nvidiaEnchantmentEnabled;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof ItemSword && ConfigHandler.nvidiaEnchantmentEnabled;
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
		if (!ConfigHandler.nvidiaEnchantmentEnabled || !(target instanceof EntityPlayer)) return;
		if (!target.getEntityWorld().isRemote) {
			if (rand.nextInt(3) == 1)
				target.attackEntityFrom(new DamageSourceNVIDIA("nVIDIA"), 20F);
			user.attackEntityFrom(new DamageSourceNVIDIA("nVIDIA"), 20F);
		}
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT && RandomItems.proxy.nVIDIA())
			if (rand.nextInt(10) == 1 && target instanceof EntityPlayer)
				RandomItems.proxy.nvidiaCrash();
	}
}
package net.enderturret.randomitems.item;

import java.util.Random;

import net.enderturret.randomitems.init.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFLARD extends ItemBase {
	private int customGeneratedEffect;
	private final Random rand = new Random();
	private final Enchantment[] enchants = {Enchantments.AQUA_AFFINITY, Enchantments.BANE_OF_ARTHROPODS, Enchantments.BINDING_CURSE,
			Enchantments.BLAST_PROTECTION, Enchantments.DEPTH_STRIDER, Enchantments.EFFICIENCY, Enchantments.FEATHER_FALLING, Enchantments.FIRE_ASPECT,
			Enchantments.FIRE_PROTECTION, Enchantments.FLAME, Enchantments.FORTUNE, Enchantments.FROST_WALKER, Enchantments.INFINITY, Enchantments.KNOCKBACK,
			Enchantments.LOOTING, Enchantments.LUCK_OF_THE_SEA, Enchantments.LURE, Enchantments.MENDING, Enchantments.POWER, Enchantments.PROJECTILE_PROTECTION,
			Enchantments.PROTECTION, Enchantments.PUNCH, Enchantments.RESPIRATION, Enchantments.SHARPNESS, Enchantments.SILK_TOUCH, Enchantments.SMITE, Enchantments.SWEEPING,
			Enchantments.THORNS, Enchantments.UNBREAKING, Enchantments.VANISHING_CURSE};

	public ItemFLARD() {
		super("flard");
		setMaxStackSize(1);
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!worldIn.isRemote)
			if (entityIn instanceof EntityPlayer) {
				EntityPlayer playerIn = (EntityPlayer)entityIn;
				if (playerIn.getHeldItemMainhand() != null)
					if (playerIn.getHeldItemMainhand().getItem() == ModItems.flard)
						executeFlardEffect(stack, worldIn, playerIn);
			}
	}
	/** Method called whenever a random effect is needed */
	protected void executeFlardEffect(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		customGeneratedEffect = rand.nextInt(5);
		playerIn.inventory.deleteStack(playerIn.getHeldItemMainhand());
		if (customGeneratedEffect == 0) {
			System.out.println("poison");
			playerIn.addPotionEffect(new PotionEffect(MobEffects.POISON, 500, 2));
		}
		else if (customGeneratedEffect == 1) {
			System.out.println("enchantment");
			if (playerIn.getHeldItemOffhand() != null)
				playerIn.getHeldItemOffhand().addEnchantment(enchants[rand.nextInt(enchants.length)], rand.nextInt(10));
		}
		else if (customGeneratedEffect == 2) {
			System.out.println("drop items");
			playerIn.inventory.dropAllItems();
		}
		else if (customGeneratedEffect == 3) {
			System.out.println("weather");
			worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), false));
		}
		else if (customGeneratedEffect == 4) {
			System.out.println("diamond");
			playerIn.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, 1));
		}
	}
}
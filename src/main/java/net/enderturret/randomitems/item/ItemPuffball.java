package net.enderturret.randomitems.item;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemPuffball extends ItemBase {

	public ItemPuffball(String name) {
		super(name);
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (ConfigHandler.puffballEffectsEnabled == true && entityIn instanceof EntityPlayer) {
			EntityPlayer playerIn = (EntityPlayer)entityIn;
			if (playerIn.getHeldItemOffhand() != ItemStack.EMPTY) {
				Item i = playerIn.getHeldItemOffhand().getItem();
				if (i == ModItems.puffballWhite)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 0));

				else if (i == ModItems.puffballLightGray)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 20, 0));

				else if (i == ModItems.puffballGray)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 20, 0));

				else if (i == ModItems.puffballBlack)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 20, 0));

				else if (i == ModItems.puffballBrown)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 20, 0));

				else if (i == ModItems.puffballRed)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20, 0));

				else if (i == ModItems.puffballOrange)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 20, 0));

				else if (i == ModItems.puffballYellow)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 20, 0));

				else if (i == ModItems.puffballLime)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.LUCK, 20, 0));

				else if (i == ModItems.puffballGreen)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 0));

				else if (i == ModItems.puffballCyan)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 20, 0));

				else if (i == ModItems.puffballLightBlue)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 20, 0));

				else if (i == ModItems.puffballBlue)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 20, 0));

				// else if (i == ModItems.puffballPurple) TODO: Fix this???
					// playerIn.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 80, 0));

				else if (i == ModItems.puffballMagenta)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 20, 0));

				else if (i == ModItems.puffballPink)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20, 0));
			}
		}
	}
}
package net.enderturret.randomitems.item;

import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPuffball extends ItemBase {

	public ItemPuffball(String name)
	{
		super(name);
		setCreativeTab(RandomItems.creativeTab);
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof EntityPlayer) {
			EntityPlayer playerIn = (EntityPlayer) entityIn;
			if (playerIn.getHeldItemOffhand() != null) {
				if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallWhite)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallLightGray)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallGray)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallBlack)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallBrown)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallRed)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallOrange)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallYellow)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallLime)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.LUCK, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallGreen)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallCyan)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallLightBlue)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallBlue)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 20, 0));

				//else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallPurple)
					//playerIn.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 80, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallMagenta)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 20, 0));

				else if (playerIn.getHeldItemOffhand().getItem() == ModItems.puffBallPink)
					playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20, 0));
			}
		}
	}
}
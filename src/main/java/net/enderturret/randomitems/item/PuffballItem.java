package net.enderturret.randomitems.item;

import java.util.UUID;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class PuffballItem extends Item {

	private static final UUID MAX_HEALTH_UUID = UUID.fromString("edf80de8-538c-4ca1-90ec-4f34fde9aaa9");
	private final Potion effect;

	public PuffballItem(Potion effect) {
		this.effect = effect;
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (this == ModItems.BROWN_PUFFBALL && !ConfigHandler.brownPuffballEnabled)
			return;
		if (ConfigHandler.puffballEffectsEnabled && entityIn instanceof EntityPlayer) {
			EntityPlayer playerIn = (EntityPlayer)entityIn;
			if (playerIn.getHeldItemOffhand().getItem() == this) {
				if (this == ModItems.PURPLE_PUFFBALL && playerIn.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getModifier(MAX_HEALTH_UUID) == null)
					playerIn.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(new AttributeModifier(MAX_HEALTH_UUID, "puffball_health_boost", 8.0D, 0));
				else if (effect != MobEffects.HEALTH_BOOST) playerIn.addPotionEffect(new PotionEffect(effect, 20, 2, false, false));
			}
			else if (playerIn.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getModifier(MAX_HEALTH_UUID) != null) playerIn.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(MAX_HEALTH_UUID);
		}
	}
}
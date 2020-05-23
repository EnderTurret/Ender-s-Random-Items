package net.enderturret.randomitems.item;

import java.util.UUID;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class PuffballItem extends Item {

	private static final UUID MAX_HEALTH_UUID = UUID.fromString("edf80de8-538c-4ca1-90ec-4f34fde9aaa9");
	private final Effect effect;

	public PuffballItem(Item.Properties settings, Effect effect) {
		super(settings);
		this.effect = effect;
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (this == ModItems.BROWN_PUFFBALL.get() && !ConfigHandler.get().brownPuffballEnabled.get())
			return;
		if (ConfigHandler.get().puffballEffectsEnabled.get() && entityIn instanceof PlayerEntity) {
			final PlayerEntity playerIn = (PlayerEntity) entityIn;
			if (playerIn.getHeldItemOffhand().getItem() == this) {
				if (this == ModItems.PURPLE_PUFFBALL.get() && playerIn.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getModifier(MAX_HEALTH_UUID) == null)
					playerIn.getAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(new AttributeModifier(MAX_HEALTH_UUID, "puffball_health_boost", 8.0D, AttributeModifier.Operation.ADDITION));
				else if (effect != Effects.HEALTH_BOOST) playerIn.addPotionEffect(new EffectInstance(effect, 20, 2, false, false));
			}
			else if (playerIn.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getModifier(MAX_HEALTH_UUID) != null) playerIn.getAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(MAX_HEALTH_UUID);
		}
	}
}
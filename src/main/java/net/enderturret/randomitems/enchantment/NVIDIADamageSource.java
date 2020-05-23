package net.enderturret.randomitems.enchantment;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class NVIDIADamageSource extends DamageSource {

	public NVIDIADamageSource() {
		super("nVIDIA");
	}

	@Override
	public TextComponent getDeathMessage(LivingEntity entityIn) {
		return new TranslationTextComponent("enchantment.randomitems.nvidia.death", entityIn.getName());
	}
}
package net.enderturret.randomitems.enchantment;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class DamageSourceNVIDIA extends DamageSource {

	public DamageSourceNVIDIA(String damageTypeIn) {
		super(damageTypeIn);
	}

	@Override
	public ITextComponent getDeathMessage(EntityLivingBase entityIn) {
		return new TextComponentTranslation("enchantment.nvidia.deathmessage", entityIn.getName());
	}
}
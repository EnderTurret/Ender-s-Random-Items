package net.enderturret.randomitems.enchantment;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class DamageSourceNVIDIA extends DamageSource {

	public DamageSourceNVIDIA(String damageTypeIn) {
		super(damageTypeIn);
	}

	@Override
	public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn) {
		return new TextComponentString(entityLivingBaseIn.getName() + " experienced nVIDIA");
	}
}
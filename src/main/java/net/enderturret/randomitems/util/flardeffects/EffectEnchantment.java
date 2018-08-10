package net.enderturret.randomitems.util.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.enchantment.ModEnchantments;
import net.enderturret.randomitems.item.ItemFLARD;
import net.enderturret.randomitems.util.IFLARDEffect;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EffectEnchantment implements IFLARDEffect {
	/** Array of every enchantment available. Use it for those times you want an array of enchants */
	public static final Enchantment[] enchants = {
			Enchantments.AQUA_AFFINITY, Enchantments.BANE_OF_ARTHROPODS, Enchantments.BINDING_CURSE, Enchantments.BLAST_PROTECTION, Enchantments.DEPTH_STRIDER,
			Enchantments.EFFICIENCY, Enchantments.FEATHER_FALLING, Enchantments.FIRE_ASPECT, Enchantments.FIRE_PROTECTION, Enchantments.FLAME,
			Enchantments.FORTUNE, Enchantments.FROST_WALKER, Enchantments.INFINITY, Enchantments.KNOCKBACK, Enchantments.LOOTING,
			Enchantments.LUCK_OF_THE_SEA, Enchantments.LURE, Enchantments.MENDING, Enchantments.POWER, Enchantments.PROJECTILE_PROTECTION,
			Enchantments.PROTECTION, Enchantments.PUNCH, Enchantments.RESPIRATION, Enchantments.SHARPNESS, Enchantments.SILK_TOUCH,
			Enchantments.SMITE, Enchantments.SWEEPING, Enchantments.THORNS, Enchantments.UNBREAKING, Enchantments.VANISHING_CURSE,
			ModEnchantments.antiGravity};
	@Override
	public void onFLARDEffectRun(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos) {
		if (ConfigHandler.flardEffects.flardOffhandEnchantEffect == true)
			if (playerIn.getHeldItemOffhand() != ItemStack.EMPTY) {
				log(" got their offhand item enchanted", playerIn);
				playerIn.getHeldItemOffhand().addEnchantment(enchants[rand.nextInt(enchants.length)], rand.nextInt(5));
			}
			else
				log(" could have had their offhand item enchanted, but their offhand was empty", playerIn);
		else {
			ItemFLARD f = (ItemFLARD)stack.getItem();
			f.rollEffect(stack, worldIn, playerIn, pos);
		}
	}
}
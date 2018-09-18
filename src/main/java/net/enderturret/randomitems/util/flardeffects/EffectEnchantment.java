package net.enderturret.randomitems.util.flardeffects;

import java.util.Collection;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.enchantment.ModEnchantments;
import net.enderturret.randomitems.item.ItemFLARD;
import net.enderturret.randomitems.util.AbstractFLARDEffect;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class EffectEnchantment extends AbstractFLARDEffect {

	/*private static final Enchantment[] enchants = {
			Enchantments.AQUA_AFFINITY, Enchantments.BANE_OF_ARTHROPODS, Enchantments.BINDING_CURSE, Enchantments.BLAST_PROTECTION, Enchantments.DEPTH_STRIDER,
			Enchantments.EFFICIENCY, Enchantments.FEATHER_FALLING, Enchantments.FIRE_ASPECT, Enchantments.FIRE_PROTECTION, Enchantments.FLAME,
			Enchantments.FORTUNE, Enchantments.FROST_WALKER, Enchantments.INFINITY, Enchantments.KNOCKBACK, Enchantments.LOOTING,
			Enchantments.LUCK_OF_THE_SEA, Enchantments.LURE, Enchantments.MENDING, Enchantments.POWER, Enchantments.PROJECTILE_PROTECTION,
			Enchantments.PROTECTION, Enchantments.PUNCH, Enchantments.RESPIRATION, Enchantments.SHARPNESS, Enchantments.SILK_TOUCH,
			Enchantments.SMITE, Enchantments.SWEEPING, Enchantments.THORNS, Enchantments.UNBREAKING, Enchantments.VANISHING_CURSE,
			ModEnchantments.antiGravity
			};*/
	private static Enchantment[] enchants = null;

	@Override
	public void onFLARDEffectRun(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos) {
		if (enchants == null) enchants = ForgeRegistries.ENCHANTMENTS.getValuesCollection().toArray(new Enchantment[0]);
		if (ConfigHandler.flardEffects.flardOffhandEnchantEffect)
			if (playerIn.getHeldItemOffhand() != ItemStack.EMPTY) {
				log(" got their offhand item enchanted", playerIn);
				playerIn.getHeldItemOffhand().addEnchantment(enchants[rand.nextInt(enchants.length)], rand.nextInt(5));
			}
			else
				log(" could have had their offhand item enchanted, but their offhand was empty", playerIn);
		else {
			((ItemFLARD) stack.getItem()).rollEffect(stack, worldIn, playerIn, pos);
		}
	}
}
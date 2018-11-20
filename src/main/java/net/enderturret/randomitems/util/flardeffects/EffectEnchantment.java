package net.enderturret.randomitems.util.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.item.ItemFLARD;
import net.enderturret.randomitems.util.AbstractFLARDEffect;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class EffectEnchantment extends AbstractFLARDEffect {

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
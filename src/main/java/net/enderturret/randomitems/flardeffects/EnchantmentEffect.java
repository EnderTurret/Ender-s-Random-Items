package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.util.RandomItemsUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class EnchantmentEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, EntityPlayer playerIn) {
		playerIn.getHeldItemOffhand().addEnchantment(RandomItemsUtil.getRandom(ForgeRegistries.ENCHANTMENTS, RAND), RAND.nextInt(5));
	}

	@Override
	public boolean canRun(World worldIn, EntityPlayer playerIn) {
		return ConfigHandler.flardEffects.flardOffhandEnchantEffect && playerIn.getHeldItemOffhand() != ItemStack.EMPTY;
	}
}
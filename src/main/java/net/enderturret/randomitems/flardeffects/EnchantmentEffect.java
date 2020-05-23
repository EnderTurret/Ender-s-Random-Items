package net.enderturret.randomitems.flardeffects;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.util.RandomItemsUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentEffect extends FLARDEffect {

	@Override
	public void runEffect(World worldIn, PlayerEntity playerIn) {
		playerIn.getHeldItemOffhand().addEnchantment(RandomItemsUtil.getRandom(ForgeRegistries.ENCHANTMENTS, RAND), RAND.nextInt(5));
	}

	@Override
	public boolean canRun(World worldIn, PlayerEntity playerIn) {
		return ConfigHandler.get().flardOffhandEnchantEffect.get() && playerIn.getHeldItemOffhand() != ItemStack.EMPTY;
	}
}
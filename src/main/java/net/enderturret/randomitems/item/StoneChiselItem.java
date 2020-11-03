package net.enderturret.randomitems.item;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundEvents;

public class StoneChiselItem extends Item {

	private final int stickCount;

	public StoneChiselItem(Item.Properties settings, int stickCount) {
		super(settings);

		this.stickCount = stickCount;
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext ctx) {
		if (ConfigHandler.areStoneChiselsEnabled() && ctx.getWorld().getBlockState(ctx.getPos()) == Blocks.STONE.getDefaultState()) {
			ctx.getPlayer().addItemStackToInventory(new ItemStack(ModItems.STONE_STICK.get(), stickCount));

			ctx.getWorld().removeBlock(ctx.getPos(), false);

			ctx.getItem().damageItem(1, ctx.getPlayer(), player -> player.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1F, 1F));

			return ActionResultType.SUCCESS;
		}

		return ActionResultType.PASS;
	}
}
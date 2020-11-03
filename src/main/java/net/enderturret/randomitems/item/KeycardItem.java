package net.enderturret.randomitems.item;

import net.enderturret.randomitems.block.KeycardReaderBlock;
import net.enderturret.randomitems.tileentity.KeycardReaderTE;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.TranslationTextComponent;

public class KeycardItem extends Item {

	public KeycardItem(Item.Properties settings) {
		super(settings);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext ctx) {
		if (ctx.getWorld().getBlockState(ctx.getPos()).getBlock() instanceof KeycardReaderBlock && !ctx.getWorld().isRemote && ctx.getWorld().getTileEntity(ctx.getPos()) != null)
			if (ctx.getWorld().getTileEntity(ctx.getPos()) instanceof KeycardReaderTE) {
				final KeycardReaderTE te = (KeycardReaderTE) ctx.getWorld().getTileEntity(ctx.getPos());

				if (ctx.getPlayer().isCrouching() && te.isOwner(PlayerEntity.getUUID(ctx.getPlayer().getGameProfile()))) {
					te.setKeycardName(ctx.getPlayer().getHeldItemMainhand().getDisplayName().getString());
					ctx.getPlayer().sendMessage(new TranslationTextComponent("randomitems.keycard.setname", ctx.getPlayer().getHeldItemMainhand().getDisplayName()));

					return ActionResultType.SUCCESS;
				}
			}

		return ActionResultType.FAIL;
	}
}
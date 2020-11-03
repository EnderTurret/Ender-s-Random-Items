package net.enderturret.randomitems.command;

import static net.minecraft.command.Commands.literal;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.server.permission.PermissionAPI;

public class RepairCommand {

	public static TextComponent repairItems(PlayerEntity playerIn) {
		try {
			int repaired = 0;
			for (int i = 0; i < playerIn.inventory.getSizeInventory(); i++)
				if (!playerIn.inventory.getStackInSlot(i).isEmpty()) {
					final ItemStack stack = playerIn.inventory.getStackInSlot(i);
					if (stack.isDamaged()) {
						repairItem(stack);
						repaired++;
					}
				}
			if (repaired == 0) return new TranslationTextComponent("command.repair.nonerepaired");
			return new TranslationTextComponent("command.repair.bulkrepair", repaired);
		} catch (Exception e) {
			return new TranslationTextComponent("command.repair.error");
		}
	}

	public static TextComponent repairHand(PlayerEntity playerIn, boolean mainHand) {
		try {
			final ItemStack stack = mainHand ? playerIn.getHeldItemMainhand() : playerIn.getHeldItemOffhand();
			if (stack.isEmpty()) return new TranslationTextComponent("command.repair.handempty");
			if (!stack.isDamaged()) return new TranslationTextComponent("command.repair.nodurability");
			repairItem(stack);
			return new TranslationTextComponent("command.repair.handsuccess", new TranslationTextComponent(stack.getItem().getTranslationKey()));
		} catch (Exception e) {
			return new TranslationTextComponent("command.repair.error");
		}
	}

	public static boolean repairItem(ItemStack stack) {
		if (stack.isDamaged()) {
			stack.setDamage(0);
			return true;
		}

		return false;
	}

	public static LiteralArgumentBuilder<CommandSource> createBuilder() {
		final LiteralArgumentBuilder<CommandSource> repair = literal("repair").requires(source -> PermissionAPI.hasPermission((PlayerEntity) source.getEntity(), "randomitems.repair"));

		repair.then(literal("all").requires(source -> PermissionAPI.hasPermission((PlayerEntity) source.getEntity(), "randomitems.repair.all")).executes(ctx -> {
			if (ctx.getSource().getEntity() instanceof PlayerEntity)
				ctx.getSource().sendFeedback(RepairCommand.repairItems((PlayerEntity) ctx.getSource().getEntity()), false);
			return Command.SINGLE_SUCCESS;
		}));

		repair.then(literal("mainhand").requires(source -> PermissionAPI.hasPermission((PlayerEntity) source.getEntity(), "randomitems.repair.hand")).executes(ctx -> {
			if (ctx.getSource().getEntity() instanceof PlayerEntity)
				ctx.getSource().sendFeedback(RepairCommand.repairHand((PlayerEntity) ctx.getSource().getEntity(), true), false);
			return Command.SINGLE_SUCCESS;
		}));

		repair.then(literal("offhand").requires(source -> PermissionAPI.hasPermission((PlayerEntity) source.getEntity(), "randomitems.repair.hand")).executes(ctx -> {
			if (ctx.getSource().getEntity() instanceof PlayerEntity)
				ctx.getSource().sendFeedback(RepairCommand.repairHand((PlayerEntity) ctx.getSource().getEntity(), false), false);
			return Command.SINGLE_SUCCESS;
		}));

		return repair;
	}
}

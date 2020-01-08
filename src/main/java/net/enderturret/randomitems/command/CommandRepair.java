package net.enderturret.randomitems.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.server.permission.PermissionAPI;

public class CommandRepair extends CommandBase {

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length > 0 && !sender.getEntityWorld().isRemote && sender.getCommandSenderEntity() instanceof EntityPlayer) {
			final EntityPlayer playerIn = (EntityPlayer) sender.getCommandSenderEntity();
			if ("all".equals(args[0]) && PermissionAPI.hasPermission(playerIn, "randomitems.repair.all"))
				sender.sendMessage(repairItems(playerIn));
			else if (PermissionAPI.hasPermission(playerIn, "randomitems.repair.hand"))
				if ("mainhand".equals(args[0]))
					sender.sendMessage(repairHand(playerIn, true));
				else if ("offhand".equals(args[0]))
					sender.sendMessage(repairHand(playerIn, false));
		} else sender.sendMessage(new TextComponentString(getUsage(sender)));
	}

	public static ITextComponent repairItems(EntityPlayer playerIn) {
		try {
			int repaired = 0;
			for (int i = 0; i < playerIn.inventory.getSizeInventory(); i++)
				if (!playerIn.inventory.getStackInSlot(i).isEmpty()) {
					final ItemStack stack = playerIn.inventory.getStackInSlot(i);
					if (stack.isItemDamaged()) {
						repairItem(stack);
						repaired++;
					}
				}
			if (repaired == 0) return new TextComponentTranslation("command.repair.nonerepaired");
			return new TextComponentTranslation("command.repair.bulkrepair", repaired);
		} catch (Exception e) {
			return new TextComponentTranslation("command.repair.error");
		}
	}

	public static ITextComponent repairHand(EntityPlayer playerIn, boolean mainHand) {
		try {
			final ItemStack stack = mainHand ? playerIn.getHeldItemMainhand() : playerIn.getHeldItemOffhand();
			if (stack.isEmpty()) return new TextComponentTranslation("command.repair.handempty");
			if (!stack.isItemDamaged()) return new TextComponentTranslation("command.repair.nodurability");
			repairItem(stack);
			return new TextComponentTranslation("command.repair.handsuccess", new TextComponentTranslation(stack.getItem().getTranslationKey() + ".name"));
		} catch (Exception e) {
			return new TextComponentTranslation("command.repair.error");
		}
	}

	public static boolean repairItem(ItemStack stack) {
		if (stack.isItemDamaged()) {
			stack.setItemDamage(0);
			return true;
		}
		return false;
	}

	@Override
	public String getName() {
		return "repair";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/repair <all|mainhand|offhand>";
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
		final List<String> tab = new ArrayList<>();
		if (args.length == 1) {
			tab.add("all");
			tab.add("mainhand");
			tab.add("offhand");
		}
		return tab;
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return sender.getCommandSenderEntity() instanceof EntityPlayer &&
				PermissionAPI.hasPermission((EntityPlayer) sender.getCommandSenderEntity(), "randomitems.repair");
	}
}
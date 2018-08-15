package net.enderturret.randomitems.util;

import java.util.ArrayList;
import java.util.Arrays;
import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.RandomItems;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.server.permission.PermissionAPI;

public class CommandRepair extends CommandBase {
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length > 0 && !sender.getEntityWorld().isRemote)
			if (args[0].equalsIgnoreCase("all") || args[0].equalsIgnoreCase("hand"))
				if (sender.getCommandSenderEntity() instanceof EntityPlayer) {
					EntityPlayer playerIn = (EntityPlayer)sender.getCommandSenderEntity();
					if (args[0].equalsIgnoreCase("all") && PermissionAPI.hasPermission(playerIn, "randomitems.repair.all")) {
						final ArrayList<String> names = new ArrayList<String>();
						for (int i = 0; i < playerIn.inventory.getSizeInventory(); i++)
							if (playerIn.inventory.getStackInSlot(i) != ItemStack.EMPTY)
								if (playerIn.inventory.getStackInSlot(i).isItemDamaged()) {
									playerIn.inventory.getStackInSlot(i).setItemDamage(0);
									if (ConfigHandler.repairHumour)
										names.add(playerIn.inventory.getStackInSlot(i).getDisplayName());
									else
										names.add(RandomItems.proxy.localize(playerIn.inventory.getStackInSlot(i).getUnlocalizedName()+".name"));
								}
						sender.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, names.size());
						if (!names.isEmpty()) {
							final String[] n = names.toArray(new String[0]);
							if (n.length > 5) {
								final String[] five = {n[1], n[2], n[3], n[4], n[5]};
								playerIn.sendMessage(new TextComponentString(RandomItems.proxy.localize("command.repair.success")+Arrays.toString(five)+" and "+(n.length-5)+" more..."));
							}
							else
								playerIn.sendMessage(new TextComponentString(RandomItems.proxy.localize("command.repair.success")+Arrays.toString(n)));
						}
					}
					else if (args[0].equalsIgnoreCase("hand") && PermissionAPI.hasPermission(playerIn, "randomitems.repair.hand"))
						if (playerIn.getHeldItemMainhand() != ItemStack.EMPTY)
							if (playerIn.getHeldItemMainhand().isItemDamaged()) {
								playerIn.getHeldItemMainhand().setItemDamage(0);
								sender.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, 1);
								if (ConfigHandler.repairHumour)
									playerIn.sendMessage(new TextComponentString(RandomItems.proxy.localize("command.repair.success")+playerIn.getHeldItemMainhand().getDisplayName()));
								else
									playerIn.sendMessage(new TextComponentString(RandomItems.proxy.localize("command.repair.success")+RandomItems.proxy.localize(playerIn.getHeldItemMainhand().getUnlocalizedName()+".name")));
							}
				}
				else {}
			else
				throw new WrongUsageException(this.getUsage(sender), new Object[0]);
		else
			sender.sendMessage(new TextComponentString(this.getUsage(sender)));
	}

	@Override
	public String getName() {
		return "repair";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/repair <all|hand>";
	}

	public CommandRepair() {
		aliases.add("repair");
		tabCompletions.add("all");
		tabCompletions.add("hand");
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return (sender.getCommandSenderEntity() instanceof EntityPlayer) ? PermissionAPI.hasPermission((EntityPlayer)sender.getCommandSenderEntity(), "randomitems.repair") : false;
	}
}
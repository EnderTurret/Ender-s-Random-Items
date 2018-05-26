package net.enderturret.randomitems.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.enderturret.randomitems.ConfigHandler;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.server.permission.PermissionAPI;

public class CommandRepair implements ICommand {
	private final List aliases;
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length > 0 && !sender.getEntityWorld().isRemote)
			if (args[0].equalsIgnoreCase("all") || args[0].equalsIgnoreCase("hand"))
				if (sender.getCommandSenderEntity() instanceof EntityPlayer) {
					EntityPlayer playerIn = (EntityPlayer)sender.getCommandSenderEntity();
					if (args[0].equalsIgnoreCase("all") && PermissionAPI.hasPermission(playerIn, "command.repair.all")) {
						final List<String> names = new ArrayList<String>();
						for (int i = 0; i < playerIn.inventory.getSizeInventory(); i++)
							if (playerIn.inventory.getStackInSlot(i) != ItemStack.EMPTY)
								if (playerIn.inventory.getStackInSlot(i).isItemDamaged()) {
									playerIn.inventory.getStackInSlot(i).setItemDamage(0);
									if (ConfigHandler.repairHumour)
										names.add(playerIn.inventory.getStackInSlot(i).getDisplayName());
									else
										names.add(I18n.translateToLocal(playerIn.inventory.getStackInSlot(i).getUnlocalizedName()+".name"));
								}
						sender.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, names.size());
						if (!names.isEmpty()) {
							final String[] n = names.toArray(new String[0]);
							if (n.length > 5) {
								final String[] firstFive = {n[1], n[2], n[3], n[4], n[5]};
								final int something = n.length-5;
								playerIn.sendMessage(new TextComponentString("Successfully repaired your: "+Arrays.toString(firstFive)+" and "+something+" more..."));
							}
							else
								playerIn.sendMessage(new TextComponentString("Successfully repaired your: "+Arrays.toString(n)));
						}
					}
					else if (args[0].equalsIgnoreCase("hand") && PermissionAPI.hasPermission(playerIn, "command.repair.hand"))
						if (playerIn.getHeldItemMainhand() != ItemStack.EMPTY)
							if (playerIn.getHeldItemMainhand().isItemDamaged()) {
								playerIn.getHeldItemMainhand().setItemDamage(0);
								sender.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, 1);
								if (ConfigHandler.repairHumour)
									playerIn.sendMessage(new TextComponentString("Successfully repaired your: "+playerIn.getHeldItemMainhand().getDisplayName()));
								else
									playerIn.sendMessage(new TextComponentString("Successfully repaired your: "+I18n.translateToLocal(playerIn.getHeldItemMainhand().getUnlocalizedName()+".name")));
							}
				}
				else {}
			else
				throw new WrongUsageException("/repair <all|hand> ", new Object[0]);
		else
			sender.sendMessage(new TextComponentString(this.getUsage(sender)));
	}
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
		List<String> l = new ArrayList<String>();
		l.add("all");
		l.add("hand");
		return l;
	}
	@Override
	public String getName() {
		return "repair";
	}
	@Override
	public String getUsage(ICommandSender sender) {
		return "/repair <all|hand>";
	}
	@Override
	public int compareTo(ICommand o) {
		return 0;
	}
	@Override
	public List<String> getAliases() {
		return aliases;
	}
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}
	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}
	public CommandRepair() {
		aliases = new ArrayList();
		aliases.add("repair");
	}
}
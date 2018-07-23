package net.enderturret.randomitems.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

/** Command base class, it simplifies things. */
public abstract class CommandBase implements ICommand {
	/** Tab completions, fill it in upon class initialization. */
	protected static List<String> tabCompletions = new ArrayList<String>();
	/** Aliases, same as above ^ */
	protected static List<String> aliases = new ArrayList<String>();
	@Override
	public int compareTo(ICommand o) {return 0;}
	@Override
	public List<String> getAliases() {
		return aliases;
	}
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
		return tabCompletions;
	}
	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}
}
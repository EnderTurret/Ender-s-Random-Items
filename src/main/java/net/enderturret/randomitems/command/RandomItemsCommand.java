package net.enderturret.randomitems.command;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import net.enderturret.randomitems.FLARDEffectRegistry;
import net.enderturret.randomitems.flardeffects.FLARDEffect;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.server.permission.PermissionAPI;

public class RandomItemsCommand extends CommandBase {

	private static final Pattern RESOURCE_LOCATION_PATTERN = Pattern.compile("[a-zA-Z0-9_]+:[a-zA-Z0-9/_]+");

	public static void processFLARDEffect(ResourceLocation id, EntityPlayer playerIn) {
		final FLARDEffect effect = FLARDEffectRegistry.getRegistry().getValue(id);
		if (effect == null)
			playerIn.sendMessage(new TextComponentString("No effect registered with id " + id.toString()));
		else if (!effect.canRun(playerIn.getEntityWorld(), playerIn))
			playerIn.sendMessage(new TextComponentString("Effect " + id.toString() + "returned false from canRun()."));
		else {
			effect.runEffect(playerIn.getEntityWorld(), playerIn);
			playerIn.sendMessage(new TextComponentString("Successfully run effect " + id.toString()));
		}
	}

	@Override
	public String getName() {
		return "randomitems";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/randomitems runFlardEffect <id>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length > 0 && args.length == 2 || !(sender.getCommandSenderEntity() instanceof EntityPlayer)) {
			final EntityPlayer playerIn = (EntityPlayer) sender.getCommandSenderEntity();
			if ("runFlardEffect".equals(args[0])) {
				if (!args[1].contains(":")) args[2] = "minecraft:" + args[1];
				if (RESOURCE_LOCATION_PATTERN.matcher(args[1]).matches())
					processFLARDEffect(new ResourceLocation(args[1]), playerIn);
			}
		} else sender.sendMessage(new TextComponentString(getUsage(sender)));
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return sender.getCommandSenderEntity() instanceof EntityPlayer &&
				PermissionAPI.hasPermission((EntityPlayer) sender.getCommandSenderEntity(), "randomitems.randomitems");
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
		final List<String> tab = new ArrayList<>();
		if (args.length == 1) tab.add("runFlardEffect");
		else if (args.length == 2) suggestResourceLocations(FLARDEffectRegistry.getRegistry().getKeys(), args[1], tab);
		return tab;
	}

	public static List<String> suggestResourceLocations(Iterable<ResourceLocation> locations, String input, List<String> list) {
		final boolean containsColon = input.indexOf(':') != -1;
		for (ResourceLocation loc : locations) {
			final String str = loc.toString();
			if (containsColon) {
				if (str.startsWith(input))
					list.add(str);
			} else if (loc.getNamespace().startsWith(input) ||
					"minecraft".equals(loc.getNamespace()) && loc.getPath().startsWith(input)) // Vanilla logic.
				list.add(str);
		}
		return list;
	}
}
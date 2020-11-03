package net.enderturret.randomitems.init;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.command.RandomItemsCommand;
import net.enderturret.randomitems.command.RepairCommand;
import net.minecraft.command.CommandSource;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;

public final class ModCommands {

	private ModCommands() {}

	private static final LiteralArgumentBuilder<CommandSource> REPAIR = RepairCommand.createBuilder();
	private static final LiteralArgumentBuilder<CommandSource> RANDOMITEMS = RandomItemsCommand.createBuilder();

	public static void registerCommands(CommandDispatcher<CommandSource> dispatcher) {
		if (ConfigHandler.get().repairCommandEnabled.get())
			dispatcher.register(REPAIR);
		dispatcher.register(RANDOMITEMS);
	}

	public static void registerPermissionNodes() {
		if (ConfigHandler.get().repairCommandEnabled.get()) {
			PermissionAPI.registerNode("randomitems.repair.all", DefaultPermissionLevel.OP, "Used for /repair all");
			PermissionAPI.registerNode("randomitems.repair.hand", DefaultPermissionLevel.OP, "Used for /repair mainhand and /repair offhand");
			PermissionAPI.registerNode("randomitems.repair", DefaultPermissionLevel.OP, "Used for /repair");
		}
	}
}
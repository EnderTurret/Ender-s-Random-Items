package net.enderturret.randomitems.command;

import static net.minecraft.command.Commands.argument;
import static net.minecraft.command.Commands.literal;

import java.util.concurrent.CompletableFuture;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;

import net.enderturret.randomitems.FLARDEffectRegistry;
import net.enderturret.randomitems.flardeffects.FLARDEffect;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.ResourceLocationArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;

public class RandomItemsCommand {

	public static void processFLARDEffect(ResourceLocation id, PlayerEntity playerIn) {
		final FLARDEffect effect = FLARDEffectRegistry.getRegistry().getValue(id);
		if (effect == null)
			playerIn.sendMessage(new StringTextComponent("No effect registered with id " + id.toString()));
		else if (!effect.canRun(playerIn.getEntityWorld(), playerIn))
			playerIn.sendMessage(new StringTextComponent("Effect " + id.toString() + " returned false from canRun()."));
		else {
			effect.runEffect(playerIn.getEntityWorld(), playerIn);
			playerIn.sendMessage(new StringTextComponent("Successfully run effect " + id.toString()));
		}
	}

	public static LiteralArgumentBuilder<CommandSource> createBuilder() {
		final LiteralArgumentBuilder<CommandSource> randomitems = literal("randomitems");
		randomitems.then(literal("runFlardEffect")
				.then(argument("id", ResourceLocationArgument.resourceLocation())
						.suggests((ctx, builder) -> suggestResourceLocations(FLARDEffectRegistry.getRegistry().getKeys(), builder.getRemaining(), builder))
						.requires(source -> source.hasPermissionLevel(2))
						.executes(ctx -> {
							if (ctx.getSource().getEntity() instanceof PlayerEntity) {
								final ResourceLocation id = ResourceLocationArgument.getResourceLocation(ctx, "id");
								RandomItemsCommand.processFLARDEffect(id, (PlayerEntity) ctx.getSource().getEntity());
							}
							return Command.SINGLE_SUCCESS;
						})));
		return randomitems;
	}

	public static CompletableFuture<Suggestions> suggestResourceLocations(Iterable<ResourceLocation> locations, String input, SuggestionsBuilder builder) {
		final boolean containsColon = input.indexOf(':') != -1;
		for (ResourceLocation loc : locations) {
			final String str = loc.toString();
			if (containsColon) {
				if (str.startsWith(input))
					builder.suggest(str);
			} else if (loc.getNamespace().startsWith(input) ||
					"minecraft".equals(loc.getNamespace()) && loc.getPath().startsWith(input)) // Vanilla logic.
				builder.suggest(str);
		}
		return builder.buildFuture();
	}
}

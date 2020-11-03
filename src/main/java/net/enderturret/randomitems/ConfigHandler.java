package net.enderturret.randomitems;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

@EventBusSubscriber(modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ConfigHandler {

	private static final ConfigHandler INSTANCE;
	static final ForgeConfigSpec SPEC;

	static {
		final Pair<ConfigHandler,ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(ConfigHandler::new);
		INSTANCE = pair.getLeft();
		SPEC = pair.getRight();
	}

	@Deprecated // Prefer areTesseractsEnabled()
	public final BooleanValue tesseractsEnabled;
	@Deprecated // Prefer isFLARDEnabled()
	public final BooleanValue flardEnabled;
	@Deprecated // Prefer isQuestionableCheeseEnabled()
	public final BooleanValue questionableCheeseEnabled;
	@Deprecated // Prefer arePuffballsEffectsEnabled()
	public final BooleanValue puffballEffectsEnabled;
	@Deprecated // Prefer isBrownPuffballEnabled()
	public final BooleanValue brownPuffballEnabled;
	@Deprecated // Prefer areStoneChiselsEnabled()
	public final BooleanValue stoneChiselEnabled;
	public final BooleanValue repairCommandEnabled;
	@Deprecated // Prefer isAntiGravityEnabled()
	public final BooleanValue antiGravEnabled;
	@Deprecated // Prefer isCoreCraftingEnabled()
	public final BooleanValue coreCraftingEnabled;

	public final BooleanValue flardPoisonEffect;
	public final BooleanValue flardOffhandEnchantEffect;
	public final BooleanValue flardInventoryDropEffect;
	public final BooleanValue flardLightningEffect;
	public final BooleanValue flardDiamondEffect;
	public final BooleanValue flardHoleEffect;
	public final BooleanValue flardExplosionEffect;
	public final BooleanValue flardXPEffect;
	public final BooleanValue flardChestLootEffect;
	public final BooleanValue flardFireEffect;
	public final BooleanValue flardPuddleEffect;
	public final BooleanValue flardCobwebEffect;
	public final BooleanValue flardBlockChangeEffect;
	public final ForgeConfigSpec.ConfigValue<List<? extends String>> flardBlockBlacklist;

	private boolean tesseractsEnabledBaked;
	private boolean flardEnabledBaked;
	private boolean questionableCheeseEnabledBaked;
	private boolean puffballEffectsEnabledBaked;
	private boolean brownPuffballEnabledBaked;
	private boolean stoneChiselEnabledBaked;
	private boolean antiGravEnabledBaked;
	private boolean coreCraftingEnabledBaked;

	private ConfigHandler(ForgeConfigSpec.Builder builder) {
		builder.push("RandomItems");

		tesseractsEnabled = builder.comment("Whether tesseracts apply effects.").define("tesseractEnabled", true);
		flardEnabled = builder.comment("Whether FLARD does anything when right-clicked.").define("flardEnabled", true);
		questionableCheeseEnabled = builder.comment("Whether questionable cheese explodes.").define("questionableCheeseEnabled", true);
		puffballEffectsEnabled = builder.comment("Whether puffballs apply effects.").define("puffballEffectsEnabled", true);
		brownPuffballEnabled = builder.comment("Whether the brown puffball applies its effect.").define("brownPuffballEnabled", true);
		stoneChiselEnabled = builder.comment("Whether the stone chisels can be used.").define("stoneChiselEnabled", true);
		repairCommandEnabled = builder.comment("Whether /repair is enabled.").define("repairCommandEnabled", true);
		antiGravEnabled = builder.comment("Whether the anti-gravity enchant applies its effect.").define("antiGravEnabled", true);
		coreCraftingEnabled = builder.comment("Whether core crafting is enabled.").define("coreCraftingEnabled", true);

		builder.push("flardEffects");

		flardPoisonEffect			= builder.comment("Whether the poison effect is enabled.").define("flardPoisonEffect", true);
		flardOffhandEnchantEffect	= builder.comment("Whether the offhand enchant is enabled.").define("flardOffhandEnchantEffect", true);
		flardInventoryDropEffect	= builder.comment("Whether the inventory drop effect is enabled.").define("flardInventoryDropEffect", true);
		flardLightningEffect		= builder.comment("Whether the lightning strike effect is enabled.").define("flardLightningEffect", true);
		flardDiamondEffect			= builder.comment("Whether the diamond effect is enabled. (Gives the player one diamond.)").define("flardDiamondEffect", true);
		flardHoleEffect				= builder.comment("Whether the hole effect is enabled. (Removes the block under the player.)").define("flardHoleEffect", true);
		flardExplosionEffect		= builder.comment("Whether the explosion effect is enabled.").define("flardExplosionEffect", true);
		flardXPEffect				= builder.comment("Whether the XP effect is enabled. (Gives the player 0-9 xp points.)").define("flardXPEffect", true);
		flardChestLootEffect		= builder.comment("Whether the chest loot table effect is enabled. (Modifies an empty chest's loot table and respawns loot.)").define("flardChestLootEffect", true);
		flardFireEffect				= builder.comment("Whether the fire effect is enabled.").define("flardFireEffect", true);
		flardPuddleEffect			= builder.comment("Whether the puddle effect is enabled.").define("flardPuddleEffect", true);
		flardCobwebEffect			= builder.comment("Whether the cobweb effect is enabled.").define("flardCobwebEffect", true);
		flardBlockChangeEffect		= builder.comment("Whether the block change effect is enabled. (Changes the block under the player to a random block.)").define("flardBlockChangeEffect", true);
		flardBlockBlacklist			= builder.comment("The blacklist for the block change effect.").defineList("flardBlockBlacklist",
				Arrays.asList("minecraft:bedrock", "minecraft:repeating_command_block", "minecraft:command_block",
						"minecraft:chain_command_block", "minecraft:barrier", "minecraft:end_portal_frame",
						"minecraft:portal", "minecraft:mob_spawner", "minecraft:structure_block", "minecraft:structure_void"),
				o -> {
					if (!(o instanceof String)) return false;

					final String s = (String) o;

					if (s.isEmpty() || !s.contains(":")) return false;

					final String[] split = s.split(":");

					if (split.length != 2) return false;

					return split[0].chars().allMatch(i -> isNamespaceValid((char) i)) &&
							split[1].chars().allMatch(i -> isPathValid((char) i));
				});

		builder.pop(2);
	}

	public void bake() {
		tesseractsEnabledBaked = tesseractsEnabled.get();
		flardEnabledBaked = flardEnabled.get();
		questionableCheeseEnabledBaked = questionableCheeseEnabled.get();
		puffballEffectsEnabledBaked = puffballEffectsEnabled.get();
		brownPuffballEnabledBaked = brownPuffballEnabled.get();
		stoneChiselEnabledBaked = stoneChiselEnabled.get();
		antiGravEnabledBaked = antiGravEnabled.get();
		coreCraftingEnabledBaked = coreCraftingEnabled.get();
	}

	@SubscribeEvent
	static void onConfigChange(ModConfig.ModConfigEvent e) {
		if (e.getConfig().getSpec() == SPEC)
			INSTANCE.bake();
	}

	public static boolean areTesseractEffectsEnabled() {
		return INSTANCE.tesseractsEnabledBaked;
	}

	public static boolean isFLARDEnabled() {
		return INSTANCE.flardEnabledBaked;
	}

	public static boolean isQuestionableCheeseEnabled() {
		return INSTANCE.questionableCheeseEnabledBaked;
	}

	public static boolean arePuffballEffectsEnabled() {
		return INSTANCE.puffballEffectsEnabledBaked;
	}

	public static boolean isBrownPuffballEnabled() {
		return INSTANCE.brownPuffballEnabledBaked;
	}

	public static boolean areStoneChiselsEnabled() {
		return INSTANCE.stoneChiselEnabledBaked;
	}

	public static boolean isAntiGravityEnabled() {
		return INSTANCE.antiGravEnabledBaked;
	}

	public static boolean isCoreCraftingEnabled() {
		return INSTANCE.coreCraftingEnabledBaked;
	}

	private static boolean isPathValid(char charIn) {
		return charIn >= '0' && charIn <= '9' || charIn >= 'a' && charIn <= 'z' || charIn == '_' || charIn == ':' || charIn == '/' || charIn == '.' || charIn == '-';
	}

	private static boolean isNamespaceValid(char charIn) {
		return charIn >= '0' && charIn <= '9' || charIn >= 'a' && charIn <= 'z' || charIn == '_' || charIn == ':' || charIn == '.' || charIn == '-';
	}

	public static ConfigHandler get() {
		return INSTANCE;
	}
}
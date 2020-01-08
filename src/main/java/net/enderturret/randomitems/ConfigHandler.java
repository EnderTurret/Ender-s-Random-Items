package net.enderturret.randomitems;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;

@Config(modid = Reference.MOD_ID, type = Config.Type.INSTANCE)
public class ConfigHandler {

	@Comment("Whether tesseracts apply effects.")
	public static boolean tesseractEffects = true;

	@Comment("Whether FLARD does anything when right-clicked.")
	public static boolean flardEnabled = true;

	@Comment("Whether questionable cheese explodes.")
	public static boolean questionableCheeseEnabled = true;

	@Comment("Whether puffballs apply effects.")
	public static boolean puffballEffectsEnabled = true;

	@Comment("Whether the brown puffball applies its effect.")
	public static boolean saturationPuffballEnabled = true;

	@Comment("Whether the stone chisels can be used.")
	public static boolean stoneChiselEnabled = true;

	@Comment("Whether /repair is enabled")
	@Config.RequiresWorldRestart
	public static boolean repairCommandEnabled = true;

	@Comment("On servers, this controls whether nvidia insta-kills players. On the client, this controls whether nvidia crashes the game.")
	public static boolean nvidiaEnchantmentEnabled = false;

	@Comment("Whether the anti-gravity enchant applies its effect.")
	public static boolean antiGravEnabled = true;

	@Comment("Whether core crafting is enabled.")
	public static boolean coreThingEnabled = true;

	@Comment("For controlling individual effects.")
	public static SubCategoryFLARD flardEffects = new SubCategoryFLARD();

	public static class SubCategoryFLARD {

		@Comment("Whether the poison effect is enabled.")
		public boolean flardPoisonEffect = true;

		@Comment("Whether the offhand enchant is enabled.")
		public boolean flardOffhandEnchantEffect = true;

		@Comment("Whether the inventory drop effect is enabled.")
		public boolean flardInventoryDropEffect = true;

		@Comment("Whether the lightning strike effect is enabled.")
		public boolean flardLightningEffect = true;

		@Comment("Whether the diamond effect is enabled. (Gives the player one diamond.)")
		public boolean flardDiamondEffect = true;

		@Comment("Whether the hole effect is enabled. (Removes the block under the player.)")
		public boolean flardHoleEffect = true;

		@Comment("Whether the explosion effect is enabled.")
		public boolean flardExplosionEffect = true;

		@Comment("Whether the XP effect is enabled. (Gives the player 0-9 xp points.)")
		public boolean flardXPEffect = true;

		@Comment("Whether the chest loot table effect is enabled. (Modifies an empty chest's loot table and respawns loot.)")
		public boolean flardChestLootEffect = true;

		@Comment("Whether the fire effect is enabled.")
		public boolean flardFireEffect = true;

		@Comment("Whether the puddle effect is enabled.")
		public boolean flardPuddleEffect = true;

		@Comment("Whether the cobweb effect is enabled.")
		public boolean flardCobwebEffect = true;

		@Comment("Whether the block change effect is enabled. (Changes the block under the player to a random block.)")
		public boolean flardBlockChangeEffect = true;

		@Comment("The blacklist for the block change effect.")
		public String[] flardBlockBlacklist = {"minecraft:bedrock", "minecraft:repeating_command_block", "minecraft:command_block",
				"minecraft:chain_command_block", "minecraft:barrier", "minecraft:end_portal_frame",
				"minecraft:portal", "minecraft:mob_spawner", "minecraft:structure_block", "minecraft:structure_void"};
	}
}
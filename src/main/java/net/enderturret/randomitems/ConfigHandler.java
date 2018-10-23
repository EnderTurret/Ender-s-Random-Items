package net.enderturret.randomitems;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;

@Config(modid="randomitems",type=Config.Type.INSTANCE)
public class ConfigHandler {

	@Comment("Controls whether tesseracts apply effects.")
	public static boolean tesseractEffects = true;

	@Comment("Controls whether FLARD does anything.")
	public static boolean flardEnabled = true;

	@Comment("Controls whether questionable cheese can be used.")
	public static boolean questionableCheeseEnabled = true;

	@Comment("Controls whether puffballs apply effects.")
	public static boolean puffballEffectsEnabled = true;

	@Comment("Controls whether the stone chisel can be used.")
	public static boolean stoneChiselEnabled = true;

	@Comment("Controls whether /repair lists the names of the items vs the localized name")
	public static boolean repairHumour = false;

	@Comment("Whether the /repair command is enabled")
	@Config.RequiresWorldRestart
	public static boolean repairCommandEnabled = true;

	@Comment("Controls whether FLARD can log players using it.")
	public static boolean flardMessages = true;

	@Comment("Controls whether the nVIDIA enchantment works.")
	public static boolean nvidiaEnchantmentEnabled = false;

	@Comment("Controls whether the anti-gravity enchant works.")
	public static boolean antiGravEnabled = true;

	@Comment("Controls whether the cores do anything when right-clicked.")
	public static boolean coreThingEnabled = true;

	@Comment("For controlling individual effects.")
	public static SubCategoryFLARD flardEffects = new SubCategoryFLARD();

	public static class SubCategoryFLARD {

		@Comment("Set to false to disable FLARD's poison effect")
		public boolean flardPoisonEffect = true;

		@Comment("Set to false to disable FLARD's offhand enchant effect")
		public boolean flardOffhandEnchantEffect = true;

		@Comment("Set to false to disable FLARD's inventory drop effect")
		public boolean flardInventoryDropEffect = true;

		@Comment("Set to false to disable FLARD's lightning strike effect")
		public boolean flardLightningEffect = true;

		@Comment("Set to false to disable FLARD's diamond spawning effect")
		public boolean flardDiamondEffect = true;

		@Comment("Set to false to disable FLARD's hole creation effect")
		public boolean flardHoleEffect = true;

		@Comment("Set to false to disable FLARD's explosion effect")
		public boolean flardExplosionEffect = true;

		@Comment("Set to false to disable FLARD's experience adding effect")
		public boolean flardXPEffect = true;

		@Comment("Set to false to disable FLARD's random chest loot effect")
		public boolean flardChestLootEffect = true;

		@Comment("Set to false to disable FLARD's fire spawning effect")
		public boolean flardFireEffect = true;

		@Comment("Set to false to disable FLARD's puddle effect")
		public boolean flardPuddleEffect = true;

		@Comment("Set to false to disable FLARD's cobweb creation effect")
		public boolean flardCobwebEffect = true;

		@Comment("Set to false to disable FLARD's block changing effect")
		public boolean flardBlockChangeEffect = true;

		@Comment("A list of blocks for the block change effect to not change things to")
		public String[] flardBlockBlacklist = {"minecraft:bedrock", "minecraft:repeating_command_block", "minecraft:command_block",
				"minecraft:chain_command_block", "minecraft:barrier", "minecraft:end_portal_frame",
				"minecraft:portal", "minecraft:mob_spawner", "minecraft:structure_block", "minecraft:structure_void"};
	}
}
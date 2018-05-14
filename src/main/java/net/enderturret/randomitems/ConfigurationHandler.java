package net.enderturret.randomitems;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

@Config(modid = "randomitems")
public class ConfigurationHandler {

	@RequiresMcRestart
	@Comment("Set to false to disable tesseracts effects")
	public static boolean tesseractEffects = true;
	@RequiresMcRestart
	@Comment("Set to false to disable FLARD having any use")
	public static boolean flardEnabled = true;
	@RequiresMcRestart
	@Comment("Set to false to disable questionable cheese having any use")
	public static boolean questionableCheeseEnabled = true;
	@RequiresMcRestart
	@Comment("Set to false to disable puffballs having any use whatsoever")
	public static boolean puffballEffectsEnabled = true;
	@RequiresMcRestart
	@Comment("Set to false to disable the stone chisel being useable")
	public static boolean stoneChiselEnabled = true;

	public static SubCategoryFLARD flardEffects = new SubCategoryFLARD();
	public static class SubCategoryFLARD {
		@RequiresMcRestart
		@Comment("Set to false to disable FLARD's poison effect")
		public boolean flardPoisonEffect = true;
		@RequiresMcRestart
		@Comment("Set to false to disable FLARD's offhand enchant effect")
		public boolean flardOffhandEnchantEffect = true;
		@RequiresMcRestart
		@Comment("Set to false to disable FLARD's inventory drop effect")
		public boolean flardInventoryDropEffect = true;
		@RequiresMcRestart
		@Comment("Set to false to disable FLARD's lightning strike effect")
		public boolean flardLightningEffect = true;
		@RequiresMcRestart
		@Comment("Set to false to disable FLARD's diamond spawning effect")
		public boolean flardDiamondEffect = true;
		@RequiresMcRestart
		@Comment("Set to false to disable FLARD's hole creation effect")
		public boolean flardHoleEffect = true;
		@RequiresMcRestart
		@Comment("Set to false to disable FLARD's explosion effect")
		public boolean flardExplosionEffect = true;
		@RequiresMcRestart
		@Comment("Set to false to disable FLARD's experience adding effect")
		public boolean flardXPEffect = true;
		@RequiresMcRestart
		@Comment("Set to false to disable FLARD's random chest loot effect")
		public boolean flardChestLootEffect = true;
		@RequiresMcRestart
		@Comment("Set to false to disable FLARD's fire spawning effect")
		public boolean flardFireEffect = true;
		@RequiresMcRestart
		@Comment("Set to false to disable FLARD's puddle effect")
		public boolean flardPuddleEffect = true;
		@RequiresMcRestart
		@Comment("Set to false to disable FLARD's cobweb creation effect")
		public boolean flardCobwebEffect = true;
		//@RequiresMcRestart
		//@Comment("Set to false to disable FLARD's ")
		//public boolean flardEffect = true;
	}
}
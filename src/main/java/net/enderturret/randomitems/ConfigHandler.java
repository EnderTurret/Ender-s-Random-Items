package net.enderturret.randomitems;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Type;

@Config(modid = "randomitems", type = Type.INSTANCE)
public class ConfigHandler {
	@Comment("Set to false to disable tesseracts effects")
	public static boolean tesseractEffects = true;
	@Comment("Set to false to disable FLARD having any use")
	public static boolean flardEnabled = true;
	@Comment("Set to false to disable questionable cheese having any use")
	public static boolean questionableCheeseEnabled = true;
	@Comment("Set to false to disable puffballs having any use whatsoever")
	public static boolean puffballEffectsEnabled = true;
	@Comment("Set to false to disable the stone chisel being useable")
	public static boolean stoneChiselEnabled = true;
	@Comment("Set to true to make /repair list the names of items rather than the item itself")
	public static boolean repairHumour = false;
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
		//@Comment("Set to false to disable FLARD's ")
		//public boolean flardEffect = true;
	}
}
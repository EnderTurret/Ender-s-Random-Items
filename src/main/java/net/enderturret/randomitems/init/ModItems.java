package net.enderturret.randomitems.init;

import net.enderturret.randomitems.util.ArmorMaterials;
import net.enderturret.randomitems.item.*;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

	public static final ItemBase moistTowelette = new ItemBase("moist_towelette");
	public static final ItemBase sanitizingWater = new ItemBase("sanitizing_water");
	public static final ItemBase puffballTail = new ItemBase("puffball_tail");
	public static final ItemBase puffballFur = new ItemBase("puffball_fur");
	public static final ItemBase stoneStick = new ItemBase("stone_stick");
	public static final ItemStoneChisel stoneChiselIron = new ItemStoneChisel("iron_stone_chisel", 31, 4);
	public static final ItemStoneChisel stoneChiselDiamond = new ItemStoneChisel("diamond_stone_chisel", 63, 8);
	public static final ItemQuestionableCheese questionableCheese = new ItemQuestionableCheese();
	public static final ItemFLARD flard = new ItemFLARD();

	public static final SaturatedFoodItem secretCoke = new SaturatedFoodItem("secret_coke", 1, 1f, false, true);
	//public static final SaturatedFoodItem syntacticSugar = new SaturatedFoodItem("syntactic_sugar", 1, 1f, false, false);

	public static final ItemPuffball puffball = new ItemPuffball("puffball");
	public static final ItemPuffball puffballWhite = new ItemPuffball("puffball_white");
	public static final ItemPuffball puffballLightGray = new ItemPuffball("puffball_light_gray");
	public static final ItemPuffball puffballGray = new ItemPuffball("puffball_gray");
	public static final ItemPuffball puffballBlack = new ItemPuffball("puffball_black");
	public static final ItemPuffball puffballBrown = new ItemPuffball("puffball_brown");
	public static final ItemPuffball puffballRed = new ItemPuffball("puffball_red");
	public static final ItemPuffball puffballOrange = new ItemPuffball("puffball_orange");
	public static final ItemPuffball puffballYellow = new ItemPuffball("puffball_yellow");
	public static final ItemPuffball puffballLime = new ItemPuffball("puffball_lime");
	public static final ItemPuffball puffballGreen = new ItemPuffball("puffball_green");
	public static final ItemPuffball puffballCyan = new ItemPuffball("puffball_cyan");
	public static final ItemPuffball puffballLightBlue = new ItemPuffball("puffball_light_blue");
	public static final ItemPuffball puffballBlue = new ItemPuffball("puffball_blue");
	public static final ItemPuffball puffballPurple = new ItemPuffball("puffball_purple");
	public static final ItemPuffball puffballMagenta = new ItemPuffball("puffball_magenta");
	public static final ItemPuffball puffballPink = new ItemPuffball("puffball_pink");
	//public static final ItemPuffball puffBallPurple = new ItemPuffball("puffball_purple");

	public static final ItemArmor invisibleLeatherCap = new ItemArmor("invisible_leather_cap", ArmorMaterials.invisibleLeather, EntityEquipmentSlot.HEAD);
	public static final ItemArmor invisibleLeatherTunic = new ItemArmor("invisible_leather_tunic", ArmorMaterials.invisibleLeather, EntityEquipmentSlot.CHEST);
	public static final ItemArmor invisibleLeatherPants = new ItemArmor("invisible_leather_pants", ArmorMaterials.invisibleLeather, EntityEquipmentSlot.LEGS);
	public static final ItemArmor invisibleLeatherBoots = new ItemArmor("invisible_leather_boots", ArmorMaterials.invisibleLeather, EntityEquipmentSlot.FEET);

	public static final ItemArmor invisibleChainHelmet = new ItemArmor("invisible_chainmail_helmet", ArmorMaterials.invisibleChainmail, EntityEquipmentSlot.HEAD);
	public static final ItemArmor invisibleChainChestplate = new ItemArmor("invisible_chainmail_chestplate", ArmorMaterials.invisibleChainmail, EntityEquipmentSlot.CHEST);
	public static final ItemArmor invisibleChainLeggings = new ItemArmor("invisible_chainmail_leggings", ArmorMaterials.invisibleChainmail, EntityEquipmentSlot.LEGS);
	public static final ItemArmor invisibleChainBoots = new ItemArmor("invisible_chainmail_boots", ArmorMaterials.invisibleChainmail, EntityEquipmentSlot.FEET);

	public static final ItemArmor invisibleIronHelmet = new ItemArmor("invisible_iron_helmet", ArmorMaterials.invisibleIron, EntityEquipmentSlot.HEAD);
	public static final ItemArmor invisibleIronChestplate = new ItemArmor("invisible_iron_chestplate", ArmorMaterials.invisibleIron, EntityEquipmentSlot.CHEST);
	public static final ItemArmor invisibleIronLeggings = new ItemArmor("invisible_iron_leggings", ArmorMaterials.invisibleIron, EntityEquipmentSlot.LEGS);
	public static final ItemArmor invisibleIronBoots = new ItemArmor("invisible_iron_boots", ArmorMaterials.invisibleIron, EntityEquipmentSlot.FEET);

	public static final ItemArmor invisibleGoldHelmet = new ItemArmor("invisible_gold_helmet", ArmorMaterials.invisibleGold, EntityEquipmentSlot.HEAD);
	public static final ItemArmor invisibleGoldChestplate = new ItemArmor("invisible_gold_chestplate", ArmorMaterials.invisibleGold, EntityEquipmentSlot.CHEST);
	public static final ItemArmor invisibleGoldLeggings = new ItemArmor("invisible_gold_leggings", ArmorMaterials.invisibleGold, EntityEquipmentSlot.LEGS);
	public static final ItemArmor invisibleGoldBoots = new ItemArmor("invisible_gold_boots", ArmorMaterials.invisibleGold, EntityEquipmentSlot.FEET);

	public static final ItemArmor invisibleDiamondHelmet = new ItemArmor("invisible_diamond_helmet", ArmorMaterials.invisibleDiamond, EntityEquipmentSlot.HEAD);
	public static final ItemArmor invisibleDiamondChestplate = new ItemArmor("invisible_diamond_chestplate", ArmorMaterials.invisibleDiamond, EntityEquipmentSlot.CHEST);
	public static final ItemArmor invisibleDiamondLeggings = new ItemArmor("invisible_diamond_leggings", ArmorMaterials.invisibleDiamond, EntityEquipmentSlot.LEGS);
	public static final ItemArmor invisibleDiamondBoots = new ItemArmor("invisible_diamond_boots", ArmorMaterials.invisibleDiamond, EntityEquipmentSlot.FEET);

	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				moistTowelette,
				sanitizingWater,
				secretCoke,
				puffballTail,
				puffballFur,
				stoneStick,
				stoneChiselIron,
				stoneChiselDiamond,
				questionableCheese,
				flard,
				//syntacticSugar,

				puffball,
				puffballWhite,
				puffballLightGray,
				puffballGray,
				puffballBlack,
				puffballBrown,
				puffballRed,
				puffballOrange,
				puffballYellow,
				puffballLime,
				puffballGreen,
				puffballCyan,
				puffballLightBlue,
				puffballBlue,
				//puffballPurple,
				puffballMagenta,
				puffballPink,

				invisibleLeatherCap,
				invisibleLeatherTunic,
				invisibleLeatherPants,
				invisibleLeatherBoots,
				invisibleChainHelmet,
				invisibleChainChestplate,
				invisibleChainLeggings,
				invisibleChainBoots,
				invisibleIronHelmet,
				invisibleIronChestplate,
				invisibleIronLeggings,
				invisibleIronBoots,
				invisibleGoldHelmet,
				invisibleGoldChestplate,
				invisibleGoldLeggings,
				invisibleGoldBoots,
				invisibleDiamondHelmet,
				invisibleDiamondChestplate,
				invisibleDiamondLeggings,
				invisibleDiamondBoots
		);
	}

	public static void registerModels() {
		moistTowelette.registerItemModel();
		sanitizingWater.registerItemModel();
		secretCoke.registerItemModel();
		puffballTail.registerItemModel();
		puffballFur.registerItemModel();
		stoneStick.registerItemModel();
		stoneChiselIron.registerItemModel();
		stoneChiselDiamond.registerItemModel();
		questionableCheese.registerItemModel();
		flard.registerItemModel();
		//syntacticSugar.registerItemModel();

		puffball.registerItemModel();
		puffballWhite.registerItemModel();
		puffballLightGray.registerItemModel();
		puffballGray.registerItemModel();
		puffballBlack.registerItemModel();
		puffballBrown.registerItemModel();
		puffballRed.registerItemModel();
		puffballOrange.registerItemModel();
		puffballYellow.registerItemModel();
		puffballLime.registerItemModel();
		puffballGreen.registerItemModel();
		puffballCyan.registerItemModel();
		puffballLightBlue.registerItemModel();
		puffballBlue.registerItemModel();
		//puffballPurple.registerItemModel();
		puffballMagenta.registerItemModel();
		puffballPink.registerItemModel();

		invisibleLeatherCap.registerItemModel();
		invisibleLeatherTunic.registerItemModel();
		invisibleLeatherPants.registerItemModel();
		invisibleLeatherBoots.registerItemModel();
		invisibleChainHelmet.registerItemModel();
		invisibleChainChestplate.registerItemModel();
		invisibleChainLeggings.registerItemModel();
		invisibleChainBoots.registerItemModel();
		invisibleIronHelmet.registerItemModel();
		invisibleIronChestplate.registerItemModel();
		invisibleIronLeggings.registerItemModel();
		invisibleIronBoots.registerItemModel();
		invisibleGoldHelmet.registerItemModel();
		invisibleGoldChestplate.registerItemModel();
		invisibleGoldLeggings.registerItemModel();
		invisibleGoldBoots.registerItemModel();
		invisibleDiamondHelmet.registerItemModel();
		invisibleDiamondChestplate.registerItemModel();
		invisibleDiamondLeggings.registerItemModel();
		invisibleDiamondBoots.registerItemModel();
	}
}
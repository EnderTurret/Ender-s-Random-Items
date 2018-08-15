package net.enderturret.randomitems.util;

import net.enderturret.randomitems.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterials {
	public static final ArmorMaterial invisibleLeather = EnumHelper.addArmorMaterial("INVISIBLE_LEATHER", Reference.modId+":invisible_armor", 5, new int[] {1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial invisibleChainmail = EnumHelper.addArmorMaterial("INVISIBLE_CHAINMAIL", Reference.modId+":invisible_armor", 15, new int[] {1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F);
	public static final ArmorMaterial invisibleIron = EnumHelper.addArmorMaterial("INVISIBLE_IRON", Reference.modId+":invisible_armor", 15, new int[] {2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ArmorMaterial invisibleGold = EnumHelper.addArmorMaterial("INVISIBLE_GOLD", Reference.modId+":invisible_armor", 7, new int[] {1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);
	public static final ArmorMaterial invisibleDiamond = EnumHelper.addArmorMaterial("INVISIBLE_DIAMOND", Reference.modId+":invisible_armor", 33, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
}
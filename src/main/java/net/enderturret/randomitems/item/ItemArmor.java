package net.enderturret.randomitems.item;

import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class ItemArmor extends net.minecraft.item.ItemArmor {

	private final String name;
	private final boolean invisible;

	public ItemArmor(String name, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
		this(name, materialIn, equipmentSlotIn, false);
	}

	public ItemArmor(String name, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn, boolean isInvisible) {
		super(materialIn, 0, equipmentSlotIn);
		this.name = name;
		this.invisible = isInvisible;
		setCreativeTab(RandomItems.TAB);
		setRegistryName(name);
		setTranslationKey(name);
	}

	public void registerItemModel() {
		RandomItems.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return invisible ? Reference.MOD_ID + ":textures/model/invisible_armor.png" : super.getArmorTexture(stack, entity, slot, type);
	}
}
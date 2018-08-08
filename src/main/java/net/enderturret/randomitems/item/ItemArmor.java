package net.enderturret.randomitems.item;

import net.enderturret.randomitems.RandomItems;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemArmor extends net.minecraft.item.ItemArmor {

	private final String name;

	public ItemArmor(String name, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, 0, equipmentSlotIn);
		this.name = name;
		setCreativeTab(RandomItems.creativeTab);
		setRegistryName(name);
		setUnlocalizedName(name);
	}

	public void registerItemModel() {
		RandomItems.proxy.registerItemRenderer(this, 0, name);
	}
}
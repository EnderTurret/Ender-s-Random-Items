package net.enderturret.randomitems.item;

import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class ItemArmor extends net.minecraft.item.ItemArmor {

	private final String name;
	private final boolean isInvisible;

	public ItemArmor(String name, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
		this(name, materialIn, equipmentSlotIn, false);
	}

	public ItemArmor(String name, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn, boolean isInvisible) {
		super(materialIn, 0, equipmentSlotIn);
		this.name = name;
		this.isInvisible = isInvisible;
		setCreativeTab(RandomItems.tab);
		setRegistryName(name);
		setUnlocalizedName(name);
	}

	public void registerItemModel() {
		RandomItems.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return isInvisible ? Reference.modId+":textures/model/invisible_armor.png" : super.getArmorTexture(stack, entity, slot, type);
	}
}
package net.enderturret.randomitems.proxy;

import net.enderturret.randomitems.Reference;
import net.enderturret.randomitems.enchantment.NVIDIAException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.crash.CrashReport;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.modId+ ":" + id, "inventory"));
	}

	@Override
	public void notSuspicious() {
		Minecraft.getMinecraft().crashed(new CrashReport("Experienced nVIDIA", new NVIDIAException("You were killed by something with the nVIDIA enchant. DO NOT REPORT THIS")));
	}

	@Override
	public String localize(String unlocalized) {
		return I18n.format(unlocalized);
	}
}
package net.enderturret.randomitems.proxy;

import org.lwjgl.opengl.GL11;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.Reference;
import net.enderturret.randomitems.enchantment.NVIDIAException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.crash.CrashReport;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy implements IProxy {

	private static boolean nvidia = false;

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + id, "inventory"));
	}

	@Override
	public void nvidiaCrash() {
		if (ConfigHandler.nvidiaEnchantmentEnabled && nVIDIA())
			Minecraft.getMinecraft().crashed(new CrashReport("Experienced nVIDIA", new NVIDIAException("You were killed by something with the nVIDIA enchant. DO NOT REPORT THIS")));
	}

	@Override
	public void init() {
		nvidia = GL11.glGetString(GL11.GL_VENDOR).toLowerCase().contains("nvidia");
	}

	@Override
	public boolean nVIDIA() {
		return nvidia;
	}
}
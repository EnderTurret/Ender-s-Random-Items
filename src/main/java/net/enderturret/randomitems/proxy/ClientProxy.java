package net.enderturret.randomitems.proxy;

import org.lwjgl.opengl.GL11;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.enchantment.NVIDIAException;
import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReport;

public class ClientProxy implements IProxy {

	private boolean nvidia = false;

	@Override
	public void nvidiaCrash() {
		if (ConfigHandler.get().nvidiaEnchantmentEnabled.get() && isNVIDIA())
			Minecraft.getInstance().crashed(new CrashReport("Experienced nVIDIA", new NVIDIAException("You were killed by something with the nVIDIA enchant. DO NOT REPORT THIS")));
	}

	@Override
	public void init() {
		Minecraft.getInstance().enqueue(() -> nvidia = GL11.glGetString(GL11.GL_VENDOR).toLowerCase().contains("nvidia"));
	}

	@Override
	public boolean isNVIDIA() {
		return nvidia;
	}
}

package net.enderturret.randomitems.proxy;

public class ServerProxy implements IProxy {

	@Override
	public void nvidiaCrash() {}

	@Override
	public void init() {}

	@Override
	public boolean isNVIDIA() { return false; }
}
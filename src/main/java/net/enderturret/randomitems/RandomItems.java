package net.enderturret.randomitems;

import net.enderturret.randomitems.init.ModBlocks;
import net.enderturret.randomitems.init.ModItems;
import net.enderturret.randomitems.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod(modid = "randomitems", name = "Ender's Random Items", version = "0.0.1")
public class RandomItems {

	public static final String modId = "randomitems";
	public static final RandomItemsTab creativeTab = new RandomItemsTab();
	
	@Mod.Instance(modId)
	public static RandomItems instance;

	@SidedProxy(serverSide = "net.enderturret.randomitems.proxy.CommonProxy", clientSide = "net.enderturret.randomitems.proxy.ClientProxy")
	public static CommonProxy proxy;

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {

		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ModBlocks.registerItemBlocks(event.getRegistry());
			ModItems.register(event.getRegistry());
		}

		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			
			ModBlocks.register(event.getRegistry());
		}

		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			ModBlocks.registerModels();
			ModItems.registerModels();
		}
	}
}

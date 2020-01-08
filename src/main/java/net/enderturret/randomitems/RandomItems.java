package net.enderturret.randomitems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.enderturret.randomitems.command.CommandRandomItems;
import net.enderturret.randomitems.command.CommandRepair;
import net.enderturret.randomitems.flardeffects.FLARDEffect;
import net.enderturret.randomitems.init.*;
import net.enderturret.randomitems.proxy.IProxy;
import net.enderturret.randomitems.tileentity.TileEntityKeycardReader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;

@Mod(modid = Reference.MOD_ID, name = "Ender's Random Items", version = Reference.MOD_VERSION, acceptedMinecraftVersions = "[1.12,)")
public class RandomItems {

	public static final RandomItemsTab TAB = new RandomItemsTab();
	public static final Logger LOGGER = LogManager.getLogger("randomitems");

	@Mod.Instance(Reference.MOD_ID)
	public static RandomItems instance;

	@SidedProxy(serverSide = "net.enderturret.randomitems.proxy.ServerProxy", clientSide = "net.enderturret.randomitems.proxy.ClientProxy")
	public static IProxy proxy;

	@Mod.EventHandler
	public static void init(FMLInitializationEvent e) {
		if (ConfigHandler.repairCommandEnabled) {
			PermissionAPI.registerNode("randomitems.repair.all", DefaultPermissionLevel.OP, "Used for /repair all");
			PermissionAPI.registerNode("randomitems.repair.hand", DefaultPermissionLevel.OP, "Used for /repair hand");
			PermissionAPI.registerNode("randomitems.repair", DefaultPermissionLevel.OP, "Used for /repair");
		}
		PermissionAPI.registerNode("randomitems.randomitems", DefaultPermissionLevel.OP, "Debug command for testing FLARD effects and stuff.");

		ModItems.initOreDict();
		ModBlocks.initOreDict();

		proxy.init();
		GameRegistry.registerTileEntity(TileEntityKeycardReader.class, new ResourceLocation(Reference.MOD_ID, "tileentitykeycardreader"));
	}

	@Mod.EventHandler
	public static void onServerStart(FMLServerStartingEvent e) {
		if (ConfigHandler.repairCommandEnabled)
			e.registerServerCommand(new CommandRepair());
		e.registerServerCommand(new CommandRandomItems());
	}

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {

		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> e) {
			ModBlocks.registerItemBlocks(e.getRegistry());
			ModItems.register(e.getRegistry());
		}

		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> e) {
			ModBlocks.register(e.getRegistry());
		}

		@SubscribeEvent
		public static void registerFlardEffects(RegistryEvent.Register<FLARDEffect> e) {
			ModFlardEffects.registerAll(e.getRegistry());
		}

		@SubscribeEvent
		public static void createRegistries(RegistryEvent.NewRegistry e) {
			FLARDEffectRegistry.createRegistry();
		}

		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent e) {
			ModBlocks.registerModels();
			ModItems.registerModels();
		}

		@SubscribeEvent
		public static void onLootLoad(LootTableLoadEvent e) {
			if ("minecraft:chests/simple_dungeon".equals(e.getName().toString())) {
				final LootEntry flard = new LootEntryItem(ModItems.FLARD, 6, 80, new LootFunction[0], new LootCondition[0], "randomitems:flard");
				final LootPool pool = new LootPool(new LootEntry[]{flard}, new LootCondition[0], new RandomValueRange(0, 2), new RandomValueRange(0), "randomitems:dungeon_pool");
				e.getTable().addPool(pool);
			}
		}

		@SubscribeEvent
		public static void onConfigChanged(OnConfigChangedEvent e) {
			if (e.getModID().equals(Reference.MOD_ID))
				ConfigManager.sync(Reference.MOD_ID, Type.INSTANCE);
		}
	}
}
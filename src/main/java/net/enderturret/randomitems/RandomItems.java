package net.enderturret.randomitems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.enderturret.randomitems.init.ModBlocks;
import net.enderturret.randomitems.init.ModItems;
import net.enderturret.randomitems.proxy.CommonProxy;
import net.enderturret.randomitems.util.CommandRepair;
import net.enderturret.randomitems.util.FLARDEffectRegistry;
import net.enderturret.randomitems.util.flardeffects.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;

@Mod(modid = Reference.modId, name = "Ender's Random Items", version = Reference.modVersion)
public class RandomItems {

	public static final RandomItemsTab tab = new RandomItemsTab();
	public static final Logger log = LogManager.getLogger("randomitems");

	@Mod.Instance(Reference.modId)
	public static RandomItems instance;

	@SidedProxy(serverSide = "net.enderturret.randomitems.proxy.CommonProxy", clientSide = "net.enderturret.randomitems.proxy.ClientProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public static void init(FMLInitializationEvent e) {
		if (ConfigHandler.repairCommandEnabled) {
			PermissionAPI.registerNode("randomitems.repair.all", DefaultPermissionLevel.OP, "Used for /repair all");
			PermissionAPI.registerNode("randomitems.repair.hand", DefaultPermissionLevel.OP, "Used for /repair hand");
			PermissionAPI.registerNode("randomitems.repair", DefaultPermissionLevel.OP, "Used for /repair");
		}

		ModItems.initOreDict();
		ModBlocks.initOreDict();
	}

	@Mod.EventHandler
	public static void onServerStart(FMLServerStartingEvent e) {
		if (ConfigHandler.repairCommandEnabled) e.registerServerCommand(new CommandRepair());
	}

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {

		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> e) {
			ModBlocks.registerItemBlocks(e.getRegistry());
			ModItems.register(e.getRegistry());
			FLARDEffectRegistry.registerAll(new EffectChestLoot(), new EffectEnchantment(), new EffectBlockChange());
		}

		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> e) {
			ModBlocks.register(e.getRegistry());
		}

		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent e) {
			ModBlocks.registerModels();
			ModItems.registerModels();
		}

		@SubscribeEvent
		public static void onLootLoad(LootTableLoadEvent e) {
			if (e.getName().toString().equals("minecraft:chests/simple_dungeon")) {
				LootEntry flard = new LootEntryItem(ModItems.flard, 6, 80, new LootFunction[0], new LootCondition[0], "randomitems:flard");
				LootPool poolDungeon = new LootPool(new LootEntry[]{flard}, new LootCondition[0], new RandomValueRange(0,2), new RandomValueRange(0), "randomitems:dungeon_pool");
				e.getTable().addPool(poolDungeon);
			}
		}

		@SubscribeEvent
		public static void onConfigChanged(OnConfigChangedEvent e) {
			if (e.getModID().equals(Reference.modId)) ConfigManager.sync(Reference.modId, Type.INSTANCE);
		}
	}
}
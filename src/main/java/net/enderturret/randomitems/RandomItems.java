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

		@SubscribeEvent
		public static void missingMappings(RegistryEvent.MissingMappings<Item> event) {
			for (RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getMappings()) {
				final String path = mapping.key.getPath();
				if (path.startsWith("puffball_")) {
					if ("puffball_white".equals(path)) mapping.remap(ModItems.PUFFBALL_WHITE);
					else if ("puffball_light_gray".equals(path)) mapping.remap(ModItems.PUFFBALL_LIGHT_GRAY);
					else if ("puffball_gray".equals(path)) mapping.remap(ModItems.PUFFBALL_GRAY);
					else if ("puffball_black".equals(path)) mapping.remap(ModItems.PUFFBALL_BLACK);
					else if ("puffball_brown".equals(path)) mapping.remap(ModItems.PUFFBALL_BROWN);
					else if ("puffball_red".equals(path)) mapping.remap(ModItems.PUFFBALL_RED);
					else if ("puffball_orange".equals(path)) mapping.remap(ModItems.PUFFBALL_ORANGE);
					else if ("puffball_yellow".equals(path)) mapping.remap(ModItems.PUFFBALL_YELLOW);
					else if ("puffball_lime".equals(path)) mapping.remap(ModItems.PUFFBALL_LIME);
					else if ("puffball_green".equals(path)) mapping.remap(ModItems.PUFFBALL_GREEN);
					else if ("puffball_cyan".equals(path)) mapping.remap(ModItems.PUFFBALL_CYAN);
					else if ("puffball_light_blue".equals(path)) mapping.remap(ModItems.PUFFBALL_LIGHT_BLUE);
					else if ("puffball_blue".equals(path)) mapping.remap(ModItems.PUFFBALL_BLUE);
					else if ("puffball_purple".equals(path)) mapping.remap(ModItems.PUFFBALL_PURPLE);
					else if ("puffball_magenta".equals(path)) mapping.remap(ModItems.PUFFBALL_MAGENTA);
					else if ("puffball_pink".equals(path)) mapping.remap(ModItems.PUFFBALL_PINK);
				}

				if ("block_tesseract".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.TESSERACT));
				else if ("block_love_tesseract".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.LOVE_TESSERACT));
				else if ("block_stone_torch".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.STONE_TORCH));
				else if ("block_wolfenoot_cake".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.WOLFENOOT_CAKE));
				else if ("block_keycard_reader".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.KEYCARD_READER));
				else if ("block_dog_plushie".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.DOG_PLUSH));
				else if ("block_clear_core".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_CLEAR));
				else if ("block_sun_core".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_SUN));
				else if ("block_night_core".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_NIGHT));
				else if ("block_corrupted_core".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_CORRUPT));
				else if ("block_universe_core".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_UNIVERSE));
				else if (path.startsWith("block_core_")) {
					if ("block_core_purple".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_PURPLE));
					else if ("block_core_red".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_RED));
					else if ("block_core_blue".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_BLUE));
					else if ("block_core_black".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_BLACK));
					else if ("block_core_yellow".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_YELLOW));
					else if ("block_core_white".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_WHITE));
					else if ("block_core_gray".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_GRAY));
					else if ("block_core_light_gray".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_LIGHT_GRAY));
					else if ("block_core_light_blue".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_LIGHT_BLUE));
					else if ("block_core_cyan".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_CYAN));
					else if ("block_core_orange".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_ORANGE));
					else if ("block_core_magenta".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_MAGENTA));
					else if ("block_core_pink".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_PINK));
					else if ("block_core_brown".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_BROWN));
					else if ("block_core_green".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_GREEN));
					else if ("block_core_lime".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_LIME));
					else if ("block_core_black_2".equals(path)) mapping.remap(Item.getItemFromBlock(ModBlocks.CORE_BLACK_2));
				}
			}
		}

		@SubscribeEvent
		public static void missingMappingsBlock(RegistryEvent.MissingMappings<Block> event) {
			for (RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getMappings()) {
				final String path = mapping.key.getPath();
				if ("block_tesseract".equals(path)) mapping.remap(ModBlocks.TESSERACT);
				else if ("block_love_tesseract".equals(path)) mapping.remap(ModBlocks.LOVE_TESSERACT);
				else if ("block_stone_torch".equals(path)) mapping.remap(ModBlocks.STONE_TORCH);
				else if ("block_wolfenoot_cake".equals(path)) mapping.remap(ModBlocks.WOLFENOOT_CAKE);
				else if ("block_keycard_reader".equals(path)) mapping.remap(ModBlocks.KEYCARD_READER);
				else if ("block_dog_plushie".equals(path)) mapping.remap(ModBlocks.DOG_PLUSH);
				else if ("block_clear_core".equals(path)) mapping.remap(ModBlocks.CORE_CLEAR);
				else if ("block_sun_core".equals(path)) mapping.remap(ModBlocks.CORE_SUN);
				else if ("block_night_core".equals(path)) mapping.remap(ModBlocks.CORE_NIGHT);
				else if ("block_corrupted_core".equals(path)) mapping.remap(ModBlocks.CORE_CORRUPT);
				else if ("block_universe_core".equals(path)) mapping.remap(ModBlocks.CORE_UNIVERSE);
				else if (path.startsWith("block_core")) {
					if ("block_core_purple".equals(path)) mapping.remap(ModBlocks.CORE_PURPLE);
					else if ("block_core_red".equals(path)) mapping.remap(ModBlocks.CORE_RED);
					else if ("block_core_blue".equals(path)) mapping.remap(ModBlocks.CORE_BLUE);
					else if ("block_core_black".equals(path)) mapping.remap(ModBlocks.CORE_BLACK);
					else if ("block_core_yellow".equals(path)) mapping.remap(ModBlocks.CORE_YELLOW);
					else if ("block_core_white".equals(path)) mapping.remap(ModBlocks.CORE_WHITE);
					else if ("block_core_gray".equals(path)) mapping.remap(ModBlocks.CORE_GRAY);
					else if ("block_core_light_gray".equals(path)) mapping.remap(ModBlocks.CORE_LIGHT_GRAY);
					else if ("block_core_light_blue".equals(path)) mapping.remap(ModBlocks.CORE_LIGHT_BLUE);
					else if ("block_core_cyan".equals(path)) mapping.remap(ModBlocks.CORE_CYAN);
					else if ("block_core_orange".equals(path)) mapping.remap(ModBlocks.CORE_ORANGE);
					else if ("block_core_magenta".equals(path)) mapping.remap(ModBlocks.CORE_MAGENTA);
					else if ("block_core_pink".equals(path)) mapping.remap(ModBlocks.CORE_PINK);
					else if ("block_core_brown".equals(path)) mapping.remap(ModBlocks.CORE_BROWN);
					else if ("block_core_green".equals(path)) mapping.remap(ModBlocks.CORE_GREEN);
					else if ("block_core_lime".equals(path)) mapping.remap(ModBlocks.CORE_LIME);
					else if ("block_core_black_2".equals(path)) mapping.remap(ModBlocks.CORE_BLACK_2);
				}
			}
		}
	}
}
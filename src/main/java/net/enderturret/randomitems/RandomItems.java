package net.enderturret.randomitems;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.enderturret.randomitems.enchantment.ModEnchantments;
import net.enderturret.randomitems.init.ModBlocks;
import net.enderturret.randomitems.init.ModCommands;
import net.enderturret.randomitems.init.ModFlardEffects;
import net.enderturret.randomitems.init.ModItems;
import net.enderturret.randomitems.init.ModTileEntities;
import net.enderturret.randomitems.proxy.ClientProxy;
import net.enderturret.randomitems.proxy.ServerProxy;
import net.enderturret.randomitems.proxy.IProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.storage.loot.ItemLootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class RandomItems {

	public static final ItemGroup TAB = new ItemGroup(Reference.MOD_ID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.TESSERACT.get());
		}
	};

	public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);

	public static IProxy proxy = DistExecutor.safeRunForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

	public RandomItems() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.CONFIG_SPEC, Reference.MOD_ID + ".toml");
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::init);
		bus.addListener(this::clientInit);
		ModBlocks.REGISTRY.register(bus);
		ModItems.REGISTRY.register(bus);
		ModTileEntities.REGISTRY.register(bus);
		ModEnchantments.REGISTRY.register(bus);
		ModBlocks.registerItemBlocks();
		MinecraftForge.EVENT_BUS.addListener(this::onServerStart); // ServerStartingEvent is fired on the Forge bus, not the mod one.
		MinecraftForge.EVENT_BUS.addListener(this::onLootLoad); // Same with this all these.
		MinecraftForge.EVENT_BUS.addListener(this::onEntityTick);
		MinecraftForge.EVENT_BUS.addListener(this::missingMappings);
		MinecraftForge.EVENT_BUS.addListener(this::missingMappingsBlock);
	}

	public void init(FMLCommonSetupEvent e) {
		ModCommands.registerPermissionNodes();

		proxy.init();
	}

	public void clientInit(FMLClientSetupEvent e) {
		RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.RED_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.PINK_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.LIME_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_CORE_2.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.CLEAR_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.SUN_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NIGHT_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.CORRUPT_CORE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.UNIVERSE_CORE.get(), RenderType.getCutout());

		RenderTypeLookup.setRenderLayer(ModBlocks.STONE_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.STONE_TORCH_WALL.get(), RenderType.getCutout());
	}

	private void onServerStart(FMLServerStartingEvent e) {
		ModCommands.registerCommands(e.getCommandDispatcher());
	}

	private void onLootLoad(LootTableLoadEvent e) {
		if ("minecraft:chests/simple_dungeon".equals(e.getName().toString())) {
			final ItemLootEntry.Builder flard = ItemLootEntry.builder(() -> ModItems.FLARD.get()).weight(6).quality(80);
			final LootPool pool = LootPool.builder().addEntry(flard).name("randomitems:flard_pool").rolls(new RandomValueRange(0,2)).build();
			e.getTable().addPool(pool);
		}
	}

	private void onEntityTick(LivingUpdateEvent e) {
		if (!e.getEntityLiving().getEntityWorld().isRemote) {
			final int lvlGrav = EnchantmentHelper.getMaxEnchantmentLevel(ModEnchantments.ANTI_GRAVITY.get(), e.getEntityLiving());
			if (lvlGrav > 0 && ConfigHandler.get().antiGravEnabled.get())
				e.getEntityLiving().addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 20, Math.min(3, lvlGrav)));
		}
	}

	private void missingMappings(RegistryEvent.MissingMappings<Item> event) {
		final List<RegistryEvent.MissingMappings.Mapping<Item>> mappings = event.getAllMappings().stream().filter(m -> Reference.MOD_ID.equals(m.key.getNamespace())).collect(Collectors.toList());
		for (RegistryEvent.MissingMappings.Mapping<Item> mapping : mappings) {
			final String path = mapping.key.getPath();
			if (path.startsWith("puffball_")) {
				if ("puffball_white".equals(path)) mapping.remap(ModItems.WHITE_PUFFBALL.get());
				else if ("puffball_light_gray".equals(path)) mapping.remap(ModItems.LIGHT_GRAY_PUFFBALL.get());
				else if ("puffball_gray".equals(path)) mapping.remap(ModItems.GRAY_PUFFBALL.get());
				else if ("puffball_black".equals(path)) mapping.remap(ModItems.BLACK_PUFFBALL.get());
				else if ("puffball_brown".equals(path)) mapping.remap(ModItems.BROWN_PUFFBALL.get());
				else if ("puffball_red".equals(path)) mapping.remap(ModItems.RED_PUFFBALL.get());
				else if ("puffball_orange".equals(path)) mapping.remap(ModItems.ORANGE_PUFFBALL.get());
				else if ("puffball_yellow".equals(path)) mapping.remap(ModItems.YELLOW_PUFFBALL.get());
				else if ("puffball_lime".equals(path)) mapping.remap(ModItems.LIME_PUFFBALL.get());
				else if ("puffball_green".equals(path)) mapping.remap(ModItems.GREEN_PUFFBALL.get());
				else if ("puffball_cyan".equals(path)) mapping.remap(ModItems.CYAN_PUFFBALL.get());
				else if ("puffball_light_blue".equals(path)) mapping.remap(ModItems.LIGHT_BLUE_PUFFBALL.get());
				else if ("puffball_blue".equals(path)) mapping.remap(ModItems.BLUE_PUFFBALL.get());
				else if ("puffball_purple".equals(path)) mapping.remap(ModItems.PURPLE_PUFFBALL.get());
				else if ("puffball_magenta".equals(path)) mapping.remap(ModItems.MAGENTA_PUFFBALL.get());
				else if ("puffball_pink".equals(path)) mapping.remap(ModItems.PINK_PUFFBALL.get());
			}

			if ("block_tesseract".equals(path)) mapping.remap(ModBlocks.TESSERACT.get().asItem());
			else if ("block_love_tesseract".equals(path)) mapping.remap(ModBlocks.LOVE_TESSERACT.get().asItem());
			else if ("block_stone_torch".equals(path)) mapping.remap(ModBlocks.STONE_TORCH.get().asItem());
			else if ("block_wolfenoot_cake".equals(path)) mapping.remap(ModBlocks.WOLFENOOT_CAKE.get().asItem());
			else if ("block_keycard_reader".equals(path)) mapping.remap(ModBlocks.KEYCARD_READER.get().asItem());
			else if ("block_dog_plushie".equals(path)) mapping.remap(ModBlocks.DOG_PLUSHIE.get().asItem());
			else if ("block_clear_core".equals(path)) mapping.remap(ModBlocks.CLEAR_CORE.get().asItem());
			else if ("block_sun_core".equals(path)) mapping.remap(ModBlocks.SUN_CORE.get().asItem());
			else if ("block_night_core".equals(path)) mapping.remap(ModBlocks.NIGHT_CORE.get().asItem());
			else if ("block_corrupted_core".equals(path)) mapping.remap(ModBlocks.CORRUPT_CORE.get().asItem());
			else if ("block_universe_core".equals(path)) mapping.remap(ModBlocks.UNIVERSE_CORE.get().asItem());
			else if (path.startsWith("block_core_")) {
				if ("block_core_purple".equals(path)) mapping.remap(ModBlocks.PURPLE_CORE.get().asItem());
				else if ("block_core_red".equals(path)) mapping.remap(ModBlocks.RED_CORE.get().asItem());
				else if ("block_core_blue".equals(path)) mapping.remap(ModBlocks.BLUE_CORE.get().asItem());
				else if ("block_core_black".equals(path)) mapping.remap(ModBlocks.BLACK_CORE.get().asItem());
				else if ("block_core_yellow".equals(path)) mapping.remap(ModBlocks.YELLOW_CORE.get().asItem());
				else if ("block_core_white".equals(path)) mapping.remap(ModBlocks.WHITE_CORE.get().asItem());
				else if ("block_core_gray".equals(path)) mapping.remap(ModBlocks.GRAY_CORE.get().asItem());
				else if ("block_core_light_gray".equals(path)) mapping.remap(ModBlocks.LIGHT_GRAY_CORE.get().asItem());
				else if ("block_core_light_blue".equals(path)) mapping.remap(ModBlocks.LIGHT_BLUE_CORE.get().asItem());
				else if ("block_core_cyan".equals(path)) mapping.remap(ModBlocks.CYAN_CORE.get().asItem());
				else if ("block_core_orange".equals(path)) mapping.remap(ModBlocks.ORANGE_CORE.get().asItem());
				else if ("block_core_magenta".equals(path)) mapping.remap(ModBlocks.MAGENTA_CORE.get().asItem());
				else if ("block_core_pink".equals(path)) mapping.remap(ModBlocks.PINK_CORE.get().asItem());
				else if ("block_core_brown".equals(path)) mapping.remap(ModBlocks.BROWN_CORE.get().asItem());
				else if ("block_core_green".equals(path)) mapping.remap(ModBlocks.GREEN_CORE.get().asItem());
				else if ("block_core_lime".equals(path)) mapping.remap(ModBlocks.LIME_CORE.get().asItem());
				else if ("block_core_black_2".equals(path)) mapping.remap(ModBlocks.BLACK_CORE_2.get().asItem());
			}
		}
	}

	private void missingMappingsBlock(RegistryEvent.MissingMappings<Block> event) {
		final List<RegistryEvent.MissingMappings.Mapping<Block>> mappings = event.getAllMappings().stream().filter(m -> Reference.MOD_ID.equals(m.key.getNamespace())).collect(Collectors.toList());
		for (RegistryEvent.MissingMappings.Mapping<Block> mapping : mappings) {
			final String path = mapping.key.getPath();
			if ("block_tesseract".equals(path)) mapping.remap(ModBlocks.TESSERACT.get());
			else if ("block_love_tesseract".equals(path)) mapping.remap(ModBlocks.LOVE_TESSERACT.get());
			else if ("block_stone_torch".equals(path)) mapping.remap(ModBlocks.STONE_TORCH.get());
			else if ("block_wolfenoot_cake".equals(path)) mapping.remap(ModBlocks.WOLFENOOT_CAKE.get());
			else if ("block_keycard_reader".equals(path)) mapping.remap(ModBlocks.KEYCARD_READER.get());
			else if ("block_dog_plushie".equals(path)) mapping.remap(ModBlocks.DOG_PLUSHIE.get());
			else if ("block_clear_core".equals(path)) mapping.remap(ModBlocks.CLEAR_CORE.get());
			else if ("block_sun_core".equals(path)) mapping.remap(ModBlocks.SUN_CORE.get());
			else if ("block_night_core".equals(path)) mapping.remap(ModBlocks.NIGHT_CORE.get());
			else if ("block_corrupted_core".equals(path)) mapping.remap(ModBlocks.CORRUPT_CORE.get());
			else if ("block_universe_core".equals(path)) mapping.remap(ModBlocks.UNIVERSE_CORE.get());
			else if (path.startsWith("block_core")) {
				if ("block_core_purple".equals(path)) mapping.remap(ModBlocks.PURPLE_CORE.get());
				else if ("block_core_red".equals(path)) mapping.remap(ModBlocks.RED_CORE.get());
				else if ("block_core_blue".equals(path)) mapping.remap(ModBlocks.BLUE_CORE.get());
				else if ("block_core_black".equals(path)) mapping.remap(ModBlocks.BLACK_CORE.get());
				else if ("block_core_yellow".equals(path)) mapping.remap(ModBlocks.YELLOW_CORE.get());
				else if ("block_core_white".equals(path)) mapping.remap(ModBlocks.WHITE_CORE.get());
				else if ("block_core_gray".equals(path)) mapping.remap(ModBlocks.GRAY_CORE.get());
				else if ("block_core_light_gray".equals(path)) mapping.remap(ModBlocks.LIGHT_GRAY_CORE.get());
				else if ("block_core_light_blue".equals(path)) mapping.remap(ModBlocks.LIGHT_BLUE_CORE.get());
				else if ("block_core_cyan".equals(path)) mapping.remap(ModBlocks.CYAN_CORE.get());
				else if ("block_core_orange".equals(path)) mapping.remap(ModBlocks.ORANGE_CORE.get());
				else if ("block_core_magenta".equals(path)) mapping.remap(ModBlocks.MAGENTA_CORE.get());
				else if ("block_core_pink".equals(path)) mapping.remap(ModBlocks.PINK_CORE.get());
				else if ("block_core_brown".equals(path)) mapping.remap(ModBlocks.BROWN_CORE.get());
				else if ("block_core_green".equals(path)) mapping.remap(ModBlocks.GREEN_CORE.get());
				else if ("block_core_lime".equals(path)) mapping.remap(ModBlocks.LIME_CORE.get());
				else if ("block_core_black_2".equals(path)) mapping.remap(ModBlocks.BLACK_CORE_2.get());
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistrationHandler {

		@SubscribeEvent
		static void createRegistries(RegistryEvent.NewRegistry e) {
			FLARDEffectRegistry.createRegistry();
			ModFlardEffects.REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus()); // Don't register flard effects before the registry is created.
		}
	}
}
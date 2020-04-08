package net.enderturret.randomitems.init;

import java.util.Arrays;

import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.Reference;
import net.enderturret.randomitems.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	@ObjectHolder("tesseract_block")
	public static final Block TESSERACT = null;
	@ObjectHolder("love_tesseract_block")
	public static final Block LOVE_TESSERACT = null;
	@ObjectHolder("stone_torch_block")
	public static final Block STONE_TORCH = null;
	@ObjectHolder("wolfenoot_cake_block")
	public static final Block WOLFENOOT_CAKE = null;
	@ObjectHolder("keycard_reader_block")
	public static final Block KEYCARD_READER = null;
	@ObjectHolder("dog_plushie_block")
	public static final Block DOG_PLUSH = null;

	@ObjectHolder("purple_core_block")
	public static final Block CORE_PURPLE = null;
	@ObjectHolder("red_core_block")
	public static final Block CORE_RED = null;
	@ObjectHolder("blue_core_block")
	public static final Block CORE_BLUE = null;
	@ObjectHolder("black_core_block")
	public static final Block CORE_BLACK = null;
	@ObjectHolder("yellow_core_block")
	public static final Block CORE_YELLOW = null;
	@ObjectHolder("white_core_block")
	public static final Block CORE_WHITE = null;
	@ObjectHolder("gray_core_block")
	public static final Block CORE_GRAY = null;
	@ObjectHolder("light_gray_core_block")
	public static final Block CORE_LIGHT_GRAY = null;
	@ObjectHolder("light_blue_core_block")
	public static final Block CORE_LIGHT_BLUE = null;
	@ObjectHolder("cyan_core_block")
	public static final Block CORE_CYAN = null;
	@ObjectHolder("orange_core_block")
	public static final Block CORE_ORANGE = null;
	@ObjectHolder("magenta_core_block")
	public static final Block CORE_MAGENTA = null;
	@ObjectHolder("pink_core_block")
	public static final Block CORE_PINK = null;
	@ObjectHolder("brown_core_block")
	public static final Block CORE_BROWN = null;
	@ObjectHolder("green_core_block")
	public static final Block CORE_GREEN = null;
	@ObjectHolder("lime_core_block")
	public static final Block CORE_LIME = null;
	@ObjectHolder("black_core_block_2")
	public static final Block CORE_BLACK_2 = null;

	@ObjectHolder("clear_core_block")
	public static final Block CORE_CLEAR = null;
	@ObjectHolder("sun_core_block")
	public static final Block CORE_SUN = null;
	@ObjectHolder("night_core_block")
	public static final Block CORE_NIGHT = null;
	@ObjectHolder("corrupted_core_block")
	public static final Block CORE_CORRUPT = null;
	@ObjectHolder("universe_core_block")
	public static final Block CORE_UNIVERSE = null;

	/*
	 * One registry to rule them all.
	 */
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				//configure(new Block(Material), "_block"),
				configure(new BlockTesseract(SoundType.METAL, Material.CIRCUITS, MobEffects.RESISTANCE), "tesseract_block"),
				configure(new BlockTesseract(SoundType.METAL, Material.CIRCUITS, MobEffects.REGENERATION), "love_tesseract_block"),
				configure(new BlockCustomTorch(SoundType.STONE), "stone_torch_block"),
				configure(new BlockWolfenootCake(), "wolfenoot_cake_block"),
				configure(new BlockKeycardReader(), "keycard_reader_block"),
				configure(new BlockPlushie(SoundType.CLOTH, Material.CLOTH), "dog_plushie_block"),
				configure(new BlockCore(EnumDyeColor.PURPLE), "purple_core_block"),
				configure(new BlockCore(EnumDyeColor.RED), "red_core_block"),
				configure(new BlockCore(EnumDyeColor.BLUE), "blue_core_block"),
				configure(new BlockCore(EnumDyeColor.BLACK), "black_core_block"),
				configure(new BlockCore(EnumDyeColor.YELLOW), "yellow_core_block"),
				configure(new BlockCore(EnumDyeColor.WHITE), "white_core_block"),
				configure(new BlockCore(EnumDyeColor.GRAY), "gray_core_block"),
				configure(new BlockCore(EnumDyeColor.LIGHT_BLUE), "light_blue_core_block"),
				configure(new BlockCore(EnumDyeColor.SILVER), "light_gray_core_block"),
				configure(new BlockCore(EnumDyeColor.CYAN), "cyan_core_block"),
				configure(new BlockCore(EnumDyeColor.ORANGE), "orange_core_block"),
				configure(new BlockCore(EnumDyeColor.MAGENTA), "magenta_core_block"),
				configure(new BlockCore(EnumDyeColor.PINK), "pink_core_block"),
				configure(new BlockCore(EnumDyeColor.BROWN), "brown_core_block"),
				configure(new BlockCore(EnumDyeColor.GREEN), "green_core_block"),
				configure(new BlockCore(EnumDyeColor.LIME), "lime_core_block"),
				configure(new BlockCore(EnumDyeColor.BLACK), "black_core_block_2"),
				configure(new BlockSpecialCore(), "clear_core_block"),
				configure(new BlockSpecialCore(), "sun_core_block"),
				configure(new BlockSpecialCore(), "night_core_block"),
				configure(new BlockSpecialCore(), "corrupted_core_block"),
				configure(new BlockSpecialCore(), "universe_core_block")
				);
	}

	/*
	 * One registry to find them.
	 */
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				items(TESSERACT, LOVE_TESSERACT, STONE_TORCH, WOLFENOOT_CAKE, KEYCARD_READER,
				CORE_PURPLE, CORE_RED, CORE_BLUE, CORE_BLACK, CORE_YELLOW,
				CORE_WHITE, CORE_GRAY, CORE_LIGHT_BLUE, CORE_LIGHT_GRAY, CORE_CYAN,
				CORE_ORANGE, CORE_MAGENTA, CORE_PINK, CORE_BROWN, CORE_GREEN,
				CORE_LIME, CORE_BLACK_2, CORE_CLEAR, CORE_SUN, CORE_NIGHT,
				CORE_CORRUPT, CORE_UNIVERSE, DOG_PLUSH));
	}

	/*
	 * One registry to bring them all and in the event register them.
	 */
	public static void registerModels() {
		registerModels(TESSERACT, LOVE_TESSERACT, STONE_TORCH, WOLFENOOT_CAKE, KEYCARD_READER,
				CORE_PURPLE, CORE_RED, CORE_BLUE, CORE_BLACK, CORE_YELLOW,
				CORE_WHITE, CORE_GRAY, CORE_LIGHT_BLUE, CORE_LIGHT_GRAY, CORE_CYAN,
				CORE_ORANGE, CORE_MAGENTA, CORE_PINK, CORE_BROWN, CORE_GREEN,
				CORE_LIME, CORE_BLACK_2, CORE_CLEAR, CORE_SUN, CORE_NIGHT,
				CORE_CORRUPT, CORE_UNIVERSE, DOG_PLUSH);
		/*TESSERACT.registerItemModel();
		LOVE_TESSERACT.registerItemModel();
		STONE_TORCH.registerItemModel();
		WOLFENOOT_CAKE.registerItemModel();
		KEYCARD_READER.registerItemModel();
		CORE_PURPLE.registerItemModel();
		CORE_RED.registerItemModel();
		CORE_BLUE.registerItemModel();
		CORE_BLACK.registerItemModel();
		CORE_YELLOW.registerItemModel();
		CORE_WHITE.registerItemModel();
		CORE_GRAY.registerItemModel();
		CORE_LIGHT_BLUE.registerItemModel();
		CORE_LIGHT_GRAY.registerItemModel();
		CORE_CYAN.registerItemModel();
		CORE_ORANGE.registerItemModel();
		CORE_MAGENTA.registerItemModel();
		CORE_PINK.registerItemModel();
		CORE_BROWN.registerItemModel();
		CORE_GREEN.registerItemModel();
		CORE_LIME.registerItemModel();
		CORE_BLACK_2.registerItemModel();
		CORE_CLEAR.registerItemModel();
		CORE_SUN.registerItemModel();
		CORE_NIGHT.registerItemModel();
		CORE_CORRUPT.registerItemModel();
		CORE_UNIVERSE.registerItemModel();
		DOG_PLUSH.registerItemModel();*/
	}

	public static void registerModels(Block... blocks) {
		for (Block b : blocks) {
			final Item item = Item.getItemFromBlock(b);
			RandomItems.proxy.registerItemRenderer(item, 0, item.getRegistryName().getPath());
		}
	}

	public static ItemBlock item(Block block) {
		final ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		return item;
	}

	public static ItemBlock[] items(Block... blocks) {
		return Arrays.stream(blocks).map(block -> item(block)).toArray(ItemBlock[]::new);
	}

	// setSoundType() and blockSoundType are protected, meaning we can't set them here.
	public static <T extends Block> T configure(T block, String registryName) {
		block.setRegistryName(Reference.MOD_ID, registryName).setTranslationKey(registryName).setCreativeTab(RandomItems.TAB);
		return block;
	}

	public static void initOreDict() {
		OreDictionary.registerOre("core", CORE_PURPLE);
		OreDictionary.registerOre("core", CORE_RED);
		OreDictionary.registerOre("core", CORE_BLUE);
		OreDictionary.registerOre("core", CORE_BLACK);
		OreDictionary.registerOre("core", CORE_YELLOW);
		OreDictionary.registerOre("core", CORE_WHITE);
		OreDictionary.registerOre("core", CORE_GRAY);
		OreDictionary.registerOre("core", CORE_LIGHT_BLUE);
		OreDictionary.registerOre("core", CORE_LIGHT_GRAY);
		OreDictionary.registerOre("core", CORE_CYAN);
		OreDictionary.registerOre("core", CORE_ORANGE);
		OreDictionary.registerOre("core", CORE_MAGENTA);
		OreDictionary.registerOre("core", CORE_PINK);
		OreDictionary.registerOre("core", CORE_BROWN);
		OreDictionary.registerOre("core", CORE_GREEN);
		OreDictionary.registerOre("core", CORE_LIME);
		OreDictionary.registerOre("core", CORE_BLACK_2);
		OreDictionary.registerOre("coreSpecial", CORE_CLEAR);
		OreDictionary.registerOre("coreSpecial", CORE_SUN);
		OreDictionary.registerOre("coreSpecial", CORE_NIGHT);
		OreDictionary.registerOre("coreSpecial", CORE_CORRUPT);
		OreDictionary.registerOre("coreSpecial", CORE_UNIVERSE);
	}
}
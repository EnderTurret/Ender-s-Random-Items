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
	public static final Block DOG_PLUSHIE = null;

	@ObjectHolder("purple_core_block")
	public static final Block PURPLE_CORE = null;
	@ObjectHolder("red_core_block")
	public static final Block RED_CORE = null;
	@ObjectHolder("blue_core_block")
	public static final Block BLUE_CORE = null;
	@ObjectHolder("black_core_block")
	public static final Block BLACK_CORE = null;
	@ObjectHolder("yellow_core_block")
	public static final Block YELLOW_CORE = null;
	@ObjectHolder("white_core_block")
	public static final Block WHITE_CORE = null;
	@ObjectHolder("gray_core_block")
	public static final Block GRAY_CORE = null;
	@ObjectHolder("light_gray_core_block")
	public static final Block LIGHT_GRAY_CORE = null;
	@ObjectHolder("light_blue_core_block")
	public static final Block LIGHT_BLUE_CORE = null;
	@ObjectHolder("cyan_core_block")
	public static final Block CYAN_CORE = null;
	@ObjectHolder("orange_core_block")
	public static final Block ORANGE_CORE = null;
	@ObjectHolder("magenta_core_block")
	public static final Block MAGENTA_CORE = null;
	@ObjectHolder("pink_core_block")
	public static final Block PINK_CORE = null;
	@ObjectHolder("brown_core_block")
	public static final Block BROWN_CORE = null;
	@ObjectHolder("green_core_block")
	public static final Block GREEN_CORE = null;
	@ObjectHolder("lime_core_block")
	public static final Block LIME_CORE = null;
	@ObjectHolder("black_core_block_2")
	public static final Block BLACK_2_CORE = null;

	@ObjectHolder("clear_core_block")
	public static final Block CLEAR_CORE = null;
	@ObjectHolder("sun_core_block")
	public static final Block SUN_CORE = null;
	@ObjectHolder("night_core_block")
	public static final Block NIGHT_CORE = null;
	@ObjectHolder("corrupted_core_block")
	public static final Block CORRUPT_CORE = null;
	@ObjectHolder("universe_core_block")
	public static final Block UNIVERSE_CORE = null;

	/*
	 * One registry to rule them all.
	 */
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				//configure(new Block(Material), "_block"),
				configure(new TesseractBlock(SoundType.METAL, Material.CIRCUITS, MobEffects.RESISTANCE), "tesseract_block"),
				configure(new TesseractBlock(SoundType.METAL, Material.CIRCUITS, MobEffects.REGENERATION), "love_tesseract_block"),
				configure(new StoneTorchBlock(SoundType.STONE), "stone_torch_block"),
				configure(new WolfenootCakeBlock(), "wolfenoot_cake_block"),
				configure(new KeycardReaderBlock(), "keycard_reader_block"),
				configure(new PlushieBlock(SoundType.CLOTH, Material.CLOTH), "dog_plushie_block"),
				configure(new CoreBlock(EnumDyeColor.PURPLE), "purple_core_block"),
				configure(new CoreBlock(EnumDyeColor.RED), "red_core_block"),
				configure(new CoreBlock(EnumDyeColor.BLUE), "blue_core_block"),
				configure(new CoreBlock(EnumDyeColor.BLACK), "black_core_block"),
				configure(new CoreBlock(EnumDyeColor.YELLOW), "yellow_core_block"),
				configure(new CoreBlock(EnumDyeColor.WHITE), "white_core_block"),
				configure(new CoreBlock(EnumDyeColor.GRAY), "gray_core_block"),
				configure(new CoreBlock(EnumDyeColor.LIGHT_BLUE), "light_blue_core_block"),
				configure(new CoreBlock(EnumDyeColor.SILVER), "light_gray_core_block"),
				configure(new CoreBlock(EnumDyeColor.CYAN), "cyan_core_block"),
				configure(new CoreBlock(EnumDyeColor.ORANGE), "orange_core_block"),
				configure(new CoreBlock(EnumDyeColor.MAGENTA), "magenta_core_block"),
				configure(new CoreBlock(EnumDyeColor.PINK), "pink_core_block"),
				configure(new CoreBlock(EnumDyeColor.BROWN), "brown_core_block"),
				configure(new CoreBlock(EnumDyeColor.GREEN), "green_core_block"),
				configure(new CoreBlock(EnumDyeColor.LIME), "lime_core_block"),
				configure(new CoreBlock(EnumDyeColor.BLACK), "black_core_block_2"),
				configure(new SpecialCoreBlock(), "clear_core_block"),
				configure(new SpecialCoreBlock(), "sun_core_block"),
				configure(new SpecialCoreBlock(), "night_core_block"),
				configure(new SpecialCoreBlock(), "corrupted_core_block"),
				configure(new SpecialCoreBlock(), "universe_core_block")
				);
	}

	/*
	 * One registry to find them.
	 */
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				items(TESSERACT, LOVE_TESSERACT, STONE_TORCH, WOLFENOOT_CAKE, KEYCARD_READER,
						PURPLE_CORE, RED_CORE, BLUE_CORE, BLACK_CORE, YELLOW_CORE,
						WHITE_CORE, GRAY_CORE, LIGHT_BLUE_CORE, LIGHT_GRAY_CORE, CYAN_CORE,
						ORANGE_CORE, MAGENTA_CORE, PINK_CORE, BROWN_CORE, GREEN_CORE,
						LIME_CORE, BLACK_2_CORE, CLEAR_CORE, SUN_CORE, NIGHT_CORE,
						CORRUPT_CORE, UNIVERSE_CORE, DOG_PLUSHIE));
	}

	/*
	 * One registry to bring them all and in the event register them.
	 */
	public static void registerModels() {
		registerModels(TESSERACT, LOVE_TESSERACT, STONE_TORCH, WOLFENOOT_CAKE, KEYCARD_READER,
				PURPLE_CORE, RED_CORE, BLUE_CORE, BLACK_CORE, YELLOW_CORE,
				WHITE_CORE, GRAY_CORE, LIGHT_BLUE_CORE, LIGHT_GRAY_CORE, CYAN_CORE,
				ORANGE_CORE, MAGENTA_CORE, PINK_CORE, BROWN_CORE, GREEN_CORE,
				LIME_CORE, BLACK_2_CORE, CLEAR_CORE, SUN_CORE, NIGHT_CORE,
				CORRUPT_CORE, UNIVERSE_CORE, DOG_PLUSHIE);
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
		return Arrays.stream(blocks).map(ModBlocks::item).toArray(ItemBlock[]::new);
	}

	// setSoundType() and blockSoundType are protected, meaning we can't set them here.
	public static <T extends Block> T configure(T block, String registryName) {
		block.setRegistryName(Reference.MOD_ID, registryName).setTranslationKey(registryName).setCreativeTab(RandomItems.TAB);
		return block;
	}

	public static void initOreDict() {
		OreDictionary.registerOre("core", PURPLE_CORE);
		OreDictionary.registerOre("core", RED_CORE);
		OreDictionary.registerOre("core", BLUE_CORE);
		OreDictionary.registerOre("core", BLACK_CORE);
		OreDictionary.registerOre("core", YELLOW_CORE);
		OreDictionary.registerOre("core", WHITE_CORE);
		OreDictionary.registerOre("core", GRAY_CORE);
		OreDictionary.registerOre("core", LIGHT_BLUE_CORE);
		OreDictionary.registerOre("core", LIGHT_GRAY_CORE);
		OreDictionary.registerOre("core", CYAN_CORE);
		OreDictionary.registerOre("core", ORANGE_CORE);
		OreDictionary.registerOre("core", MAGENTA_CORE);
		OreDictionary.registerOre("core", PINK_CORE);
		OreDictionary.registerOre("core", BROWN_CORE);
		OreDictionary.registerOre("core", GREEN_CORE);
		OreDictionary.registerOre("core", LIME_CORE);
		OreDictionary.registerOre("core", BLACK_2_CORE);
		OreDictionary.registerOre("coreSpecial", CLEAR_CORE);
		OreDictionary.registerOre("coreSpecial", SUN_CORE);
		OreDictionary.registerOre("coreSpecial", NIGHT_CORE);
		OreDictionary.registerOre("coreSpecial", CORRUPT_CORE);
		OreDictionary.registerOre("coreSpecial", UNIVERSE_CORE);
	}
}

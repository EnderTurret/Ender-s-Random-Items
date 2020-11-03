package net.enderturret.randomitems.init;

import net.enderturret.randomitems.Reference;
import net.enderturret.randomitems.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import static net.minecraft.block.Block.Properties.create;

public final class ModBlocks {

	private ModBlocks() {}

	// One registry to rule them all.
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);

	// One registry to find them.
	public static final RegistryObject<Block> TESSERACT = REGISTRY.register("tesseract_block", () -> new TesseractBlock(create(Material.IRON).harvestTool(ToolType.PICKAXE).lightValue(15).hardnessAndResistance(50F, 2000F).sound(SoundType.METAL).notSolid(), Effects.RESISTANCE));
	public static final RegistryObject<Block> LOVE_TESSERACT = REGISTRY.register("love_tesseract_block", () -> new TesseractBlock(create(Material.IRON).harvestTool(ToolType.PICKAXE).lightValue(15).hardnessAndResistance(50F, 2000F).sound(SoundType.METAL).notSolid(), Effects.REGENERATION));
	public static final RegistryObject<Block> STONE_TORCH = REGISTRY.register("stone_torch_block", () -> new StoneTorchBlock(create(Material.MISCELLANEOUS).sound(SoundType.STONE).lightValue(14).hardnessAndResistance(0.0F).doesNotBlockMovement()));
	public static final RegistryObject<Block> STONE_TORCH_WALL = REGISTRY.register("stone_torch_wall_block", () -> new StoneWallTorchBlock(create(Material.MISCELLANEOUS).sound(SoundType.STONE).lightValue(14).hardnessAndResistance(0.0F).doesNotBlockMovement().lootFrom(STONE_TORCH.get())));
	public static final RegistryObject<Block> WOLFENOOT_CAKE = REGISTRY.register("wolfenoot_cake_block", () -> new WolfenootCakeBlock());
	public static final RegistryObject<Block> KEYCARD_READER = REGISTRY.register("keycard_reader_block", () -> new KeycardReaderBlock());
	public static final RegistryObject<Block> DOG_PLUSHIE = REGISTRY.register("dog_plushie_block", () -> new PlushieBlock(create(Material.WOOL).sound(SoundType.CLOTH).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> PURPLE_CORE = REGISTRY.register("purple_core_block", () -> new CoreBlock(DyeColor.PURPLE));
	public static final RegistryObject<Block> RED_CORE = REGISTRY.register("red_core_block", () -> new CoreBlock(DyeColor.RED));
	public static final RegistryObject<Block> BLUE_CORE = REGISTRY.register("blue_core_block", () -> new CoreBlock(DyeColor.BLUE));
	public static final RegistryObject<Block> BLACK_CORE = REGISTRY.register("black_core_block", () -> new CoreBlock(DyeColor.BLACK));
	public static final RegistryObject<Block> YELLOW_CORE = REGISTRY.register("yellow_core_block", () -> new CoreBlock(DyeColor.YELLOW));
	public static final RegistryObject<Block> WHITE_CORE = REGISTRY.register("white_core_block", () -> new CoreBlock(DyeColor.WHITE));
	public static final RegistryObject<Block> GRAY_CORE = REGISTRY.register("gray_core_block", () -> new CoreBlock(DyeColor.GRAY));
	public static final RegistryObject<Block> LIGHT_GRAY_CORE = REGISTRY.register("light_gray_core_block", () -> new CoreBlock(DyeColor.LIGHT_GRAY));
	public static final RegistryObject<Block> LIGHT_BLUE_CORE = REGISTRY.register("light_blue_core_block", () -> new CoreBlock(DyeColor.LIGHT_BLUE));
	public static final RegistryObject<Block> CYAN_CORE = REGISTRY.register("cyan_core_block", () -> new CoreBlock(DyeColor.CYAN));
	public static final RegistryObject<Block> ORANGE_CORE = REGISTRY.register("orange_core_block", () -> new CoreBlock(DyeColor.ORANGE));
	public static final RegistryObject<Block> MAGENTA_CORE = REGISTRY.register("magenta_core_block", () -> new CoreBlock(DyeColor.MAGENTA));
	public static final RegistryObject<Block> PINK_CORE = REGISTRY.register("pink_core_block", () -> new CoreBlock(DyeColor.PINK));
	public static final RegistryObject<Block> BROWN_CORE = REGISTRY.register("brown_core_block", () -> new CoreBlock(DyeColor.BROWN));
	public static final RegistryObject<Block> GREEN_CORE = REGISTRY.register("green_core_block", () -> new CoreBlock(DyeColor.GREEN));
	public static final RegistryObject<Block> LIME_CORE = REGISTRY.register("lime_core_block", () -> new CoreBlock(DyeColor.LIME));
	public static final RegistryObject<Block> BLACK_CORE_2 = REGISTRY.register("black_core_block_2", () -> new CoreBlock(DyeColor.BLACK));

	public static final RegistryObject<Block> CLEAR_CORE = REGISTRY.register("clear_core_block", () -> new SpecialCoreBlock());
	public static final RegistryObject<Block> SUN_CORE = REGISTRY.register("sun_core_block", () -> new SpecialCoreBlock());
	public static final RegistryObject<Block> NIGHT_CORE = REGISTRY.register("night_core_block", () -> new SpecialCoreBlock());
	public static final RegistryObject<Block> CORRUPT_CORE = REGISTRY.register("corrupted_core_block", () -> new SpecialCoreBlock());
	public static final RegistryObject<Block> UNIVERSE_CORE = REGISTRY.register("universe_core_block", () -> new SpecialCoreBlock());

	// One registry to bring them all and in the event register them.
	public static void registerItemBlocks() {
		createItemBlock(TESSERACT, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(LOVE_TESSERACT, ModItems.props().rarity(Rarity.RARE));
		createWallOrFloorItemBlock(STONE_TORCH_WALL, STONE_TORCH);
		createItemBlock(WOLFENOOT_CAKE);
		createItemBlock(KEYCARD_READER);
		createItemBlock(PURPLE_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(RED_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(BLUE_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(BLACK_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(YELLOW_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(WHITE_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(GRAY_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(LIGHT_BLUE_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(LIGHT_GRAY_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(CYAN_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(ORANGE_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(MAGENTA_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(PINK_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(BROWN_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(GREEN_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(LIME_CORE, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(BLACK_CORE_2, ModItems.props().rarity(Rarity.RARE));
		createItemBlock(CLEAR_CORE);
		createItemBlock(SUN_CORE);
		createItemBlock(NIGHT_CORE);
		createItemBlock(CORRUPT_CORE);
		createItemBlock(UNIVERSE_CORE);
		createItemBlock(DOG_PLUSHIE);
	}

	static void createItemBlock(RegistryObject<Block> block, Item.Properties props) {
		ModItems.REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), props));
	}

	static void createItemBlock(RegistryObject<Block> block) {
		createItemBlock(block, ModItems.props());
	}

	static void createWallOrFloorItemBlock(RegistryObject<Block> wall, RegistryObject<Block> floor) {
		ModItems.REGISTRY.register(floor.getId().getPath(), () -> new WallOrFloorItem(floor.get(), wall.get(), ModItems.props()));
	}
}
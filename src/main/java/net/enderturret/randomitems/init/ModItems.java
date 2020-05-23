package net.enderturret.randomitems.init;

import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.Reference;
import net.enderturret.randomitems.item.*;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModItems {

	private ModItems() {}

	public static final DeferredRegister<Item> REGISTRY = new DeferredRegister<>(ForgeRegistries.ITEMS, Reference.MOD_ID);

	public static final RegistryObject<Item> MOIST_TOWELETTE = REGISTRY.register("moist_towelette", () -> new Item(create()));
	public static final RegistryObject<Item> SANITIZING_WATER = REGISTRY.register("sanitizing_water", () -> new Item(create()));
	public static final RegistryObject<Item> PUFFBALL_TAIL = REGISTRY.register("puffball_tail", () -> new Item(create()));
	public static final RegistryObject<Item> PUFFBALL_FUR = REGISTRY.register("puffball_fur", () -> new Item(create()));
	public static final RegistryObject<Item> STONE_STICK = REGISTRY.register("stone_stick", () -> new Item(create()));
	// Aren't you glad there isn't a stone stone chisel?
	public static final RegistryObject<Item> STONE_CHISEL_IRON = REGISTRY.register("iron_stone_chisel", () -> new StoneChiselItem(create().maxStackSize(1).maxDamage(31), 4));
	public static final RegistryObject<Item> STONE_CHISEL_DIAMOND = REGISTRY.register("diamond_stone_chisel", () -> new StoneChiselItem(create().maxStackSize(1).maxDamage(63), 8));
	public static final RegistryObject<Item> QUESTIONABLE_CHEESE = REGISTRY.register("questionable_cheese", () -> new QuestionableCheeseItem());
	public static final RegistryObject<Item> FLARD = REGISTRY.register("flard", () -> new FLARDItem());
	public static final RegistryObject<Item> KEYCARD = REGISTRY.register("keycard", () -> new KeycardItem(create().maxStackSize(1)));

	public static final RegistryObject<Item> SECRET_COKE = REGISTRY.register("secret_coke", () -> new FoodItem(new Item.Properties(), 1, 1f, false, true));

	public static final RegistryObject<Item> PUFFBALL = REGISTRY.register("puffball", () -> new Item(create()));
	public static final RegistryObject<Item> WHITE_PUFFBALL = REGISTRY.register("white_puffball", () -> new PuffballItem(create(), Effects.SPEED));
	public static final RegistryObject<Item> LIGHT_GRAY_PUFFBALL = REGISTRY.register("light_gray_puffball", () -> new PuffballItem(create(), Effects.INVISIBILITY));
	public static final RegistryObject<Item> GRAY_PUFFBALL = REGISTRY.register("gray_puffball", () -> new PuffballItem(create(), Effects.RESISTANCE));
	public static final RegistryObject<Item> BLACK_PUFFBALL = REGISTRY.register("black_puffball", () -> new PuffballItem(create(), Effects.LEVITATION));
	public static final RegistryObject<Item> BROWN_PUFFBALL = REGISTRY.register("brown_puffball", () -> new PuffballItem(create(), Effects.SATURATION));
	public static final RegistryObject<Item> RED_PUFFBALL = REGISTRY.register("red_puffball", () -> new PuffballItem(create(), Effects.REGENERATION));
	public static final RegistryObject<Item> ORANGE_PUFFBALL = REGISTRY.register("orange_puffball", () -> new PuffballItem(create(), Effects.FIRE_RESISTANCE));
	public static final RegistryObject<Item> YELLOW_PUFFBALL = REGISTRY.register("yellow_puffball", () -> new PuffballItem(create(), Effects.ABSORPTION));
	public static final RegistryObject<Item> LIME_PUFFBALL = REGISTRY.register("lime_puffball", () -> new PuffballItem(create(), Effects.LUCK));
	public static final RegistryObject<Item> GREEN_PUFFBALL = REGISTRY.register("green_puffball", () -> new PuffballItem(create(), Effects.JUMP_BOOST));
	public static final RegistryObject<Item> CYAN_PUFFBALL = REGISTRY.register("cyan_puffball", () -> new PuffballItem(create(), Effects.HASTE));
	public static final RegistryObject<Item> LIGHT_BLUE_PUFFBALL = REGISTRY.register("light_blue_puffball", () -> new PuffballItem(create(), Effects.WATER_BREATHING));
	public static final RegistryObject<Item> BLUE_PUFFBALL = REGISTRY.register("blue_puffball", () -> new PuffballItem(create(), Effects.NIGHT_VISION));
	public static final RegistryObject<Item> PURPLE_PUFFBALL = REGISTRY.register("purple_puffball", () -> new PuffballItem(create(), Effects.HEALTH_BOOST));
	public static final RegistryObject<Item> MAGENTA_PUFFBALL = REGISTRY.register("magenta_puffball", () -> new PuffballItem(create(), Effects.GLOWING));
	public static final RegistryObject<Item> PINK_PUFFBALL = REGISTRY.register("pink_puffball", () -> new PuffballItem(create(), Effects.STRENGTH));

	static Item.Properties create() {
		return new Item.Properties().group(RandomItems.TAB);
	}
}
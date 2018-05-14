package net.enderturret.randomitems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.enderturret.randomitems.init.ModBlocks;
import net.enderturret.randomitems.init.ModItems;
import net.enderturret.randomitems.proxy.CommonProxy;
import net.enderturret.randomitems.util.FLARDEffectRegistry;
import net.enderturret.randomitems.util.flardeffects.EffectChestLoot;
import net.enderturret.randomitems.util.flardeffects.EffectEnchantment;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "randomitems", name = "Ender's Random Items", version = "0.1.2")
public class RandomItems {

	public static final RandomItemsTab creativeTab = new RandomItemsTab();
	public static final Logger log = LogManager.getLogger("randomitems");

	@Mod.Instance("randomitems")
	public static RandomItems instance;

	@SidedProxy(serverSide = "net.enderturret.randomitems.proxy.CommonProxy", clientSide = "net.enderturret.randomitems.proxy.ClientProxy")
	public static CommonProxy proxy;

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		// Register the things
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ModBlocks.registerItemBlocks(event.getRegistry());
			ModItems.register(event.getRegistry());
			FLARDEffectRegistry.registerAll(new EffectChestLoot(), new EffectEnchantment());
		}
		// Register some more
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			ModBlocks.register(event.getRegistry());
		}
		// Register just a bit more
		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			ModBlocks.registerModels();
			ModItems.registerModels();
		}
		// Add FLARD to the dungeon loot table pool thing
		@SubscribeEvent
		public static void onLootLoad(LootTableLoadEvent e) {
			if (e.getName().toString().equals("minecraft:chests/simple_dungeon")) {
				LootEntry flard = new LootEntryItem(ModItems.flard, 6, 80, new LootFunction[0], new LootCondition[0], "randomitems:flard");
				LootPool poolDungeon = new LootPool(new LootEntry[]{flard}, new LootCondition[0], new RandomValueRange(0,2), new RandomValueRange(0), "randomitems:dungeon_pool");
				e.getTable().addPool(poolDungeon);
			}
		}
	}
}
package net.enderturret.randomitems.item;

import java.util.Random;

import org.apache.logging.log4j.Level;

import net.enderturret.randomitems.ConfigurationHandler;
import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.init.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemFLARD extends ItemBase {
	private int customGeneratedEffect;
	private final Random rand = new Random();
	/** Array of every enchantment available. Use it for those times you want an array of enchants */
	public static final Enchantment[] enchants = {Enchantments.AQUA_AFFINITY, Enchantments.BANE_OF_ARTHROPODS, Enchantments.BINDING_CURSE,
			Enchantments.BLAST_PROTECTION, Enchantments.DEPTH_STRIDER, Enchantments.EFFICIENCY, Enchantments.FEATHER_FALLING, Enchantments.FIRE_ASPECT,
			Enchantments.FIRE_PROTECTION, Enchantments.FLAME, Enchantments.FORTUNE, Enchantments.FROST_WALKER, Enchantments.INFINITY, Enchantments.KNOCKBACK,
			Enchantments.LOOTING, Enchantments.LUCK_OF_THE_SEA, Enchantments.LURE, Enchantments.MENDING, Enchantments.POWER, Enchantments.PROJECTILE_PROTECTION,
			Enchantments.PROTECTION, Enchantments.PUNCH, Enchantments.RESPIRATION, Enchantments.SHARPNESS, Enchantments.SILK_TOUCH, Enchantments.SMITE, Enchantments.SWEEPING,
			Enchantments.THORNS, Enchantments.UNBREAKING, Enchantments.VANISHING_CURSE};
	/** Array of chest loot tables. Use for whatever */
	public static final ResourceLocation[] chests = {new ResourceLocation("minecraft", "chests/simple_dungeon"),
			new ResourceLocation("minecraft", "chests/abandoned_mineshaft"), new ResourceLocation("minecraft", "chests/desert_pyramid"),
			new ResourceLocation("minecraft", "chests/end_city_treasure"), new ResourceLocation("minecraft", "chests/stronghold_corridor"),
			new ResourceLocation("minecraft", "chests/jungle_temple"), new ResourceLocation("minecraft", "chests/woodland_mansion")};
	public ItemFLARD() {
		super("flard");
		setMaxStackSize(1);
	}
	@Override
	public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
			return true;
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!worldIn.isRemote)
			if (entityIn instanceof EntityPlayer) {
				EntityPlayer playerIn = (EntityPlayer)entityIn;
				if (playerIn.getHeldItemMainhand() != null)
					if (playerIn.getHeldItemMainhand().getItem() == ModItems.flard)
						if (ConfigurationHandler.flardEnabled == true)
							executeFlardEffect(stack, worldIn, playerIn, playerIn.getPosition());
		}
	}
	/** Method called whenever a random effect is needed */
	protected void executeFlardEffect(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos) {
		customGeneratedEffect = rand.nextInt(12);
		playerIn.inventory.deleteStack(playerIn.getHeldItemMainhand());
		if (customGeneratedEffect == 0 && ConfigurationHandler.flardEffects.flardPoisonEffect == true) {
			log(" was poisoned.", playerIn);
			playerIn.addPotionEffect(new PotionEffect(MobEffects.POISON, 500, 2));
		}
		else if (customGeneratedEffect == 1 && ConfigurationHandler.flardEffects.flardOffhandEnchantEffect == true) {
			if (playerIn.getHeldItemOffhand() != ItemStack.EMPTY) {
				log(" got their offhand item enchanted", playerIn);
				playerIn.getHeldItemOffhand().addEnchantment(enchants[rand.nextInt(enchants.length)], rand.nextInt(5));
			}
			else
				log(" could have had their offhand item enchanted, but they weren't holding anything (Offhand was empty)", playerIn);
		}
		else if (customGeneratedEffect == 2 && ConfigurationHandler.flardEffects.flardInventoryDropEffect == true) {
			log(" had their inventory dropped", playerIn);
			playerIn.inventory.dropAllItems();
		}
		else if (customGeneratedEffect == 3 && ConfigurationHandler.flardEffects.flardLightningEffect == true) {
			log(" got struck by lightning", playerIn);
			worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), false));
		}
		else if (customGeneratedEffect == 4 && ConfigurationHandler.flardEffects.flardDiamondEffect == true) {
			log(" got a diamond added to their inventory", playerIn);
			playerIn.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, 1));
		}
		else if (customGeneratedEffect == 5 && ConfigurationHandler.flardEffects.flardHoleEffect == true) {
			log(" fell into a hole", playerIn);
			if (worldIn.getBlockState(playerIn.getPosition().down()) != Blocks.AIR.getDefaultState())
				worldIn.setBlockToAir(playerIn.getPosition().down());
		}
		else if (customGeneratedEffect == 6 && ConfigurationHandler.flardEffects.flardExplosionEffect == true) {
			log(" exploded", playerIn);
			worldIn.createExplosion(null, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), 6.0F, true);
		}
		else if (customGeneratedEffect == 7 && ConfigurationHandler.flardEffects.flardXPEffect == true) {
			log(" got a few levels", playerIn);
			playerIn.addExperienceLevel(rand.nextInt(4));
		}
		else if (customGeneratedEffect == 8 && ConfigurationHandler.flardEffects.flardChestLootEffect == true) {
			if (worldIn.getTileEntity(pos.down()) != null) {
				TileEntity tileEntity = worldIn.getTileEntity(playerIn.getPosition().down());
				if (tileEntity instanceof TileEntityChest) {
					log(" stood on a chest and got loot added", playerIn);
					TileEntityChest chest = (TileEntityChest)tileEntity;
					if (chest.isEmpty()) {
						chest.setLootTable(chests[rand.nextInt(chests.length)], rand.nextLong());
						chest.fillWithLoot(null);
					}
					else
						log(" would have had a chest of loot, but there were items in it (Chest had items in it)", playerIn);
				}
				else
					log(" would have had a chest of loot, but none were found (TileEntity wasn't a chest)", playerIn);
			}
			else
				log(" would have had a chest of loot, but none were found (No TileEntityChest under their feet)", playerIn);
		}
		else if (customGeneratedEffect == 9 && ConfigurationHandler.flardEffects.flardFireEffect == true) {
			log(" was set on fire", playerIn);
			if (worldIn.isAirBlock(pos))
				worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState());
		}
		else if (customGeneratedEffect == 10 && ConfigurationHandler.flardEffects.flardPuddleEffect == true) {
			log(" had a puddle appear under them", playerIn);
			if (worldIn.isAirBlock(pos))
				worldIn.setBlockState(pos, Blocks.FLOWING_WATER.getStateFromMeta(7));
		}
		else if (customGeneratedEffect == 11 && ConfigurationHandler.flardEffects.flardCobwebEffect == true) {
			log(" got stuck in a cobweb", playerIn);
			if (worldIn.isAirBlock(pos))
				worldIn.setBlockState(pos, Blocks.WEB.getDefaultState());
		}
		else if (customGeneratedEffect == 12 && ConfigurationHandler.flardEffects.flardXPEffect == true) {
			log(" 12", playerIn);
		}
		else if (customGeneratedEffect == 13 && ConfigurationHandler.flardEffects.flardXPEffect == true) {
			log(" 13", playerIn);
		}
	}
	public void log(String message, EntityPlayer playerIn) {
		RandomItems.log.log(Level.INFO, "[FLARD] "+playerIn.getName()+message);
	}
}
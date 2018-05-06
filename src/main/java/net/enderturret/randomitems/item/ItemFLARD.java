package net.enderturret.randomitems.item;

import java.util.Random;

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
import net.minecraft.world.World;

public class ItemFLARD extends ItemBase {
	private int customGeneratedEffect;
	private final Random rand = new Random();
	/** Array of every enchantment available. Use it for those times you want an array of enchants */
	public final Enchantment[] enchants = {Enchantments.AQUA_AFFINITY, Enchantments.BANE_OF_ARTHROPODS, Enchantments.BINDING_CURSE,
			Enchantments.BLAST_PROTECTION, Enchantments.DEPTH_STRIDER, Enchantments.EFFICIENCY, Enchantments.FEATHER_FALLING, Enchantments.FIRE_ASPECT,
			Enchantments.FIRE_PROTECTION, Enchantments.FLAME, Enchantments.FORTUNE, Enchantments.FROST_WALKER, Enchantments.INFINITY, Enchantments.KNOCKBACK,
			Enchantments.LOOTING, Enchantments.LUCK_OF_THE_SEA, Enchantments.LURE, Enchantments.MENDING, Enchantments.POWER, Enchantments.PROJECTILE_PROTECTION,
			Enchantments.PROTECTION, Enchantments.PUNCH, Enchantments.RESPIRATION, Enchantments.SHARPNESS, Enchantments.SILK_TOUCH, Enchantments.SMITE, Enchantments.SWEEPING,
			Enchantments.THORNS, Enchantments.UNBREAKING, Enchantments.VANISHING_CURSE};
	/** Array of chest loot tables. Use for whatever */
	public final ResourceLocation[] chests = {new ResourceLocation("minecraft", "chests/simple_dungeon"),
			new ResourceLocation("minecraft", "chests/abandoned_mineshaft"), new ResourceLocation("minecraft", "chests/desert_pyramid"),
			new ResourceLocation("minecraft", "chests/end_city_treasure"), new ResourceLocation("minecraft", "chests/stronghold_corridor"),
			new ResourceLocation("minecraft", "chests/jungle_temple"), new ResourceLocation("minecraft", "chests/woodland_mansion")};
	public ItemFLARD() {
		super("flard");
		setMaxStackSize(1);
	}
	@Override
	public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
		//if (armorType == EntityEquipmentSlot.HEAD)
			return true;
		//else
			//return false;
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!worldIn.isRemote)
			if (entityIn instanceof EntityPlayer) {
				EntityPlayer playerIn = (EntityPlayer)entityIn;
				if (playerIn.getHeldItemMainhand() != null)
					if (playerIn.getHeldItemMainhand().getItem() == ModItems.flard)
						executeFlardEffect(stack, worldIn, playerIn);
		}
	}
	/** Method called whenever a random effect is needed */
	protected void executeFlardEffect(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		customGeneratedEffect = rand.nextInt(9);
		playerIn.inventory.deleteStack(playerIn.getHeldItemMainhand());
		if (customGeneratedEffect == 0) {
			System.out.println("Poison");
			playerIn.addPotionEffect(new PotionEffect(MobEffects.POISON, 500, 2));
		}
		else if (customGeneratedEffect == 1) {
			System.out.println("Enchant");
			if (playerIn.getHeldItemOffhand() != null)
				playerIn.getHeldItemOffhand().addEnchantment(enchants[rand.nextInt(enchants.length)], rand.nextInt(5));
		}
		else if (customGeneratedEffect == 2) {
			System.out.println("Drop Items");
			playerIn.inventory.dropAllItems();
		}
		else if (customGeneratedEffect == 3) {
			System.out.println("Lightning");
			worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), false));
		}
		else if (customGeneratedEffect == 4) {
			System.out.println("Diamond");
			playerIn.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, 1));
		}
		else if (customGeneratedEffect == 5) {
			System.out.println("Hole");
			if (worldIn.getBlockState(playerIn.getPosition().down()) != Blocks.AIR.getDefaultState())
				worldIn.setBlockToAir(playerIn.getPosition().down());
		}
		else if (customGeneratedEffect == 6) {
			System.out.println("Explosion");
			worldIn.createExplosion(null, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), 6.0F, true);
		}
		else if (customGeneratedEffect == 7) {
			System.out.println("XP");
			playerIn.addExperienceLevel(rand.nextInt(4));
		}
		else if (customGeneratedEffect == 8) {
			System.out.println("Chest loot table swap");
			if (worldIn.getTileEntity(playerIn.getPosition().down()) != null) {
				TileEntity tileEntity = worldIn.getTileEntity(playerIn.getPosition().down());
				if (tileEntity instanceof TileEntityChest) {
					TileEntityChest chest = (TileEntityChest)tileEntity;
					if (chest.isEmpty())
						chest.setLootTable(chests[rand.nextInt(chests.length)], rand.nextLong());
						chest.fillWithLoot(null);
				}
			}
		}
		else if (customGeneratedEffect == 9) {
			System.out.println("9");
		}
		else if (customGeneratedEffect == 10) {
			System.out.println("10");
		}
		else if (customGeneratedEffect == 11) {
			System.out.println("11");
		}
		else if (customGeneratedEffect == 12) {
			System.out.println("12");
		}
		else if (customGeneratedEffect == 13) {
			System.out.println("13");
		}
	}
}
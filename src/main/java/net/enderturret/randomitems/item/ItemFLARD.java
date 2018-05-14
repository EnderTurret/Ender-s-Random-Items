package net.enderturret.randomitems.item;

import java.util.Random;

import org.apache.logging.log4j.Level;

import net.enderturret.randomitems.ConfigurationHandler;
import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.init.ModItems;
import net.enderturret.randomitems.util.FLARDEffectRegistry;
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
	private int effectNum;
	private final Random rand = new Random();
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
		effectNum = rand.nextInt(10+FLARDEffectRegistry.effects.size());
		playerIn.inventory.deleteStack(playerIn.getHeldItemMainhand());
		if (effectNum == 0 && ConfigurationHandler.flardEffects.flardPoisonEffect == true) {
			log(" was poisoned.", playerIn);
			playerIn.addPotionEffect(new PotionEffect(MobEffects.POISON, 500, 2));
		}
		else if (effectNum == 1 && ConfigurationHandler.flardEffects.flardInventoryDropEffect == true) {
			log(" had their inventory dropped", playerIn);
			playerIn.inventory.dropAllItems();
		}
		else if (effectNum == 2 && ConfigurationHandler.flardEffects.flardLightningEffect == true) {
			log(" got struck by lightning", playerIn);
			worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), false));
		}
		else if (effectNum == 3 && ConfigurationHandler.flardEffects.flardDiamondEffect == true) {
			log(" got a diamond added to their inventory", playerIn);
			playerIn.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, 1));
		}
		else if (effectNum == 4 && ConfigurationHandler.flardEffects.flardHoleEffect == true) {
			log(" fell into a hole", playerIn);
			if (worldIn.getBlockState(playerIn.getPosition().down()) != Blocks.AIR.getDefaultState())
				worldIn.setBlockToAir(playerIn.getPosition().down());
		}
		else if (effectNum == 5 && ConfigurationHandler.flardEffects.flardExplosionEffect == true) {
			log(" exploded", playerIn);
			worldIn.createExplosion(null, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), 6.0F, true);
		}
		else if (effectNum == 6 && ConfigurationHandler.flardEffects.flardXPEffect == true) {
			log(" got a few levels", playerIn);
			playerIn.addExperienceLevel(rand.nextInt(4));
		}
		else if (effectNum == 7 && ConfigurationHandler.flardEffects.flardFireEffect == true) {
			log(" was set on fire", playerIn);
			if (worldIn.isAirBlock(pos))
				worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState());
		}
		else if (effectNum == 8 && ConfigurationHandler.flardEffects.flardPuddleEffect == true) {
			log(" had a puddle appear under them", playerIn);
			if (worldIn.isAirBlock(pos))
				worldIn.setBlockState(pos, Blocks.FLOWING_WATER.getStateFromMeta(7));
		}
		else if (effectNum == 9 && ConfigurationHandler.flardEffects.flardCobwebEffect == true) {
			log(" got stuck in a cobweb", playerIn);
			if (worldIn.isAirBlock(pos))
				worldIn.setBlockState(pos, Blocks.WEB.getDefaultState());
		}
		else
			if (effectNum >= 10 && FLARDEffectRegistry.effects.get(effectNum-10) != null)
				FLARDEffectRegistry.effects.get(effectNum-10).onFLARDEffectRun(stack, worldIn, playerIn, pos);
	}
	public void log(String message, EntityPlayer playerIn) {
		RandomItems.log.log(Level.INFO, "[FLARD] "+playerIn.getName()+message);
	}
}
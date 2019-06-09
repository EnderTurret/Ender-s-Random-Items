package net.enderturret.randomitems.item;

import net.enderturret.randomitems.ConfigHandler;
import net.enderturret.randomitems.RandomItems;
import net.enderturret.randomitems.util.FLARDEffectRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemFLARD extends ItemBase {

	private int effectNum;

	public ItemFLARD() {
		super("flard");
		setMaxStackSize(1);
	}

	@Override
	public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
		return true;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!worldIn.isRemote && ConfigHandler.flardEnabled)
			rollEffect(playerIn.getHeldItem(handIn), worldIn, playerIn, playerIn.getPosition());
		return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	/**
	 * Rolls a FLARD effect.
	 * @param stack The {@code ItemStack} containing this item.
	 * @param worldIn The player's world.
	 * @param playerIn The player right-clicking this item.
	 * @param pos The player's position.
	 */
	public void rollEffect(ItemStack stack, World worldIn, EntityPlayer playerIn, BlockPos pos) {
		effectNum = Item.itemRand.nextInt(10 + FLARDEffectRegistry.registry.size());

		if (effectNum == 0) {
			if (ConfigHandler.flardEffects.flardPoisonEffect) {
				log(" was poisoned.", playerIn);
				playerIn.addPotionEffect(new PotionEffect(MobEffects.POISON, 500, 2));
			} else
				rollEffect(stack, worldIn, playerIn, pos);
		}

		else if (effectNum == 1) {
			if (ConfigHandler.flardEffects.flardInventoryDropEffect) {
				log(" had their inventory dropped", playerIn);
				playerIn.inventory.dropAllItems();
			} else
				rollEffect(stack, worldIn, playerIn, pos);
		}

		else if (effectNum == 2) {
			if (ConfigHandler.flardEffects.flardLightningEffect) {
				log(" got struck by lightning", playerIn);
				worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, playerIn.getPosition().getX(),
						playerIn.getPosition().getY(), playerIn.getPosition().getZ(), false));
			} else
				rollEffect(stack, worldIn, playerIn, pos);
		}

		else if (effectNum == 3) {
			if (ConfigHandler.flardEffects.flardDiamondEffect) {
				log(" got a diamond added to their inventory", playerIn);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, 1));
			} else
				rollEffect(stack, worldIn, playerIn, pos);
		}

		else if (effectNum == 4) {
			if (ConfigHandler.flardEffects.flardHoleEffect) {
				log(" fell into a hole", playerIn);
				if (worldIn.getBlockState(playerIn.getPosition().down()) != Blocks.AIR.getDefaultState() || worldIn.getBlockState(playerIn.getPosition().down()) != Blocks.BEDROCK.getDefaultState())
					worldIn.setBlockToAir(playerIn.getPosition().down());
			} else
				rollEffect(stack, worldIn, playerIn, pos);
		}

		else if (effectNum == 5) {
			if (ConfigHandler.flardEffects.flardExplosionEffect) {
				log(" exploded", playerIn);
				worldIn.createExplosion(null, playerIn.getPosition().getX(), playerIn.getPosition().getY(),
						playerIn.getPosition().getZ(), 6.0F, true);
			} else
				rollEffect(stack, worldIn, playerIn, pos);
		}

		else if (effectNum == 6) {
			if (ConfigHandler.flardEffects.flardXPEffect) {
				log(" got a few levels", playerIn);
				playerIn.addExperienceLevel(Item.itemRand.nextInt(4));
			} else
				rollEffect(stack, worldIn, playerIn, pos);
		}

		else if (effectNum == 7) {
			if (ConfigHandler.flardEffects.flardFireEffect) {
				log(" was set on fire", playerIn);
				if (worldIn.isAirBlock(pos))
					worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState());
			} else
				rollEffect(stack, worldIn, playerIn, pos);
		}

		else if (effectNum == 8) {
			if (ConfigHandler.flardEffects.flardPuddleEffect) {
				log(" had a puddle appear under them", playerIn);
				if (worldIn.isAirBlock(pos))
					worldIn.setBlockState(pos, Blocks.FLOWING_WATER.getStateFromMeta(7));
			} else
				rollEffect(stack, worldIn, playerIn, pos);
		}

		else if (effectNum == 9) {
			if (ConfigHandler.flardEffects.flardCobwebEffect) {
				log(" got stuck in a cobweb", playerIn);
				if (worldIn.isAirBlock(pos))
					worldIn.setBlockState(pos, Blocks.WEB.getDefaultState());
			} else
				rollEffect(stack, worldIn, playerIn, pos);
		}

		else if (effectNum >= 10 && FLARDEffectRegistry.registry.get(effectNum - 10) != null)
			FLARDEffectRegistry.registry.get(effectNum - 10).onFLARDEffectRun(stack, worldIn, playerIn, pos);
		finishRoll(playerIn);
	}

	public void log(String message, EntityPlayer playerIn) {
		if (ConfigHandler.flardMessages)
			RandomItems.log.info("[FLARD] " + playerIn.getName() + message);
	}

	public void finishRoll(EntityPlayer playerIn) {
		playerIn.inventory.deleteStack(playerIn.getHeldItemMainhand());
	}
}
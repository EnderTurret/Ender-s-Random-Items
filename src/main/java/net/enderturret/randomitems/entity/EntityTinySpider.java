package net.enderturret.randomitems.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityTinySpider extends EntityCreature {
	//TODO: Actually make this work properly.
	public EntityTinySpider(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public boolean canBeCollidedWith() {
		return false;
	}
	@Override
	public boolean canBePushed() {
		return false;
	}
	@Override
	public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
		return false;
	}
	@Override
	public boolean canBeHitWithPotion() {
		return true;
	}
	@Override
	public boolean canPickUpLoot() {
		return false;
	}
	@Override
	public boolean canBeAttackedWithItem() {
		return true;
	}
	@Override
	public boolean canTrample(World world, Block block, BlockPos pos, float fallDistance) {
		return false;
	}
	@Override
	public boolean canBeLeashedTo(EntityPlayer player) {
		return false;
	}
	@Override
	protected boolean canBeRidden(Entity entityIn) {
		return false;
	}
	@Override
	protected boolean canDropLoot() {
		return false;
	}
	
}
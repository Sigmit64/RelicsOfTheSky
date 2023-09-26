package sigmit.relicsofthesky.item.relics;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.SpawnListEntry;


public class ItemMercuryLamp extends ItemBaseRefill{
	public ItemMercuryLamp() {
		super("mercury_lamp", 3000, 20);
	}
	
	private static double spawnChance=0.2;
	//private static int spawnRadius=2;
	
	

	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(!worldIn.isRemote) {
			ItemStack stack=playerIn.getHeldItem(handIn);
			setActiveStatus(stack, !isActive(stack));
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	public boolean isActive(ItemStack stack) {
		NBTTagCompound nbt=stack.getTagCompound();
		
		return nbt!=null && nbt.getBoolean("active");
	}
	
	public void setActiveStatus(ItemStack stack, boolean status) {
		NBTTagCompound nbt=stack.getTagCompound();
		if(nbt==null) {
			NBTTagCompound nbtnew=new NBTTagCompound();
			nbtnew.setBoolean("active", false);
			stack.setTagCompound(nbtnew);
			return;
		}
		nbt.setBoolean("active", status);
		stack.setTagCompound(nbt);
	}
	
	

	

	@Override
	public boolean hasEffect(ItemStack stack) {
		// TODO Auto-generated method stub
		if(stack==null) return false;
		return super.hasEffect(stack)  || isActive(stack);
	}
	
	

	

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		if(worldIn.isRemote || !(worldIn.getTotalWorldTime()%20==0)) return;
		if(isActive(stack)) {
			if(!canUse(stack, 50, (EntityPlayer) entityIn)) {
				setActiveStatus(stack, false);
				return;
			}else {
				Random random=worldIn.rand;
				if(random.nextDouble()<spawnChance) {
					try {
						trySpawn(worldIn, entityIn.getPosition(), random);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public int randNeg(Random rand) {
		return rand.nextInt(2)*2-1;
	}
	
	public void trySpawn(World world, BlockPos pos, Random rand) throws Exception {
		float x=pos.getX()+MathHelper.getInt(rand, 4, 12)*randNeg(rand);
		float y=pos.getY()+MathHelper.getInt(rand, 0 , 4);
		float z=pos.getZ()+MathHelper.getInt(rand, 4, 12)*randNeg(rand);
		BlockPos newPos=new BlockPos(x,y,z);
		if(!world.getBlockState(pos).getBlock().equals(Blocks.AIR)) return;
		List<SpawnListEntry> list=world.getBiome(pos).getSpawnableList(EnumCreatureType.MONSTER);
		if(list==null) return;
		SpawnListEntry entry=list.get(MathHelper.getInt(rand, 0,list.size()-1));
		if(entry==null) return;
		EntityLiving entityLiving=entry.newInstance(world);
		if(entityLiving==null) return;
		entityLiving.setLocationAndAngles(x, y, z, rand.nextInt(360), 0);
		world.spawnParticle(EnumParticleTypes.FLAME, x, y, z, 0, 0, 0);
		world.spawnEntity(entityLiving);
	}
	
	
}

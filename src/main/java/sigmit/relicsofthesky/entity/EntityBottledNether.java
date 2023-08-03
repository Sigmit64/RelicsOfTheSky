package sigmit.relicsofthesky.entity;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class EntityBottledNether extends EntityBottle{
	
	public static final String ID = "bottled_nether";
	public static final String NAME = RelicsOfTheSky.MODID + "." + ID;
	
	
	public EntityBottledNether(World worldIn) {
		super(worldIn);
		
	}
	
	public EntityBottledNether(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn,throwerIn);
	}
	
	

	

	@Override
	public SoundEvent getSound() {
		// TODO Auto-generated method stub
		return SoundEvents.ENTITY_BLAZE_SHOOT;
	}

	@Override
	public int getRange() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public IBlockState getTransformResult(IBlockState state, World world, BlockPos pos) {
		// TODO Auto-generated method stub
		if(state.getBlock().equals(Blocks.AIR) || !state.isFullBlock() || state.getBlockHardness(world, pos)<0.0F) {
			return state;
		}
		if(state.getMaterial().equals(Material.ROCK) && state.getBlockHardness(world, pos)<=2.0F && !state.getBlock().equals(Blocks.BEDROCK)) {
			return (Math.random()>0.9F)?Blocks.FLOWING_LAVA.getDefaultState():(Math.random()>0.5F)?Blocks.NETHERRACK.getDefaultState():state;
		}
		//return Math.random()>0.8F?(Math.random()>)?Blocks.FLOWING_LAVA.getDefaultState():Blocks.AIR.getDefaultState():state;
		if(state.getBlockHardness(world, pos) < Math.random()) {
			return Blocks.AIR.getDefaultState();
		}
		if(state.getBlockHardness(world, pos) < Math.random()*2) {
			return Blocks.FLOWING_LAVA.getDefaultState();
		}
		return state;
	}

	@Override
	public void customImpact(World world, BlockPos pos) {
		if(world.getBlockState(pos).getBlock().equals(Blocks.AIR) && world.getBlockState(pos.down()).isFullBlock()) {
			if(Math.random()>0.8F) {
				world.setBlockState(pos, Blocks.FIRE.getDefaultState());
			}
		}
		
	}
}

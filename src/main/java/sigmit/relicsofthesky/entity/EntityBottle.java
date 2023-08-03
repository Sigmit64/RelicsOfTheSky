package sigmit.relicsofthesky.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import sigmit.relicsofthesky.RelicsOfTheSky;

public abstract class EntityBottle extends EntityThrowable{
	
	

	public EntityBottle(World worldIn) {
		super(worldIn);
		
	}
	
	public EntityBottle(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn,throwerIn);
	}
	
	public abstract SoundEvent getSound();
	public abstract int getRange();
	public abstract void customImpact(World world,BlockPos pos);
	
	public abstract IBlockState getTransformResult(IBlockState state,World world,BlockPos pos);

	@Override
	protected void onImpact(RayTraceResult result) {
		
		if(!this.world.isRemote) {
			if(result.getBlockPos() != null) {
				BlockPos hit = result.getBlockPos();
				
				
				world.playSound(hit.getX(),hit.getY(),hit.getZ(),getSound(),SoundCategory.BLOCKS,5.0F,1.0F,false);
				
				for(BlockPos transform : BlockPos.getAllInBoxMutable(hit.add(-getRange(),-getRange(),-getRange()), hit.add(getRange(),getRange(),getRange()))) {
					world.setBlockState(transform, getTransformResult(world.getBlockState(transform),world,transform));
					
				}
				for(BlockPos transform : BlockPos.getAllInBoxMutable(hit.add(-getRange(),-getRange(),-getRange()), hit.add(getRange(),getRange(),getRange()))) {
					customImpact(world,transform);
					
				}
				
				this.setDead();
			}
		}
		
	}

}

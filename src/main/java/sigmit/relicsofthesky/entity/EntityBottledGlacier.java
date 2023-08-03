package sigmit.relicsofthesky.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class EntityBottledGlacier extends EntityBottle{

	public EntityBottledGlacier(World worldIn) {
		super(worldIn);
		
	}
	public EntityBottledGlacier(World worldIn, EntityLivingBase entity) {
		super(worldIn,entity);
		
	}

	@Override
	public SoundEvent getSound() {
		
		return SoundEvents.ENTITY_BLAZE_SHOOT;
	}

	@Override
	public int getRange() {
		
		return 3;
	}

	@Override
	public void customImpact(World world, BlockPos pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBlockState getTransformResult(IBlockState state, World world, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

}

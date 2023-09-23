package sigmit.relicsofthesky.item.relics;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemLighter extends ItemBaseRefill{
	public ItemLighter() {
		super("lighter",1000,20);
	}
	
	public static Random rand= new Random();
	
	public static Map<IBlockState, Integer> map = new HashMap<>();
	
	static{
		
		
		map.put(Blocks.COBBLESTONE.getDefaultState(), 2);
		map.put(Blocks.STONE.getDefaultState(), 4);
		map.put(Blocks.NETHERRACK.getDefaultState(), 20);
		map.put(Blocks.MAGMA.getDefaultState(),100);
		
	}
	
	public static boolean getChance(IBlockState blockstate) {
		
		Integer value=map.get(blockstate);
		return !(value==null || !ItemUtils.getChance(value));
		
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem(hand);
		
		
		
		if(!canUse(stack,50,player)){
			return EnumActionResult.FAIL;
		}
		
		if (!worldIn.isRemote) {
			worldIn.playEvent(2004, pos, 0);
			worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.0F,false);
			
			if (getChance(worldIn.getBlockState(pos))) {
				worldIn.setBlockState(pos, Blocks.FLOWING_LAVA.getDefaultState());
				
	            return EnumActionResult.SUCCESS;
	        }
            
        }
        
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
	
}

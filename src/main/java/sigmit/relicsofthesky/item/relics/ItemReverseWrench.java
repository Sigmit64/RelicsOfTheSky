package sigmit.relicsofthesky.item.relics;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemReverseWrench extends ItemBaseRelics{
	public ItemReverseWrench() {
		super("reverse_wrench");
	}
	
	

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			
			IBlockState state = worldIn.getBlockState(pos);
			
			if(state.getBlock() instanceof BlockSlab && !((BlockSlab) state.getBlock()).isDouble()) {
				worldIn.playEvent(1001,pos,0);
				if(player.isSneaking()) {
					NonNullList<ItemStack> ret = NonNullList.create();
					state.getBlock().getDrops(ret,worldIn, pos, state, 0);
					Block.spawnAsEntity(worldIn, pos,ret.get(0));
					worldIn.setBlockToAir(pos);
				}else {
					if(state.getValue(BlockSlab.HALF).equals(BlockSlab.EnumBlockHalf.BOTTOM)) {
						worldIn.setBlockState(pos, state.withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.TOP));
					}else {
						worldIn.setBlockState(pos, state.withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.BOTTOM));
					}
				}
				
			}
		}
		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
	
	
}
 
package sigmit.relicsofthesky.item.relics;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemGrasser extends ItemBaseRelics{
	public ItemGrasser() {
		super("grasser");
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		// TODO Auto-generated method stub
		if(!worldIn.isRemote) {
			if(worldIn.getBlockState(pos).getBlock().equals(Blocks.DIRT)) {
				worldIn.setBlockState(pos, Blocks.GRASS.getDefaultState());
			}
			
		}
		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
	
	
	
	
	
}

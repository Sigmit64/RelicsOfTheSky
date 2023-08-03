package sigmit.relicsofthesky.item.relics;

import net.minecraft.block.IGrowable;
import net.minecraftforge.common.util.Constants;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class ItemWandOfNature extends ItemBaseRefill{
	public ItemWandOfNature() {
		super("wand_of_the_nature",2000,20);
	}
	
	

	



	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem(hand);
		
		
		if(!canUse(stack,20,player)){
			return EnumActionResult.FAIL;
		}
		
        if (applyBonemeal(stack, worldIn, pos, player, hand)) {
            if (!worldIn.isRemote) {
                worldIn.playEvent(2005, pos, 0);
            }
            return EnumActionResult.SUCCESS;
        }
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
	
	public boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target, EntityPlayer player, @javax.annotation.Nullable EnumHand hand) {
		IBlockState iblockstate = worldIn.getBlockState(target);

        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, target, iblockstate, stack, hand);
        if (hook != 0) return hook > 0;

        if (iblockstate.getBlock() instanceof IGrowable)
        {
            IGrowable igrowable = (IGrowable)iblockstate.getBlock();

            if (igrowable.canGrow(worldIn, target, iblockstate, worldIn.isRemote))
            {
                if (!worldIn.isRemote)
                {
                    if (igrowable.canUseBonemeal(worldIn, worldIn.rand, target, iblockstate))
                    {
                        igrowable.grow(worldIn, worldIn.rand, target, iblockstate);
                    }
                    //stack.setItemDamage(stack.getItemDamage()+100);
                    //stack.shrink(1);
                }

                return true;
            }
        }

        return false;
	}
	
	
	
}

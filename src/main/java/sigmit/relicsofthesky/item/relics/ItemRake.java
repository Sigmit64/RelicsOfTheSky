package sigmit.relicsofthesky.item.relics;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;
import sigmit.relicsofthesky.item.relics.ItemUtils.ItemStackChance;

public class ItemRake extends ItemBaseRefill{
	public ItemRake() {
		super("rake",2000,20);
	}
	
	public static List<ItemStackChance> listDrop= new ArrayList<>();
	
	static {
		listDrop.add(new ItemStackChance(Items.WHEAT_SEEDS,1,20));
		listDrop.add(new ItemStackChance(Item.getItemFromBlock(Blocks.COBBLESTONE),1,20));
	}
	
	public static List<ItemStack> getDropList(){
		List<ItemStack> returnList = new ArrayList<>();
		for(ItemStackChance i : listDrop) {
			if(ItemUtils.getChance(i.chance)) {
				returnList.add(i.stack);
			}
			
		}
		return returnList;
	}


	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos,
			EntityLivingBase entityLiving) {
		// TODO Auto-generated method stub
		return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
	}
	
	
}

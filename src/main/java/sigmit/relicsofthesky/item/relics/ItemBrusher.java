package sigmit.relicsofthesky.item.relics;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class ItemBrusher extends ItemBaseRefill{
	public ItemBrusher() {
		super("brusher", 2500,20);
	}
	
	public static Random rand= new Random();
	
	public static final Map<Item, Integer> map = new HashMap<>();
	
	static{
		
		map.put(Items.IRON_NUGGET, 20);
		map.put(Items.FLINT, 50);
		map.put(Items.GOLD_NUGGET, 10);
		map.put(Item.getItemFromBlock(Blocks.SAND),20);
	}
	

	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ, EnumHand hand) {
		
		if(!world.isRemote) {
			ItemStack stack = player.getHeldItem(hand);
			if(world.getBlockState(pos).getBlock().equals(Blocks.GRAVEL)) {
				if(!canUse(stack,20,player)) {
					return EnumActionResult.FAIL;
				}
				
				world.playEvent(1001, pos, 0);
				map.forEach((item,chance)->{
					if(ItemUtils.getChance(chance)) {
						EntityItem entityItem = new EntityItem(world,pos.getX(),pos.getY()+1,pos.getZ(),new ItemStack(item));
						entityItem.setDefaultPickupDelay();
						world.spawnEntity(entityItem);
					}
				});
				
				if(ItemUtils.getChance(20)) {
					
					world.playEvent(2001,pos,Block.getStateId(Blocks.GRAVEL.getDefaultState()));
					world.setBlockToAir(pos);
					
				}
			}
		}
		return EnumActionResult.PASS;
	}

	
	
}

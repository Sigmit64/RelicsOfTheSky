package sigmit.relicsofthesky.item.relics;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ItemSteelHammer extends ItemBaseRefill{
	public ItemSteelHammer() {
		super("steel_hammer",1000,20);
	}
	
	

	@Override
	public boolean canHarvestBlock(IBlockState blockIn) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		
		if(world.isRemote) return;
		EntityPlayer player=event.getEntityPlayer();
		ItemStack stack=event.getItemStack();
		
		if(stack.getItem() instanceof ItemSteelHammer) {
			
			if(world.getBlockState(pos).getBlock().equals(Blocks.ANVIL)) {
				if((1000 - stack.getItemDamage())>=20){
					stack.damageItem(20, player);
					
				}else {
					return;
				}
				BlockPos pos2=new BlockPos(pos.getX(),pos.getY()+1,pos.getZ());
				AxisAlignedBB aabb=new AxisAlignedBB(pos2);
				for(EntityItem itementity : world.getEntitiesWithinAABB(EntityItem.class, aabb)){
					if(itementity.getItem().getItem().equals(Items.IRON_INGOT)) {
						if(ItemUtils.getChance(10)) {
							itementity.getItem().shrink(1);
							EntityItem steel = new EntityItem(world,pos.getX(),pos.getY(),pos.getZ(),new ItemStack(ItemRegistryHandler.ITEM_INGOT,1,5));
							world.spawnEntity(steel);
						}
						break;
					}
				}
				
			}
		}
	}
	


	@Override
	public boolean canDestroyBlockInCreative(World world, BlockPos pos, ItemStack stack, EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
	}



	


	
	
	
}

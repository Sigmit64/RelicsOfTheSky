package sigmit.relicsofthesky.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sigmit.relicsofthesky.item.relics.ItemRake;

@EventBusSubscriber
public class RakeEventHandler {
	@SubscribeEvent
	public static void onRakeDestroy(BlockEvent.HarvestDropsEvent event) {
		if(event.getWorld().isRemote || event.isSilkTouching() || !(event.getHarvester() instanceof EntityPlayer)) {
			return;
		}
		ItemStack stack= event.getHarvester().getHeldItemMainhand();
		
		if(stack.getItem() instanceof ItemRake) {
			ItemRake item=(ItemRake) stack.getItem();
			if(!item.canUse(stack, 20, event.getHarvester())){
				return;
			}
			event.getDrops().clear();
			event.setDropChance(1.0F);
			event.getDrops().addAll(ItemRake.getDropList());
			
		}
	}
}

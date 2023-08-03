package sigmit.relicsofthesky.item.common;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.item.relics.ItemRegistryHandler;

@EventBusSubscriber
public class ColorRegistryHandler {
	
	@SubscribeEvent
	public static void itemColors(ColorHandlerEvent.Item event) {
		//RelicsOfTheSky.logger.info("color!!!!!");
		Item itemIngot = ItemRegistryHandler.ITEM_INGOT;
		event.getItemColors().registerItemColorHandler(new ItemColor(), itemIngot);
		Item itemNugget = ItemRegistryHandler.ITEM_NUGGET;
		event.getItemColors().registerItemColorHandler(new ItemColor(), itemNugget);
	}
}

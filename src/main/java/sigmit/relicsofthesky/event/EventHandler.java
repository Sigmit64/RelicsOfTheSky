package sigmit.relicsofthesky.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.capability.CapabilityRegistryHandler;
import sigmit.relicsofthesky.capability.PlayerItemUsed;
import sigmit.relicsofthesky.capability.PlayerItemUsedProvider;
import sigmit.relicsofthesky.item.relics.ItemRegistryHandler;

@EventBusSubscriber
public class EventHandler {
	@SubscribeEvent
	public static void onPlayerJoin(EntityJoinWorldEvent event) {
		Entity entity=event.getEntity();
		if(entity instanceof EntityPlayer) {
			String message="Welcome to Sigmit's house, "+ entity.getName() +"!";
			TextComponentString text=new TextComponentString(message);
			entity.sendMessage(text);
		}
	}
	
	
}

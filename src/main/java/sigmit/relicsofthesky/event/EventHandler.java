package sigmit.relicsofthesky.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;


public class EventHandler {
	
	public static void onPlayerJoin(EntityJoinWorldEvent event) {
		Entity entity=event.getEntity();
		if(entity instanceof EntityPlayer) {
			String message="Welcome to Sigmit's house, "+ entity.getName() +"!";
			TextComponentString text=new TextComponentString(message);
			entity.sendMessage(text);
		}
	}
	
	
}

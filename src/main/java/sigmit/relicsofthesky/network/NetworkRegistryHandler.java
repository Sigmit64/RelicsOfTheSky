package sigmit.relicsofthesky.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class NetworkRegistryHandler {
	public static void register() {
		NetworkRegistry.INSTANCE.registerGuiHandler(RelicsOfTheSky.MODID, new RelicsGuiHandler());
		
	}
	
	
}

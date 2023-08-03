package sigmit.relicsofthesky.entity;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class EntityRegistryHandler {
	
	@SubscribeEvent
	public static void onRegistry(RegistryEvent.Register<EntityEntry> event) {
		IForgeRegistry<EntityEntry> registry = event.getRegistry();
		registry.register(BOTTLED_NETHER);
	}
	
	public static final EntityEntry BOTTLED_NETHER=
			EntityEntryBuilder.create().entity(EntityBottledNether.class).id(EntityBottledNether.ID, 0)
			.name(EntityBottledNether.NAME).tracker(64, 10, true).build();
}

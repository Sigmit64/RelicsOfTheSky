package sigmit.relicsofthesky.capability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sigmit.relicsofthesky.RelicsOfTheSky;

@EventBusSubscriber
public class CapabilityRegistryHandler {
	
	@CapabilityInject(PlayerItemUsed.class)
	public static Capability<PlayerItemUsed> PLAYER_ITEM_USED;
	
	@SubscribeEvent
	public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		
		if(event.getObject() instanceof EntityPlayer) {
			PlayerItemUsedProvider provider=new PlayerItemUsedProvider();
			event.addCapability(new ResourceLocation(RelicsOfTheSky.MODID+":player_item_used"), provider);
			RelicsOfTheSky.logger.info("Capability attached AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		}
	}
	
	@SubscribeEvent
	public static void onPlayerClone(PlayerEvent.Clone event) {
		PlayerItemUsed instancePlayerItemUsed =event.getEntityPlayer().getCapability(CapabilityRegistryHandler.PLAYER_ITEM_USED, null);
		PlayerItemUsed originalItemUsed=event.getOriginal().getCapability(CapabilityRegistryHandler.PLAYER_ITEM_USED, null);
		instancePlayerItemUsed.copy(originalItemUsed);
		RelicsOfTheSky.logger.info("Capability copied AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	
	public static void register() {
		CapabilityManager.INSTANCE.register(PlayerItemUsed.class, new Capability.IStorage<PlayerItemUsed>() {

			@Override
			public NBTBase writeNBT(Capability<PlayerItemUsed> capability, PlayerItemUsed instance, EnumFacing side) {
				return instance.serializeNBT();
			}

			@Override
			public void readNBT(Capability<PlayerItemUsed> capability, PlayerItemUsed instance, EnumFacing side,
					NBTBase nbt) {
				if(nbt instanceof NBTTagCompound) {
					instance.deserializeNBT((NBTTagCompound) nbt);
				}
				
			}
			
		},
				PlayerItemUsed::new);
		RelicsOfTheSky.logger.info("Capability registered AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
}

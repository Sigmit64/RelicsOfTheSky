package sigmit.relicsofthesky.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;


public class PlayerItemUsedProvider implements ICapabilitySerializable<NBTTagCompound>{
	
	private final PlayerItemUsed instance;
	private final Capability<PlayerItemUsed> capability;
	
	
	
	public PlayerItemUsedProvider() {
		this.instance=new PlayerItemUsed();
		this.capability=CapabilityRegistryHandler.PLAYER_ITEM_USED;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return this.capability.equals(capability);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return this.capability.equals(capability) ? this.capability.cast(this.instance) :null;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		// TODO Auto-generated method stub
		return this.instance.serializeNBT();
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		this.instance.deserializeNBT(nbt);
		
	}

}

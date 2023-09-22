package sigmit.relicsofthesky.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.energy.SkyEnergyStorage;

public class TileEntityEnergyStorageBase extends TileEntity{
	
	public static final String ID = RelicsOfTheSky.MODID + ":energy_storage";
	public SkyEnergyStorage energyStorage=new SkyEnergyStorage(8000, 50);
	
	public int getEnergy() {
		return energyStorage.getEnergyStored();
	}
	public int getCapacity() {
		return energyStorage.getMaxEnergyStored();
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability.equals(CapabilityEnergy.ENERGY)||super.hasCapability(capability, facing);
		
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability.equals(CapabilityEnergy.ENERGY)) {
			return CapabilityEnergy.ENERGY.cast(energyStorage);
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		energyStorage.setEnergy(compound.getInteger("energy"));
		super.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		compound.setInteger("energy", energyStorage.getEnergyStored());
		return super.writeToNBT(compound);
	}
	
	
}

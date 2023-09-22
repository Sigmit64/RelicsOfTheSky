package sigmit.relicsofthesky.energy;

import net.minecraftforge.energy.EnergyStorage;

public class SkyEnergyStorage extends EnergyStorage{
	public SkyEnergyStorage(int capacity, int maxTransfer) {
		super(capacity,maxTransfer);
	}
	
	public void setEnergy(int amount) {
		if(amount<0 || amount>this.capacity) return;
		this.energy=amount;
	}
}

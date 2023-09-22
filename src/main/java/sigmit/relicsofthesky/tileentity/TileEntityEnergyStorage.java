package sigmit.relicsofthesky.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.util.ITickable;

public class TileEntityEnergyStorage extends TileEntityEnergyStorageBase implements ITickable{

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(world.isRemote) return;
		
		if(world.getBlockState(pos.down()).getBlock().equals(Blocks.REDSTONE_BLOCK)) {
			this.energyStorage.receiveEnergy(10, false);
		}
	}
	
}

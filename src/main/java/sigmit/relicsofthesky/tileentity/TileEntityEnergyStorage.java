package sigmit.relicsofthesky.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class TileEntityEnergyStorage extends TileEntityEnergyStorageBase implements ITickable{

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(world.isRemote) return;
		
		if(world.getBlockState(pos.down()).getBlock().equals(Blocks.REDSTONE_BLOCK)) {
			this.energyStorage.receiveEnergy(10, false);
		}
		insertToTop();
	}
	
	public void insertToTop() {
		TileEntity tile=world.getTileEntity(pos.up());
		if(tile!=null && tile.hasCapability(CapabilityEnergy.ENERGY, EnumFacing.DOWN)) {
			IEnergyStorage handler=tile.getCapability(CapabilityEnergy.ENERGY, EnumFacing.DOWN);
			int transfer=Math.min(this.energyStorage.extractEnergy(Integer.MAX_VALUE, true),handler.receiveEnergy(Integer.MAX_VALUE, true));
			if(transfer!=0) {
				this.energyStorage.extractEnergy(transfer, false);
				handler.receiveEnergy(transfer, false);
				markDirty();
			}
		}
	}
	
}

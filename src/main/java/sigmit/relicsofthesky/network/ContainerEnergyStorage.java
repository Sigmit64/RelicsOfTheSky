package sigmit.relicsofthesky.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sigmit.relicsofthesky.tileentity.TileEntityEnergyStorage;
import sigmit.relicsofthesky.tileentity.TileEntityMetalPurifier;

public class ContainerEnergyStorage extends Container{
	
	private final World world;
	private final BlockPos pos;
	
	private int energy=0;
	private int capacity=0;
    public int getEnergy() {
    	return this.energy;
    }
    public int getCapacity() {
    	return this.capacity;
    }



	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		// TODO Auto-generated method stub
		return ItemStack.EMPTY;
	}

	
	public ContainerEnergyStorage(EntityPlayer player, World world, int x,int y, int z) {
		this.world=world;
		this.pos=new BlockPos(x,y,z);
		TileEntity tileEntity = world.getTileEntity(this.pos);
		if(tileEntity instanceof TileEntityEnergyStorage) {
			this.capacity=((TileEntityEnergyStorage) tileEntity).getCapacity();
		}
		
		InventoryPlayer inventoryPlayer = player.inventory;

        int[] range = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};

        for (int i : range)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + 18 * i, 152));
            this.addSlotToContainer(new Slot(inventoryPlayer, i + 9, 8 + 18 * i, 94));
            this.addSlotToContainer(new Slot(inventoryPlayer, i + 18, 8 + 18 * i, 112));
            this.addSlotToContainer(new Slot(inventoryPlayer, i + 27, 8 + 18 * i, 130));
        }
	}
	
	@Override
	public void detectAndSendChanges() {
		
		super.detectAndSendChanges();
		TileEntity tileEntity = this.world.getTileEntity(this.pos);
        if (tileEntity instanceof TileEntityEnergyStorage)
        {
            int energy = ((TileEntityEnergyStorage) tileEntity).getEnergy();
            if (energy!= this.energy)
            {
                this.energy=energy;
                for (IContainerListener listener : this.listeners)
                {
                    listener.sendWindowProperty(this, 0, energy);
                }
            }
        }
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		if(id==0) {
			this.energy=data;
		}
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return playerIn.world.equals(this.world) && playerIn.getDistanceSq(this.pos)<=64.0;
	}

}

package sigmit.relicsofthesky.tileentity;

import javax.annotation.Nullable;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class TileEntitySandOfTime extends TileEntity implements ITickable{
	
	public static final String ID = RelicsOfTheSky.MODID + ":sand_of_time";
	
	public int getTick() {
		return 20;
	}
	public ItemStack getItemStack() {
		return new ItemStack(Item.getItemFromBlock(Blocks.SAND));
	}
	public int tickCount=0;

	@Override
	public void update()
	{
		if(world.isRemote) return;

		tickCount++;
		
		if(tickCount >= getTick())
		{
			tickCount = 0;
			ItemStack stack=output.getStackInSlot(0);
			if(stack == ItemStack.EMPTY || stack.getItem() != this.getItemStack().getItem())
			{
				this.output.setStackInSlot(0, this.getItemStack());
			} 
			else
			{
				stack.setCount(Math.min(stack.getMaxStackSize(), stack.getCount()+this.getItemStack().getCount()));
				this.output.setStackInSlot(0, stack);
			}
			
			
			
			insertToTop();
		}
	}
	
	public void insertToTop() {
		TileEntity tile = world.getTileEntity(pos.offset(EnumFacing.UP));
		if (tile != null && tile.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN)) {
			IItemHandler handler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);

			if (this.output.getStackInSlot(0) != ItemStack.EMPTY) {
				ItemStack stack = this.output.getStackInSlot(0).copy();
				stack.setCount(1);
				ItemStack stack1 = ItemHandlerHelper.insertItem(handler, stack, true);
				if (stack1 == ItemStack.EMPTY || stack1.getCount() == 0) {
					ItemHandlerHelper.insertItem(handler, this.output.extractItem(0, 1, false), false);
					markDirty();
				}
			}
		}
		
	}
	
	
	
	public final ItemStackHandler output = new ItemStackHandler(1) {
		@Override
		protected void onContentsChanged(int slot) {
			TileEntitySandOfTime.this.markDirty();
		}
		
		@Override
		public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
			
			return stack;
		}

		@Override
		public boolean isItemValid(int slot, ItemStack stack) {
			return false;
		}
		
	};
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.output.deserializeNBT(compound.getCompoundTag("Output"));
		
		super.readFromNBT(compound);
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("Output", this.output.serializeNBT());
		
		return super.writeToNBT(compound);
	}
	@Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
        Capability<IItemHandler> itemHandlerCapability = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
        return itemHandlerCapability.equals(capability) || super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
    	if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return (T) this.output;
        }
        return super.getCapability(capability, facing);
    }
}

package sigmit.relicsofthesky.tileentity;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

public abstract class TileEntityFluidPassiveGenerator extends TileEntity implements ITickable{
	
	
	
	public abstract int getTick();
	public abstract FluidStack getFluidStack();
	public int tickCount=0;
	
	private final FluidTank output=new FluidTank(1000) {

		@Override
		protected void onContentsChanged() {
			TileEntityFluidPassiveGenerator.this.markDirty();
		}

		@Override
		public boolean canFillFluidType(FluidStack fluid) {
			return fluid.isFluidEqual(getFluidStack());
		}

		
		
	};

	@Override
	public void update()
	{
		if(world.isRemote) return;

		tickCount++;
		
		if(tickCount >= getTick())
		{
			tickCount = 0;
			FluidStack fluidStack=output.getFluid();
			if(fluidStack==null || !fluidStack.isFluidEqual(getFluidStack())) {
				output.setFluid(getFluidStack());
			}else {
				output.fill(getFluidStack(), true);
			}
			
			
			
			
			
			insertToTop();
		}
	}
	
	public void insertToTop() {
		
		IFluidHandler handler =FluidUtil.getFluidHandler(world, pos.offset(EnumFacing.UP), EnumFacing.DOWN);
		if(handler!=null) {
			FluidUtil.tryFluidTransfer(handler, output, getFluidStack(), true);
			markDirty();
		}
		
		
	}
	
	
	
	
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.output.readFromNBT(compound);
		
		super.readFromNBT(compound);
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		this.output.writeToNBT(compound);
		
		return super.writeToNBT(compound);
	}
	@Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
        Capability<IFluidHandler> fluidHandlerCapability = CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;
        return fluidHandlerCapability.equals(capability) || super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
    	if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(output);
        }
        return super.getCapability(capability, facing);
    }
}

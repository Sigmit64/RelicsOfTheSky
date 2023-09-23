package sigmit.relicsofthesky.tileentity;



import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.item.common.ItemMesh;
import sigmit.relicsofthesky.recipe.RecipeLiquidFilterator;
import sigmit.relicsofthesky.recipe.RecipeLiquidFilterator.RLFInput;

public class TileEntityLiquidFilterator extends TileEntity implements ITickable{
	public static final String ID = RelicsOfTheSky.MODID + ":liquid_filterator";
	private int progress=0;
	private int maxProgress=100;
	public int getProgress() {
		return (int) (this.progress*100.0/this.maxProgress);
	}
	private final ItemStackHandler mesh = new ItemStackHandler(1) {

		@Override
		protected void onContentsChanged(int slot) {
			TileEntityLiquidFilterator.this.markDirty();
		}

		@Override
		public boolean isItemValid(int slot, ItemStack stack) {
			
			return stack.getItem() instanceof ItemMesh;
		}
		
		
		
	};
	private final ItemStackHandler output = new ItemStackHandler(9) {

		@Override
		protected void onContentsChanged(int slot) {
			TileEntityLiquidFilterator.this.markDirty();
		}
		
	};
	
	private IFluidHandler input = new FluidTank(8000) {

		@Override
		protected void onContentsChanged() {
			TileEntityLiquidFilterator.this.markDirty();
		}
		
	};
	
	public FluidStack getFluid() {
		
		return ((FluidTank) this.input).getFluid();
	}
	
	public IFluidHandler getInput() {
		return input;
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		if(capability.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)) {
			return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(output);
		}
		if(capability.equals(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)) {
			return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(input);
		}
		return super.getCapability(capability, facing);
	}

	public IItemHandler getMesh(){
		return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(mesh);
	}

	
	


	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		
		return super.hasCapability(capability, facing) || capability.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) || capability.equals(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY);
	}


	




	@Override
	public void readFromNBT(NBTTagCompound compound) {
		((FluidTank) input).readFromNBT(compound);
		this.output.deserializeNBT(compound.getCompoundTag("Output"));
		this.mesh.deserializeNBT(compound.getCompoundTag("Mesh"));
		this.progress=compound.getInteger("Progress");
		super.readFromNBT(compound);
	}







	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		((FluidTank) input).writeToNBT(compound);
		compound.setTag("Output", this.output.serializeNBT());
		compound.setTag("Mesh", this.mesh.serializeNBT());
		compound.setInteger("Progress", this.progress);
		return super.writeToNBT(compound);
	}





	List<ItemStack> outputList;

	@Override
	public void update() {
		
		if(progress>0) {
			progress++;
			if(progress>=maxProgress) {
				arrangeOutputs();
				progress=0;
				
				this.markDirty();
			}
		}else {
			RLFInput match=RecipeLiquidFilterator.getRecipeMatch(((FluidTank) input).getFluid(),mesh.getStackInSlot(0).copy());
			if(match!=null) {
				input.drain(match.stack, true);
				outputList=RecipeLiquidFilterator.getRecipeReturn(match);
				maxProgress=RecipeLiquidFilterator.getRecipeTime(match)*20;
				progress+=1;
				this.markDirty();
			}
		}
		
		
		
		
	}
		
	public void arrangeOutputs() {
		if(outputList==null) return;
		for(ItemStack stack:outputList) {
			for(int i=0;i<9 && !stack.isEmpty();i++) {
				stack=output.insertItem(i, stack, false);
			}
		}
		outputList.clear();
	}

}

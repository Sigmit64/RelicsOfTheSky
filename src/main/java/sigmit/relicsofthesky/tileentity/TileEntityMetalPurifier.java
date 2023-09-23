package sigmit.relicsofthesky.tileentity;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.item.common.ItemCatalyst;
import sigmit.relicsofthesky.item.relics.ItemUtils;
import sigmit.relicsofthesky.recipe.RecipeMetalPurifier;

public class TileEntityMetalPurifier extends TileEntity implements ITickable {
	public static final String ID = RelicsOfTheSky.MODID + ":metal_purifier";
	
	private int progress = 0;
	public int getProgress() {
		return this.progress;
	}
	private final ItemStackHandler up = new ItemStackHandler(1) {
		@Override
		protected void onContentsChanged(int slot) {
			TileEntityMetalPurifier.this.markDirty();
		}
	};
	private final ItemStackHandler down = new ItemStackHandler(1) {
		@Override
		protected void onContentsChanged(int slot) {
			TileEntityMetalPurifier.this.markDirty();
		}

		@Override
		public boolean isItemValid(int slot, ItemStack stack) {
			return false;
		}
		
		
	};
	private final ItemStackHandler side = new ItemStackHandler(1) {
		@Override
		protected void onContentsChanged(int slot) {
			TileEntityMetalPurifier.this.markDirty();
		}
	};
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.down.deserializeNBT(compound.getCompoundTag("Down"));
		this.up.deserializeNBT(compound.getCompoundTag("Up"));
		this.side.deserializeNBT(compound.getCompoundTag("Side"));
		this.progress=compound.getInteger("Progress");
		super.readFromNBT(compound);
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("Down", this.down.serializeNBT());
		compound.setTag("Up", this.up.serializeNBT());
		compound.setTag("Side", this.side.serializeNBT());
		compound.setInteger("Progress", this.progress);
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
        Capability<IItemHandler> itemHandlerCapability = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
        if (itemHandlerCapability.equals(capability))
        {
            if (EnumFacing.UP.equals(facing))
            {
                return itemHandlerCapability.cast(this.up);
            }
            if (EnumFacing.DOWN.equals(facing))
            {
                return itemHandlerCapability.cast(this.down);
            }
            return itemHandlerCapability.cast(this.side);
        }
        return super.getCapability(capability, facing);
    }
    
    public ItemStack outputStack=ItemStack.EMPTY;
    
    int totalTicks=0;
	@Override
	public void update() {
		if(world.isRemote) return;
		totalTicks++;
		if(totalTicks>=60) {
			totalTicks=0;
			//RelicsOfTheSky.logger.info(RecipeMetalPurifier.oreDictMap);
		}
		
		if(this.progress > 0) {
        	this.progress += 1;
            if (this.progress >= 240)
            {
            	//RelicsOfTheSky.logger.info(outputStack);
            	this.down.insertItem(0, outputStack, false);
            	this.progress = 0;
                
            }
            else
            {
                this.markDirty();
            }
        
        }else {
        	ItemStack input=this.side.extractItem(0, 1, true);
    		input.setCount(1);
    		if(RecipeMetalPurifier.getRecipe(input).isEmpty()) return;
    		//RelicsOfTheSky.logger.info(input);
    		ItemStack catalyst =this.up.extractItem(0, 1, true);
    		ItemStack output = RecipeMetalPurifier.getRecipe(input);
            boolean canExtractInput = (catalyst.getItem() instanceof ItemCatalyst);
            if (canExtractInput)
            {
                if (this.progress == 0)
                {
                    
                    boolean canInsertOutput = this.down.insertItem(0, output, true).isEmpty();
                    if (canInsertOutput)
                    {
                    	outputStack=output;
                        this.side.extractItem(0, 1, false);
                        if(!ItemUtils.getChance(ItemCatalyst.getChance(catalyst.getMetadata()))) {
                        	
                        	this.up.extractItem(0, 1, false);
                        }
                        
                        this.progress += 1;
                    }
                }
            }
        }
            
        
                
        
		
	}

	
}

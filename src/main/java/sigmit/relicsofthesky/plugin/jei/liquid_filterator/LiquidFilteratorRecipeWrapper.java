package sigmit.relicsofthesky.plugin.jei.liquid_filterator;

import java.util.ArrayList;
import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import sigmit.relicsofthesky.item.relics.ItemUtils.ItemStackChance;

public class LiquidFilteratorRecipeWrapper implements IRecipeWrapper{
	
	//private final static List<ItemStack> CATALYSTS = Lists.newArrayList(new ItemStack(ItemRegistryHandler.ITEM_CATALYST,1,0),new ItemStack(ItemRegistryHandler.ITEM_CATALYST,1,1));
	
	private ItemStack inputMesh;
	private FluidStack inputFluidStack;
	private List<ItemStack> output = new ArrayList<ItemStack>();
	private List<ItemStackChance> outputChances=new ArrayList<ItemStackChance>();
	
	public LiquidFilteratorRecipeWrapper(FluidStack fluid,ItemStack input, List<ItemStackChance> output) {
		//RelicsOfTheSky.logger.info(fluid.getLocalizedName());
		//RelicsOfTheSky.logger.info(input.getDisplayName());
		
		
		if(input.isEmpty()) {
			this.inputMesh=new ItemStack(Blocks.BARRIER);
		}else {
			this.inputMesh=input;
		}
		
		this.inputFluidStack=fluid;
		this.outputChances=output;
		for(ItemStackChance itemStackChance:output) {
			this.output.add(itemStackChance.stack);
		}
		
	}
	
	public String getChance(int index) {
		if(outputChances.get(index).chance!=100) {
			return outputChances.get(index).chance+"%";
		}
		return "";
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInput(VanillaTypes.ITEM, inputMesh);
		ingredients.setInput(VanillaTypes.FLUID, inputFluidStack);
		ingredients.setOutputs(VanillaTypes.ITEM, output);
		
	}

	
}

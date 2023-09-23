package sigmit.relicsofthesky.plugin.jei.liquid_filterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import sigmit.relicsofthesky.item.relics.ItemUtils.ItemStackChance;
import sigmit.relicsofthesky.recipe.RecipeLiquidFilterator;
import sigmit.relicsofthesky.recipe.RecipeLiquidFilterator.RLFInput;

public class LiquidFilteratorRecipeHandler{
	public static List<LiquidFilteratorRecipeWrapper> getRecipes(IJeiHelpers jeiHelpers){
		IStackHelper stackHelper=jeiHelpers.getStackHelper();
		List<LiquidFilteratorRecipeWrapper> recipes = new ArrayList<LiquidFilteratorRecipeWrapper>();
		for(Entry<RLFInput, ItemStackChance[]> entry : RecipeLiquidFilterator.map.entrySet()) {
			ItemStack inputmesh = entry.getKey().mesh;
			ItemStackChance[] output =entry.getValue();
			FluidStack inputFluidStacks= entry.getKey().stack;
			LiquidFilteratorRecipeWrapper wrapper = new LiquidFilteratorRecipeWrapper(inputFluidStacks,inputmesh, Arrays.asList(output));
			
			recipes.add(wrapper);
		}
		
		return recipes;
	}
}

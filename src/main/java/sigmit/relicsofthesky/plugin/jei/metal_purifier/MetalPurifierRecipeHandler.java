package sigmit.relicsofthesky.plugin.jei.metal_purifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import sigmit.relicsofthesky.recipe.OreDictItem;
import sigmit.relicsofthesky.recipe.RecipeMetalPurifier;

public class MetalPurifierRecipeHandler{
	public static List<MetalPurifierRecipeWrapper> getRecipes(IJeiHelpers jeiHelpers){
		IStackHelper stackHelper=jeiHelpers.getStackHelper();
		List<MetalPurifierRecipeWrapper> recipes = new ArrayList<MetalPurifierRecipeWrapper>();
		for(Entry<ItemStack, ItemStack> entry : RecipeMetalPurifier.stackMap.entrySet()) {
			ItemStack input = entry.getKey();
			ItemStack output =entry.getValue();
			List<ItemStack> inputItemStacks= stackHelper.getSubtypes(input);
			MetalPurifierRecipeWrapper wrapper = new MetalPurifierRecipeWrapper(inputItemStacks, output);
			recipes.add(wrapper);
		}
		for(Entry<OreDictItem, ItemStack> entry : RecipeMetalPurifier.oreDictMap.entrySet()) {
			OreDictItem input = entry.getKey();
			ItemStack output =entry.getValue();
			List<ItemStack> inputItemStacks= OreDictionary.getOres(input.name);
			MetalPurifierRecipeWrapper wrapper = new MetalPurifierRecipeWrapper(inputItemStacks, output);
			recipes.add(wrapper);
		}
		return recipes;
	}
}

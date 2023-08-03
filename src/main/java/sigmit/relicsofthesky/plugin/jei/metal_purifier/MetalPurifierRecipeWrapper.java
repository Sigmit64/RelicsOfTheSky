package sigmit.relicsofthesky.plugin.jei.metal_purifier;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import sigmit.relicsofthesky.item.relics.ItemRegistryHandler;

public class MetalPurifierRecipeWrapper implements IRecipeWrapper{
	
	private final static List<ItemStack> CATALYSTS = Lists.newArrayList(new ItemStack(ItemRegistryHandler.ITEM_CATALYST,1,0),new ItemStack(ItemRegistryHandler.ITEM_CATALYST,1,1));
	
	private final List<List<ItemStack>> input;
	private ItemStack output;
	
	public MetalPurifierRecipeWrapper(ItemStack input, ItemStack output) {
		this.input=Lists.newArrayList(Collections.singletonList(input),CATALYSTS);
		this.output=output;
	}
	
	public MetalPurifierRecipeWrapper(List<ItemStack> input, ItemStack output) {
		this.input=Lists.newArrayList(input,CATALYSTS);
		this.output=output;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputLists(VanillaTypes.ITEM, input);
		ingredients.setOutput(VanillaTypes.ITEM, output);
	}

}

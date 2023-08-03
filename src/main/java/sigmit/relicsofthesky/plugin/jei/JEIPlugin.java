package sigmit.relicsofthesky.plugin.jei;


import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;

import net.minecraft.item.ItemStack;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.block.BlockRegistryHandler;
import sigmit.relicsofthesky.plugin.jei.liquid_filterator.LiquidFilteratorRecipeCategory;
import sigmit.relicsofthesky.plugin.jei.liquid_filterator.LiquidFilteratorRecipeHandler;
import sigmit.relicsofthesky.plugin.jei.metal_purifier.MetalPurifierRecipeCategory;
import sigmit.relicsofthesky.plugin.jei.metal_purifier.MetalPurifierRecipeHandler;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin{
	
	public static final String METAL_PURIFIER_UID = RelicsOfTheSky.NAME + ".metal_purifier";
	public static final String LIQUID_FILTERATOR_UID = RelicsOfTheSky.NAME + ".liquid_filterator";
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IJeiHelpers jeiHelpers=registry.getJeiHelpers();
		IGuiHelper guiHelper=jeiHelpers.getGuiHelper();
		registry.addRecipeCategories(new MetalPurifierRecipeCategory(guiHelper));
		registry.addRecipeCategories(new LiquidFilteratorRecipeCategory(guiHelper));
	}

	@Override
	public void register(IModRegistry registry) {
		//IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
		IJeiHelpers jeiHelpers=registry.getJeiHelpers();
		registry.addRecipes(MetalPurifierRecipeHandler.getRecipes(jeiHelpers),METAL_PURIFIER_UID);
		registry.addRecipeCatalyst(new ItemStack(BlockRegistryHandler.BLOCK_METAL_PURIFIER), METAL_PURIFIER_UID);
		registry.addRecipes(LiquidFilteratorRecipeHandler.getRecipes(jeiHelpers), LIQUID_FILTERATOR_UID);
		registry.addRecipeCatalyst(new ItemStack(BlockRegistryHandler.BLOCK_LIQUID_FILTERATOR), LIQUID_FILTERATOR_UID);
		
	}
	
}

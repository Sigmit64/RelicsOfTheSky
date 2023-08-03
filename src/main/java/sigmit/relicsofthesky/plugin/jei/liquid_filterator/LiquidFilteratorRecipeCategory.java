package sigmit.relicsofthesky.plugin.jei.liquid_filterator;

import java.util.List;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.ITooltipCallback;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IntIdentityHashBiMap;
import net.minecraft.util.ResourceLocation;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.block.BlockRegistryHandler;
import sigmit.relicsofthesky.plugin.jei.metal_purifier.BaseRecipeCategory;

public class LiquidFilteratorRecipeCategory extends BaseRecipeCategory<LiquidFilteratorRecipeWrapper>{
	private static final ResourceLocation TEXTURE=new ResourceLocation(RelicsOfTheSky.MODID + ":textures/gui/container/liquid_filterator_jei.png");
	
	private final IDrawable icon;
	private final IDrawableStatic background;

	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "liquid_filterator";
	}

	@Override
	public String getUid() {
		// TODO Auto-generated method stub
		return sigmit.relicsofthesky.plugin.jei.JEIPlugin.LIQUID_FILTERATOR_UID;
	}
	
	

	@Override
	public IDrawable getBackground() {
		// TODO Auto-generated method stub
		return background;
	}
	

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, LiquidFilteratorRecipeWrapper recipeWrapper,
			IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks =recipeLayout.getItemStacks();
		IGuiFluidStackGroup guiFluidStackGroup=recipeLayout.getFluidStacks();
		guiItemStacks.init(0, true, 58, 40);
		for(int i=1;i<=9;i++) {
			guiItemStacks.init(i, false, 92+18*((i-1)%3), 22+18*((i-1)/3));
		}
		guiFluidStackGroup.init(0, true, 26, 23, 16, 52, 8000, true, null);
		guiItemStacks.set(ingredients);
		guiFluidStackGroup.set(ingredients);
		guiItemStacks.addTooltipCallback(new ITooltipCallback<ItemStack>() {
			
			@Override
			public void onTooltip(int slotIndex, boolean input, ItemStack ingredient, List<String> tooltip) {
				if(!input) tooltip.add(recipeWrapper.getChance(slotIndex-1));
				
				
			}
		});
	}
	
	public LiquidFilteratorRecipeCategory(IGuiHelper guiHelper) {
		background=guiHelper.createDrawable(TEXTURE, 0, 0, 176, 95);
		icon=guiHelper.createDrawableIngredient(new ItemStack(BlockRegistryHandler.BLOCK_LIQUID_FILTERATOR));
	}

}

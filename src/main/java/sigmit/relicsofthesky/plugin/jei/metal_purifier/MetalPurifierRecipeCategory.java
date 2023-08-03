package sigmit.relicsofthesky.plugin.jei.metal_purifier;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.block.BlockRegistryHandler;

public class MetalPurifierRecipeCategory extends BaseRecipeCategory<MetalPurifierRecipeWrapper>{
	private static final ResourceLocation TEXTURE=new ResourceLocation(RelicsOfTheSky.MODID + ":textures/gui/container/metal_purifier_jei.png");
	
	private final IDrawable icon;
	private final IDrawableStatic background;

	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "metal_purifier";
	}

	@Override
	public String getUid() {
		// TODO Auto-generated method stub
		return sigmit.relicsofthesky.plugin.jei.JEIPlugin.METAL_PURIFIER_UID;
	}
	
	

	@Override
	public IDrawable getBackground() {
		// TODO Auto-generated method stub
		return background;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, MetalPurifierRecipeWrapper recipeWrapper,
			IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks =recipeLayout.getItemStacks();
		guiItemStacks.init(0, true, 43, 58);
		guiItemStacks.init(1, false, 115, 58);
		guiItemStacks.init(2, true, 79, 43);
		guiItemStacks.set(ingredients);
	}
	
	public MetalPurifierRecipeCategory(IGuiHelper guiHelper) {
		background=guiHelper.createDrawable(TEXTURE, 0, 0, 176, 92);
		icon=guiHelper.createDrawableIngredient(new ItemStack(BlockRegistryHandler.BLOCK_METAL_PURIFIER));
	}

}

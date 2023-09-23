package sigmit.relicsofthesky.plugin.jei.metal_purifier;

import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import sigmit.relicsofthesky.RelicsOfTheSky;

public abstract class BaseRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T>{
	
	public abstract String getName();
	
	@Override
	public String getUid() {
		// TODO Auto-generated method stub
		return RelicsOfTheSky.MODID + "." + getName();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return I18n.format("jei."+RelicsOfTheSky.MODID + "." + getName() + ".title");
	}

	@Override
	public String getModName() {
		// TODO Auto-generated method stub
		return RelicsOfTheSky.NAME;
	}

	

}

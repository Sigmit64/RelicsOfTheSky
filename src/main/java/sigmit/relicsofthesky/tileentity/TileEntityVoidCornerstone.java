package sigmit.relicsofthesky.tileentity;

import java.util.Map;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.item.relics.ItemRegistryHandler;
import sigmit.relicsofthesky.item.relics.ItemUtils.ItemStackChance;
import sigmit.relicsofthesky.recipe.BlockTransformerMap;

public class TileEntityVoidCornerstone extends TileEntityBlockTransformer{
	
	public static final String ID =RelicsOfTheSky.MODID + ":void_cornerstone";
	
	public BlockTransformerMap transformerMap=new BlockTransformerMap()
			.addRecipe(Blocks.STONE.getDefaultState(), Blocks.REDSTONE_ORE.getDefaultState(), 10)
			.addRecipe(Blocks.BEDROCK.getDefaultState(),Blocks.DIAMOND_BLOCK.getDefaultState(),100);
	

	@Override
	public BlockTransformerMap getBlockTransformerMap() {
		return transformerMap;
	}


	@Override
	public ItemStackChance getPassiveGeneration() {
		return new ItemStackChance(new ItemStack(ItemRegistryHandler.ITEM_CATALYST,1,0),1);
	}
	
	

}

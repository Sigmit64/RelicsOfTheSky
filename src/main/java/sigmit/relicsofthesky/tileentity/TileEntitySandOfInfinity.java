package sigmit.relicsofthesky.tileentity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.block.BlockRegistryHandler;

public class TileEntitySandOfInfinity extends TileEntityItemPassiveGenerator{
	
	public final static String ID = RelicsOfTheSky.MODID + ":sand_of_infinity";
	
	@Override
	public int getTick() {
		return 600;
	}
	
	@Override
	public ItemStack getItemStack() {
		return new ItemStack(Item.getItemFromBlock(BlockRegistryHandler.BLOCK_SAND_OF_TIME));
	}
}

package sigmit.relicsofthesky.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sigmit.relicsofthesky.block.BlockRegistryHandler;

public class TileEntitySandOfInfinity extends TileEntitySandOfTime{
	
	@Override
	public int getTick() {
		return 600;
	}
	
	@Override
	public ItemStack getItemStack() {
		return new ItemStack(Item.getItemFromBlock(BlockRegistryHandler.BLOCK_SAND_OF_TIME));
	}
}

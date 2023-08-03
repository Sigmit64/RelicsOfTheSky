package sigmit.relicsofthesky.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TileEntitySandOfTimeCompressed extends TileEntitySandOfTime{
	
	@Override
	public int getTick() {
		return 2;
	}
	
	@Override
	public ItemStack getItemStack() {
		return new ItemStack(Item.getItemFromBlock(Blocks.SAND),9);
	}
}

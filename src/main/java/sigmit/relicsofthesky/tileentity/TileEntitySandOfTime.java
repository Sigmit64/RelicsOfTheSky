package sigmit.relicsofthesky.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.block.BlockRegistryHandler;

public class TileEntitySandOfTime extends TileEntityItemPassiveGenerator{
public final static String ID = RelicsOfTheSky.MODID + ":sand_of_time";
	
	@Override
	public int getTick() {
		return 20;
	}
	
	@Override
	public ItemStack getItemStack() {
		return new ItemStack(Blocks.SAND);
	}
}

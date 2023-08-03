package sigmit.relicsofthesky.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import scala.annotation.meta.companionClass;
import sigmit.relicsofthesky.item.relics.ItemRegistryHandler;

public class OreDictRegistry {
	public static void OreDictRegister() {
		
		
		register("ingotCopper", ItemRegistryHandler.ITEM_INGOT, 1);
		register("ingotSilver", ItemRegistryHandler.ITEM_INGOT, 2);
		register("ingotTin", ItemRegistryHandler.ITEM_INGOT, 3);
		register("ingotLead", ItemRegistryHandler.ITEM_INGOT, 4);
		register("ingotSteel", ItemRegistryHandler.ITEM_INGOT, 5);
		
		register("nuggetCopper", ItemRegistryHandler.ITEM_NUGGET, 1);
		register("nuggetSilver", ItemRegistryHandler.ITEM_NUGGET, 2);
		register("nuggetTin", ItemRegistryHandler.ITEM_NUGGET, 3);
		register("nuggetLead", ItemRegistryHandler.ITEM_NUGGET, 4);
		register("nuggetSteel", ItemRegistryHandler.ITEM_NUGGET, 5);
	}
	
	public static void register(String name, Item item, int meta) {
		OreDictionary.registerOre(name, new ItemStack(item,1,meta));
	}
	
}

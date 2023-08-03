package sigmit.relicsofthesky.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import scala.annotation.meta.companionClass;
import sigmit.relicsofthesky.item.relics.ItemRegistryHandler;

public class OreDictRegistry {
	public static void OreDictRegister() {
		
		OreDictionary.registerOre("ingotCopper", new ItemStack(ItemRegistryHandler.ITEM_INGOT,1,1));
		OreDictionary.registerOre("ingotSilver", new ItemStack(ItemRegistryHandler.ITEM_INGOT,1,2));
		OreDictionary.registerOre("ingotTin", new ItemStack(ItemRegistryHandler.ITEM_INGOT,1,3));
		OreDictionary.registerOre("ingotLead", new ItemStack(ItemRegistryHandler.ITEM_INGOT,1,4));
	}
	
	
}

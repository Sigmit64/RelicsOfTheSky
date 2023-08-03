package sigmit.relicsofthesky.recipe;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.item.relics.ItemRegistryHandler;

public class RecipeMetalPurifier {
	public static Map<ItemStack,ItemStack> stackMap=new HashMap<ItemStack, ItemStack>();
	public static Map<OreDictItem, ItemStack> oreDictMap=new HashMap<OreDictItem, ItemStack>();
	public static void register() {
		
		addRecipe("ingotLead",1,new ItemStack(ItemRegistryHandler.ITEM_INGOT,1,3));
		addRecipe("ingotTin",1,new ItemStack(Items.IRON_INGOT,1,0));
		addRecipe("ingotIron",1,new ItemStack(ItemRegistryHandler.ITEM_INGOT,1,1));
		addRecipe("ingotCopper",1,new ItemStack(ItemRegistryHandler.ITEM_INGOT,1,2));
		addRecipe("ingotSilver",1,new ItemStack(Items.GOLD_INGOT,1,0));
		//RelicsOfTheSky.logger.info("REGISTERED");
	}
	
	public static void addRecipe(ItemStack input, ItemStack output) {
		stackMap.put(input, output);
	}
	
	public static void addRecipe(OreDictItem input, ItemStack output) {
		oreDictMap.put(input, output);
	}
	
	public static void addRecipe(String name, int amount, ItemStack output) {
		addRecipe(new OreDictItem(name, amount), output);
	}
	
	public static boolean isEqual(ItemStack stack1, ItemStack stack2) {
		return stack1.getItem()==stack2.getItem() && (stack1.getMetadata()==stack2.getMetadata() || stack1.getMetadata()==32767 || stack2.getMetadata()==32767);
	}
	
	public static ItemStack getRecipe(ItemStack input) {
		
		for(ItemStack ingredients : stackMap.keySet()) {
			
			if(isEqual(input, ingredients)) {
				if(ingredients.getCount()<=input.getCount()) {
					return stackMap.get(ingredients).copy();
				}
				
			}
		}
		for(OreDictItem ingredients : oreDictMap.keySet()) {
			
			for(ItemStack ing2 : OreDictionary.getOres(ingredients.name)) {
				if(isEqual(input, ing2)) {
					if(ingredients.amount<=input.getCount()) {
						return oreDictMap.get(ingredients).copy();
					}
					
				}
			}
		}
		return ItemStack.EMPTY;
		
	}
}

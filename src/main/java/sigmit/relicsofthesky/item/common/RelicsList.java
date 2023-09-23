package sigmit.relicsofthesky.item.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sigmit.relicsofthesky.item.relics.ItemRegistryHandler;

public class RelicsList {
	
	//public static Item[] list = {Items.APPLE,Items.BEEF,Items.CARROT,Items.DIAMOND,Items.ENDER_PEARL,Items.FEATHER,Items.GHAST_TEAR,Items.HOPPER_MINECART};
	
	public static Map<Integer, ItemStack> relicMap = new HashMap<Integer,ItemStack>();
	
	public static int relicCount=0;
	
	public static ItemStack getRelics(int id) {
		return relicMap.get(id).copy();
	}
	
	public static void addRelicToList(ItemStack relic) {
		relicMap.put(relicCount, relic);
		relicCount++;
	}
	
	public static void addRelicToList(Item relic) {
		addRelicToList(new ItemStack(relic,1));
	}
	
	public static void addRelicsToList(Item...items) {
		for(Item item:items) {
			addRelicToList(item);
		}
	}
	
	static {
		addRelicsToList(
				ItemRegistryHandler.ITEM_BOTTLED_NETHER,
				ItemRegistryHandler.ITEM_BRUSHER,
				ItemRegistryHandler.ITEM_ENERGY_STORAGE,
				ItemRegistryHandler.ITEM_GRASSER,
				ItemRegistryHandler.ITEM_LAVA_GENERATOR,
				ItemRegistryHandler.ITEM_LIGHTER,
				ItemRegistryHandler.ITEM_LIQUID_FILTERATOR,
				ItemRegistryHandler.ITEM_MAGIC_COOKIE,
				ItemRegistryHandler.ITEM_METAL_PURIFIER,
				ItemRegistryHandler.ITEM_RAKE,
				ItemRegistryHandler.ITEM_REVERSE_WRENCH,
				ItemRegistryHandler.ITEM_SAND_OF_INFINITY,
				ItemRegistryHandler.ITEM_SAND_OF_TIME,
				ItemRegistryHandler.ITEM_STEEL_HAMMER,
				ItemRegistryHandler.ITEM_WAND_OF_NATURE,
				ItemRegistryHandler.ITEM_WATER_GENERATOR,
				ItemRegistryHandler.ITEM_VOID_CORNERSTONE
				
				
				);
	}
	
	public static int pack(Set<Integer> set) {
		int multi=1,result=0;
		for(int a:set) {
			result+=(a*multi);
			multi*=relicCount;
		}
		
		return result;
	}
	
	public static Set<Integer> unpack(int pack){
		Set<Integer> set=new HashSet<Integer>();
		while(pack>0) {
			set.add(pack%relicCount);
			pack/=relicCount;
		}
		
		return set;
	}
	
	public static Set<Integer> getInt(int count) {
		Random random = new Random();
		Set<Integer> l=new HashSet<Integer>();
		while(l.size()<count) {
			l.add(random.nextInt(relicCount));
		}
		
		return l;
	}
}

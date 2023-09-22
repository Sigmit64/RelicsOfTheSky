package sigmit.relicsofthesky.item.relics;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import sigmit.relicsofthesky.block.BlockRegistryHandler;
import sigmit.relicsofthesky.item.common.ItemCatalyst;
import sigmit.relicsofthesky.item.common.ItemIngot;
import sigmit.relicsofthesky.item.common.ItemMesh;
import sigmit.relicsofthesky.item.common.ItemMeta;
import sigmit.relicsofthesky.item.common.ItemNugget;
import sigmit.relicsofthesky.item.common.ItemRelicChest;
import sigmit.relicsofthesky.item.relics.bottles.BottledNether;

@EventBusSubscriber
public class ItemRegistryHandler {
	public static final ItemGrasser ITEM_GRASSER = new ItemGrasser();
	public static final ItemWandOfNature ITEM_WAND_OF_NATURE = new ItemWandOfNature();
	public static final ItemLighter ITEM_LIGHTER = new ItemLighter();
	public static final ItemReverseWrench ITEM_REVERSE_WRENCH = new ItemReverseWrench();
	public static final ItemBrusher ITEM_BRUSHER = new ItemBrusher();
	public static final ItemSteelHammer ITEM_STEEL_HAMMER = new ItemSteelHammer();
	public static final ItemRake ITEM_RAKE = new ItemRake();
	
	public static final BottledNether ITEM_BOTTLED_NETHER = new BottledNether();
	
	public static final ItemIngot ITEM_INGOT = new ItemIngot();
	public static final ItemCatalyst ITEM_CATALYST = new ItemCatalyst();
	public static final ItemMesh ITEM_MESH = new ItemMesh();
	public static final ItemNugget ITEM_NUGGET=new ItemNugget();
	public static final ItemMagicCookie ITEM_MAGIC_COOKIE=new ItemMagicCookie();
	public static final ItemRelicChest ITEM_RELIC_CHEST = new ItemRelicChest();
	
	//public static final ItemBlock ITEM_MERGER = withRegistryName(new ItemBlock(BlockRegistryHandler.BLOCK_MERGER));
	public static final ItemBlock ITEM_METAL_PURIFIER = withRegistryName(new ItemBlock(BlockRegistryHandler.BLOCK_METAL_PURIFIER));
	public static final ItemBlock ITEM_SAND_OF_TIME = withRegistryName(new ItemBlock(BlockRegistryHandler.BLOCK_SAND_OF_TIME));
	public static final ItemBlock ITEM_SAND_OF_TIME_COMPRESSED = withRegistryName(new ItemBlock(BlockRegistryHandler.BLOCK_SAND_OF_TIME_COMPRESSED));
	public static final ItemBlock ITEM_SAND_OF_INFINITY = withRegistryName(new ItemBlock(BlockRegistryHandler.BLOCK_SAND_OF_INFINITY));
	public static final ItemBlock ITEM_LIQUID_FILTERATOR = withRegistryName(new ItemBlock(BlockRegistryHandler.BLOCK_LIQUID_FILTERATOR));
	public static final ItemBlock ITEM_WATER_GENERATOR = withRegistryName(new ItemBlock(BlockRegistryHandler.BLOCK_WATER_GENERATOR));
	public static final ItemBlock ITEM_LAVA_GENERATOR = withRegistryName(new ItemBlock(BlockRegistryHandler.BLOCK_LAVA_GENERATOR));
	public static final ItemBlock ITEM_VOID_CORNERSTONE = withRegistryName(new ItemBlock(BlockRegistryHandler.BLOCK_VOID_CORNERSTONE));
	public static final ItemBlock ITEM_ENERGY_STORAGE = withRegistryName(new ItemBlock(BlockRegistryHandler.BLOCK_ENERGY_STORAGE));
	
	private static ItemBlock withRegistryName(ItemBlock item) {
		item.setRegistryName(item.getBlock().getRegistryName());
		return item;
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onModelRegistry(ModelRegistryEvent event) {
		regitserModelAll(
			ITEM_GRASSER,
			ITEM_WAND_OF_NATURE,
			ITEM_LIGHTER,
			ITEM_RELIC_CHEST,
			ITEM_REVERSE_WRENCH,
			ITEM_BRUSHER,
			ITEM_STEEL_HAMMER,
			ITEM_RAKE,
			ITEM_BOTTLED_NETHER,
			
			//ITEM_MERGER,
			ITEM_METAL_PURIFIER,
			ITEM_SAND_OF_TIME,
			ITEM_SAND_OF_TIME_COMPRESSED,
			ITEM_SAND_OF_INFINITY,
			ITEM_LIQUID_FILTERATOR,
			ITEM_WATER_GENERATOR,
			ITEM_LAVA_GENERATOR,
			ITEM_VOID_CORNERSTONE,
			ITEM_ENERGY_STORAGE,
			
			ITEM_INGOT,
			ITEM_CATALYST,
			ITEM_MESH,
			ITEM_NUGGET,
			ITEM_MAGIC_COOKIE
			
		);
		
	}
	public static void regitserModelAll(Item... items) {
		for(Item item:items) {
			if(item instanceof ItemMeta) {
				if(((ItemMeta) item).getHasModel()) {
					for(int i=0;i<((ItemMeta) item).getCount();i++) {
						registerModelV(item, i);
					}
				}else {
					for(int i=0;i<((ItemMeta) item).getCount();i++) {
						registerModel(item, i);
					}
				}
				
			}else {
				registerModel(item);
			}
			
		}
	}
	
	
	
	public static void registerModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, 
				new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}
	
	public static void registerModel(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, 
				new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}
	public static void registerModelV(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, 
				new ModelResourceLocation(item.getRegistryName().toString()+"_"+String.valueOf(meta),"inventory"));
	}
	
	@SubscribeEvent
	public static void onRegistry(Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.registerAll(
			ITEM_GRASSER,
			ITEM_WAND_OF_NATURE,
			ITEM_LIGHTER,
			ITEM_RELIC_CHEST,
			ITEM_REVERSE_WRENCH,
			ITEM_BRUSHER,
			ITEM_STEEL_HAMMER,
			ITEM_RAKE,
			ITEM_BOTTLED_NETHER,
			
			//ITEM_MERGER,
			ITEM_METAL_PURIFIER,
			ITEM_SAND_OF_TIME,
			ITEM_SAND_OF_TIME_COMPRESSED,
			ITEM_SAND_OF_INFINITY,
			ITEM_LIQUID_FILTERATOR,
			ITEM_WATER_GENERATOR,
			ITEM_LAVA_GENERATOR,
			ITEM_VOID_CORNERSTONE,
			ITEM_ENERGY_STORAGE,
			
			ITEM_INGOT,
			ITEM_CATALYST,
			ITEM_MESH,
			ITEM_NUGGET,
			ITEM_MAGIC_COOKIE
		);
	}
}

package sigmit.relicsofthesky.recipe;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import scala.annotation.meta.companionClass;
import sigmit.relicsofthesky.item.relics.ItemRegistryHandler;
import sigmit.relicsofthesky.item.relics.ItemUtils;
import sigmit.relicsofthesky.item.relics.ItemUtils.ItemStackChance;

public class RecipeLiquidFilterator {
	
	public static class RLFInput{
		public FluidStack stack;
		public ItemStack mesh;
		public RLFInput(FluidStack stack, ItemStack mesh) {
			this.stack=stack;
			this.mesh=mesh;
		}
		public RLFInput(FluidStack stack, Item mesh) {
			this.stack=stack;
			this.mesh=new ItemStack(mesh);
		}
	}
	public static Map<RLFInput, ItemStackChance[]> map = new HashMap<RLFInput,ItemStackChance[]>();
	public static Map<RLFInput, Integer> mapTime  = new HashMap<RLFInput,Integer>();
	public static void register() {
		addRecipe(FluidRegistry.LAVA, 1000, ItemStack.EMPTY, 5,
				new ItemStackChance(Items.IRON_NUGGET,1, 30),
				new ItemStackChance(new ItemStack(ItemRegistryHandler.ITEM_NUGGET,1,4),40),
				new ItemStackChance(Items.GOLD_NUGGET,1, 5)
				
				);
		addRecipe(FluidRegistry.LAVA, 1000, new ItemStack(ItemRegistryHandler.ITEM_MESH,1,0), 5,
				new ItemStackChance(Items.IRON_NUGGET,1, 70),
				new ItemStackChance(Items.IRON_NUGGET,1, 20),
				new ItemStackChance(new ItemStack(ItemRegistryHandler.ITEM_NUGGET,1,4),40),
				new ItemStackChance(Items.GOLD_NUGGET,1, 5)
				);
	}
	
	
	
	public static void addRecipe(FluidStack fluid, ItemStack mesh, int time, ItemStackChance...chances) {
	
		map.put(new RLFInput(fluid, mesh) , chances);
		mapTime.put(new RLFInput(fluid, mesh), time);
	}
	public static void addRecipe(Fluid fluid, int amount,ItemStack mesh,int time, ItemStackChance...chances) {
		addRecipe(new FluidStack(fluid, amount), mesh,time,chances);
	}
	public static void addRecipe(Fluid fluid, ItemStack mesh, int time,ItemStackChance...chances) {
		addRecipe(new FluidStack(fluid, 1000), mesh,time,chances);
	}
	
	public static RLFInput getRecipeMatch(FluidStack fluid,ItemStack mesh) {
		if(fluid!=null && fluid.amount!=0) {
			
			for(RLFInput input:map.keySet()) {
				if(fluid.containsFluid(input.stack) && (mesh.isItemEqual(input.mesh) || (mesh.isEmpty() && input.mesh.isEmpty()))) {
					return input;
				}
			}
		}
		return null;
	}
	
	public static int getRecipeTime(RLFInput input) {
		for(RLFInput r:mapTime.keySet()) {
			if((r.mesh.isItemEqual(input.mesh) || (r.mesh.isEmpty() && input.mesh.isEmpty()))&& input.stack.isFluidStackIdentical(r.stack)) {
				return mapTime.get(r);
			}
		}
		return 114514;
	}
	
	public static List<ItemStack> getRecipeReturn(RLFInput input) {
		List<ItemStack> list=new ArrayList<ItemStack>();
		for(Map.Entry<RLFInput, ItemStackChance[]> entry:map.entrySet()) {
			if(input.equals(entry.getKey())) {
				for(ItemStackChance isc:entry.getValue()) {
					if(ItemUtils.getChance(isc.chance)) {
						list.add(isc.stack.copy());
					}
				}
				return list;
			}
			
		}
		return null;
	}
}

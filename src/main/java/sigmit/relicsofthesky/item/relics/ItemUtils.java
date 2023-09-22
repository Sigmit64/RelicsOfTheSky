package sigmit.relicsofthesky.item.relics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import scala.annotation.meta.companionClass;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class ItemUtils {
	
	public static Random rand = new Random();
	
	public static boolean getChance(int num) {
		return getChance(num,100);
	}
	
	public static boolean getChance(int num, int max) {
		return num>rand.nextInt(max);
	}
	
	public static void addInfo(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn, String name) {
		String text=I18n.format("tooltip.relicsofthesky."+name);
		
		if(!text.startsWith("tooltip")) {
			

			String[] addList=text.split("~");
			
			for(int i=0;i<addList.length;i++) {
				
				String t=addList[i];
				
				if(t.startsWith("@")) {
					tooltip.add(TextFormatting.AQUA + t.substring(1));
				}else {
					tooltip.add(TextFormatting.YELLOW + t);
				}
				
			}
			
			
		}
		//tooltip.add(TextFormatting.RED+ text);
	}
	
	public static class ItemStackChance{
		public ItemStack stack;
		public int chance;
		public ItemStackChance(ItemStack stack, int chance) {
			this.stack=stack;
			this.chance=chance;
		}
		public ItemStackChance(Item item,int amount, int chance) {
			this.stack=new ItemStack(item,amount);
			this.chance=chance;
		}
		public ItemStackChance(Item item) {
			this.stack=new ItemStack(item,1);
			this.chance=100;
		}
	}
	
	public static class FluidStackChance{
		public FluidStack stack;
		public int chance;
		public FluidStackChance(FluidStack stack, int chance) {
			this.stack=stack;
			this.chance=chance;
		}
		public FluidStackChance(Fluid fluid,int amount, int chance) {
			this.stack=new FluidStack(fluid,amount);
			this.chance=chance;
		}
	}
	/*
	public static class Ingredients{
		public List<FluidStackChance> fluids=new ArrayList<FluidStackChance>();
		public List<ItemStackChance> items=new ArrayList<ItemStackChance>();
		public Ingredients setItems(ItemStack...itemStacks) {
			for(ItemStack stack:itemStacks) {
				items.add(stack)
			}
			return this;
		}
		public Ingredients setFluids(FluidStack...itemStacks) {
			fluids.addAll(items);
			return this;
		}
	}
	*/
}

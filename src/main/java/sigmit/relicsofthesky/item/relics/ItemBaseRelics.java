package sigmit.relicsofthesky.item.relics;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class ItemBaseRelics extends Item{
	public ItemBaseRelics(String name) {
		this.setUnlocalizedName(RelicsOfTheSky.MODID + "." + name);
		this.setRegistryName(name);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
	public ItemBaseRelics(String name, int maxDamage) {
		this.setUnlocalizedName(RelicsOfTheSky.MODID + "." + name);
		this.setRegistryName(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(maxDamage);
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
	public ItemBaseRelics(String name, boolean exhaust) {
		this.setUnlocalizedName(RelicsOfTheSky.MODID + "." + name);
		this.setRegistryName(name);
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativeTabs.MISC);
	}
}

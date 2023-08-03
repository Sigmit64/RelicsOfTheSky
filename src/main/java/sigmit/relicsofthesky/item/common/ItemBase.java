package sigmit.relicsofthesky.item.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class ItemBase extends Item{
	public ItemBase(String name) {
		this.setUnlocalizedName(RelicsOfTheSky.MODID + "." + name);
		this.setRegistryName(name);
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativeTabs.MISC);
	}
}

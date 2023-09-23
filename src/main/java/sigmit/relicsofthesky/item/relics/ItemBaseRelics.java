package sigmit.relicsofthesky.item.relics;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
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
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		ItemUtils.addInfo(stack, worldIn, tooltip, flagIn, this.getUnlocalizedName());
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}

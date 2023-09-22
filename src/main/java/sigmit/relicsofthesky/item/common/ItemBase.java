package sigmit.relicsofthesky.item.common;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.item.relics.ItemUtils;

public class ItemBase extends Item{
	public ItemBase(String name) {
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

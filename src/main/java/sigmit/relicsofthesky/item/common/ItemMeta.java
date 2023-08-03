package sigmit.relicsofthesky.item.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemMeta extends ItemBase{
	private int count=0;
	public ItemMeta(String name,int count) {
		super(name);
		this.hasSubtypes=true;
		this.count=count;
	}

	@Override
	public int getMetadata(int damage) {
		// TODO Auto-generated method stub
		return damage;
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		for(int i=0;i<count;i++) {
			items.add(new ItemStack(this,1,i));
		}
	}

	

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		// TODO Auto-generated method stub
		return super.getUnlocalizedName(stack)+'.'+stack.getMetadata();
	}
}

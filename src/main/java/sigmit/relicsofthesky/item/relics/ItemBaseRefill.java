package sigmit.relicsofthesky.item.relics;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBaseRefill extends ItemBaseRelics{
	public ItemBaseRefill(String name, int maxDamage, int regenerationRate) {
		super(name,maxDamage);
		this.regenerationRate=regenerationRate;
		this.maxDamage=maxDamage;
	}
	
	public int regenerationRate=0;
	public int maxDamage=0;
	
	public int getRegenerationRate() {
		return this.regenerationRate;
	}
	
	public boolean canUse(ItemStack stack, int power ,EntityPlayer player) {
		
		if((this.maxDamage - stack.getItemDamage())>=power){
			stack.damageItem(power, player);
			return true;
		}
		return false;
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(!worldIn.isRemote) {
			if(worldIn.getTotalWorldTime()%20==0) {
				
				stack.setItemDamage(stack.getItemDamage() - (this.regenerationRate * (isSelected?2:1)));
				
			}
		}
		
		
		
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	
}

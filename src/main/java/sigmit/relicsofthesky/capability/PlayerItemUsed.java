package sigmit.relicsofthesky.capability;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public class PlayerItemUsed implements INBTSerializable<NBTTagCompound>{
	
	public static final int MAGIC_COOKIE_ID = 0;
	
	public static final int ITEM_COUNT = 1;
	
	private List<Boolean> usedItems = new ArrayList<Boolean>();
	
	public PlayerItemUsed() {
		for(int i=0;i<ITEM_COUNT;i++) {
			this.usedItems.add(i,false);
		}
	}
	
	public void copy(PlayerItemUsed original) {
		for(int i=0;i<ITEM_COUNT;i++) {
			this.usedItems.set(i, original.getItemUsed(i));
		}
	}
	
	public boolean getItemUsed(int id) {
		return usedItems.get(id)==null ? false :usedItems.get(id);
	}
	
	public void setItemUsed(int id, boolean value) {
		this.usedItems.set(id, value);
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound nbt = new NBTTagCompound();
		for(int i=0;i<ITEM_COUNT;i++) {
			nbt.setBoolean(Integer.toString(i), this.usedItems.get(i));
		}
		return nbt;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		for(int i=0;i<ITEM_COUNT;i++) {
			this.usedItems.set(i, nbt.getBoolean(Integer.toString(i)));
		}
		
	}
	
}

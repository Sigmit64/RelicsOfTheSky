package sigmit.relicsofthesky.item.common;

import java.util.List;
import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.capability.CapabilityRegistryHandler;
import sigmit.relicsofthesky.capability.PlayerItemUsed;
import sigmit.relicsofthesky.network.RelicsGuiHandler;

public class ItemRelicChest extends ItemBase{
	
	
	//public static final int RELIC_IN_A_CHEST = 3;
	
	public ItemRelicChest() {
		super("relic_chest");
		this.setMaxStackSize(1);
	}
	
	public static int getRelicCount(EntityPlayer player) {
		PlayerItemUsed used=player.getCapability(CapabilityRegistryHandler.PLAYER_ITEM_USED, null);
		int baseCount=3;
		if(used==null) return baseCount;
		if(used.getItemUsed(PlayerItemUsed.MAGIC_COOKIE_ID)) baseCount++;
		
		return baseCount;
		
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(!worldIn.isRemote) {
			ItemStack item=playerIn.getHeldItem(handIn);
			
			if(!item.hasTagCompound()){
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setBoolean("opened", true);
				Set<Integer> set=RelicsList.getInt(getRelicCount(playerIn));
				
				nbt.setInteger("relics", RelicsList.pack(set));
				
				//RelicsOfTheSky.logger.info(nbt.toString());
				item.setTagCompound(nbt);
				
			}
			if(handIn.equals(EnumHand.MAIN_HAND)) {
				playerIn.openGui(RelicsOfTheSky.MODID, RelicsGuiHandler.RELIC_CHEST, worldIn, item.getTagCompound().getInteger("relics"),getRelicCount(playerIn),0);
				
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	
	
	

	


	
}

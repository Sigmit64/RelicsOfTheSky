package sigmit.relicsofthesky.network;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.item.common.RelicsList;

public class ContainerRelicChest extends Container{
	
	private EntityPlayer player;
	private World world;
	private boolean canInteract=true;
	private List<Integer> items=new ArrayList<Integer>();

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return canInteract;
	}
	//x=packed relics, y=amount of relics, z unused
	public ContainerRelicChest(EntityPlayer player, World worldIn, int x,int y,int z) {
		InventoryBasic ib = new InventoryBasic("test",false,y);
		Set<Integer> relics=RelicsList.unpack(x);
		for(int i:relics) {
			ib.addItem(RelicsList.getRelics(i));
			items.add(i);
		}
		
		//this.item[0]=relics.;this.item[1]=y;this.item[2]=z;
		this.addSlotToContainer(new Slot(ib,0,80,32));
		this.addSlotToContainer(new Slot(ib,1,134,59));
		this.addSlotToContainer(new Slot(ib,2,26,59));
		this.player=player;
		this.world=worldIn;
	}

	@Override
	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
		//RelicsOfTheSky.logger.info(world.isRemote);
		
		if(!world.isRemote) {
			player.setHeldItem(EnumHand.MAIN_HAND, RelicsList.getRelics(items.get(slotId)));
		}
		this.canInteract=false;
		return ItemStack.EMPTY;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		// TODO Auto-generated method stub
		return ItemStack.EMPTY;
	}

	
	
}

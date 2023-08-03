package sigmit.relicsofthesky.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import sigmit.relicsofthesky.client.network.GuiLiquidFilterator;
import sigmit.relicsofthesky.client.network.GuiMetalPurifier;
import sigmit.relicsofthesky.client.network.GuiRelicChest;

public class RelicsGuiHandler implements IGuiHandler{
	
	public static final int METAL_PURIFIER = 1;
	public static final int RELIC_CHEST = 2;
	public static final int LIQUID_FILTERATOR = 3;
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		if(ID==METAL_PURIFIER) {
			return new ContainerMetalPurifier(player, world,x,y,z);
		}
		if(ID==RELIC_CHEST) {
			return new ContainerRelicChest(player, world,x,y,z);
		}
		if(ID==LIQUID_FILTERATOR) {
			return new ContainerLiquidFilterator(player, world,x,y,z);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		if(ID==METAL_PURIFIER) {
			return new GuiMetalPurifier(player, world,x,y,z);
		}
		if(ID==RELIC_CHEST) {
			return new GuiRelicChest(player, world,x,y,z);
		}
		if(ID==LIQUID_FILTERATOR) {
			return new GuiLiquidFilterator(player, world,x,y,z);
		}
		return null;
	}

}

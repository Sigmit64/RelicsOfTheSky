package sigmit.relicsofthesky.item.common;

import java.util.logging.Level;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class ItemColor implements IItemColor{

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		// TODO Auto-generated method stub
		
		switch(stack.getMetadata()) {
		case 0:
			return 0x114514;
		case 1://copper
			return 0xD2691E;
		case 2://silver
			return 0xE0FFFF;
		case 3://tin
			return 0xB0E0E6;
		case 4://lead
			return 0x4682B4;
		case 5://steel
			return 0x999999;
		default:
			return 0;
		}
	}

}

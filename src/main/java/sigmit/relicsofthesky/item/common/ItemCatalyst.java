package sigmit.relicsofthesky.item.common;

public class ItemCatalyst extends ItemMeta{
	public ItemCatalyst() {
		super("catalyst",2,true);
		
	}
	
	
	



	public static int getChance(int meta) {
		switch(meta) {
		case 0:
			return 50;
		case 1:
			return 30;
		default:
			return 0;
		}
	}
	
	
}

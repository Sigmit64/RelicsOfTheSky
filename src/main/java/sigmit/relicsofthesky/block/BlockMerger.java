package sigmit.relicsofthesky.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class BlockMerger extends Block{
	public BlockMerger() {
		super(Material.GROUND);
		this.setUnlocalizedName(RelicsOfTheSky.MODID + ".merger");
		this.setRegistryName("merger");
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(10.0F);
		
	}
	
	
}

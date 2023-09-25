package sigmit.relicsofthesky.block;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.fluid.FluidRegistryHandler;

public class BlockFluidRainbow extends BlockFluidClassic{
	public BlockFluidRainbow() {
		super(FluidRegistryHandler.FLUID_RAINBOW, Material.WATER);
		//this.setUnlocalizedName(RelicsOfTheSky.MODID + ".fluid_test");
		this.setRegistryName("test");
		
	}
}

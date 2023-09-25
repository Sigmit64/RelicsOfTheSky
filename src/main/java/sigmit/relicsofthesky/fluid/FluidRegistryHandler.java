package sigmit.relicsofthesky.fluid;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.stats.StatCrafting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.block.BlockFluidRainbow;

public class FluidRegistryHandler {
	public static final FluidRainbow FLUID_RAINBOW=new FluidRainbow();
	public static final BlockFluidRainbow BLOCK_FLUID_RAINBOW=new BlockFluidRainbow();
	//public static final Fluid FLUID_RAINBOW=new Fluid("rainbow", new ResourceLocation("blocks/rainbow_still"), new ResourceLocation("blocks/rainbow_still")).setGaseous(false).setDensity(Integer.MAX_VALUE);
	public static void register() {
		//FluidRegistry.registerFluid(FLUID_TEST);
		FluidRegistry.addBucketForFluid(FLUID_RAINBOW);
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerModel() {
		FLUID_RAINBOW.initModel();
	}
}

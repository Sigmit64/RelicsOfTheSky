package sigmit.relicsofthesky.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidRegistryHandler {
	public static final Fluid FLUID_RAINBOW=new Fluid("rainbow", new ResourceLocation("blocks/rainbow_still"), new ResourceLocation("blocks/rainbow_still")).setGaseous(false).setDensity(Integer.MAX_VALUE);
	public static void register() {
		FluidRegistry.registerFluid(FLUID_RAINBOW);
		FluidRegistry.addBucketForFluid(FLUID_RAINBOW);
	}
}

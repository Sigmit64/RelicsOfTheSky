package sigmit.relicsofthesky.tileentity;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class TileEntityWaterGenerator extends TileEntityFluidPassiveGenerator{
	public static final String ID = RelicsOfTheSky.MODID + ":water_generator";
	@Override
	public int getTick() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public FluidStack getFluidStack() {
		// TODO Auto-generated method stub
		return new FluidStack(FluidRegistry.WATER, 1000);
	}

}

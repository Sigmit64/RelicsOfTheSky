package sigmit.relicsofthesky.fluid;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class FluidMap {
	public static Map<Fluid, Integer> map = new HashMap<Fluid,Integer>();
	public static int maxFluid=0;
	
	public static int getFluidID(Fluid fluid) {
		if(map.containsKey(fluid)) {
			return map.get(fluid);
		}else {
			map.put(fluid, maxFluid);
			maxFluid++;
			return maxFluid-1;
			
			
		}
	}
	public static Fluid getFluidFromID(int ID) {
		for(Map.Entry<Fluid, Integer> entry: map.entrySet()) {
			if(entry.getValue()==ID) {
				return entry.getKey();
			}
		}
		return null;
	}
}

package sigmit.relicsofthesky.fluid;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition{
	
	public final Fluid fluid;
	public final ModelResourceLocation location;
	
	public FluidStateMapper(Fluid fluid) {
		this.fluid=fluid;
		this.location=new ModelResourceLocation(new ResourceLocation(RelicsOfTheSky.MODID,"fluid_block"), fluid.getName());
	}

	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) {
		// TODO Auto-generated method stub
		return location;
	}

	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		// TODO Auto-generated method stub
		return location;
	}

}

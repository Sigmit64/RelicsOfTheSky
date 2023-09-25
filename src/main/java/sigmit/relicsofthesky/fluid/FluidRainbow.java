package sigmit.relicsofthesky.fluid;


import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sigmit.relicsofthesky.RelicsOfTheSky;

public class FluidRainbow extends Fluid{
	public FluidRainbow() {
		super("rainbow", new ResourceLocation(RelicsOfTheSky.MODID+":blocks/rainbow_still"),new ResourceLocation(RelicsOfTheSky.MODID+":blocks/rainbow_flow"));
		FluidRegistry.registerFluid(this);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		Block block=this.getBlock();
		FluidStateMapper fluidStateMapper=new FluidStateMapper(this);
		Item item = Item.getItemFromBlock(block);
		if(item!=Items.AIR) {
			ModelLoader.registerItemVariants(item);
			ModelLoader.setCustomMeshDefinition(item, fluidStateMapper);
		}
		//RelicsOfTheSky.logger.info(block);
		ModelLoader.setCustomStateMapper(block, fluidStateMapper);
	
	}
}

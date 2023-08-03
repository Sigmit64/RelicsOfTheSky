package sigmit.relicsofthesky.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidUtil;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.tileentity.TileEntityLavaGenerator;
import sigmit.relicsofthesky.tileentity.TileEntityWaterGenerator;

public class BlockLavaGenerator extends BlockContainer{
	public BlockLavaGenerator() {
		super(Material.GLASS);
		this.setUnlocalizedName(RelicsOfTheSky.MODID + ".lava_generator");
		this.setRegistryName("lava_generator");
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(0.5F);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityLavaGenerator();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		FluidUtil.interactWithFluidHandler(playerIn, hand, worldIn, pos, facing);
		return true;
	}
	
	
}

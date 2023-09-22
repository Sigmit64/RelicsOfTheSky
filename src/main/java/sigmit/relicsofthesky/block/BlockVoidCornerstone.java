package sigmit.relicsofthesky.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.tileentity.TileEntityVoidCornerstone;

public class BlockVoidCornerstone extends BlockContainer{
	public BlockVoidCornerstone() {
		super(Material.ROCK);
		this.setUnlocalizedName(RelicsOfTheSky.MODID + ".void_cornerstone");
		this.setRegistryName("void_cornerstone");
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(3.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityVoidCornerstone();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
	
	


	
	
}

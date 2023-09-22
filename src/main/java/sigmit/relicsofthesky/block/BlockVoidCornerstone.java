package sigmit.relicsofthesky.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.item.relics.ItemUtils;
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
	
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		ItemUtils.addInfo(stack, worldIn, tooltip, flagIn, this.getUnlocalizedName());
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	
	
}

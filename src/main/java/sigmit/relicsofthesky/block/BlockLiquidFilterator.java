package sigmit.relicsofthesky.block;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.items.ItemStackHandler;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.item.relics.ItemUtils;
import sigmit.relicsofthesky.network.RelicsGuiHandler;
import sigmit.relicsofthesky.tileentity.TileEntityLiquidFilterator;

public class BlockLiquidFilterator extends BlockContainer{
	public static final IProperty<EnumFacing> FACING = PropertyDirection.create("facing",EnumFacing.Plane.HORIZONTAL);

	public BlockLiquidFilterator() {
		super(Material.ROCK);
		this.setUnlocalizedName(RelicsOfTheSky.MODID + ".liquid_filterator");
		this.setRegistryName("liquid_filterator");
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(3.5F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		// TODO Auto-generated method stub
		return new BlockStateContainer(this,FACING);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		// TODO Auto-generated method stub
		return state.getValue(FACING).getHorizontalIndex();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		// TODO Auto-generated method stub
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		// TODO Auto-generated method stub
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityLiquidFilterator();
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
	
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// TODO Auto-generated method stub
		TileEntity te=worldIn.getTileEntity(pos);
		if(!worldIn.isRemote && te instanceof TileEntityLiquidFilterator) {
			ItemStack stack=playerIn.getHeldItem(hand);
			FluidStack fluidStack=FluidUtil.getFluidContained(stack);
			if(fluidStack!=null) {
				FluidActionResult result=FluidUtil.tryEmptyContainer(stack, FluidUtil.getFluidHandler(worldIn, pos, null), 1000, playerIn, true);
				if(result.isSuccess()) {
					if(!playerIn.capabilities.isCreativeMode) {
						playerIn.setHeldItem(hand, result.result);
					}
					return true;
				}
			}
			int x=pos.getX(),y=pos.getY(),z=pos.getZ();
			playerIn.openGui(RelicsOfTheSky.MODID, RelicsGuiHandler.LIQUID_FILTERATOR, worldIn, x, y, z);
		}
		return true;
	}
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		ItemUtils.addInfo(stack, worldIn, tooltip, flagIn, this.getUnlocalizedName());
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}

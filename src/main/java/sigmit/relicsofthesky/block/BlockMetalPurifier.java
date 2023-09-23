package sigmit.relicsofthesky.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.item.relics.ItemUtils;
import sigmit.relicsofthesky.network.RelicsGuiHandler;
import sigmit.relicsofthesky.tileentity.TileEntityMetalPurifier;

public class BlockMetalPurifier extends BlockContainer{
	
	public static final IProperty<EnumFacing> FACING = PropertyDirection.create("facing",EnumFacing.Plane.HORIZONTAL);
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		ItemUtils.addInfo(stack, worldIn, tooltip, flagIn, this.getUnlocalizedName());
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	public BlockMetalPurifier() {
		super(Material.ROCK);
		this.setUnlocalizedName(RelicsOfTheSky.MODID + ".metal_purifier");
		this.setRegistryName("metal_purifier");
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
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// TODO Auto-generated method stub
		if(!worldIn.isRemote) {
			int x=pos.getX(),y=pos.getY(),z=pos.getZ();
			playerIn.openGui(RelicsOfTheSky.MODID, RelicsGuiHandler.METAL_PURIFIER, worldIn, x, y, z);
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityMetalPurifier();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        Capability<IItemHandler> itemHandlerCapability = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;

        IItemHandler up = tileEntity.getCapability(itemHandlerCapability, EnumFacing.UP);
        IItemHandler down = tileEntity.getCapability(itemHandlerCapability, EnumFacing.DOWN);
        IItemHandler side = tileEntity.getCapability(itemHandlerCapability, EnumFacing.NORTH);

        Block.spawnAsEntity(worldIn, pos, up.getStackInSlot(0));
        Block.spawnAsEntity(worldIn, pos, down.getStackInSlot(0));
        Block.spawnAsEntity(worldIn, pos, side.getStackInSlot(0));

        super.breakBlock(worldIn, pos, state);
    }

	 @Override
	 public boolean isFullCube(IBlockState state)
	    {
	        return false;
	    }
	 @Override
	 public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	    {
	        return BlockFaceShape.UNDEFINED;
	    }
	 @Override
	 public boolean isOpaqueCube(IBlockState state)
	    {
	        return false;
	    }

	
	
	
}

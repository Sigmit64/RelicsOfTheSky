package sigmit.relicsofthesky.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.tileentity.TileEntitySandOfTime;

public class BlockSandOfTime extends BlockContainer{

	protected BlockSandOfTime() {
		super(Material.SAND);
		this.setUnlocalizedName(RelicsOfTheSky.MODID + ".sand_of_time");
		this.setRegistryName("sand_of_time");
		this.setHarvestLevel("shovel", 0);
		this.setHardness(0.5F);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntitySandOfTime();
		
		
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if(world.isRemote)
    	{
    		return true;
    	}
    	
    	TileEntity tile = world.getTileEntity(pos);
    	
    	if(tile != null && tile instanceof TileEntitySandOfTime)
    	{
    		TileEntitySandOfTime stile = (TileEntitySandOfTime) tile;
    		
    		if(!player.isSneaking())
    		{
        		ItemStack stack = stile.output.getStackInSlot(0);
        		stile.output.setStackInSlot(0, ItemStack.EMPTY);
        		
	    		if(stack != null)
	    		{
		    		if(!player.inventory.addItemStackToInventory(stack))
		    		{		    			
		    			//player.dropItem(stack, false);
		    			ForgeHooks.onPlayerTossEvent(player, stack, false);
		    		}
	    		}
    		} else
    		{
        		ItemStack stack = stile.output.getStackInSlot(0);
    			player.sendMessage(new TextComponentString(stack.getDisplayName() + " x " + (stack.isEmpty()? 0 : stack.getCount())));
    		}
    	}
    	
        return true;
    }
}

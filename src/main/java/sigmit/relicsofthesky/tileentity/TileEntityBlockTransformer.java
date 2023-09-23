package sigmit.relicsofthesky.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import sigmit.relicsofthesky.item.relics.ItemUtils;
import sigmit.relicsofthesky.item.relics.ItemUtils.ItemStackChance;
import sigmit.relicsofthesky.recipe.BlockTransformerMap;

public abstract class TileEntityBlockTransformer extends TileEntity implements ITickable{
	
	public abstract BlockTransformerMap getBlockTransformerMap();
	
	public abstract ItemStackChance getPassiveGeneration();
	
	private int tick=0;

	@Override
	public void update() {
		if(world.isRemote) return;
		if(tick<20) {
			tick+=1;
			return;
		}
		//RelicsOfTheSky.logger.info("Triggered");
		tick=0;
		IBlockState block=world.getBlockState(this.pos.up());
		if(block==null || block.getBlock().equals(Blocks.AIR)) {
			ItemStackChance isc=getPassiveGeneration();
			if(isc!=null) {
				if(ItemUtils.getChance(isc.chance)) {
					world.spawnEntity(new EntityItem(world, pos.getX(), pos.up().getY(), pos.getZ(), isc.stack.copy()));
					world.playEvent(2003, pos.up(), 0);
				}
			}
			return;
		}
		
		
		BlockTransformerMap map=getBlockTransformerMap();
		IBlockState newBlockState=map.getBlock(block);
		if(!block.equals(newBlockState)) {
			world.playEvent(2001, pos.up(), Block.getStateId(block));
			world.setBlockState(pos.up(), newBlockState);
			world.playEvent(2003, pos.up(), 0);
			
		}
	}

}

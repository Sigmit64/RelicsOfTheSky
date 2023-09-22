package sigmit.relicsofthesky.recipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import sigmit.relicsofthesky.item.relics.ItemUtils;



public class BlockTransformerMap {
	
	public Map<IBlockState, BlockChance> map=new HashMap<IBlockState,BlockChance>();
	
	public BlockTransformerMap addRecipe(IBlockState block,BlockChance blockChance) {
		map.put(block,blockChance);
		return this;
	}
	
	public BlockTransformerMap addRecipe(IBlockState block,IBlockState block2,int chance) {
		map.put(block,new BlockChance(block2,chance));
		return this;
	}
	
	public static class BlockChance {
		public IBlockState block;
		public int chance;
		public BlockChance(IBlockState block, int chance) {
			this.block=block;
			this.chance=chance;
		}
		public BlockChance(Block block, int chance) {
			this.block=block.getDefaultState();
			this.chance=chance;
		}
	}
	
	public IBlockState getBlock(IBlockState input) {
		if(!map.containsKey(input)) return input;
		
		int chance=map.get(input).chance;
		if(ItemUtils.getChance(chance)) {
			return map.get(input).block;
		}
		return input;
	}
	
}

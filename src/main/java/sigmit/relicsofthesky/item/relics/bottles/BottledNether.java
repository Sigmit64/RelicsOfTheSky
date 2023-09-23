package sigmit.relicsofthesky.item.relics.bottles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import sigmit.relicsofthesky.entity.EntityBottledNether;
import sigmit.relicsofthesky.item.relics.ItemBaseRelics;

public class BottledNether extends ItemBaseRelics{
	public BottledNether() {
		super("bottled_nether",true);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack=playerIn.getHeldItem(handIn);
		if(!playerIn.capabilities.isCreativeMode) {
			stack.shrink(1);
		}
		
		if(worldIn.isRemote) {
			return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
		}
		
		worldIn.playSound((EntityPlayer)null, playerIn.getPosition(), SoundEvents.ENTITY_SNOWBALL_THROW,SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		EntityBottledNether bottledNether = new EntityBottledNether(worldIn,playerIn);
		float pitch = playerIn.rotationPitch;
		float yaw = playerIn.rotationYaw;
		bottledNether.shoot(playerIn, pitch, yaw, 0.0F, 1.5F, 0.5F);
		worldIn.spawnEntity(bottledNether);
		return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
	}
	
	
}

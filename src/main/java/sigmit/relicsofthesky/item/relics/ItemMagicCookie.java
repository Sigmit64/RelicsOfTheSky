package sigmit.relicsofthesky.item.relics;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.capability.CapabilityRegistryHandler;
import sigmit.relicsofthesky.capability.PlayerItemUsed;
import sigmit.relicsofthesky.capability.PlayerItemUsedProvider;


public class ItemMagicCookie extends ItemFood{
	public ItemMagicCookie() {
		super(4,1.2F,false);
		this.setAlwaysEdible();
		this.setUnlocalizedName(RelicsOfTheSky.MODID + "." + "magic_cookie");
		this.setRegistryName("magic_cookie");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
	




	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if(!worldIn.isRemote) {
			PlayerItemUsed used=player.getCapability(CapabilityRegistryHandler.PLAYER_ITEM_USED, null);
			if(used==null) {
				RelicsOfTheSky.logger.info("Capability is null AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			}
			if(used.getItemUsed(PlayerItemUsed.MAGIC_COOKIE_ID)) {
				player.sendMessage(new TextComponentString(I18n.format("text.relicsofthesky.magic_cookie.used")));
			} else {
				used.setItemUsed(PlayerItemUsed.MAGIC_COOKIE_ID, true);
				player.sendMessage(new TextComponentString(I18n.format("text.relicsofthesky.magic_cookie.on_use")));
				
			}
		}
		
		super.onFoodEaten(stack, worldIn, player);
	}
	
	
}

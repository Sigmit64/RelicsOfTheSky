package sigmit.relicsofthesky.client.network;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.fluid.FluidMap;
import sigmit.relicsofthesky.fluid.FluidRenderUtils;
import sigmit.relicsofthesky.network.ContainerLiquidFilterator;

@SideOnly(Side.CLIENT)
public class GuiLiquidFilterator extends GuiContainer{

	private static final ResourceLocation TEXTURE=new ResourceLocation(RelicsOfTheSky.MODID + ":textures/gui/container/liquid_filterator.png");
	private World world;
	private BlockPos pos;
	
	public GuiLiquidFilterator(EntityPlayer player, World world, int x, int y,int z) {
		super(new ContainerLiquidFilterator(player, world,x,y,z));
		this.xSize=176;
		this.ySize=178;
		this.world=world;
		this.pos=new BlockPos(x,y,z);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		// TODO Auto-generated method stub
		super.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		super.renderHoveredToolTip(mouseX, mouseY);
		
	}

	


	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		int left=(this.width-this.xSize)/2;
		int top=(this.height-this.ySize)/2;
		GlStateManager.color(1.0F,1.0F,1.0F,1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(left, top, 0, 0, this.xSize, this.ySize);
		int progress=((ContainerLiquidFilterator) this.inventorySlots ).getProgress();
		if(progress<=50) {
			this.drawTexturedModalRect(left+48, top+44, 3, 181, (int) Math.round(progress/50.0*9.0), 10);
		}else {
			this.drawTexturedModalRect(left+48, top+44, 3, 181, 9, 10);
			this.drawTexturedModalRect(left+77, top+41, 32, 179, (int) Math.round((progress-50)/50.0*12.0),16);
		}
		
		int amount=((ContainerLiquidFilterator) this.inventorySlots ).getAmount();
		int fluidID=((ContainerLiquidFilterator) this.inventorySlots ).getID();
		//RelicsOfTheSky.logger.info(amount);
		Fluid fluid=FluidMap.getFluidFromID(fluidID);
		//RelicsOfTheSky.logger.info(fluid);
		if(fluid!=null && amount>0) {
			//TextureAtlasSprite fluidSprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(fluid.getStill().toString());
			this.zLevel++;
			this.drawTexturedModalRect(left+26, top+23, 26, 23, 16, 52-(int)(amount*52.0/8000.0));
			this.zLevel--;
			FluidRenderUtils.renderTiledFluid(left + 26, top + 75-(int)(amount*52.0/8000.0), 16, (int)(amount*52.0/8000.0), 0.0F, new FluidStack(fluid, amount));
			
			
		}
		
		
		
	}


	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
		String text=I18n.format("tile.relicsofthesky.liquid_filterator.name");
		//this.drawCenteredString(this.fontRenderer, text, this.xSize/2, 6, 0x00303030);
		this.fontRenderer.drawString(text, (this.xSize/2 - this.fontRenderer.getStringWidth(text) / 2), 6, 0x00303030);
	}

	
}

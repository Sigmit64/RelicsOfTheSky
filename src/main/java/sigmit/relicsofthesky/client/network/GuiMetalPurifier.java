package sigmit.relicsofthesky.client.network;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.network.ContainerMetalPurifier;

@SideOnly(Side.CLIENT)
public class GuiMetalPurifier extends GuiContainer{

	private static final ResourceLocation TEXTURE=new ResourceLocation(RelicsOfTheSky.MODID + ":textures/gui/container/metal_purifier.png");
	
	public GuiMetalPurifier(EntityPlayer player, World world, int x, int y,int z) {
		super(new ContainerMetalPurifier(player, world,x,y,z));
		this.xSize=176;
		this.ySize=176;
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
		int barHeight=12;
		int barWidth=Math.round(((ContainerMetalPurifier) this.inventorySlots ).getProgress() *46.0F/240.0F);
		this.drawTexturedModalRect(left+66, top+61, 4, 177, barWidth,barHeight);
	}


	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		String text=I18n.format("tile.relicsofthesky.metal_purifier.name");
		//this.drawCenteredString(this.fontRenderer, text, this.xSize/2, 6, 0x00303030);
		this.fontRenderer.drawString(text, (this.xSize/2 - this.fontRenderer.getStringWidth(text) / 2), 6, 0x00303030);
	}

	
}

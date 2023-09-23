package sigmit.relicsofthesky.client.network;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.network.ContainerEnergyStorage;

public class GuiEnergyStorage extends GuiContainer{
	
	private static final ResourceLocation TEXTURE=new ResourceLocation(RelicsOfTheSky.MODID + ":textures/gui/container/energy_storage.png");
	private World world;
	private BlockPos pos;

	public GuiEnergyStorage(EntityPlayer player, World world, int x, int y,int z) {
		super(new ContainerEnergyStorage(player, world,x,y,z));
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
		int energy=((ContainerEnergyStorage) this.inventorySlots ).getEnergy();
		int capacity=((ContainerEnergyStorage) this.inventorySlots ).getCapacity();
		
		if(energy!=0 && capacity!=0) {
			this.drawGradientRect(left+26, (int)(top+23+52-(energy*52.0/capacity)), left+26+16, top+23+52, 0xFF00D151, 0xFFA4F9C6);
			//this.drawRect(left+36, top+23, left+36+16, top+23+52, 0x66EE66);
			//this.drawTexturedModalRect(left+36, top+23, 3, 181, (int) Math.round(energy/50.0*9.0), 10);
		}
			
		
		
		
		
		
		
	}


	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
		String text=I18n.format("tile.relicsofthesky.energy_storage.name");
		//this.drawCenteredString(this.fontRenderer, text, this.xSize/2, 6, 0x00303030);
		this.fontRenderer.drawString(text, (this.xSize/2 - this.fontRenderer.getStringWidth(text) / 2), 6, 0x00303030);
	}

}

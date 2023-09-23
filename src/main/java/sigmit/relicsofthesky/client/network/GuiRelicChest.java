package sigmit.relicsofthesky.client.network;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import sigmit.relicsofthesky.RelicsOfTheSky;
import sigmit.relicsofthesky.network.ContainerRelicChest;

public class GuiRelicChest extends GuiContainer{
	private static final ResourceLocation TEXTURE_3=new ResourceLocation(RelicsOfTheSky.MODID + ":textures/gui/container/relic_chest_3.png");
	private static final ResourceLocation TEXTURE_4=new ResourceLocation(RelicsOfTheSky.MODID + ":textures/gui/container/relic_chest_4.png");
	private static final ResourceLocation TEXTURE_5=new ResourceLocation(RelicsOfTheSky.MODID + ":textures/gui/container/relic_chest_5.png");
	
	private EntityPlayer player;
	private World world;
	private int count;
	public GuiRelicChest(EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated constructor stub
		super(new ContainerRelicChest(player,world,x,y,z));
		this.xSize=176;
		this.ySize=95;
		this.player=player;
		this.world=world;
		this.count=y;
	}
	
	private ResourceLocation getTexture() {
		switch(this.count) {
		case 3:
			return TEXTURE_3;
		case 4:
			return TEXTURE_4;
		case 5:
			return TEXTURE_5;
		}
		return TEXTURE_3;
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
		this.mc.getTextureManager().bindTexture(getTexture());
		this.drawTexturedModalRect(left, top, 0, 0, this.xSize, this.ySize);
	}


	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		String text=I18n.format("text.relicsofthesky.choose_your_reward");
		//this.drawCenteredString(this.fontRenderer, text, this.xSize/2, 6, 0x00303030);
		this.fontRenderer.drawString(text, (this.xSize/2 - this.fontRenderer.getStringWidth(text) / 2), 6, 0x00303030);
		
	
	
	}

}

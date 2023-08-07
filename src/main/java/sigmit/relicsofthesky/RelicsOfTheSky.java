package sigmit.relicsofthesky;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sigmit.relicsofthesky.capability.CapabilityRegistryHandler;
import sigmit.relicsofthesky.entity.EntityBottledNether;
import sigmit.relicsofthesky.fluid.FluidRegistryHandler;
import sigmit.relicsofthesky.item.common.RelicsList;
import sigmit.relicsofthesky.item.relics.ItemRegistryHandler;
import sigmit.relicsofthesky.network.NetworkRegistryHandler;
import sigmit.relicsofthesky.recipe.OreDictRegistry;
import sigmit.relicsofthesky.recipe.RecipeManager;
import sigmit.relicsofthesky.render.RenderRegistryHandler;

import org.apache.logging.log4j.Logger;

@Mod(modid = RelicsOfTheSky.MODID, name = RelicsOfTheSky.NAME, version = RelicsOfTheSky.VERSION)
public class RelicsOfTheSky
{
    public static final String MODID = "relicsofthesky";
    public static final String NAME = "Relics of the Sky";
    public static final String VERSION = "1.0";

    public static Logger logger;
    
    public RelicsOfTheSky() {
    	FluidRegistry.enableUniversalBucket();
	}

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	logger = event.getModLog();
    	NetworkRegistryHandler.register();
        RecipeManager.registerRecipes();
        CapabilityRegistryHandler.register();
        //FluidRegistryHandler.register();
    }
    
    @EventHandler
    @SideOnly(Side.CLIENT)
    public void preInitClient(FMLPreInitializationEvent event)
    {
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityBottledNether.class,manager->new RenderSnowball<>(manager,ItemRegistryHandler.ITEM_BOTTLED_NETHER,Minecraft.getMinecraft().getRenderItem()));
		
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    	OreDictRegistry.OreDictRegister();
        // some example code
        //logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}

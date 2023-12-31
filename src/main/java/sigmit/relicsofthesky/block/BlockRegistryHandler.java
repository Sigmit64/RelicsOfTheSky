package sigmit.relicsofthesky.block;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import sigmit.relicsofthesky.fluid.FluidRegistryHandler;
import sigmit.relicsofthesky.tileentity.TileEntityEnergyStorage;
import sigmit.relicsofthesky.tileentity.TileEntityLavaGenerator;
import sigmit.relicsofthesky.tileentity.TileEntityLiquidFilterator;
import sigmit.relicsofthesky.tileentity.TileEntityMetalPurifier;
import sigmit.relicsofthesky.tileentity.TileEntitySandOfInfinity;
import sigmit.relicsofthesky.tileentity.TileEntitySandOfTime;
import sigmit.relicsofthesky.tileentity.TileEntitySandOfTimeCompressed;
import sigmit.relicsofthesky.tileentity.TileEntityVoidCornerstone;
import sigmit.relicsofthesky.tileentity.TileEntityWaterGenerator;

@EventBusSubscriber
public class BlockRegistryHandler {
	//public static final BlockMerger BLOCK_MERGER = new BlockMerger();
	public static final BlockSandOfTime BLOCK_SAND_OF_TIME = new BlockSandOfTime();
	public static final BlockSandOfTimeCompressed BLOCK_SAND_OF_TIME_COMPRESSED = new BlockSandOfTimeCompressed();
	public static final BlockSandOfInfinity BLOCK_SAND_OF_INFINITY = new BlockSandOfInfinity();
	public static final BlockMetalPurifier BLOCK_METAL_PURIFIER = new BlockMetalPurifier();
	public static final BlockLiquidFilterator BLOCK_LIQUID_FILTERATOR = new BlockLiquidFilterator();
	public static final BlockWaterGenerator BLOCK_WATER_GENERATOR = new BlockWaterGenerator();
	public static final BlockLavaGenerator BLOCK_LAVA_GENERATOR = new BlockLavaGenerator();
	public static final BlockVoidCornerstone BLOCK_VOID_CORNERSTONE = new BlockVoidCornerstone();
	public static final BlockEnergyStorage BLOCK_ENERGY_STORAGE = new BlockEnergyStorage();
	
	//public static final BlockFluidTest BLOCK_FLUID_TEST = new BlockFluidTest();
	
	@SubscribeEvent
	public static void onRegistry(Register<Block> event) {
		
		IForgeRegistry<Block> registry=event.getRegistry();
		registry.registerAll(
			//BLOCK_MERGER,
			BLOCK_METAL_PURIFIER,
			BLOCK_SAND_OF_TIME,
			BLOCK_SAND_OF_TIME_COMPRESSED,
			BLOCK_SAND_OF_INFINITY,
			BLOCK_LIQUID_FILTERATOR,
			BLOCK_WATER_GENERATOR,
			BLOCK_LAVA_GENERATOR,
			BLOCK_VOID_CORNERSTONE,
			BLOCK_ENERGY_STORAGE,
			
			FluidRegistryHandler.BLOCK_FLUID_RAINBOW
		);
		TileEntity.register(TileEntityMetalPurifier.ID, TileEntityMetalPurifier.class);
		TileEntity.register(TileEntitySandOfTime.ID, TileEntitySandOfTime.class);
		TileEntity.register(TileEntitySandOfInfinity.ID, TileEntitySandOfInfinity.class);
		TileEntity.register(TileEntitySandOfTimeCompressed.ID, TileEntitySandOfTimeCompressed.class);
		TileEntity.register(TileEntityLiquidFilterator.ID, TileEntityLiquidFilterator.class);
		TileEntity.register(TileEntityWaterGenerator.ID, TileEntityWaterGenerator.class);
		TileEntity.register(TileEntityLavaGenerator.ID, TileEntityLavaGenerator.class);
		TileEntity.register(TileEntityVoidCornerstone.ID, TileEntityVoidCornerstone.class);
		TileEntity.register(TileEntityEnergyStorage.ID, TileEntityEnergyStorage.class);
	}
}

package com.bixel.rec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bixel.rec.init.BlockRegister;
import com.bixel.rec.init.ClientSetup;
import com.bixel.rec.init.ContainerRegister;
import com.bixel.rec.init.ItemRegister;
import com.bixel.rec.init.ModSetup;
import com.bixel.rec.init.TileEntityRegister;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("recdec")
public class RecDecMod
{
	public static RecDecMod instance;
	public static final String MOD_ID = "recdec";
	public static final String MOD_NAME = "Bixel's Decoration Mod";

	public static final String VERSION = "0.1.0";
	
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
    public static ResourceLocation loc(String name)
    {
    	return new ResourceLocation(MOD_ID, name);
    }

    public RecDecMod() 
    {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
    	BlockRegister.BLOCKS.register(modEventBus);
    	ItemRegister.ITEMS.register(modEventBus);
    	TileEntityRegister.TILE_ENTITY_TYPES.register(modEventBus);
        ContainerRegister.CONTAINER_TYPES.register(modEventBus);
    	
    	modEventBus.addListener(ModSetup::init);
    	modEventBus.addListener(ClientSetup::init);
    	instance = this;
    }

    /*
    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
    	//registers the gui to the container
    	//ScreenManager.registerFactory(ContainerRegister.EXAMPLE_CHEST.get(), ExampleChestScreen::new);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("recdec", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
    }*/
    
    //done before the server starts...
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event)
    {
    	//OreGen.GenerateOre();
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {

    }
}

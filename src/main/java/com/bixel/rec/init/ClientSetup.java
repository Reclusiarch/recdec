package com.bixel.rec.init;

import com.bixel.rec.RecDecMod;
import com.bixel.rec.client.gui.VillageBarrelScreen;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

//https://github.com/McJty/YouTubeModding14/blob/master/src/main/java/com/mcjty/mytutorial/setup/ClientSetup.java
@Mod.EventBusSubscriber(modid = RecDecMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup 
{
    public static void init(final FMLClientSetupEvent event) 
    {
        ScreenManager.registerFactory(ContainerRegister.VILLAGE_BARREL.get(), VillageBarrelScreen::new);
    }
    
    @SubscribeEvent
    public void onTooltipPre(RenderTooltipEvent.Pre event) 
    {
        Item item = event.getStack().getItem();
        if (item.getRegistryName().getNamespace().equals(RecDecMod.MOD_ID)) 
        {
            event.setMaxWidth(200);
        }
    }
}

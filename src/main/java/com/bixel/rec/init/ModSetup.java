package com.bixel.rec.init;

import com.bixel.rec.RecDecMod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = RecDecMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class ModSetup 
{
	public static ItemGroup itemGroup = new ItemGroup("recdec")
	{
	    @Override
	    public ItemStack createIcon() 
	    {
	    	//return new ItemStack(BlockInit.chiseled_stone_cross);
	        return new ItemStack(BlockRegister.CHISELED_STONE_CROSS.get());
	    }
	};
	
    public static void init(final FMLCommonSetupEvent event) 
    {
    	//explore this
    	//https://github.com/McJty/YouTubeModding14/tree/master/src/main/java/com/mcjty/mytutorial/network
        //Networking.registerMessages();
    }
}

package com.bixel.rec.init;

import com.bixel.rec.RecDecMod;
import com.bixel.rec.container.VillageBarrelContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Register after Tile types
 * @author Bixel
 *
 */
public class ContainerRegister 
{
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, RecDecMod.MOD_ID);
	
	public static final RegistryObject<ContainerType<VillageBarrelContainer>> VILLAGE_BARREL = CONTAINER_TYPES.register("village_barrel",
			() -> IForgeContainerType.create(VillageBarrelContainer::new));
}

package com.bixel.rec.init;

import com.bixel.rec.RecDecMod;
import com.bixel.rec.tileentities.ExampleChestTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Register TileEntity before Containers
 * @author Bixel
 *
 */
public class TileEntityRegister 
{
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, RecDecMod.MOD_ID);
	
	public static final RegistryObject<TileEntityType<ExampleChestTileEntity>> EXAMPLE_CHEST = TILE_ENTITY_TYPES.register("example_chest",
			() -> TileEntityType.Builder.create(ExampleChestTileEntity::new, BlockRegister.EXAMPLE_CHEST.get()).build(null));
}

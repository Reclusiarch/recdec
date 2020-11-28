package com.bixel.rec.init;

import com.bixel.rec.RecDecMod;
import com.bixel.rec.tiles.VillageBarrelTileEntity;

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
	
	public static final RegistryObject<TileEntityType<VillageBarrelTileEntity>> VILLAGE_BARREL = TILE_ENTITY_TYPES.register("village_barrel",
			() -> TileEntityType.Builder.create(VillageBarrelTileEntity::new, BlockRegister.VILLAGE_BARREL.get()).build(null));
}

package com.bixel.rec.init;

import com.bixel.rec.RecDecMod;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegister 
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RecDecMod.MOD_ID);
	
	public static final RegistryObject<Item> STONE_BRICKS_DIRTY = ITEMS.register("stone_bricks_dirty", () -> 
		new BlockItem(BlockRegister.STONE_BRICKS_DIRTY.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> STONE_BRICKS_SANDY = ITEMS.register("stone_bricks_sandy", () -> 
		new BlockItem(BlockRegister.STONE_BRICKS_SANDY.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> STONE_BRICKS_SANDY_RED = ITEMS.register("stone_bricks_sandy_red", () -> 
		new BlockItem(BlockRegister.STONE_BRICKS_SANDY_RED.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> CHISELED_STONE_CROSS = ITEMS.register("chiseled_stone_cross", () -> 
		new BlockItem(BlockRegister.CHISELED_STONE_CROSS.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> CHISELED_STONE_CROSS_THICK = ITEMS.register("chiseled_stone_cross_thick", () -> 
		new BlockItem(BlockRegister.CHISELED_STONE_CROSS_THICK.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> STONE_CROSS_BRICKS = ITEMS.register("stone_cross_bricks", () -> 
		new BlockItem(BlockRegister.STONE_CROSS_BRICKS.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> STONE_CENTERCROSS_BRICKS = ITEMS.register("stone_centercross_bricks", () -> 
		new BlockItem(BlockRegister.STONE_CENTERCROSS_BRICKS.get(), new Item.Properties().group(ModSetup.itemGroup)));
	
	public static final RegistryObject<Item> DUNGEON_BRAZIER = ITEMS.register("dungeon_brazier", () -> 
		new BlockItem(BlockRegister.DUNGEON_BRAZIER.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> VILLAGE_BARREL = ITEMS.register("village_barrel", () -> 
		new BlockItem(BlockRegister.VILLAGE_BARREL.get(), new Item.Properties().group(ModSetup.itemGroup)));
	
	public static final RegistryObject<Item> EXAMPLE_CHEST = ITEMS.register("example_chest", () -> 
		new BlockItem(BlockRegister.EXAMPLE_CHEST.get(), new Item.Properties().group(ModSetup.itemGroup)));
}

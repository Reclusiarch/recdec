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
	public static final RegistryObject<Item> CHISELED_FLAG_STONE = ITEMS.register("chiseled_flag_stone", () -> 
		new BlockItem(BlockRegister.CHISELED_FLAG_STONE.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> FLAG_STONE = ITEMS.register("flag_stone", () -> 
		new BlockItem(BlockRegister.FLAG_STONE.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> STONE_CENTERCROSS_BRICKS = ITEMS.register("stone_centercross_bricks", () -> 
		new BlockItem(BlockRegister.STONE_CENTERCROSS_BRICKS.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> STACKED_STONE_BRICKS = ITEMS.register("stacked_stone_bricks", () -> 
		new BlockItem(BlockRegister.STACKED_STONE_BRICKS.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> SMOKED_SMOOTH_STONE = ITEMS.register("smoked_smooth_stone", () -> 
		new BlockItem(BlockRegister.SMOKED_SMOOTH_STONE.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> SMOKED_POLISHED_ANDESITE = ITEMS.register("smoked_polished_andesite", () -> 
		new BlockItem(BlockRegister.SMOKED_POLISHED_ANDESITE.get(), new Item.Properties().group(ModSetup.itemGroup)));
	
	public static final RegistryObject<Item> DUNGEON_BRAZIER = ITEMS.register("dungeon_brazier", () -> 
		new BlockItem(BlockRegister.DUNGEON_BRAZIER.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> EMISSIVE_SHROOMS = ITEMS.register("emissive_shrooms", () -> 
		new BlockItem(BlockRegister.EMISSIVE_SHROOMS.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> VILLAGE_BARREL = ITEMS.register("village_barrel", () -> 
		new BlockItem(BlockRegister.VILLAGE_BARREL.get(), new Item.Properties().group(ModSetup.itemGroup)));
	
	public static final RegistryObject<Item> FLAG_STONE_SLAB = ITEMS.register("flag_stone_slab", () -> 
		new BlockItem(BlockRegister.FLAG_STONE_SLAB.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> STONE_CENTERCROSS_SLAB = ITEMS.register("stone_centercross_slab", () -> 
		new BlockItem(BlockRegister.STONE_CENTERCROSS_SLAB.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> SMOKED_SMOOTH_STONE_SLAB = ITEMS.register("smoked_smooth_stone_slab", () -> 
		new BlockItem(BlockRegister.SMOKED_SMOOTH_STONE_SLAB.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> SMOKED_SMOOTH_STONE_STAIRS = ITEMS.register("smoked_smooth_stone_stairs", () -> 
		new BlockItem(BlockRegister.SMOKED_SMOOTH_STONE_STAIRS.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> SMOKED_POLISHED_ANDESITE_SLAB = ITEMS.register("smoked_polished_andesite_slab", () -> 
		new BlockItem(BlockRegister.SMOKED_POLISHED_ANDESITE_SLAB.get(), new Item.Properties().group(ModSetup.itemGroup)));
	public static final RegistryObject<Item> SMOKED_POLISHED_ANDESITE_STAIRS = ITEMS.register("smoked_polished_andesite_stairs", () -> 
		new BlockItem(BlockRegister.SMOKED_POLISHED_ANDESITE_STAIRS.get(), new Item.Properties().group(ModSetup.itemGroup)));
}

package com.bixel.rec.init;

import com.bixel.rec.RecDecMod;
import com.bixel.rec.objects.blocks.DungeonBrazierBlock;
import com.bixel.rec.objects.blocks.DungeonCandles;
import com.bixel.rec.objects.blocks.ModelBlock;
import com.bixel.rec.objects.blocks.VillageBarrelBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegister 
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RecDecMod.MOD_ID);
	
	/**
	 * BLOCKS
	 */
	public static final RegistryObject<Block> STONE_BRICKS_DIRTY = BLOCKS.register("stone_bricks_dirty", () -> 
		new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> STONE_BRICKS_SANDY = BLOCKS.register("stone_bricks_sandy", () -> 
		new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> STONE_BRICKS_SANDY_RED = BLOCKS.register("stone_bricks_sandy_red", () -> 
		new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_STONE_CROSS = BLOCKS.register("chiseled_stone_cross", () -> 
		new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_STONE_CROSS_THICK = BLOCKS.register("chiseled_stone_cross_thick", () -> 
		new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> FLAG_STONE = BLOCKS.register("flag_stone", () -> 
		new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_FLAG_STONE = BLOCKS.register("chiseled_flag_stone", () -> 
		new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> STONE_CENTERCROSS_BRICKS = BLOCKS.register("stone_centercross_bricks", () -> 
		new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> STACKED_STONE_BRICKS = BLOCKS.register("stacked_stone_bricks", () -> 
		new ModelBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	
	/**
	 * Groups
	 */
	//SMOKED_SMOOTH_STONE
	public static final RegistryObject<Block> SMOKED_SMOOTH_STONE = BLOCKS.register("smoked_smooth_stone", () -> 
		new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOKED_SMOOTH_STONE_SLAB = BLOCKS.register("smoked_smooth_stone_slab", () -> 
		new SlabBlock(Block.Properties.from(SMOKED_SMOOTH_STONE.get())));
	public static final RegistryObject<Block> SMOKED_SMOOTH_STONE_STAIRS = BLOCKS.register("smoked_smooth_stone_stairs", () -> 
		new StairsBlock(() -> SMOKED_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(SMOKED_SMOOTH_STONE.get())));
	//SMOKED_POLISHED_ANDESITE
	public static final RegistryObject<Block> SMOKED_POLISHED_ANDESITE = BLOCKS.register("smoked_polished_andesite", () -> 
		new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOKED_POLISHED_ANDESITE_SLAB = BLOCKS.register("smoked_polished_andesite_slab", () -> 
		new SlabBlock(Block.Properties.from(SMOKED_POLISHED_ANDESITE.get())));
	public static final RegistryObject<Block> SMOKED_POLISHED_ANDESITE_STAIRS = BLOCKS.register("smoked_polished_andesite_stairs", () -> 
		new StairsBlock(() -> SMOKED_POLISHED_ANDESITE.get().getDefaultState(), Block.Properties.from(SMOKED_POLISHED_ANDESITE.get())));

	/**
	 * SLABS
	 */
	public static final RegistryObject<Block> FLAG_STONE_SLAB = BLOCKS.register("flag_stone_slab", () -> 
		new SlabBlock(Block.Properties.from(FLAG_STONE.get())));
	public static final RegistryObject<Block> STONE_CENTERCROSS_SLAB = BLOCKS.register("stone_centercross_slab", () -> 
		new SlabBlock(Block.Properties.from(STONE_CENTERCROSS_BRICKS.get())));


	/**
	 * MODELS
	 */
	public static final RegistryObject<Block> DUNGEON_BRAZIER = BLOCKS.register("dungeon_brazier", () -> 
		new DungeonBrazierBlock(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(2f, 30.0f).
			harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	public static final RegistryObject<Block> EMISSIVE_SHROOMS = BLOCKS.register("emissive_shrooms", () -> 
		new ModelBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.YELLOW).hardnessAndResistance(0.5f, 6.0f).sound(SoundType.STEM)));
	public static final RegistryObject<Block> VILLAGE_BARREL = BLOCKS.register("village_barrel", () ->
		new VillageBarrelBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(1f, 10.0f).
			harvestLevel(1).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
}

package com.bixel.rec.init;

import com.bixel.rec.RecDecMod;
import com.bixel.rec.objects.blocks.DungeonBrazierBlock;
import com.bixel.rec.objects.blocks.ExampleChestBlock;
import com.bixel.rec.objects.blocks.VillageBarrelBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegister 
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RecDecMod.MOD_ID);
	
	//DeferredRegistries are not working
	
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
	public static final RegistryObject<Block> STONE_CROSS_BRICKS = BLOCKS.register("stone_cross_bricks", () -> 
		new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> STONE_CENTERCROSS_BRICKS = BLOCKS.register("stone_centercross_bricks", () -> 
		new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> DUNGEON_BRAZIER = BLOCKS.register("dungeon_brazier", () -> 
		new DungeonBrazierBlock(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(2f, 30.0f).
			harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	public static final RegistryObject<Block> VILLAGE_BARREL = BLOCKS.register("village_barrel", () ->
		new VillageBarrelBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(1f, 10.0f).
			harvestLevel(1).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	
	public static final RegistryObject<Block> EXAMPLE_CHEST = BLOCKS.register("example_chest", () -> 
		new ExampleChestBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(1f, 10.0f).
			harvestLevel(1).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
}

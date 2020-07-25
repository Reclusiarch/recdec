package com.bixel.rec.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class VillageBarrelBlock extends ModelBlock
{
	private static final VoxelShape SHAPE = Stream.of(
			Block.makeCuboidShape(1, 0, 1, 15, 3, 15),
			Block.makeCuboidShape(1, 19, 1, 15, 22, 15),
			Block.makeCuboidShape(0, 3, 0, 16, 19, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	
	public VillageBarrelBlock(Properties properties) 
	{
		super(properties);
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		switch (state.get(FACING))
		{
		case NORTH:
			return SHAPE;
		case SOUTH:
			return SHAPE;
		case WEST:
			return SHAPE;
		case EAST:
			return SHAPE;
		default:
			return SHAPE;
		}
	}
}

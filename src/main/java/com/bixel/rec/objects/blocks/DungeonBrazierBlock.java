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

public class DungeonBrazierBlock extends ModelBlock
{
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
			Block.makeCuboidShape(1, 1, 2, 3, 3, 5),
			Block.makeCuboidShape(1, 1, 11, 3, 3, 14),
			Block.makeCuboidShape(13, 1, 2, 15, 3, 5),
			Block.makeCuboidShape(13, 1, 11, 15, 3, 14),
			Block.makeCuboidShape(1, 1, 5, 3, 11, 11),
			Block.makeCuboidShape(13, 1, 5, 15, 11, 11),
			Block.makeCuboidShape(3, 3, 3, 13, 4, 13),
			Block.makeCuboidShape(12, 4, 3, 13, 15, 13),
			Block.makeCuboidShape(3, 4, 3, 4, 15, 13),
			Block.makeCuboidShape(4, 4, 3, 12, 15, 4),
			Block.makeCuboidShape(4, 4, 12, 12, 15, 13),
			Block.makeCuboidShape(4, 12, 4, 12, 13, 12)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
			Block.makeCuboidShape(11, 1, 1, 14, 3, 3),
			Block.makeCuboidShape(2, 1, 1, 5, 3, 3),
			Block.makeCuboidShape(11, 1, 13, 14, 3, 15),
			Block.makeCuboidShape(2, 1, 13, 5, 3, 15),
			Block.makeCuboidShape(5, 1, 1, 11, 11, 3),
			Block.makeCuboidShape(5, 1, 13, 11, 11, 15),
			Block.makeCuboidShape(3, 3, 3, 13, 4, 13),
			Block.makeCuboidShape(3, 4, 12, 13, 15, 13),
			Block.makeCuboidShape(3, 4, 3, 13, 15, 4),
			Block.makeCuboidShape(12, 4, 4, 13, 15, 12),
			Block.makeCuboidShape(3, 4, 4, 4, 15, 12),
			Block.makeCuboidShape(4, 12, 4, 12, 13, 12)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	
	public DungeonBrazierBlock(Properties properties) 
	{
		super(properties);
	}
	
    /**
     * Get a light value for this block, taking into account the given state and coordinates, normal ranges are between 0 and 15
     *
     * @param state
     * @param world
     * @param pos
     * @return The light value
     */
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos)
    {
        return 14; //torch -- sky = 15
    }
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		switch (state.get(FACING))
		{
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_N;
		case WEST:
			return SHAPE_W;
		case EAST:
			return SHAPE_W;
		default:
			return SHAPE_N;
		}
	}
}

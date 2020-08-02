package com.bixel.rec.objects.blocks;

import java.util.Random;
import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DungeonCandles extends ModelBlock
{
	//doesnt work - because its affecting ALL blocks
	//private boolean on = false;
   
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(8, 0, 4, 11, 3, 7),
			Block.makeCuboidShape(5, 0, 10, 8, 7, 13),
			Block.makeCuboidShape(11, 0, 8, 13, 5, 10),
			Block.makeCuboidShape(3, 0, 2, 5, 3, 4)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(5, 0, 9, 8, 3, 12),
			Block.makeCuboidShape(8, 0, 3, 11, 7, 6),
			Block.makeCuboidShape(3, 0, 6, 5, 5, 8),
			Block.makeCuboidShape(11, 0, 12, 13, 3, 14)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(9, 0, 8, 12, 3, 11),
			Block.makeCuboidShape(3, 0, 5, 6, 7, 8),
			Block.makeCuboidShape(6, 0, 11, 8, 5, 13),
			Block.makeCuboidShape(12, 0, 3, 14, 3, 5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(4, 0, 5, 7, 3, 8),
			Block.makeCuboidShape(10, 0, 8, 13, 7, 11),
			Block.makeCuboidShape(8, 0, 3, 10, 5, 5),
			Block.makeCuboidShape(2, 0, 11, 4, 3, 13)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public DungeonCandles(Properties properties) 
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
			return SHAPE_S;
		case WEST:
			return SHAPE_W;
		case EAST:
			return SHAPE_E;
		default:
			return SHAPE_N;
		}
	}
	
    /**
    * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
    * this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
    * of whether the block can receive random update ticks
    */

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) 
	{
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.7D;
		double d2 = (double)pos.getZ() + 0.5D;
		worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}
	
	/*
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult result)
	{
		if(!worldIn.isRemote) //not remote = server
		{
			if(on)
				on = false;
			else
				on = true;
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}*/
}

package com.bixel.rec.objects.blocks;

import java.util.stream.Stream;

import com.bixel.rec.init.TileEntityRegister;
import com.bixel.rec.tiles.VillageBarrelTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

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
	
	@Override
	public boolean hasTileEntity(BlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world)
	{
		return TileEntityRegister.VILLAGE_BARREL.get().create();
	}
	
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult result)
	{
		if(!worldIn.isRemote) //not remote = server
		{
			TileEntity tile = worldIn.getTileEntity(pos);
			if(tile instanceof VillageBarrelTileEntity)
			{
				NetworkHooks.openGui((ServerPlayerEntity)player, (VillageBarrelTileEntity)tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.FAIL;
	}
	
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving)
	{
		if(state.getBlock() != newState.getBlock())
		{
			/*
			TileEntity tile = worldIn.getTileEntity(pos);
			if(tile instanceof VillageBarrelTileEntity)
			{
				//OR WE CAN KEEP ITEMS!
				InventoryHelper.dropItems(worldIn, pos, ((VillageBarrelTileEntity)tile).getItems());
			}*/
		}
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

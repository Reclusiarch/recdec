package com.bixel.rec.tileentities;

import javax.annotation.Nonnull;

import com.bixel.rec.container.ExampleChestContainer;
import com.bixel.rec.init.TileEntityRegister;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ExampleChestTileEntity extends LockableLootTileEntity
{
	private NonNullList<ItemStack> chestContents = NonNullList.withSize(36, ItemStack.EMPTY);
	private IItemHandlerModifiable items = createHandler();
	private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);
	
	protected int numPlayersUsing;
	
	public ExampleChestTileEntity(TileEntityType<?> typeIn) 
	{
		super(typeIn);
	}
	
	public ExampleChestTileEntity() 
	{
		this(TileEntityRegister.EXAMPLE_CHEST.get());
	}

	@Override
	public int getSizeInventory() { return chestContents.size(); }

	@Override
	public NonNullList<ItemStack> getItems() { return chestContents; }

	@Override
	public void setItems(NonNullList<ItemStack> itemsIn) { this.chestContents = itemsIn; }

	@Override
	protected ITextComponent getDefaultName() 
	{
		//in lang
		return new TranslationTextComponent("container.example_chest");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) 
	{
		return new ExampleChestContainer(id, player, this);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		super.write(compound);
		if(!this.checkLootAndWrite(compound))
		{
			ItemStackHelper.saveAllItems(compound, this.chestContents);
		}
		return compound;
	}
	
	//public void read()
	@Override
	public void func_230337_a_(BlockState state, CompoundNBT compound)
	{
		super.func_230337_a_(state, compound);
		this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if(!this.checkLootAndRead(compound))
		{
			ItemStackHelper.loadAllItems(compound, this.chestContents);
		}
	}
	
	private void playSound(SoundEvent sound)
	{
		double dx = (double)this.pos.getX() + 0.5d;
		double dy = (double)this.pos.getY() + 0.5d;
		double dz = (double)this.pos.getZ() + 0.5d;
		this.world.playSound((PlayerEntity)null, dx, dy, dz, sound, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f);
	}
	
	@Override
	public boolean receiveClientEvent(int id, int type)
	{
		if(id == 1) 
		{
			this.numPlayersUsing = type;
			return true;
		}
		else
		{
			return super.receiveClientEvent(id, type);
		}
	}
	
	@Override
	public void openInventory(PlayerEntity player)
	{
		if(!player.isSpectator())
		{
			if(this.numPlayersUsing < 0)
			{
				numPlayersUsing = 0;
			}
			else
			{
				++this.numPlayersUsing;
				this.onOpenOrClose();
			}
		}
	}
	
	@Override
	public void closeInventory(PlayerEntity player)
	{
		if(!player.isSpectator())
		{
			--numPlayersUsing;
			this.onOpenOrClose();
		}
	}
	
	protected void onOpenOrClose()
	{
		Block block = this.getBlockState().getBlock();
		if(block instanceof ChestBlock)
		{
			this.world.addBlockEvent(this.pos, block, 1, numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(this.pos, block);
		}
	}
	
	public static int getPlayersUsing(IBlockReader reader, BlockPos pos)
	{
		BlockState state = reader.getBlockState(pos);
		if(state.hasTileEntity())
		{
			TileEntity tile = reader.getTileEntity(pos);
			if(tile instanceof ExampleChestTileEntity)
			{
				return ((ExampleChestTileEntity)tile).numPlayersUsing;
			}
			else
				return 0;
		}
		else
			return 0;
	}
	
	public static void swapContents(ExampleChestTileEntity tile, ExampleChestTileEntity other)
	{
		NonNullList<ItemStack> list = tile.getItems();
		tile.setItems(other.getItems());
		other.setItems(list);
	}
	
	@Override
	public void updateContainingBlockInfo()
	{
		super.updateContainingBlockInfo();
		if(this.itemHandler != null)
		{
			this.itemHandler.invalidate();
			this.itemHandler = null;
		}
	}
	
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side)
	{
		if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return itemHandler.cast();
		}
		return super.getCapability(cap, side);
	}
	
	private IItemHandlerModifiable createHandler()
	{
		return new InvWrapper(this);
	}
	
	@Override
	public void remove()
	{
		super.remove();
		if(this.itemHandler != null)
		{
			this.itemHandler.invalidate();
		}
	}
}

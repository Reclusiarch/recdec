package com.bixel.rec.container;

import java.util.Objects;

import com.bixel.rec.init.BlockRegister;
import com.bixel.rec.init.ContainerRegister;
import com.bixel.rec.tiles.VillageBarrelTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class VillageBarrelContainer extends Container
{
	//redo containers with this tutorial
	//https://www.youtube.com/watch?v=5_xFVu1DTsg&list=PLmaTwVFUUXiBKYYSyrv_uPPoPZtEsCBVJ&index=4&t=303s
	private final IWorldPosCallable canInteractWithCallable;
		
	public final VillageBarrelTileEntity entity;
	
	public VillageBarrelContainer(final int windowId, final PlayerInventory playerInventory, final VillageBarrelTileEntity tileEntity) 
	{
		super(ContainerRegister.VILLAGE_BARREL.get(), windowId);
		this.entity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.of(entity.getWorld(), entity.getPos());
		
		//Main Inventory
		int startX = 8; 
		int startY = 18; 
		int slotSizePlus2 = 18;
		
		for(int row = 0; row < 4; row++)
		{
			for(int column = 0; column < 9; column++)
			{
				this.addSlot(new Slot(entity, (row * 9) + column, startX + (column * slotSizePlus2), startY + (row * slotSizePlus2)));
			}
		}
		//Main Player Inventory
		int startPlayerInvY = startY * 5 + 12;
		for(int row = 0; row < 3; row++)
		{
			for(int column = 0; column < 9; column++)
			{
				this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * slotSizePlus2), startPlayerInvY + (row * slotSizePlus2)));
			}
		}
		//Hotbar
		int hotbarY = startPlayerInvY + (startPlayerInvY / 2) + 7; //need 160
		for(int column = 0; column < 9; column++)
		{
			this.addSlot(new Slot(playerInventory, column, startX + (column * slotSizePlus2), hotbarY));
		}
	}
	
	private static VillageBarrelTileEntity getTileEntity(final PlayerInventory inventory, final PacketBuffer data)
	{
		Objects.requireNonNull(inventory, "PlayerInventory cannot be null");
		Objects.requireNonNull(data, "Data cannot be null");
		final TileEntity tileAtPos = inventory.player.world.getTileEntity(data.readBlockPos());
		if(tileAtPos instanceof VillageBarrelTileEntity)
		{
			return (VillageBarrelTileEntity)tileAtPos;
		}
		throw new IllegalStateException("Incorrect TileEnity " + tileAtPos);
	}
	
	public VillageBarrelContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data)
	{
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn)
	{
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockRegister.VILLAGE_BARREL.get());
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index)
	{
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if(slot != null && slot.getHasStack())
		{
			ItemStack stack = slot.getStack();
			itemStack = stack.copy();
			if(index == 0)
			{
				if(!this.mergeItemStack(stack, 1, 37, true))
				{
					return ItemStack.EMPTY;
				}
				slot.onSlotChange(stack, itemStack);
			}
			else
			{
				if (!this.mergeItemStack(stack, 0, 1, false)) 
				{
                    return ItemStack.EMPTY;
                }
				else if (index < 28)
                {
                    if (!this.mergeItemStack(stack, 28, 37, false)) 
                    {
                        return ItemStack.EMPTY;
                    }
                } 
				else if (index < 37 && !this.mergeItemStack(stack, 1, 28, false)) 
                {
                    return ItemStack.EMPTY;
                }
			}
			if (stack.isEmpty()) 
			{
                slot.putStack(ItemStack.EMPTY);
            } 
			else 
			{
                slot.onSlotChanged();
            }

            if (stack.getCount() == itemStack.getCount()) 
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, stack);
		}
		return itemStack;
	}
	/*
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index)
	{
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if(slot != null && slot.getHasStack())
		{
			ItemStack itemStackSlot = slot.getStack();
			itemStack = itemStackSlot.copy();
			if(index < 36)
			{
				if(!this.mergeItemStack(itemStackSlot, 36, this.inventorySlots.size(), true))
				{
					return ItemStack.EMPTY;
				}
				else if(!this.mergeItemStack(itemStackSlot, 0, 36, false))
				{
					return ItemStack.EMPTY;
				}
				if(itemStackSlot.isEmpty())
				{
					slot.putStack(ItemStack.EMPTY);
				}
				else
				{
					slot.onSlotChanged();
				}
			}
		}
		return itemStack;
	}*/
}
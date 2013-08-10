package lazmod.blocks.containers;

import lazmod.ScienceCraft;
import lazmod.blocks.tileentities.TileBlockyBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBlockyBlock extends Container
	{
	private int id;
	
    protected TileBlockyBlock tileEntity;

    public ContainerBlockyBlock (InventoryPlayer inventoryPlayer, TileBlockyBlock te)
    	{
    	tileEntity = te;
    	
    	id = te.blockMeta;
    	
    	for (byte ctr = 0; ctr < ScienceCraft.DateHandler.BlockyISamount[id]; ctr++)
    		{
    		addSlotToContainer(new Slot(te, ctr, ScienceCraft.DateHandler.BlockySlotCoordX[id][ctr], ScienceCraft.DateHandler.BlockySlotCoordY[id][ctr]));
    		}
    	
    	bindPlayerInventory(inventoryPlayer);
    	}

    @Override
    public boolean canInteractWith(EntityPlayer player)
    	{
    	return tileEntity.isUseableByPlayer(player);
    	}


    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
    	{
        for (int i = 0; i < 3; i++)
        	{
            for (int j = 0; j < 9; j++)
            	{
            	addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            	}
        	}

        for (int i = 0; i < 9; i++)
        	{
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        	}
    	}

    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot)
    	{
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);

        if (slotObject != null && slotObject.getHasStack())
        	{
        	ItemStack stackInSlot = slotObject.getStack();
        	stack = stackInSlot.copy();
        	
        	if (slot < tileEntity.ISamnt[tileEntity.blockMeta]-1)
        		{
        		if (!this.mergeItemStack(stackInSlot, 9, 45, true))
        			{
        			return null;
        			}
                }
            else if (!this.mergeItemStack(stackInSlot, 0, 9, false))
            	{
            	return null;
            	}

            if (stackInSlot.stackSize == 0)
            	{
            	slotObject.putStack(null);
            	}
            else
            	{
            	slotObject.onSlotChanged();
            	}

            if (stackInSlot.stackSize == stack.stackSize)
            	{
            	return null;
            	}
            slotObject.onPickupFromSlot(player, stackInSlot);
        	}
        return stack;
    	}
    	
	}

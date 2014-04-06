package tests;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class ContainerPlayerModded extends ContainerPlayer
	{
	public ContainerPlayerModded(final InventoryPlayerModded par1InventoryPlayer, boolean par2, EntityPlayer par3EntityPlayer)
	    {
		super(par1InventoryPlayer, par2, par3EntityPlayer);
		
	    for (int i = 0; i<5; i++)
	        {
	        this.addSlotToContainer(new Slot(par1InventoryPlayer, i+super.inventorySlots.size(), 80 + i * 18, 8));
	        }
	    for (int i = 5; i<10; i++)
	        {
	        this.addSlotToContainer(new Slot(par1InventoryPlayer, i+super.inventorySlots.size(), 80 + i-5 * 18, 62));
	        }
	    
		NBTTagList tagList = par1InventoryPlayer.player.getEntityData().getTagList("moddedInventory", 10);
		for (byte i = 0; i < tagList.tagCount(); i++)
			{
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inventorySlots.size())
				{
				par1InventoryPlayer.setInventorySlotContents(slot+45, ItemStack.loadItemStackFromNBT(tag));
				}
			}
	    }
	
	
    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    	{
        super.onContainerClosed(par1EntityPlayer);
        
		NBTTagList itemList = new NBTTagList();
		for (byte i = 0; i < inventorySlots.size(); i++)
			{
			ItemStack stack = ((Slot) inventorySlots.get(i)).getStack();
			if (stack != null)
				{
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
				}
			}
		
        par1EntityPlayer.getEntityData().setTag("moddedInventory", itemList);
    	}
	}
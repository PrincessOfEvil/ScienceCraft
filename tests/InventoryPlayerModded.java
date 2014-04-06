package tests;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryPlayerModded extends InventoryPlayer
	{
	public ItemStack[] moddedInventory = new ItemStack[10];
	
	public InventoryPlayerModded(EntityPlayer par1EntityPlayer)
		{
		super(par1EntityPlayer);
		}
	
    public ItemStack getStackInSlot(int par1)
    {
        ItemStack[] aitemstack = this.mainInventory;

        if (par1 >= aitemstack.length)
        {
            par1 -= aitemstack.length;
            aitemstack = this.armorInventory;
            if (par1 >= aitemstack.length)
            	{
            	par1 -= aitemstack.length;
            	aitemstack = this.moddedInventory;
            	if (par1 >= aitemstack.length) return null;
            	}
        }
        return aitemstack[par1];
    }
    
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    	{
        ItemStack[] aitemstack = this.mainInventory;

        if (par1 >= aitemstack.length)
        	{
            par1 -= aitemstack.length;
            aitemstack = this.armorInventory;
            if (par1 >= aitemstack.length)
	        	{
	        	par1 -= aitemstack.length;
	        	aitemstack = this.moddedInventory;
	        	if (par1 >= aitemstack.length) return;
	        	}
        	}

        aitemstack[par1] = par2ItemStack;
    	}
}

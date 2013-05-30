package mods.lazmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileBlockyBlock extends TileEntity implements ISidedInventory //TODO: Alot, shiftclick
	{
    public int blockMeta;
    
    public	byte[] ISamnt = HighEnergyCraft.DateHandler.BlockyISamount;
    
    private ItemStack[]	inventory;

    public TileBlockyBlock(int blockMeta) 
    	{
    	this.blockMeta = blockMeta;
    	inventory = new ItemStack[ISamnt[blockMeta]];
    	}

	@Override
	public int getSizeInventory()
		{
		return inventory.length;
		}

	@Override
	public ItemStack getStackInSlot(int i)
		{
		return inventory[i];
		}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) 
		{
		super.readFromNBT(tagCompound);
		
        NBTTagList tagList = tagCompound.getTagList("Inventory");
        for (int i = 0; i < tagList.tagCount(); i++)
        	{
        	NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
        	byte slot = tag.getByte("Slot");
        	if (slot >= 0 && slot < inventory.length)
        		{
        		inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
                }
        	}
		}
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) 
		{
		super.writeToNBT(tagCompound);
		
        NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < inventory.length; i++)
        	{
            ItemStack stack = inventory[i];
            if (stack != null)
            	{
            	NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte) i);
                stack.writeToNBT(tag);
                itemList.appendTag(tag);
                }
        	}
		
		tagCompound.setTag("Inventory", itemList);
		}


    @Override
    public ItemStack decrStackSize(int slot, int amt)
    	{
        ItemStack stack = getStackInSlot(slot);
        if (stack != null)
        	{
            if (stack.stackSize <= amt)
            	{
                setInventorySlotContents(slot, null);
                }
            else
            	{
                stack = stack.splitStack(amt);
                if (stack.stackSize == 0)
                	{
                    setInventorySlotContents(slot, null);
                    }
                }
            }
            return stack;
    	}

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    	{
        ItemStack stack = getStackInSlot(slot);
        if (stack != null)
        	{
            setInventorySlotContents(slot, null);
            }
        return stack;
    	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
		{
        this.inventory[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        	{
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        	}
		}

	@Override
	public String getInvName()
		{
		return HighEnergyCraft.DateHandler.BlockyLocalization[blockMeta];
		}

	@Override
	public boolean isInvNameLocalized()
		{
		return false;
		}

	@Override
	public int getInventoryStackLimit()
		{
		return 64;
		}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
		{
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
		}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack)
		{
		if (getInvName() == "Solar Furnace" && i == 1) return false;
		return true;
		}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}
	
    public void smeltItem()
    	{
        if (this.canSmelt() && blockMeta == 0)
        	{
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.inventory[0]);

            if (this.inventory[1] == null)
            	{
                this.inventory[1] = itemstack.copy();
            	}
            else if (this.inventory[1].isItemEqual(itemstack))
            	{
            	inventory[1].stackSize += itemstack.stackSize;
            	}

            --this.inventory[0].stackSize;

            if (this.inventory[0].stackSize <= 0)
            	{
                this.inventory[0] = null;
            	}
        	}
    	}


	private boolean canSmelt()
	    {
	    if (this.inventory[0] == null || blockMeta != 0)
	    	{
	        return false;
	        }
	    else
	       	{
	    	ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.inventory[0]);
	    	if (itemstack == null) return false;
	    	if (this.inventory[1] == null) return true;
	    	if (!this.inventory[1].isItemEqual(itemstack)) return false;
	    	int result = inventory[1].stackSize + itemstack.stackSize;
	    	return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
	        }
	    }
	}

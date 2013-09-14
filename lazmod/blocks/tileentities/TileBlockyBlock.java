package lazmod.blocks.tileentities;

import lazmod.ScienceCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileBlockyBlock extends TileEntity implements ISidedInventory //TODO: Alot, shiftclick
	{
    public	int blockMeta;
    
    public	int charge;
    
    public	byte[] ISamnt = ScienceCraft.DateHandler.BlockyISamount;
    
    private	ItemStack[]	inventory;
    
    public	TileBlockyBlock(){}
    
    public	TileBlockyBlock(int blockMeta) 
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
		
		blockMeta = tagCompound.getInteger("BlockMeta");
		inventory = new ItemStack[ISamnt[blockMeta]];
		
		charge = tagCompound.getInteger("Charge");
		
        NBTTagList tagList = tagCompound.getTagList("Inventory");
        System.out.println(tagList.tagCount());
        for (byte i = 0; i < tagList.tagCount(); i++)
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
		
		tagCompound.setInteger("BlockMeta", blockMeta);
		
		tagCompound.setInteger("Charge", charge);
		
        NBTTagList itemList = new NBTTagList();
        for (byte i = 0; i < inventory.length; i++)
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

    public void updateEntity()
    	{
    	if (charge <36000)
    		{
    		charge += worldObj.getLightBrightness(xCoord, yCoord+1, zCoord)*16;
    		}
    	if (canSmelt() && charge >= 9000)
    		{
    		this.smeltItem();
    		charge -= 9000;
    		}
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
		return ScienceCraft.DateHandler.BlockyLocalization[blockMeta];
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
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
		{
		if (blockMeta == 0 && i == 1) return false;
		return true;
		}

	@Override
	public int[] getAccessibleSlotsFromSide(int i)
		{
		if (blockMeta == 0) 
			{
			if (i == 1) {return new int[]{0};}
			else {return new int[]{1};}
			}
		return null;
		}
	
	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j)
		{
		if ((i == 1 && blockMeta == 0) || (j != 1 && blockMeta == 0)) {return false;}
		return true;
		}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j)
		{
		if ((i == 0 && j != 1 && blockMeta == 0) || (i == 1 && j == 1 && blockMeta == 0)) {return false;}
		return true;
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
	    	if (this.inventory[1].isItemEqual(itemstack)) return true;
	    	int result = inventory[1].stackSize + itemstack.stackSize;
	    	return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
	        }
	    }
	}

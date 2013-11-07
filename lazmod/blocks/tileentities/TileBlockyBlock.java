package lazmod.blocks.tileentities;

import lazmod.ScienceCraft;
import lazmod.blocks.tileentities.handlers.SolarHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileBlockyBlock extends TileEntity implements ISidedInventory //TODO: Alot, shiftclick
	{
    public	int					blockMeta;
    
    public	int					charge;
    
    public	boolean				isUsing;
    
    private	byte[]				ISamnt = ScienceCraft.DateHandler.BlockyISamount;
    
    private	static SolarHandler	handler;
    
    private	ItemStack[]			inventory;
    
    public	TileBlockyBlock(){}
    
    public	TileBlockyBlock(int blockMeta) 
    	{
    	this.blockMeta = blockMeta;
    	inventory = new ItemStack[ISamnt[blockMeta]];
    	handler = new SolarHandler(blockMeta);
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
		handler = new SolarHandler(blockMeta);

		inventory = new ItemStack[ISamnt[blockMeta]];
		
		charge = tagCompound.getInteger("Charge");
		
        NBTTagList tagList = tagCompound.getTagList("Inventory");
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
    	if (charge <= 32000)
    		{
    		charge += worldObj.getLightBrightness(xCoord, yCoord+1, zCoord)*16;
    		}
    	if (charge > 32000)
			{
    		charge = 32000;
			}
    	if (canUse() && charge >= 8000)
    		{
    		this.useItem();
    		charge -= 8000;
    		isUsing = true;
    		}
    	else
    		{
    		isUsing = false;
    		}
    	if (handler.id != blockMeta)
    		{
    		handler = new SolarHandler(blockMeta);
    		System.out.println("YAAAY");
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
		return handler.getInventoryStackLimit();
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
	public boolean isItemValidForSlot(int slot, ItemStack itemstack)
		{
		return handler.isItemValidForSlot(slot);
		}

	@Override
	public int[] getAccessibleSlotsFromSide(int side)
		{
		return handler.getAccessibleSlotsFromSide(side);
		}
	
	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side)
		{
		return handler.canInsertItem(slot, side);
		}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemstack, int side)
		{
		return handler.canExtractItem(slot, side);
		}
	
	public void useItem()
    	{
		inventory = handler.useItem(inventory);
    	}

	private boolean canUse()
	    {
		return handler.canUse(inventory);
	    }
	}

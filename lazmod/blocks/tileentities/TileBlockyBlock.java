package lazmod.blocks.tileentities;

import lazmod.ScienceCraft;
import lazmod.CES.CESWaveEvent;
import lazmod.blocks.tileentities.logic.SolarLogic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.ForgeSubscribe;

public class TileBlockyBlock extends CESTileEntity implements ISidedInventory //TODO: Alot, shiftclick
	{
    public	int					blockMeta;
    public	boolean				isUsing;
    private	byte[]				ISamnt = ScienceCraft.DateHandler.BlockyISamount;
    private	ItemStack[]			inventory;
    
    public	TileBlockyBlock(){}
    
    public	TileBlockyBlock(int blockMeta) 
    	{
    	this.blockMeta = blockMeta;
    	inventory = new ItemStack[ISamnt[blockMeta]];
    	}

	public void undoCharge()
		{
		if (maxAdded == true)
			{
			system.addMax(-32000);
			}
		}
	public int getCharge()
		{
		if (system == null)
			{
			system = ScienceCraft.DateHandler.CES.get(player);
			return 0;
			}
		return system.get();
		}
	
	public void setCharge(int i)
		{
		if (system == null)
			{
			system = ScienceCraft.DateHandler.CES.get(player);
			}
		else
			{
			system.set(i);
			}
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
		
		tileRegister(player);
		
		inventory = new ItemStack[ISamnt[blockMeta]];
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
	
	@ForgeSubscribe
	@Override
    public void onWaveEvent(CESWaveEvent event)
		{
		if (!worldObj.isRemote)
			{
			if (event.player == this.player)
				{
		    	if (maxAdded == false)
					{
		    		system.addMax(32000);
		    		maxAdded = true;
					}
		    	system.add((int) (worldObj.getLightBrightness(xCoord, yCoord+1, zCoord)*320));
		    	if (canUse() && system.get() >= 8000)
		    		{
		    		this.useItem();
		    		system.add(-8000);
		    		isUsing = true;
		    		}
		    	else
		    		{
		    		isUsing = false;
		    		}
				}
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
		return ScienceCraft.DateHandler.BlockyLogic[blockMeta].getInventoryStackLimit();
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
	public boolean isItemValidForSlot(int slot, ItemStack itCEStack)
		{
		return ScienceCraft.DateHandler.BlockyLogic[blockMeta].isItemValidForSlot(slot);
		}

	@Override
	public int[] getAccessibleSlotsFromSide(int side)
		{
		return ScienceCraft.DateHandler.BlockyLogic[blockMeta].getAccessibleSlotsFromSide(side);
		}
	
	@Override
	public boolean canInsertItem(int slot, ItemStack itCEStack, int side)
		{
		return ScienceCraft.DateHandler.BlockyLogic[blockMeta].canInsertItem(slot, side);
		}

	@Override
	public boolean canExtractItem(int slot, ItemStack itCEStack, int side)
		{
		return ScienceCraft.DateHandler.BlockyLogic[blockMeta].canExtractItem(slot, side);
		}
	
	public void useItem()
    	{
		inventory = ScienceCraft.DateHandler.BlockyLogic[blockMeta].useItem(inventory);
    	}

	private boolean canUse()
	    {
		return ScienceCraft.DateHandler.BlockyLogic[blockMeta].canUse(inventory);
	    }
	}

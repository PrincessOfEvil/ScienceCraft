package lazmod.blocks.tileentities;

import lazmod.ScienceCraft;
import lazmod.EMS.EMSWaveEvent;
import lazmod.EMS.EnergyMatterSystem.EMSType;
import lazmod.blocks.tileentities.logic.SolarLogic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.ForgeSubscribe;

public class TileBlockyBlock extends EMSTileEntity implements ISidedInventory //TODO: Alot, shiftclick
	{
    public	int					blockMeta;
    
    public	int					charge;
    
    public	boolean				isUsing;
    
    private	byte[]				ISamnt = ScienceCraft.DateHandler.BlockyISamount;
    
    private	static SolarLogic	logic;
    
    private	ItemStack[]			inventory;
    
    
    public	TileBlockyBlock(){}
    
    public	TileBlockyBlock(int blockMeta) 
    	{
    	this.blockMeta = blockMeta;
    	inventory = new ItemStack[ISamnt[blockMeta]];
    	logic = new SolarLogic(blockMeta);
    	}

	public void undoCharge()
		{
		if (maxAdded == true)
			{
			system.addMax(EMSType.ENERGY, -32000);
			}
		}
	public int getCharge()
		{
		return system.get(EMSType.ENERGY);
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
		logic = new SolarLogic(blockMeta);
		
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
    public void onWaveEvent(EMSWaveEvent event)
		{
		if (!worldObj.isRemote)
			{
			if (event.player.username == this.player)
				{
		    	if (maxAdded == false)
					{
		    		system.addMax(EMSType.ENERGY, 32000);
		    		maxAdded = true;
					}
		    	system.add(EMSType.ENERGY,(int) (worldObj.getLightBrightness(xCoord, yCoord+1, zCoord)*320));
		    	charge = system.get(EMSType.ENERGY);
		    	if (canUse() && system.get(EMSType.ENERGY) >= 8000)
		    		{
		    		this.useItem();
		    		system.add(EMSType.ENERGY,-8000);
		    		isUsing = true;
		    		}
		    	else
		    		{
		    		isUsing = false;
		    		}
		    	if (logic.id != blockMeta)
		    		{
		    		System.out.println("TBB.update: -_-"+logic.toString());
		    		logic = new SolarLogic(blockMeta);
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
		return logic.getInventoryStackLimit();
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
		return logic.isItemValidForSlot(slot);
		}

	@Override
	public int[] getAccessibleSlotsFromSide(int side)
		{
		return logic.getAccessibleSlotsFromSide(side);
		}
	
	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side)
		{
		return logic.canInsertItem(slot, side);
		}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemstack, int side)
		{
		return logic.canExtractItem(slot, side);
		}
	
	public void useItem()
    	{
		inventory = logic.useItem(inventory);
    	}

	private boolean canUse()
	    {
		return logic.canUse(inventory);
	    }
	}

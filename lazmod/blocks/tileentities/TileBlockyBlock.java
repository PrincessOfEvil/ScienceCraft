package lazmod.blocks.tileentities;

import lazmod.DataHandler;
import lazmod.ScienceCraft;
import lazmod.CES.CESWaveEvent;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TileBlockyBlock extends CESTileEntity implements ISidedInventory // TODO: Ûûû. shiftclick
	{
	public int			blockMeta;
	public boolean		isUsing;
	private byte[]		ISamnt	= ScienceCraft.dataHandler.BlockyISamount;
	private ItemStack[]	inventory;
	
	public TileBlockyBlock()
		{}
	
	public TileBlockyBlock(int blockMeta)
		{
		this.blockMeta = blockMeta;
		System.out.println(blockMeta);
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
			system = ScienceCraft.dataHandler.CES.get(player);
			return 0;
			}
		return system.get();
		}
	
	public void setCharge(int i)
		{
		if (system == null)
			{
			system = ScienceCraft.dataHandler.CES.get(player);
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
		NBTTagList tagList = tagCompound.getTagList("Inventory", 10);
		for (byte i = 0; i < tagList.tagCount(); i++)
			{
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
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
				tag.setByte("Slot", i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
				}
			}
		
		tagCompound.setTag("Inventory", itemList);
		}
	
	@SubscribeEvent
	@Override
	public void onWaveEvent(CESWaveEvent event)
		{
		if (!worldObj.isRemote)
			{
			if (event.player == player)
				{
				if (maxAdded == false)
					{
					system.addMax(32000);
					maxAdded = true;
					}
				system.add((int) (worldObj.getLightBrightness(xCoord, yCoord + 1, zCoord) * 320));
				if (canUse() && system.get() >= 8000)
					{
					useItem();
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
		inventory[par1] = par2ItemStack;
		
		if (par2ItemStack != null && par2ItemStack.stackSize > getInventoryStackLimit())
			{
			par2ItemStack.stackSize = getInventoryStackLimit();
			}
		}
	
	@Override
	public String getInventoryName()
		{
		return StatCollector.translateToLocal("tile."+ScienceCraft.dataHandler.BlockyBlockTypeName[blockMeta]+".name");
		}
	
	@Override
	public boolean hasCustomInventoryName()
		{
		return true;
		}
	
	@Override
	public int getInventoryStackLimit()
		{
		return DataHandler.BlockyLogic[blockMeta].getInventoryStackLimit();
		}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
		{
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : entityplayer.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
		}
	
	@Override
	public void openInventory()
		{}
	
	@Override
	public void closeInventory()
		{}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itCEStack)
		{
		return DataHandler.BlockyLogic[blockMeta].isItemValidForSlot(slot);
		}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int side)
		{
		return DataHandler.BlockyLogic[blockMeta].getAccessibleSlotsFromSide(side);
		}
	
	@Override
	public boolean canInsertItem(int slot, ItemStack itCEStack, int side)
		{
		return DataHandler.BlockyLogic[blockMeta].canInsertItem(slot, side);
		}
	
	@Override
	public boolean canExtractItem(int slot, ItemStack itCEStack, int side)
		{
		return DataHandler.BlockyLogic[blockMeta].canExtractItem(slot, side);
		}
	
	public void useItem()
		{
		inventory = DataHandler.BlockyLogic[blockMeta].useItem(inventory);
		}
	
	private boolean canUse()
		{
		return DataHandler.BlockyLogic[blockMeta].canUse(inventory);
		}
	}

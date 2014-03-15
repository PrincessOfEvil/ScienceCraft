package lazmod.blocks.tileentities.logic;

import lazmod.DataHandler;
import lazmod.ScienceCraft;
import net.minecraft.item.ItemStack;

public class SolarLogic
	{
	public static int			id;

	public static ICraftHandler	handler;

	public SolarLogic(int Id)
		{
		id = Id;
		handler = DataHandler.BlockyCraftHandler[id];
		}

	public int getInventoryStackLimit()
		{
		return ScienceCraft.DateHandler.BlockyISlimit;
		}

	public boolean isItemValidForSlot(int slot)
		{
		if (slot == ScienceCraft.DateHandler.BlockyDangerSlot[id]) { return false; }
		return true;
		}

	public int[] getAccessibleSlotsFromSide(int side)
		{
		if (side == 1)
			{
			return new int[] {0};
			}
		else
			{
			return new int[] {1};
			}
		}

	public boolean canInsertItem(int slot, int side)
		{
		if (slot == ScienceCraft.DateHandler.BlockyDangerSlot[id] || side != 1) { return false; }
		return true;
		}

	public boolean canExtractItem(int slot, int side)
		{
		if (slot != ScienceCraft.DateHandler.BlockyDangerSlot[id] && side != 1 || slot == ScienceCraft.DateHandler.BlockyDangerSlot[id] && side == 1) { return false; }
		return true;
		}

	public ItemStack[] useItem(ItemStack[] inventory)
		{
		if (canUse(inventory))
			{
			ItemStack itCEStack = handler.getCraftingResult(inventory[0]);

			if (inventory[1] == null)
				{
				inventory[1] = itCEStack.copy();
				}
			else
				if (inventory[1].isItemEqual(itCEStack))
					{
					inventory[1].stackSize += itCEStack.stackSize;
					}

			--inventory[0].stackSize;

			if (inventory[0].stackSize <= 0)
				{
				inventory[0] = null;
				}
			}
		return inventory;
		}

	public boolean canUse(ItemStack[] inventory)
		{
		if (inventory[0] == null)
			{
			return false;
			}
		else
			if (handler.getCraftingResult(inventory[0]) == null)
				{
				return false;
				}
			else
				{
				ItemStack itCEStack = handler.getCraftingResult(inventory[0]);
				if (inventory[1] == null) { return true; }
				if (inventory[1].isItemEqual(itCEStack)) { return true; }
				int result = inventory[1].stackSize + itCEStack.stackSize;
				return result <= getInventoryStackLimit() && result <= itCEStack.getMaxStackSize();
				}
		}

	}

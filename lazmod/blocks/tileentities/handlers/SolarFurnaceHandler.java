package lazmod.blocks.tileentities.handlers;

import lazmod.ScienceCraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class SolarFurnaceHandler implements ISolarHandler {

	@Override
	public int getInventoryStackLimit()
		{
		return ScienceCraft.DateHandler.BlockyISlimit;
		}
	
	@Override
	public boolean isItemValidForSlot(int slot)
		{
		if (slot == 1) return false;
		return true;
		}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) 
		{
		if (side == 1) {return new int[]{0};}
		else {return new int[]{1};}
		}

	@Override
	public boolean canInsertItem(int slot, int side)
		{
		if ((slot == 1) || (side != 1)) {return false;}
		return true;
		}

	@Override
	public boolean canExtractItem(int slot, int side)
		{
		if ((slot == 0 && side != 1) || (slot == 1 && side == 1)) {return false;}
		return true;
		}

	@Override
	public ItemStack[] useItem(ItemStack[] inventory)
		{
		if (canUse(inventory))
			{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(inventory[0]);

			if (inventory[1] == null)
				{
				inventory[1] = itemstack.copy();
				}
			else if (inventory[1].isItemEqual(itemstack))
				{
				inventory[1].stackSize += itemstack.stackSize;
				}

			--inventory[0].stackSize;

			if (inventory[0].stackSize <= 0)
				{
				inventory[0] = null;
				}
			}
		return inventory;
		}

	@Override
	public boolean canUse(ItemStack[] inventory)
		{
		if (inventory[0] == null)
				{
				return false;
				}
		else
			{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(inventory[0]);
			if (itemstack == null) return false;
			if (inventory[1] == null) return true;
			if (inventory[1].isItemEqual(itemstack)) return true;
			int result = inventory[1].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
			}
		}

}

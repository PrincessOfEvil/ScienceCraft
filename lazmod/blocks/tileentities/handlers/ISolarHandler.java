package lazmod.blocks.tileentities.handlers;

import net.minecraft.item.ItemStack;

public interface ISolarHandler 

{
	public int			getInventoryStackLimit();
	public boolean		isItemValidForSlot(int slot);
	public int[]		getAccessibleSlotsFromSide(int side);
	public boolean		canInsertItem(int slot, int side);
	public boolean		canExtractItem(int slot, int side);
	public ItemStack[]	useItem(ItemStack[] inventory);
	public boolean		canUse(ItemStack[] inventory);
}

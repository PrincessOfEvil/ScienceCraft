package lazmod.blocks.tileentities.handlers;

import net.minecraft.item.ItemStack;

public class SolarSmasherHandler implements ISolarHandler {

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isItemValidForSlot(int slot) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int slot, int side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int slot, int side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack[] useItem(ItemStack[] inventory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canUse(ItemStack[] inventory) {
		// TODO Auto-generated method stub
		return false;
	}
}

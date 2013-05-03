package mods.lazmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileBlockyBlock extends TileEntity implements ISidedInventory //TODO: Alot.
	{
    private final byte blockTypeAmnt = 1;
    
    public int thisBlockType = 0; // itemblock should change this
    
    public	String[]	blockType	=	{
    									
    								 	"SolarFurnace"
    									
    									};
    public	int[]		ISamnt		= 	{
    		
    									2
    									
    									};
    
    private ItemStack[]	itemStacks	= new ItemStack[ISamnt[thisBlockType]];

    public TileBlockyBlock(int i)
    	{
    	thisBlockType = i;
    	}
    
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] getSizeInventorySide(int var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean func_102007_a(int par1, ItemStack par2ItemStack, int par3)
		{
        return this.isStackValidForSlot(par1, par2ItemStack);
		}

	@Override
	public boolean func_102008_b(int i, ItemStack itemstack, int j)
		{
		// TODO Auto-generated method stub
		return false;
		}
    
	}

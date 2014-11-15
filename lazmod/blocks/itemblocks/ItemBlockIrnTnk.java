package lazmod.blocks.itemblocks;

import java.util.List;

import lazmod.DataHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

public class ItemBlockIrnTnk extends ItemBlock implements IFluidContainerItem
	{
	public ItemBlockIrnTnk(Block par1)
		{
		super(par1);
		setMaxDamage(DataHandler.IrnTnkDfltCapacity);
		maxStackSize = 1;
		setNoRepair();
		}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
		{
		try
			{
			FluidStack fluid = FluidStack.loadFluidStackFromNBT(par1ItemStack.getTagCompound().getCompoundTag("Fluid"));
			
			if (fluid != null)
				{
				par3List.add(fluid.getFluid().getName() + " : " + ((Integer) fluid.amount).toString() + "/" + ((Integer) par1ItemStack.getTagCompound().getInteger("Capacity")).toString());
				}
			else
				{
				par3List.add("Empty");
				}
			}
		catch (NullPointerException e)
			{
			par3List.add("Empty");
			}
		}
	
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
		{
		return EnumRarity.uncommon;
		}
	
	@Override
	public FluidStack getFluid(ItemStack container)
		{
		return FluidStack.loadFluidStackFromNBT(container.getTagCompound().getCompoundTag("Fluid"));
		}
	
	@Override
	public int getCapacity(ItemStack container)
		{
		return container.getTagCompound().getInteger("Capacity");
		}
	
	@Override
	public int fill(ItemStack container, FluidStack resource, boolean doFill)
		{
		return 0;
		}
	
	@Override
	public FluidStack drain(ItemStack container, int maxDrain, boolean doDrain)
		{
		return null;
		}
	}

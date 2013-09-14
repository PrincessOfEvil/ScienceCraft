package lazmod.blocks.itemblocks;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class ItemBlockIrnTnk extends ItemBlock
	{
	public ItemBlockIrnTnk(int par1)
		{
		super(par1);
		}
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
		{
		FluidStack fluid = FluidStack.loadFluidStackFromNBT(par1ItemStack.stackTagCompound);
		if (fluid != null)
			{
			par3List.add("Fluid = " + fluid.getFluid().getName());
			par3List.add("Fluid amount = " + ((Integer)fluid.amount).toString());
			}
		else
			{
			par3List.add("Empty");
			}
		}
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
		{
		return EnumRarity.uncommon;
		}
	}

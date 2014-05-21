package lazmod.blocks.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileWtrSrc extends TileEntity implements IFluidHandler
	{
	private static Fluid	WATER			= FluidRegistry.WATER;
	private static int		BUCKET_VOLUME	= FluidContainerRegistry.BUCKET_VOLUME;
	
	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid)
		{
		return true;
		}
	
	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid)
		{
		return false;
		}
	
	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain)
		{
		// TODO Auto-generated method stub
		return null;
		}
	
	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
		{
		int drained = maxDrain;
		if (drained > BUCKET_VOLUME)
			{
			drained = BUCKET_VOLUME;
			}
		FluidStack stack = new FluidStack(WATER, drained);
		if (doDrain)
			{
			FluidTank tank = new FluidTank(WATER, BUCKET_VOLUME, BUCKET_VOLUME);
			
			FluidEvent.fireEvent(new FluidEvent.FluidDrainingEvent(stack, worldObj, xCoord, yCoord, zCoord, tank));
			}
		return stack;
		}
	
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill)
		{
		return 0;
		}
	
	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from)
		{
		FluidTank tank = new FluidTank(WATER, FluidContainerRegistry.BUCKET_VOLUME, FluidContainerRegistry.BUCKET_VOLUME);
		return new FluidTankInfo[] { tank.getInfo() };
		}
	
	}

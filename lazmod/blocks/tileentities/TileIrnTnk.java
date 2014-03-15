package lazmod.blocks.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileIrnTnk extends TileEntity implements IFluidHandler
	{
	public FluidTank	tank;

	public TileIrnTnk()
		{
		this(null, 0);
		}

	public TileIrnTnk(int capacity)
		{
		this(null, capacity);
		}

	public TileIrnTnk(FluidStack fluid, int capacity)
		{
		tank = new FluidTank(fluid, capacity * FluidContainerRegistry.BUCKET_VOLUME);
		}

	@Override
	public void readFromNBT(NBTTagCompound data)
		{
		super.readFromNBT(data);
		tank.readFromNBT(data);
		tank.setCapacity(data.getInteger("Capacity"));
		}

	@Override
	public void writeToNBT(NBTTagCompound data)
		{
		super.writeToNBT(data);
		tank.writeToNBT(data);
		data.setInteger("Capacity", tank.getCapacity());
		}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill)
		{
		return tank.fill(resource, doFill);
		}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain)
		{
		if (resource == null || !resource.isFluidEqual(tank.getFluid())) { return null; }
		return tank.drain(resource.amount, doDrain);
		}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
		{
		return tank.drain(maxDrain, doDrain);
		}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid)
		{
		return true;
		}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid)
		{
		return true;
		}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from)
		{
		return new FluidTankInfo[] {tank.getInfo()};
		}
	}

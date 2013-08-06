package lazmod.blocks.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

public class TileIrnTnk extends TileEntity implements IFluidTank //TODO: crash. Also, it's a copy of FhTank.
	{
    protected FluidStack fluid;
    protected int capacity;
    protected TileEntity tile;

    public TileIrnTnk(int capacity)
    	{
        this(null, capacity);
    	}

    public TileIrnTnk(FluidStack stack, int capacity)
    	{
        this.fluid = stack;
        this.capacity = capacity;
    	}
	
	@Override
	public void readFromNBT(NBTTagCompound data)
		{
		super.readFromNBT(data);
        if (!data.hasKey("Empty"))
        	{
            FluidStack fluid = FluidStack.loadFluidStackFromNBT(data);

            if (fluid != null)
            	{
                setFluid(fluid);
            	}
        	}
		}
	@Override
	public void writeToNBT(NBTTagCompound data)
		{
		super.writeToNBT(data);
        if (fluid != null)
        	{
            fluid.writeToNBT(data);
        	}
        else 
        	{
        	data.setString("Empty", "");
        	}
		}
	
	@Override
	public FluidStack getFluid()
		{
		return fluid;
		}
    public void setFluid(FluidStack fluid)
	{
    this.fluid = fluid;
	}
    
	@Override
	public int getFluidAmount()
		{
        if (fluid == null)
        	{
            return 0;
        	}
        return fluid.amount;
		}
	@Override
	public int getCapacity()
		{
		return capacity;
		}
    public void setCapacity(int capacity)
    	{
        this.capacity = capacity;
    	}

	@Override
	public FluidTankInfo getInfo()
		{
        return new FluidTankInfo(this);
		}

	@Override
	public int fill(FluidStack resource, boolean doFill)
		{
        if (resource == null)
        	{
            return 0;
        	}
        if (!doFill)
        	{
            if (fluid == null)
            	{
                return Math.min(capacity, resource.amount);
            	}
            if (!fluid.isFluidEqual(resource))
            	{
                return 0;
            	}
            return Math.min(capacity - fluid.amount, resource.amount);
        	}
        if (fluid == null)
        	{
            fluid = new FluidStack(resource, Math.min(capacity, resource.amount));

            if (tile != null)
            	{
                FluidEvent.fireEvent(new FluidEvent.FluidFillingEvent(fluid, tile.worldObj, tile.xCoord, tile.yCoord, tile.zCoord, this));
            	}
            return fluid.amount;
        	}
        if (!fluid.isFluidEqual(resource))
        	{
            return 0;
        	}
        int filled = capacity - fluid.amount;

        if (resource.amount < filled)
        	{
            fluid.amount += resource.amount;
            filled = resource.amount;
        	}
        else
        	{
            fluid.amount = capacity;
        	}
        if (tile != null)
        	{
            FluidEvent.fireEvent(new FluidEvent.FluidFillingEvent(fluid, tile.worldObj, tile.xCoord, tile.yCoord, tile.zCoord, this));
        	}
        return filled;
	}
	@Override
	public FluidStack drain(int maxDrain, boolean doDrain)
		{
        if (fluid == null)
        	{
            return null;
        	}
        int drained = maxDrain;

        if (fluid.amount < drained)
        	{
            drained = fluid.amount;
        	}
        
        FluidStack stack = new FluidStack(fluid, drained);

        if (doDrain)
        	{
            fluid.amount -= drained;

            if (fluid.amount <= 0)
            	{
                fluid = null;
            	}
            if (tile != null)
            	{
                FluidEvent.fireEvent(new FluidEvent.FluidDrainingEvent(fluid, tile.worldObj, tile.xCoord, tile.yCoord, tile.zCoord, this));
            	}
        	}
        return stack;
		}
	}
	

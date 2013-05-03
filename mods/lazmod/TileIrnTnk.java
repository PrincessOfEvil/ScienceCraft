package mods.lazmod;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileIrnTnk extends HEC_Entity implements ITankContainer //TODO: crash.
	{
	public LiquidTank IrnTnk = new LiquidTank(LiquidContainerRegistry.BUCKET_VOLUME * 32);
	
	@Override
	public void readFromNBT(NBTTagCompound data)
		{
		super.readFromNBT(data);

		if (data.hasKey("stored") && data.hasKey("liquidId"))
			{
			LiquidStack liquid = new LiquidStack(data.getInteger("liquidId"), data.getInteger("stored"), 0);
			IrnTnk.setLiquid(liquid);
			}
		else
			{
			LiquidStack liquid = LiquidStack.loadLiquidStackFromNBT(data.getCompoundTag("IrnTnk"));
			if (liquid != null)
				{
				IrnTnk.setLiquid(liquid);
				}
			}
		}
	@Override
	public void writeToNBT(NBTTagCompound data)
		{
		super.writeToNBT(data);
		if (IrnTnk.containsValidLiquid())
			{
			data.setTag("IrnTnk", IrnTnk.getLiquid().writeToNBT(new NBTTagCompound()));
			}
		}

	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		return fill(0, resource, doFill);
	}

	@Override
	public int fill(int tankIndex, LiquidStack resource, boolean doFill)
		{
		if (tankIndex != 0 || resource == null)
			{
			return 0;
			}
			
		resource = resource.copy();
		int totalUsed = 0;
		TileIrnTnk tankToFill = this;
        LiquidStack liquid = tankToFill.IrnTnk.getLiquid();

        if (liquid != null && !liquid.isLiquidEqual(resource))
        	{
            return 0;
        	}
        
		while (tankToFill != null && resource.amount > 0)
			{
			int used = tankToFill.IrnTnk.fill(resource, doFill);
			resource.amount -= used;
			totalUsed += used;
			}
		return totalUsed;
		}

	@Override
	public LiquidStack drain(ForgeDirection from, int maxEmpty, boolean doDrain) {
		return drain(0, maxEmpty, doDrain);
	}

	@Override
	public LiquidStack drain(int tankIndex, int maxEmpty, boolean doDrain) 
		{
		return IrnTnk.drain(maxEmpty, doDrain);
		}

	@Override
	public ILiquidTank[] getTanks(ForgeDirection direction)
		{
		LiquidTank IrnTank = new LiquidTank(IrnTnk.getCapacity());

		IrnTank.setCapacity(IrnTnk.getCapacity());
		return new ILiquidTank[] { IrnTank };
		}
	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type)
		{
		return IrnTnk;
		}
	
//	private int timer = 1;
//	public void updateEntity()
//		{
//		this.timer++;
//		if (this.timer > 32) {this.timer = 1;}
//		if (this.timer == 32)
//			{
//			AnnihilationCraft.TempSystem.addMatter(-1);
//			System.out.println("Matter: "+AnnihilationCraft.TempSystem.getMatter());
//			}
//		System.out.println("Timer: "+this.timer);
//		}
	}
	

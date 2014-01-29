package lazmod.crystal;

import lazmod.CES.CESWaveEvent;
import lazmod.blocks.tileentities.CESTileEntity;
import lazmod.blocks.tileentities.logic.SolarLogic;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class TileCrystal extends CESTileEntity
	{
	public String type;
	public int size;
	public String username;
	
	public TileCrystal(){}
	
	public TileCrystal(String cType)
		{
		type = cType;
		MinecraftForge.EVENT_BUS.register(this);
		}
	
	public void undoCharge()
		{
		if (maxAdded == true)
			{
			system.addMax(-8000);
			}
		}
	
	@ForgeSubscribe
	@Override
    public void onWaveEvent(CESWaveEvent event)
		{
		if (!worldObj.isRemote)
			if (this.type == "Derivium")
			{
				{
				if (event.player == this.player)
					{
			    	if (maxAdded == false)
						{
			    		system.addMax(8000);
			    		maxAdded = true;
						}
			    	system.add((int) (worldObj.getLightBrightness(xCoord, yCoord+1, zCoord)*160));
					}
				}
			}
    	}
	
	@Override
	public void readFromNBT(NBTTagCompound data)
		{
		super.readFromNBT(data);
		type = data.getString("Type");
		}

	@Override
	public void writeToNBT(NBTTagCompound data)
		{
		super.writeToNBT(data);
		data.setString("Type", type);
		}
	}
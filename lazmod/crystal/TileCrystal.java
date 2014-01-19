package lazmod.crystal;

import lazmod.EMS.EMSWaveEvent;
import lazmod.EMS.EnergyMatterSystem.EMSType;
import lazmod.blocks.tileentities.EMSTileEntity;
import lazmod.blocks.tileentities.logic.SolarLogic;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class TileCrystal extends EMSTileEntity
	{
	public String type;
	public int size;
	public String username;
	
	public TileCrystal(){}
	
	public TileCrystal(int Size,String Type)
		{
		size = Size;
		type = Type;
		MinecraftForge.EVENT_BUS.register(this);
		}
	
	public void undoCharge()
		{
		if (maxAdded == true)
			{
			system.addMax(EMSType.ENERGY, -4000 * size);
			}
		}
	
	@ForgeSubscribe
	@Override
    public void onWaveEvent(EMSWaveEvent event)
		{
		if (!worldObj.isRemote)
			if (this.type == "Derivium")
			{
				{
				if (event.player.username == this.player)
					{
			    	if (maxAdded == false)
						{
			    		system.addMax(EMSType.ENERGY, 4000 * size);
			    		maxAdded = true;
						}
			    	system.add(EMSType.ENERGY,(int) (worldObj.getLightBrightness(xCoord, yCoord+1, zCoord)*320/4*size));
					}
				}
			}
    	}
	
	@Override
	public void readFromNBT(NBTTagCompound data)
		{
		super.readFromNBT(data);
		size = data.getInteger("Size");
		type = data.getString("Type");
		}

	@Override
	public void writeToNBT(NBTTagCompound data)
		{
		super.writeToNBT(data);
		data.setInteger("Size", size);
		data.setString("Type", type);
		}
	}
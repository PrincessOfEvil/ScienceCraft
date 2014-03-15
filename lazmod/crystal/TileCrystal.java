package lazmod.crystal;

import lazmod.CES.CESWaveEvent;
import lazmod.blocks.tileentities.CESTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TileCrystal extends CESTileEntity
	{
	public String	type;
	public int		size;
	public String	username;

	public TileCrystal()
		{}

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

	@SubscribeEvent
	@Override
	public void onWaveEvent(CESWaveEvent event)
		{
		if (!worldObj.isRemote)
			{
			if (type == "Derivium")
				{
					{
					if (event.player == player)
						{
						if (maxAdded == false)
							{
							system.addMax(8000);
							maxAdded = true;
							}
						system.add((int) (worldObj.getLightBrightness(xCoord, yCoord + 1, zCoord) * 160));
						}
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
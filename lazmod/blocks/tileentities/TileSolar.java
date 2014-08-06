package lazmod.blocks.tileentities;

import lazmod.CES.CESWaveEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TileSolar extends CESTileEntity
	{
	public final byte type;

	public TileSolar(byte cType)
		{
		type = cType;
		}

	@SubscribeEvent
	public void onWaveEvent(CESWaveEvent event)
		{
		if (!worldObj.isRemote)
			{
			if (event.player.equals(player))
				{
				
				}
			}
		}
	}

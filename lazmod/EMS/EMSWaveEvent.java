package lazmod.EMS;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Event;

public class EMSWaveEvent extends Event
	{
	public final EntityPlayer player;
	
	public EMSWaveEvent(EntityPlayer cPlayer)
		{
		player = cPlayer;
		}
	}

package lazmod.CES;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Event;

public class CESWaveEvent extends Event
	{
	public final String player;
	
	public CESWaveEvent(String cPlayer)
		{
		player = cPlayer;
		}
	}

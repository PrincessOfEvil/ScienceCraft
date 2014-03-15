package lazmod.CES;

import cpw.mods.fml.common.eventhandler.Event;

public class CESWaveEvent extends Event
	{
	public final String	player;
	
	public CESWaveEvent(String cPlayer)
		{
		player = cPlayer;
		}
	}

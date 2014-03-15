package lazmod.CES;

import java.util.Timer;
import java.util.TimerTask;

import net.minecraftforge.common.MinecraftForge;

public class CESWaveShooter
	{
	public CESWaveShooter(final String cPlayer)
		{
		Timer timer = new Timer(true);
		timer.schedule(new TimerTask()
			{
				@Override
				public void run()
					{
					MinecraftForge.EVENT_BUS.post(new CESWaveEvent(cPlayer));
					}
			}, 0, 1000);
		}
	}

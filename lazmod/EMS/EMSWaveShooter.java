package lazmod.EMS;

import java.util.Timer;
import java.util.TimerTask;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class EMSWaveShooter
	{	
	public EMSWaveShooter(final EntityPlayer cPlayer)
		{
		Timer timer = new Timer(true);
		timer.schedule(
			new TimerTask()
				{
				@Override
				public void run()
					{
					MinecraftForge.EVENT_BUS.post(new EMSWaveEvent(cPlayer));
					}
				}
		, 0, 1000);
		}
	}

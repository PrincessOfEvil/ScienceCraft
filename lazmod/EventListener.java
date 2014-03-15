package lazmod;

import lazmod.CES.CrystalEnergySystem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventListener
	{
	@SubscribeEvent
	public void playerJoinLoadCES(EntityJoinWorldEvent event)
		{
		if (!event.world.isRemote)
			{
			if (event.entity instanceof EntityPlayer)
				{
				if (!ScienceCraft.DateHandler.CES.containsKey(((EntityPlayer) event.entity).getGameProfile().getName()))
					{
					String name = ((EntityPlayer) event.entity).getGameProfile().getName();
					CrystalEnergySystem CES = new CrystalEnergySystem(name);
					ScienceCraft.DateHandler.CES.put(name, CES);
					}
				}
			}
		}
	}
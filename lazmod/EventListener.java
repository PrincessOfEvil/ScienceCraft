package lazmod;

import lazmod.CES.CrystalEnergySystem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventListener
	{
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
		{
		if (event.entity instanceof EntityPlayer && CrystalEnergySystem.get((EntityPlayer) event.entity) == null)
			{
			CrystalEnergySystem.register((EntityPlayer) event.entity);
			}
		}
	}
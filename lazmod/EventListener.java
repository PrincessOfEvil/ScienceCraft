package lazmod;

import java.util.Iterator;

import lazmod.CES.CrystalEnergySystem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.WorldEvent.Save;

public class EventListener
	{
	@ForgeSubscribe
	public void playerJoinLoadCES(EntityJoinWorldEvent event)
		{
		if (!event.world.isRemote)
			{
			if (event.entity instanceof EntityPlayer)
				{
				if (!ScienceCraft.DateHandler.CES.containsKey(((EntityPlayer)event.entity).username))
					{
					String name = ((EntityPlayer) event.entity).username;
					CrystalEnergySystem CES = new CrystalEnergySystem(name);
					ScienceCraft.DateHandler.CES.put(name, CES);
					}
				}
			}
		}
	}
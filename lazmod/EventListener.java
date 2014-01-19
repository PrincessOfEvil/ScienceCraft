package lazmod;

import java.util.Iterator;

import lazmod.EMS.EnergyMatterSystem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.WorldEvent.Save;

public class EventListener
	{
	// For EMS
	@ForgeSubscribe
	public void playerJoinLoadEMS(EntityJoinWorldEvent event)
		{
		if (!event.world.isRemote)
			{
			if (event.entity instanceof EntityPlayer)
				{
				EntityPlayer entity = (EntityPlayer) event.entity;
				int[] array;
				
				if (event.entity.getEntityData().getBoolean("EMS"))
					{
					NBTTagCompound tags = entity.getEntityData();
					array = tags.getIntArray("EMS_Amounts");
					EnergyMatterSystem ems = new EnergyMatterSystem(entity, array);
					
					}
				else
					{
					EnergyMatterSystem ems = new EnergyMatterSystem(entity);
					}
				}
			}
		}
	
	@ForgeSubscribe
	public void playerSaveEMS(Save event)
		{
		if (!event.world.isRemote)
			{
			Iterator iterator = event.world.playerEntities.iterator();
			while (iterator.hasNext())
				{
				EntityPlayer entity = (EntityPlayer) iterator.next();
				if (ScienceCraft.DateHandler.EMS.containsKey(entity.username))
					{
					NBTTagCompound tags = entity.getEntityData();
					tags.setBoolean("EMS", true);
					tags.setIntArray("EMS_Amounts", ((EnergyMatterSystem)(ScienceCraft.DateHandler.EMS.get(entity.username))).get());
					}
				}
			}
		}
	}

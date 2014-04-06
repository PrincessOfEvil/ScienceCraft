package tests;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EventListenerModded
	{
	@SubscribeEvent
	public void onEntityJoinWorldEvent(EntityJoinWorldEvent event)
		{
		if (event.entity instanceof EntityPlayer)
			{
			EntityPlayer entity = (EntityPlayer)event.entity;
			entity.inventory = new InventoryPlayerModded(entity);
			entity.inventoryContainer = new ContainerPlayerModded((InventoryPlayerModded) entity.inventory, event.world.isRemote, entity);
			}
		}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onGuiOpenEvent(GuiOpenEvent event)
		{
		if (event.gui instanceof GuiInventory)
			{
			GuiInventory gui = (GuiInventory)event.gui;
			event.gui = new GuiInventoryModded(Minecraft.getMinecraft().thePlayer);
			}
		}
	}

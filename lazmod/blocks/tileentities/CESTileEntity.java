package lazmod.blocks.tileentities;

import lazmod.ScienceCraft;
import lazmod.CES.CESWaveEvent;
import lazmod.CES.CrystalEnergySystem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public abstract class CESTileEntity extends TileEntity
	{
	protected EntityPlayer				player;
	
	protected boolean				maxAdded	= false;
	
	public CESTileEntity()
		{}
	
	@SubscribeEvent
	public void onWaveEvent(CESWaveEvent event)
		{}
	
	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
		{
		super.readFromNBT(tagCompound);
		player = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(tagCompound.getString("Player"));
		}
	
	public void tileRegister(EntityPlayer cPlayer)
		{
		player = cPlayer;
		MinecraftForge.EVENT_BUS.register(this);
		}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
		{
		super.writeToNBT(tagCompound);
		tagCompound.setString("Player", player.getDisplayName());
		}
	}

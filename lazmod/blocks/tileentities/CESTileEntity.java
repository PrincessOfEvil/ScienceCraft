package lazmod.blocks.tileentities;

import lazmod.ScienceCraft;
import lazmod.CES.CESWaveEvent;
import lazmod.CES.CrystalEnergySystem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public abstract class CESTileEntity extends TileEntity
	{
	protected String				player;
	
	protected CrystalEnergySystem	system;
	
	protected boolean				maxAdded	= false;
	
	public CESTileEntity()
		{}
	
	public void tileRegister(String username)
		{
		player = username;
		MinecraftForge.EVENT_BUS.register(this);
		system = ScienceCraft.dataHandler.CES.get(player);
		}
	
	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
		{
		super.readFromNBT(tagCompound);
		player = tagCompound.getString("Player");
		system = ScienceCraft.dataHandler.CES.get(player);
		}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
		{
		super.writeToNBT(tagCompound);
		tagCompound.setString("Player", player);
		}
	
	@SubscribeEvent
	public void onWaveEvent(CESWaveEvent event)
		{}
	}

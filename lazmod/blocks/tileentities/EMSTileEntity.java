package lazmod.blocks.tileentities;

import lazmod.ScienceCraft;
import lazmod.EMS.EMSWaveEvent;
import lazmod.EMS.EnergyMatterSystem;
import lazmod.EMS.EnergyMatterSystem.EMSType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public abstract class EMSTileEntity extends TileEntity
	{
	protected String player;

    protected EnergyMatterSystem system;
    
    protected boolean maxAdded = false;
	
    public EMSTileEntity(){}
    
	public void tileRegister(String username)
		{
		player = username;
		MinecraftForge.EVENT_BUS.register(this);
		system = ScienceCraft.DateHandler.EMS.get(player);
		}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) 
		{
		super.readFromNBT(tagCompound);
		player = tagCompound.getString("Player");
		system = ScienceCraft.DateHandler.EMS.get(player);
		}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) 
		{
		super.writeToNBT(tagCompound);
		tagCompound.setString("Player", player);
		}
	
	@ForgeSubscribe
	public void onWaveEvent(EMSWaveEvent event){}
	}

package lazmod.blocks.tileentities;

import lazmod.ScienceCraft;
import lazmod.CES.CESWaveEvent;
import lazmod.CES.CrystalEnergySystem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public abstract class CESTileEntity extends TileEntity
	{
	protected String player;

    protected CrystalEnergySystem system;
    
    protected boolean maxAdded = false;
	
    public CESTileEntity(){}
    
	public void tileRegister(String username)
		{
		player = username;
		MinecraftForge.EVENT_BUS.register(this);
		system = ScienceCraft.DateHandler.CES.get(player);
		}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) 
		{
		super.readFromNBT(tagCompound);
		player = tagCompound.getString("Player");
		system = ScienceCraft.DateHandler.CES.get(player);
		}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) 
		{
		super.writeToNBT(tagCompound);
		tagCompound.setString("Player", player);
		}
	
	@ForgeSubscribe
	public void onWaveEvent(CESWaveEvent event){}
	}

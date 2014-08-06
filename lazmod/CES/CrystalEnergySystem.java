package lazmod.CES;

import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import lazmod.DataHandler;
import lazmod.ScienceCraft;

public class CrystalEnergySystem implements IExtendedEntityProperties
	{
	private EntityPlayer player;
	
	private int	energy;	// Generated ONLY by fusion
							
	private int	maxEnergy;
	
	public static String name = "CrystalEnergySystem";
	
	public CrystalEnergySystem(EntityPlayer cPlayer)
		{
		player = cPlayer;
		}
	
	public static final void register(EntityPlayer cPlayer)
		{
		cPlayer.registerExtendedProperties(name, new CrystalEnergySystem(cPlayer));
		}

	public static final CrystalEnergySystem get(EntityPlayer player)
		{
		return (CrystalEnergySystem) player.getExtendedProperties(name);
		}

	
	@Override
	public void saveNBTData(NBTTagCompound compound)
		{
		NBTTagCompound properties = new NBTTagCompound();

		properties.setInteger("Energy", this.energy);
		properties.setInteger("MaxEnergy", this.maxEnergy);

		compound.setTag(name, properties);
		}

	@Override
	public void loadNBTData(NBTTagCompound compound)
		{
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(name);
		
		this.energy = properties.getInteger("Energy");
		this.maxEnergy = properties.getInteger("MaxEnergy");
		
		System.out.println("	[SC] Energy from NBT: " + energy + "/" + maxEnergy);

		if (ScienceCraft.dataHandler.shooterMap == null)
			{
			ScienceCraft.dataHandler.shooterMap = new HashMap();
			}
		if (!(ScienceCraft.dataHandler.shooterMap.containsKey(player.getDisplayName())))
			{
			ScienceCraft.dataHandler.shooterMap.put(player.getDisplayName(), new CESWaveShooter(player.getDisplayName()));
			}
		}

	@Override
	public void init(Entity entity, World world)
		{
		}
	
	public void add(int amount)
		{
		energy += amount;
		if (energy > maxEnergy)
			{
			energy = maxEnergy;
			}
		}
	
	public void addMax(int amount)
		{
		maxEnergy += amount;
		}
	
	public int get()
		{
		return energy;
		}
	
	public int[] getAll()
		{
		return new int[] { energy, maxEnergy };
		}
	
	public int getMax()
		{
		return maxEnergy;
		}
	
	public void set(int amount)
		{
		energy = amount;
		if (energy > maxEnergy)
			{
			energy = maxEnergy;
			}
		}
	}
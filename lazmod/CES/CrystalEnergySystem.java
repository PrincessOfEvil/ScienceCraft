package lazmod.CES;

import lazmod.ScienceCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CrystalEnergySystem
{
	private int energy;		// Generated ONLY by fusion
	
	private int maxEnergy;
	
	private String player;
	
	public CrystalEnergySystem(String cPlayer)
		{
		player			= cPlayer;
		addToList(cPlayer);
		}
	
	private void addToList(String cPlayer)
		{
		ScienceCraft.DateHandler.CES.put(cPlayer, this);
		CESWaveShooter shooter = new CESWaveShooter(cPlayer);
		}
	
	public void add(int amount)
		{
		energy += amount;
		if (energy > maxEnergy)
			{
			energy = maxEnergy;
			}
		}
	public void set(int amount)
		{
		energy = amount;
		if (energy > maxEnergy)
			{
			energy = maxEnergy;
			}
		}
	public int get()
		{
		return energy;
		}

	public void addMax(int amount)
		{
		maxEnergy		+= amount;
		}
	public int getMax()
		{
		return maxEnergy;
		}
	public int[] getAll()
		{
		return new int[]{energy, maxEnergy};
		}
	}
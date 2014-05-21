package lazmod.CES;

import lazmod.ScienceCraft;

public class CrystalEnergySystem
	{
	private int	energy;	// Generated ONLY by fusion
							
	private int	maxEnergy;
	
	public CrystalEnergySystem(String cPlayer)
		{
		addToList(cPlayer);
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
	
	private void addToList(String cPlayer)
		{
		ScienceCraft.dataHandler.CES.put(cPlayer, this);
		new CESWaveShooter(cPlayer);
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
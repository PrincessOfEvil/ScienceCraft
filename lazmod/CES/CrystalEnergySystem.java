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
	
	private void addToList(String cPlayer)
		{
		ScienceCraft.dataHandler.CES.put(cPlayer, this);
		new CESWaveShooter(cPlayer);
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
		maxEnergy += amount;
		}
	
	public int getMax()
		{
		return maxEnergy;
		}
	
	public int[] getAll()
		{
		return new int[] { energy, maxEnergy };
		}
	}
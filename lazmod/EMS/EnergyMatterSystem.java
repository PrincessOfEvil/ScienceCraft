package lazmod.EMS;

public class EnergyMatterSystem
{
	private int Energy;
	private int Matter;
	
	public EnergyMatterSystem()
		{
		this.Energy = 100500;
		this.Matter = 100500;
		}
	public EnergyMatterSystem(int energy, int matter)
		{
		this.Energy = energy;
		this.Matter = matter;
		}
	

	public void addEnergy(int amount)
		{
		this.Energy += amount;
		}
	public void addMatter(int amount)
		{
		this.Matter += amount;
		}
	public void addAnything(int energy, int matter)
		{
		this.Energy += energy;
		this.Matter += matter;
		}
	

	public int getEnergy()
		{
		return this.Energy;
		}
	public int getMatter()
		{
		return this.Matter;
		}
}
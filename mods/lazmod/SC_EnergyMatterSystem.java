package mods.lazmod;

/**
Energy/matter class.
Actually, I don't know how to call it.
*/
public class SC_EnergyMatterSystem
{
	private int Energy;
	private int Matter;
	
	/**
	Constructor.
	Sets energy and matter to 100500.
	*/
	public SC_EnergyMatterSystem()
		{
		this.Energy = 100500;
		this.Matter = 100500;
		}
	/**
	Constructor.
	*/
	public SC_EnergyMatterSystem(int energy, int matter)
		{
		this.Energy = energy;
		this.Matter = matter;
		}
	
	/**
	Relative setter.
	*/
	public void addEnergy(int amount)
		{
		this.Energy += amount;
		}
	/**
	Relative setter.
	*/
	public void addMatter(int amount)
		{
		this.Matter += amount;
		}
	/**
	Relative setter.
	*/
	public void addAnything(int energy, int matter)
		{
		this.Energy += energy;
		this.Matter += matter;
		}
	
	/**
	Typical getter.
	*/
	public int getEnergy()
		{
		return this.Energy;
		}
	/**
	Typical getter.
	*/
	public int getMatter()
		{
		return this.Matter;
		}
}
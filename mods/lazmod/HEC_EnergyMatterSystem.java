package mods.lazmod;

/**
Energy/matter class.
Actually, I don't know how to call it.
*/
public class HEC_EnergyMatterSystem
{
	private int Energy;
	private int Matter;
	
	/**
	Lazy constructor.
	*/
	public HEC_EnergyMatterSystem()
		{
		this.Energy = 100500;
		this.Matter = 100500;
		}
	/**
	Constructor. I'm pretty sure it's done O_o
	*/
	public HEC_EnergyMatterSystem(int energy, int matter)
		{
		this.Energy = energy;
		this.Matter = matter;
		}
	
	/**
	Relative setter. Fuck isGen.
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
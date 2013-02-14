package lazmod;

public class ACEnergy
{
	private int Energy;
	
	public ACEnergy()
		{
		this.Energy = 100500;
		}
	public ACEnergy(int energy)
		{
		this.Energy = energy;
		}
	
	/**
	Relative setter.
	*/
	public void EnergyEdit(int amount, boolean isGenerator)
		{
		if (isGenerator)
			{
			this.Energy += amount;
			}
		else
			{
			this.Energy -= amount;
			}
		}
	/**
	Typical getter.
	*/
	public int getEnergy()
		{
		return this.Energy;
		}
}
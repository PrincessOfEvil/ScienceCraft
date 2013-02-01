package lazmod;

public class ACEnergy
{
	public int Energy = 100500;

	/**
	 * 
	 * @param amount Amount of energy 
	 * @param gen Generator?
	 */
	public void EnergyEdit(int amount, boolean gen)
		{
		if (gen)
			{
			this.Energy += amount;
			}
		else
			{
			this.Energy -= amount;
			}
		}
}
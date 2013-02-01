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
		if (gen = true)
			{
			this.Energy += amount;
			}
		else if (gen = false)
			{
//			this.Energy -= amount;
			this.Energy = this.Energy - amount;
			}
		}
}
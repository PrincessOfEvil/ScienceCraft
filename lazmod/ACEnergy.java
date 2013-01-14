package lazmod;

public class ACEnergy
{
	public int ACEnergy = 100500;
	
	public void ACEnEd(int amount, boolean gen)
		{
		if (gen = true)
			{
			this.ACEnergy += amount;
			}
		else
			{
			this.ACEnergy -= amount;
			}
		}
}

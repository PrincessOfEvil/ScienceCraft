package lazmod;

/**
Energy class.
Maybe I have to change it to energy/matter class? 
*/
public class ACEnergy
{
	private int Energy;
	
	/**
	Lazy constructor.
	*/
	public ACEnergy()
		{
		this.Energy = 100500;
		}
	/**
	Constructor. I'm pretty sure it's done O_o
	*/
	public ACEnergy(int energy)
		{
		this.Energy = energy;
		}
	
	/**
	Relative setter.
	*/
	public void edtEnergy(int amount, boolean isGenerator)
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
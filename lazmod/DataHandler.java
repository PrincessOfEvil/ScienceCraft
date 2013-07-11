package lazmod;

public class DataHandler
	{
	public DataHandler() {};
	
    public final byte	BlockyBlockTypeAmount	= 1;
	public byte[]		BlockyISamount			= new byte	[BlockyBlockTypeAmount];
	public String[]		BlockyBlockTypeName		= new String[BlockyBlockTypeAmount];
	public String[]		BlockyLocalization		= new String[BlockyBlockTypeAmount];
	public int[]		BlockyDangerSlot		= new int	[BlockyBlockTypeAmount];

	public byte[][]		BlockySlotCoordX		= new byte	[BlockyBlockTypeAmount][2];
	public byte[][]		BlockySlotCoordY		= new byte	[BlockyBlockTypeAmount][2];

	
    public final byte	CraftingItemNumber		= 3;
	public String[]		CraftingLocalization	= new String[CraftingItemNumber];

	
	public void addValues()
		{
		BlockyBlockTypeName[0]	= "SolarFurnace";
		BlockyISamount[0]		= 2;
		BlockyDangerSlot[0]		= 1;
		
		BlockySlotCoordX[0][0]	= 56;
		BlockySlotCoordY[0][0]	= 35;
		BlockySlotCoordX[0][1]	= 116;
		BlockySlotCoordY[0][1]	= 35;
		
		
		}
	public void addLocalizations()
		{
		CraftingLocalization[0] = "Placeholder";
		CraftingLocalization[1] = "Soul in a Bottle";
		CraftingLocalization[2] = "Contained Spaaaace!";
		
		BlockyLocalization[0] = "Solar Furnace";
		}
	}
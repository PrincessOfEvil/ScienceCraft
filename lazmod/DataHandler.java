package lazmod;

import lazmod.blocks.tileentities.handlers.ISolarHandler;
import lazmod.blocks.tileentities.handlers.SolarFurnaceHandler;
import lazmod.blocks.tileentities.handlers.SolarSmasherHandler;

public class DataHandler
	{
	public DataHandler() {};
	
    public final byte		BlockyBlockTypeAmount	= 2;
    public final int		BlockyISlimit			= 64;
	public byte[]			BlockyISamount			= new byte			[BlockyBlockTypeAmount];
	public String[]			BlockyBlockTypeName		= new String		[BlockyBlockTypeAmount];
	public String[]			BlockyLocalization		= new String		[BlockyBlockTypeAmount];
	public int[]			BlockyDangerSlot		= new int			[BlockyBlockTypeAmount];
	public ISolarHandler[]	BlockyHandler			= new ISolarHandler	[BlockyBlockTypeAmount];
	
	public byte[][]			BlockySlotCoordX		= new byte			[BlockyBlockTypeAmount][2];
	public byte[][]			BlockySlotCoordY		= new byte			[BlockyBlockTypeAmount][2];

	
    public final byte		CraftingItemNumber		= 3;
	public String[]			CraftingLocalization	= new String[CraftingItemNumber];

	
	public void addValues()
		{
		BlockyBlockTypeName[0]	= "SolarFurnace";
		BlockyISamount[0]		= 2;
		BlockyDangerSlot[0]		= 1;
		BlockyHandler[0]		= new SolarFurnaceHandler();
		
		BlockySlotCoordX[0][0]	= 56;
		BlockySlotCoordY[0][0]	= 35;
		BlockySlotCoordX[0][1]	= 116;
		BlockySlotCoordY[0][1]	= 35;
		
		
		BlockyBlockTypeName[1]	= "SolarSmasher";
		BlockyISamount[1]		= 2;
		BlockyDangerSlot[1]		= 1;
		BlockyHandler[1]		= new SolarSmasherHandler();
		
		BlockySlotCoordX[1][0]	= 56;
		BlockySlotCoordY[1][0]	= 35;
		BlockySlotCoordX[1][1]	= 116;
		BlockySlotCoordY[1][1]	= 35;
		}
	public void addLocalizations()
		{
		CraftingLocalization[0] = "Placeholder";
		CraftingLocalization[1] = "Soul in a Bottle";
		CraftingLocalization[2] = "Contained Spaaaace!";
		
		BlockyLocalization[0] = "Solar Furnace";
		BlockyLocalization[1] = "Solar Smasher";
		}
	}
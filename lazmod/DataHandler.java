package lazmod;

import lazmod.blocks.tileentities.handlers.CraftFurnaceHandler;
import lazmod.blocks.tileentities.handlers.CraftSmasherHandler;
import lazmod.blocks.tileentities.handlers.ICraftHandler;
import lazmod.blocks.tileentities.handlers.SolarHandler;

public class DataHandler
	{
	public DataHandler() {};
	
    public final byte		BlockyBlockTypeAmount	= 2;
    public final byte				BlockyBlockSlotAmount	= 2;
    public final int				BlockyISlimit			= 64;
	public byte[]					BlockyISamount			= new byte			[BlockyBlockTypeAmount];
	public String[]					BlockyBlockTypeName		= new String		[BlockyBlockTypeAmount];
	public String[]					BlockyLocalization		= new String		[BlockyBlockTypeAmount];
	public int[]					BlockyDangerSlot		= new int			[BlockyBlockTypeAmount];
	public ICraftHandler[]			BlockyCraftHandler		= new ICraftHandler	[BlockyBlockTypeAmount];
	
	
	public byte[][]			BlockySlotCoordX		= new byte			[BlockyBlockTypeAmount][BlockyBlockSlotAmount];
	public byte[][]			BlockySlotCoordY		= new byte			[BlockyBlockTypeAmount][BlockyBlockSlotAmount];

	
    public final byte		CraftingItemNumber		= 3;
	public String[]			CraftingLocalization	= new String[CraftingItemNumber];

	
	public void addValues()
		{
		BlockyBlockTypeName[0]	= "SolarFurnace";
		BlockyISamount[0]		= 2;
		BlockyDangerSlot[0]		= 1;
		BlockyCraftHandler[0]	= CraftFurnaceHandler.staticInst();
		
		BlockySlotCoordX[0][0]	= 56;
		BlockySlotCoordY[0][0]	= 35;
		BlockySlotCoordX[0][1]	= 116;
		BlockySlotCoordY[0][1]	= 35;
		
		
		BlockyBlockTypeName[1]	= "SolarSmasher";
		BlockyISamount[1]		= 2;
		BlockyDangerSlot[1]		= 1;
		BlockyCraftHandler[1]	= CraftSmasherHandler.staticInst();
		
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
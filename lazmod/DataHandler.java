package lazmod;

import java.util.HashMap;

import lazmod.EMS.EnergyMatterSystem;
import lazmod.blocks.tileentities.logic.CraftFurnaceHandler;
import lazmod.blocks.tileentities.logic.CraftLavaGenHandler;
import lazmod.blocks.tileentities.logic.CraftSmasherHandler;
import lazmod.blocks.tileentities.logic.ICraftHandler;
import net.minecraft.enchantment.Enchantment;

public class DataHandler
	{
	public DataHandler() {};
	
    public final byte			BlockyBlockTypeAmount		= 3;
    public final byte			BlockyBlockSlotAmount		= 2;
    public final int			BlockyISlimit				= 64;
	public byte[]				BlockyISamount				= new byte			[BlockyBlockTypeAmount];
	public String[]				BlockyBlockTypeName			= new String		[BlockyBlockTypeAmount];
	public String[]				BlockyLocalization			= new String		[BlockyBlockTypeAmount];
	public int[]				BlockyDangerSlot			= new int			[BlockyBlockTypeAmount];
	public ICraftHandler[]		BlockyCraftHandler			= new ICraftHandler	[BlockyBlockTypeAmount];
	
	
	public byte[][]				BlockySlotCoordX			= new byte			[BlockyBlockTypeAmount][BlockyBlockSlotAmount];
	public byte[][]				BlockySlotCoordY			= new byte			[BlockyBlockTypeAmount][BlockyBlockSlotAmount];

	
    public final byte			CraftingItemNumber			= 3;
	public String[]				CraftingLocalization		= new String[CraftingItemNumber];

	
	public String 				EvilEnchantLocalization[]	= new String[Enchantment.enchantmentsList.length];
	
	
	public HashMap<String, EnergyMatterSystem> EMS			= new HashMap<String, EnergyMatterSystem>();
	
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
		
		
		BlockyBlockTypeName[2]	= "SolarLavaGen";
		BlockyISamount[2]		= 2;
		BlockyDangerSlot[2]		= 1;
		BlockyCraftHandler[2]	= CraftLavaGenHandler.staticInst();
		
		BlockySlotCoordX[2][0]	= 56;
		BlockySlotCoordY[2][0]	= 35;
		BlockySlotCoordX[2][1]	= 116;
		BlockySlotCoordY[2][1]	= 35;
		}
	public void addLocalizations()
		{
		BlockyLocalization[0]	= "Solar Furnace";
		BlockyLocalization[1]	= "Solar Smasher";
		BlockyLocalization[2]	= "Solar Lava Generator";
		
		CraftingLocalization[0]	= "Placeholder";
		CraftingLocalization[1]	= "Soul in a Bottle";
		CraftingLocalization[2]	= "Contained Spaaaace!";
		
		/*
		EvilEnchantLocalization[0] = "";
		EvilEnchantLocalization[1] = "";
		EvilEnchantLocalization[2] = "";
		EvilEnchantLocalization[3] = "";
		EvilEnchantLocalization[4] = "";
		EvilEnchantLocalization[5] = "";
		EvilEnchantLocalization[6] = "";
		EvilEnchantLocalization[7] = "";
		*/
		
		EvilEnchantLocalization[16] = "Wrath";
		EvilEnchantLocalization[17] = "Necrophobia";
		EvilEnchantLocalization[18] = "Arachnophobia";
		EvilEnchantLocalization[19] = "Rage";
		EvilEnchantLocalization[20] = "Burn";
		EvilEnchantLocalization[21] = "Greed";
		
		EvilEnchantLocalization[32] = "Diligence";
		EvilEnchantLocalization[33] = "Kindness";
		EvilEnchantLocalization[34] = "Persistence";
		EvilEnchantLocalization[35] = "Charity";

		/*
		EvilEnchantLocalization[48] = "";
		EvilEnchantLocalization[49] = "";
		EvilEnchantLocalization[50] = "";
		EvilEnchantLocalization[51] = "";
		
		EvilEnchantLocalization[61] = "";
		EvilEnchantLocalization[62] = "";
		*/
		}
	}
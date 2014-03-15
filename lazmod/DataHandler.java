package lazmod;

import java.util.HashMap;

import lazmod.CES.CrystalEnergySystem;
import lazmod.blocks.tileentities.logic.CraftFurnaceHandler;
import lazmod.blocks.tileentities.logic.CraftLavaGenHandler;
import lazmod.blocks.tileentities.logic.CraftSmasherHandler;
import lazmod.blocks.tileentities.logic.ICraftHandler;
import lazmod.blocks.tileentities.logic.SolarLogic;
import net.minecraft.enchantment.Enchantment;

public class DataHandler
	{
	public DataHandler()
		{};

	public final static byte					BlockyBlockTypeAmount		= 3;
	public byte									BBType						= 0;
	public final byte							BlockyBlockSlotAmount		= 2;
	public final int							BlockyISlimit				= 64;
	public byte[]								BlockyISamount				= new byte[BlockyBlockTypeAmount];
	public String[]								BlockyBlockTypeName			= new String[BlockyBlockTypeAmount];
	public String[]								BlockyLocalization			= new String[BlockyBlockTypeAmount];
	public int[]								BlockyDangerSlot			= new int[BlockyBlockTypeAmount];
	public static ICraftHandler[]				BlockyCraftHandler			= new ICraftHandler[BlockyBlockTypeAmount];
	public static SolarLogic[]					BlockyLogic					= new SolarLogic[BlockyBlockTypeAmount];

	public byte[][]								BlockySlotCoordX			= new byte[BlockyBlockTypeAmount][BlockyBlockSlotAmount];
	public byte[][]								BlockySlotCoordY			= new byte[BlockyBlockTypeAmount][BlockyBlockSlotAmount];

	public final byte							CraftingItemNumber			= 5;
	public String[]								CraftingLocalization		= new String[CraftingItemNumber];

	public String								EvilEnchantLocalization[]	= new String[Enchantment.enchantmentsList.length];

	public HashMap<String, CrystalEnergySystem>	CES							= new HashMap<String, CrystalEnergySystem>();

	public void addValues()
		{
		BBType = 0;
		BlockyBlockTypeName[BBType] = "SolarFurnace";
		BlockyISamount[BBType] = 2;
		BlockyDangerSlot[BBType] = 1;
		BlockyCraftHandler[BBType] = CraftFurnaceHandler.staticInst();
		BlockyLogic[BBType] = new SolarLogic(BBType);

		BlockySlotCoordX[BBType][0] = 56;
		BlockySlotCoordY[BBType][0] = 35;
		BlockySlotCoordX[BBType][1] = 116;
		BlockySlotCoordY[BBType][1] = 35;

		BBType = 1;
		BlockyBlockTypeName[BBType] = "SolarSmasher";
		BlockyISamount[BBType] = 2;
		BlockyDangerSlot[BBType] = 1;
		BlockyCraftHandler[BBType] = CraftSmasherHandler.staticInst();
		BlockyLogic[BBType] = new SolarLogic(BBType);

		BlockySlotCoordX[BBType][0] = 56;
		BlockySlotCoordY[BBType][0] = 35;
		BlockySlotCoordX[BBType][1] = 116;
		BlockySlotCoordY[BBType][1] = 35;

		BBType = 2;
		BlockyBlockTypeName[BBType] = "SolarLavaGen";
		BlockyISamount[BBType] = 2;
		BlockyDangerSlot[BBType] = 1;
		BlockyCraftHandler[BBType] = CraftLavaGenHandler.staticInst();
		BlockyLogic[BBType] = new SolarLogic(BBType);

		BlockySlotCoordX[BBType][0] = 56;
		BlockySlotCoordY[BBType][0] = 35;
		BlockySlotCoordX[BBType][1] = 116;
		BlockySlotCoordY[BBType][1] = 35;
		}

	public void addLocalizations()
		{
		BlockyLocalization[0] = "Solar Furnace";
		BlockyLocalization[1] = "Solar Smasher";
		BlockyLocalization[2] = "Solar Lava Generator";

		CraftingLocalization[0] = "Placeholder";
		CraftingLocalization[1] = "Soul in a Bottle";
		CraftingLocalization[2] = "Contained Spaaaace!";
		CraftingLocalization[3] = "Iron Dust";
		CraftingLocalization[4] = "Gold Dust";
		/*
		 * EvilEnchantLocalization[0] = ""; EvilEnchantLocalization[1] = ""; EvilEnchantLocalization[2] = ""; EvilEnchantLocalization[3] = "";
		 * EvilEnchantLocalization[4] = ""; EvilEnchantLocalization[5] = ""; EvilEnchantLocalization[6] = ""; EvilEnchantLocalization[7] = "";
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
		 * EvilEnchantLocalization[48] = ""; EvilEnchantLocalization[49] = ""; EvilEnchantLocalization[50] = ""; EvilEnchantLocalization[51] = "";
		 * 
		 * EvilEnchantLocalization[61] = ""; EvilEnchantLocalization[62] = "";
		 */
		}
	}
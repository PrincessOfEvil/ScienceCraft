package lazmod;

import java.util.HashMap;
import java.util.Map;

import lazmod.CES.CESWaveShooter;
import lazmod.CES.CrystalEnergySystem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.IIcon;

public class DataHandler
	{
	public static final byte					SolarAmount					= 3;
	public static IIcon							SolarFaceIcons[]			= new IIcon[SolarAmount];
	public static IIcon							SolarOtherIcons[]			= new IIcon[3];
	public static String						SolarNames[]				= new String[SolarAmount];
	
	public static final byte					CraftingItemNumber			= 5;
	
	public static String						CraftingNames[]				= new String[CraftingItemNumber];
	public static String						EvilEnchantNames[]			= new String[Enchantment.enchantmentsList.length];
	
	public HashMap<String, CESWaveShooter> shooterMap = null;
	
	public DataHandler()
		{}
	
	public void addValues()
		{}
	
	public void addNames()
		{
		SolarNames[0] = "Furnace";
		SolarNames[1] = "Smasher";
		SolarNames[2] = "LavaGen";
		
		CraftingNames[0] = "itemDummy";
		CraftingNames[1] = "itemSoul";
		CraftingNames[2] = "itemSpace";
		CraftingNames[3] = "itemDustIron";
		CraftingNames[4] = "itemDustGold";
		
		/*
		 * EvilEnchantLocalization[0] = ""; EvilEnchantLocalization[1] = ""; EvilEnchantLocalization[2] = ""; EvilEnchantLocalization[3] = "";
		 * EvilEnchantLocalization[4] = ""; EvilEnchantLocalization[5] = ""; EvilEnchantLocalization[6] = ""; EvilEnchantLocalization[7] = "";
		 */
		
		EvilEnchantNames[16] = "Wrath";
		EvilEnchantNames[17] = "Necrophobia";
		EvilEnchantNames[18] = "Arachnophobia";
		EvilEnchantNames[19] = "Rage";
		EvilEnchantNames[20] = "Burn";
		EvilEnchantNames[21] = "Greed";
		
		EvilEnchantNames[32] = "Diligence";
		EvilEnchantNames[33] = "Kindness";
		EvilEnchantNames[34] = "Persistence";
		EvilEnchantNames[35] = "Charity";
		
		/*
		 * EvilEnchantLocalization[48] = ""; EvilEnchantLocalization[49] = ""; EvilEnchantLocalization[50] = ""; EvilEnchantLocalization[51] = "";
		 * 
		 * EvilEnchantLocalization[61] = ""; EvilEnchantLocalization[62] = "";
		 */
		}
	}
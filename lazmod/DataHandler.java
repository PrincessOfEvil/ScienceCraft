package lazmod;

import java.util.HashMap;

import lazmod.CES.CrystalEnergySystem;
import net.minecraft.enchantment.Enchantment;

public class DataHandler
	{
	public final byte							CraftingItemNumber			= 5;
	
	public String[]								CraftingUnlocalization		= new String[CraftingItemNumber];
	public String								EvilEnchantLocalization[]	= new String[Enchantment.enchantmentsList.length];
	
	public HashMap<String, CrystalEnergySystem>	CES							= new HashMap<String, CrystalEnergySystem>();
	
	public DataHandler()
		{}
	
	public void addNames()
		{
		CraftingUnlocalization[0] = "itemDummy";
		CraftingUnlocalization[1] = "itemSoul";
		CraftingUnlocalization[2] = "itemSpace";
		CraftingUnlocalization[3] = "itemDustIron";
		CraftingUnlocalization[4] = "itemDustGold";
		
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
	
	public void addValues()
		{}
	}
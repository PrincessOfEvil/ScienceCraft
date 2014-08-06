package lazmod;

import lazmod.blocks.BlockCGlass;
import lazmod.blocks.BlockCrystF;
import lazmod.blocks.BlockFField;
import lazmod.blocks.BlockIrnTnk;
import lazmod.blocks.BlockSolar;
import lazmod.blocks.BlockWtrSrc;
import lazmod.crystal.Crystal;
import lazmod.items.ItemCrafting;
import lazmod.items.ItemObsidianPick;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLModIdMappingEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "ScienceCraft", name = "Science Craft", version = "0.112 alpha")
public class ScienceCraft
	{
	public static Block					FField;
	public static Block					IrnTnk;
	public static Block					WtrSrc;
	public static Block					CrystF;
	public static Block					CGlass;
	
	public static Block					SolarFurnace;
	public static Block					SolarSmasher;
	public static Block					SolarLavaGen;

	public static Block					Derivium;
	public static Block					Emmitium;
	
	public static Item					CraftingItem;
	
	public static Item					ObsidianPick;
	
	public static float					Unawakening;
	
	public static ToolMaterial			SC_OBSIDIAN;
	
	// But no matter how distant
	// In time and space...
	public static final String			One			= "CHAOS";
	
	public static SC_Config				CFG;
	
	protected RecipeHandler				ReciHandler;
	protected RegistryHandler			RegiHandler;								// RegiSteel, RegiRock,RegiHandler.
																					
	public static DataHandler			dataHandler	= new DataHandler();
	
	public static final CreativeTabs	SCTab		= new SC_CreativeTab("SCTab");
	
	// @SidedProxy(clientSide = "mods.lazmod.SC_Client", serverSide = "mods.lazmod.SC_Proxy")
	// public static SC_Proxy proxy;
	
	@Instance("ScienceCraft")
	public static ScienceCraft			instance;
	
	@EventHandler
	public void load(FMLInitializationEvent event) // Warranty void if void.
		{
		ReciHandler.addRecipes();
		}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
		{
		System.out.println("Pre-init value:" + 0XC_FP2F);
		
		// We do what we must
		// Because we're can.
		
		CFG = new SC_Config(event, "ScienceCraft/config.cfg");
		
		CFG.config.save();
		
		dataHandler.addValues();
		dataHandler.addNames();
		
		SC_OBSIDIAN = EnumHelper.addToolMaterial("SC Obsidian", 2, 500, 6.0F, 5, 24);
		
		
		FField = new BlockFField().setBlockName("ffield").setBlockUnbreakable().setCreativeTab(ScienceCraft.SCTab).setLightLevel(0.4F);
		IrnTnk = new BlockIrnTnk().setBlockName("irntnk").setHardness(6F).setCreativeTab(ScienceCraft.SCTab);
		WtrSrc = new BlockWtrSrc().setBlockName("wtrsrc").setHardness(6F).setCreativeTab(ScienceCraft.SCTab);
		CrystF = new BlockCrystF().setBlockName("crystf").setHardness(5F).setCreativeTab(ScienceCraft.SCTab);
		CGlass = new BlockCGlass().setBlockName("cglass").setHardness(3F).setCreativeTab(ScienceCraft.SCTab);
		
		SolarFurnace = new BlockSolar(0).setBlockName("sfurnace").setHardness(3F).setCreativeTab(ScienceCraft.SCTab);
		SolarSmasher = new BlockSolar(1).setBlockName("ssmasher").setHardness(3F).setCreativeTab(ScienceCraft.SCTab);
		SolarLavaGen = new BlockSolar(2).setBlockName("slavagen").setHardness(3F).setCreativeTab(ScienceCraft.SCTab);
		
		Derivium = new Crystal("Derivium").setBlockName("derivium").setHardness(4F).setCreativeTab(ScienceCraft.SCTab).setLightLevel(0.5F);
		Emmitium = new Crystal("Emmitium").setBlockName("emmitium").setHardness(4F).setCreativeTab(ScienceCraft.SCTab).setLightLevel(0.7F);
		
		
		CraftingItem = new ItemCrafting().setUnlocalizedName("critem").setCreativeTab(ScienceCraft.SCTab);
		
		ObsidianPick = new ItemObsidianPick().setUnlocalizedName("obspick").setCreativeTab(ScienceCraft.SCTab);
		
		
		ReciHandler = new RecipeHandler();
		RegiHandler = new RegistryHandler();
		
		RegiHandler.registerThings();
		}
	}
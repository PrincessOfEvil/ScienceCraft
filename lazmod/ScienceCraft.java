package lazmod;

import lazmod.CES.CrystalEnergySystem;
import lazmod.blocks.BlockBlocky;
import lazmod.blocks.BlockCrystF;
import lazmod.blocks.BlockFField;
import lazmod.blocks.BlockIrnTnk;
import lazmod.blocks.BlockWtrSrc;
import lazmod.crystal.Crystal;
import lazmod.items.ItemCrafting;
import lazmod.items.ItemObsidianPick;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "ScienceCraft", name = "Science Craft", version = "0.111 alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


public class ScienceCraft
	{
	public static Block FField;
	public static Block IrnTnk;
	public static Block WtrSrc;
	public static Block CrystF;
	
	public static Block BlockyBlock;
	
	public static Block Derivium;
	public static Block Emmitium; // Guess what it does. Well, will do.
	
	public static Item CraftingItem;
	
	public static Item ObsidianPick;
	
	public static int FField_Cfg;
	public static int IrnTnk_Cfg;
	public static int WtrSrc_Cfg;
	public static int CrystF_Cfg;
	
	public static int BlockyBlock_Cfg;
	
	public static int Derivium_Cfg;
	public static int Emmitium_Cfg;
	
	public static float Unawakening;
	
	public static int ObsPick_Cfg;
	
	public static EnumToolMaterial SC_OBSIDIAN;
	
	// But no matter how distant
	// In time and space...
	public static final String One = "CHAOS";
	
	public static SC_Config CFG;

	protected LanguageHandler	LangHandler;
	protected RecipeHandler		ReciHandler;
	protected RegistryHandler	RegiHandler; //RegiSteel, RegiRock, RegiHandler.
	
	public static DataHandler	DateHandler = new DataHandler();
	
	public static final CreativeTabs SCTab = new SC_CreativeTab("SCTab");
	
	//@SidedProxy(clientSide = "mods.lazmod.SC_Client", serverSide= "mods.lazmod.SC_Proxy")
	//public static SC_Proxy proxy;
	
    @Instance("ScienceCraft")
    public static ScienceCraft instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
		{
		// We do what we must
		// Because we can.
		
		CFG = new SC_Config(event,"ScienceCraft/IDs.cfg");
		
		FField_Cfg		= CFG.config.get("Blocks",	"Force Field",			1240	 ).getInt();
		IrnTnk_Cfg		= CFG.config.get("Blocks",	"Iron Tank",			1241	 ).getInt();
		WtrSrc_Cfg		= CFG.config.get("Blocks",	"Infinite Water Source",1242	 ).getInt();
		CrystF_Cfg		= CFG.config.get("Blocks",	"Crystal Catcher",		1243	 ).getInt();
		
		BlockyBlock_Cfg	= CFG.config.get("Blocks",	"Type-A TE Blocks",		1250	 ).getInt();

		Derivium_Cfg	= CFG.config.get("Crystals","Derivium",				1260	 ).getInt();
		Emmitium_Cfg	= CFG.config.get("Crystals","Emmitium",				1261	 ).getInt();
		
		// Must I float away?
		// Will I ever awake? 
		Unawakening		= CFG.config.get("ItCES",	"Crafting itCES",		30000-256).getInt();
		
		ObsPick_Cfg		= CFG.config.get("ItCES",	"Obsidian Pick",		30032-256).getInt();
		
		CFG.config.save();
		
		DateHandler.addValues();
		DateHandler.addLocalizations();
		
		SC_OBSIDIAN = EnumHelper.addToolMaterial("SC Obsidian", 2, 500, 6.0F, 5, 24); 
		}
	
    @EventHandler
	public void load(FMLInitializationEvent event) // Warranty void if void.
		{
		FField			= new BlockFField		(FField_Cfg)				.setUnlocalizedName("ffield")		.setBlockUnbreakable()	.setCreativeTab(this.SCTab).setLightValue(0.4F);
		IrnTnk			= new BlockIrnTnk		(IrnTnk_Cfg)				.setUnlocalizedName("irntnk")		.setHardness(6F)		.setCreativeTab(this.SCTab);
		WtrSrc			= new BlockWtrSrc		(WtrSrc_Cfg)				.setUnlocalizedName("wtrsrc")		.setHardness(6F)		.setCreativeTab(this.SCTab);
		CrystF			= new BlockCrystF		(CrystF_Cfg)				.setUnlocalizedName("crystf")		.setHardness(5F)		.setCreativeTab(this.SCTab);

		
		BlockyBlock		= new BlockBlocky		(BlockyBlock_Cfg)			.setUnlocalizedName("blockyblock")	.setHardness(6F)		.setCreativeTab(this.SCTab);
		
		Derivium		= new Crystal			(Derivium_Cfg,"Derivium")	.setUnlocalizedName("derivium")		.setHardness(4F)		.setCreativeTab(this.SCTab).setLightValue(0.5F);
		Emmitium		= new Crystal			(Emmitium_Cfg,"Emmitium")	.setUnlocalizedName("emmitium")		.setHardness(4F)		.setCreativeTab(this.SCTab).setLightValue(0.7F);	
		
		CraftingItem	= new ItemCrafting		((int)Unawakening)			.setUnlocalizedName("crafting")								.setCreativeTab(this.SCTab);
		
		ObsidianPick	= new ItemObsidianPick	(ObsPick_Cfg)				.setUnlocalizedName("obspick")								.setCreativeTab(this.SCTab);
		
		ReciHandler		= new RecipeHandler();
		RegiHandler		= new RegistryHandler();
		LangHandler		= new LanguageHandler();

		ReciHandler.addRecipes();
		RegiHandler.registerThings();
		LangHandler.addNames();
		
		MinecraftForge.setBlockHarvestLevel(IrnTnk, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(WtrSrc, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(BlockyBlock, "pickaxe", 1);
		}
	}
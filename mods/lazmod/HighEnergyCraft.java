package mods.lazmod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid = "HighEnergyCraft", name = "HighEnergy Craft", version = "0.11 alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class HighEnergyCraft
	{
	public static Block FField;
	public static Block IrnTnk;
	public static Block BlockyBlock;
	
	public static Block Derivium;
	public static Block Emmitium;
	
	public static Item CraftingItem;
	
	public static int FField_Cfg;
	public static int IrnTnk_Cfg;
	public static int BlockyBlock_Cfg;
	
	public static int Derivium_Cfg;
	public static int Emmitium_Cfg; // Guess what it does.
	
	public static float Unawakening;
	
	// But no matter how distant
	// In time and space...
	public static final String One = "CHAOS";
	
	public static HEC_Config CFG;

	protected LanguageHandler	LangHandler;
	protected RecipeHandler		ReciHandler;
	protected RegistryHandler	RegiHandler; //RegiSteel, RegiRock, RegiHandler.
	
	public static DataHandler	DateHandler = new DataHandler();
	
	public static final CreativeTabs ACTab = new HEC_CreativeTab("ACTab");
	
	//@SidedProxy(clientSide = "mods.lazmod.HEC_Client", serverSide= "mods.lazmod.HEC_Proxy")
	//public static HEC_Proxy proxy;
	
	public static HEC_EnergyMatterSystem TempSystem;
	
    @Instance("HighEnergyCraft")
    public static HighEnergyCraft instance;

	
	@PreInit
    public void preInit(FMLPreInitializationEvent event) 
		{
		// We do what we must
		// Because we can.
		
		CFG = new HEC_Config(event,"HEC/HighEnergy Craft.cfg");
		
		FField_Cfg		= CFG.config.get("Blocks",		"Force Field",		1240	 ).getInt();
		IrnTnk_Cfg		= CFG.config.get("Blocks",		"Iron Tank",		1241	 ).getInt();
		BlockyBlock_Cfg	= CFG.config.get("Blocks",		"Type-A TE Blocks",	1242	 ).getInt();

		Derivium_Cfg	= CFG.config.get("Crystals",	"Derivium",			1243	 ).getInt();
		Emmitium_Cfg	= CFG.config.get("Crystals",	"Emmitium",			1244	 ).getInt();
		
		// Must I float away?
		// Will I ever awake? 
		Unawakening		= CFG.config.get("Items",		"Crafting items",	30000-256).getInt();
		
		CFG.config.save();
		
		DateHandler.addValues();
		DateHandler.addLocalizations();
		}
	
	@Init
	public void load(FMLInitializationEvent event) // Warranty void if void.
		{
		//proxy.registerRenderers();
		
		FField			= new BlockFField(FField_Cfg).setUnlocalizedName("b.ffield").setBlockUnbreakable().setLightValue(0.4F).setCreativeTab(this.ACTab);
		IrnTnk			= new BlockIrnTnk(IrnTnk_Cfg).setUnlocalizedName("b.irntnk").setHardness(6F).setCreativeTab(this.ACTab);
		BlockyBlock		= new BlockBlocky(BlockyBlock_Cfg).setUnlocalizedName("b.lockyblock").setHardness(6F).setCreativeTab(this.ACTab);
		
		Derivium		= new BlockDerivium(Derivium_Cfg).setUnlocalizedName("cr.derivium").setHardness(6F).setCreativeTab(this.ACTab);
		Emmitium		= new BlockEmmitium(Emmitium_Cfg).setUnlocalizedName("cr.emmitium").setHardness(6F).setCreativeTab(this.ACTab);	
		
		CraftingItem	= new ItemCrafting((int)Unawakening).setUnlocalizedName("i.crafting").setCreativeTab(this.ACTab);
		
		TempSystem		= new HEC_EnergyMatterSystem(1000,1000);
		
		ReciHandler		= new RecipeHandler();
		RegiHandler		= new RegistryHandler();
		LangHandler		= new LanguageHandler();

		ReciHandler.addRecipes();
		RegiHandler.registerThings();
		LangHandler.addNames();
		
		MinecraftForge.setBlockHarvestLevel(IrnTnk, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(BlockyBlock, "pickaxe", 1);
		}
	}
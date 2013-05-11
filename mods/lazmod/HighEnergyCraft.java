package mods.lazmod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



@Mod(modid = "HighEnergyCraft", name = "HighEnergy Craft", version = "0.11 alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class HighEnergyCraft
	{
	public static Block FField;
	public static Block IrnTnk;
	public static Block BlockyBlock;
	
	public static Item Soul;
	public static Item Space;
	
	public static HEC_Config CFG;
	
	public static int FField_Cfg;
	public static int IrnTnk_Cfg;
	public static int BlockyBlock_Cfg;
	
	public static int Soul_Cfg;
	public static int Space_Cfg;
	
	protected registryThing Thing;
	
	public static final CreativeTabs ACTab = new HEC_CreativeTab("ACTab");;
	
	//@SidedProxy(clientSide = "mods.lazmod.HEC_Client", serverSide= "mods.lazmod.HEC_Proxy")
	//public static HEC_Proxy proxy;
	
	public static HEC_EnergyMatterSystem TempSystem;
	
	@PreInit
    public void preInit(FMLPreInitializationEvent event) 
		{
		CFG = new HEC_Config(event,"HEC/HighEnergy Craft.cfg");
		
		FField_Cfg		= CFG.config.get("Blocks",	"Force Field",			1240	 ).getInt();
		IrnTnk_Cfg		= CFG.config.get("Blocks",	"Iron Tank",			1241	 ).getInt();
		BlockyBlock_Cfg	= CFG.config.get("Blocks",	"Type-A Blocks",		1242	 ).getInt(); //TODO: Add it.
		
		Soul_Cfg		= CFG.config.get("Items" ,	 "Soul in a Bottle",	30000-256).getInt();
		Space_Cfg		= CFG.config.get("Items" ,	 "Contained Space",		30001-256).getInt();
		
		// We do what we must
		// Because we can.
		
		CFG.config.save();
		}
	
	@Init
	public void load(FMLInitializationEvent event)
		{
		//proxy.registerRenderers();
		
		FField		= new BlockFField(FField_Cfg).setUnlocalizedName("ffield").setBlockUnbreakable().setLightValue(0.4F).setCreativeTab(this.ACTab);
		IrnTnk		= new BlockIrnTnk(IrnTnk_Cfg).setUnlocalizedName("irntnk").setHardness(6F).setCreativeTab(this.ACTab);
		BlockyBlock = new BlockBlocky(BlockyBlock_Cfg).setUnlocalizedName("blockyblock").setHardness(6F).setCreativeTab(this.ACTab);
		
		Soul		= new ItemSoul(Soul_Cfg).setUnlocalizedName("soulitem").setCreativeTab(this.ACTab);
		Space		= new ItemSpace(Space_Cfg).setUnlocalizedName("spaceitem").setCreativeTab(this.ACTab);
		
		TempSystem	= new HEC_EnergyMatterSystem(1000,1000);
		
		Thing		= new registryThing();
		
		//I hope this will work. This class is a little too big. 
		Thing.addNames();
		Thing.addRecipes();
		Thing.registerThings();
		
		MinecraftForge.setBlockHarvestLevel(IrnTnk, "pickaxe", 2);
		}
	}
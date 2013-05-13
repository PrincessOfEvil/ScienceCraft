package mods.lazmod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
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
	
	public static Item Soul;
	public static Item Space;
	
	public static HEC_Config CFG;
	
	public static int FField_Cfg;
	public static int IrnTnk_Cfg;
	public static int BlockyBlock_Cfg;
	
	public static int Space_Cfg;

	public static float Unawakening;
	
	protected registryThing Thing;
	
	public static final CreativeTabs ACTab = new HEC_CreativeTab("ACTab");;
	
	//@SidedProxy(clientSide = "mods.lazmod.HEC_Client", serverSide= "mods.lazmod.HEC_Proxy")
	//public static HEC_Proxy proxy;
	
	public static HEC_EnergyMatterSystem TempSystem;
	
	@PreInit
    public void preInit(FMLPreInitializationEvent event) 
		{
		// We do what we must
		// Because we can.
		
		CFG = new HEC_Config(event,"HEC/HighEnergy Craft.cfg"); //That... Works O_o
		
		FField_Cfg		= CFG.config.get("Blocks",	"Force Field",			1240	 ).getInt();
		IrnTnk_Cfg		= CFG.config.get("Blocks",	"Iron Tank",			1241	 ).getInt();
		BlockyBlock_Cfg	= CFG.config.get("Blocks",	"Type-A Blocks",		1242	 ).getInt(); //TODO: Add it.
		
		Space_Cfg		= CFG.config.get("Items" ,	 "Contained Space",		30001-256).getInt();
		
		// Must I float away?
		// Will I ever awake? 
		Unawakening		= CFG.config.get("Items" ,	 "Soul in a Bottle",	30000-256).getInt();
		
		CFG.config.save();
		}
	
	@Init
	public void load(FMLInitializationEvent event)
		{
		//proxy.registerRenderers();
		
		FField		= new BlockFField(FField_Cfg).setUnlocalizedName("ffield").setBlockUnbreakable().setLightValue(0.4F).setCreativeTab(this.ACTab);
		IrnTnk		= new BlockIrnTnk(IrnTnk_Cfg).setUnlocalizedName("irntnk").setHardness(6F).setCreativeTab(this.ACTab);
		BlockyBlock = new BlockBlocky(BlockyBlock_Cfg).setUnlocalizedName("blockyblock").setHardness(6F).setCreativeTab(this.ACTab);
		
		Soul		= new ItemSoul((int)Unawakening).setUnlocalizedName("soulitem").setCreativeTab(this.ACTab);
		Space		= new ItemSpace(Space_Cfg).setUnlocalizedName("spaceitem").setCreativeTab(this.ACTab);
		
		TempSystem	= new HEC_EnergyMatterSystem(1000,1000);
		
		Thing		= new registryThing(); 
		Thing.addNames();
		Thing.addRecipes();
		Thing.registerThings();
		
		MinecraftForge.setBlockHarvestLevel(IrnTnk, "pickaxe", 2);
		}
	}
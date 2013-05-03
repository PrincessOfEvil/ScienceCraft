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
		
		Soul		= new ItemSoul(Soul_Cfg).setUnlocalizedName("soulItem").setCreativeTab(this.ACTab);
		Space		= new ItemSpace(Space_Cfg).setUnlocalizedName("spaceItem").setCreativeTab(this.ACTab);
		
		TempSystem	= new HEC_EnergyMatterSystem(1000,1000);
		
		GameRegistry.registerBlock(FField, "ForceField");
		GameRegistry.registerBlock(IrnTnk, "IronTank");
		
		GameRegistry.registerTileEntity(TileIrnTnk.class, "IronTankTile");
		
		GameRegistry.addRecipe(new ItemStack(Soul, 8), new Object[]{ "111", "101", "111", Character.valueOf('0'), Block.slowSand,  Character.valueOf('1'), Item.glassBottle});
		
		GameRegistry.addRecipe(new ItemStack(FField, 1), new Object[]{ "111", "202", "111", Character.valueOf('0'), Block.bedrock, Character.valueOf('1'), Block.glass, Character.valueOf('2'), Item.redstone});
		GameRegistry.addRecipe(new ItemStack(IrnTnk, 1), new Object[]{ "#1#", "202", "#1#", Character.valueOf('0'), Block.glass, Character.valueOf('1'), Item.ingotIron, Character.valueOf('2'), Block.blockSteel});

		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 55), new Object[]{ Item.slimeBall, Item.slimeBall, Soul});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 54), new Object[]{ Item.rottenFlesh, Item.rottenFlesh, Soul});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 51), new Object[]{ Item.arrow, Item.arrow, Item.bone, Item.bone, Soul});

		LanguageRegistry.addName(FField, "Force Field");
		LanguageRegistry.addName(IrnTnk, "Iron Tank");
		LanguageRegistry.addName(BlockyBlock, "Type-A Blocks");
		
		LanguageRegistry.addName(Soul, "Soul in a Bottle");
		LanguageRegistry.addName(Space, "Contained Space");
		

		LanguageRegistry.instance().addStringLocalization("itemGroup.ACTab", "en_US", "Annihilation Craft");
		
		MinecraftForge.setBlockHarvestLevel(IrnTnk, "pickaxe", 2);
		}
	}
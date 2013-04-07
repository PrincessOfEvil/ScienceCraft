package mods.lazmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



@Mod(modid = "AnnihilationCraft", name = "Annihilation Craft", version = "0.1 alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class AnnihilationCraft
	{
	public static Block FField;
	public static Block IrnTnk;
	
	public static Item Soul;
	public static Item Space;
	
	public static final CreativeTabs ACTab = new ACCreativeTab("ACTab");;
	
	//@SidedProxy(clientSide = "mods.lazmod.ACClient", serverSide= "mods.lazmod.ACProxy")
	//public static ACProxy proxy;
	
	public static ACSystem TempSystem;
	
	@Init
	public void load(FMLInitializationEvent event)
		{
		//proxy.registerRenderers();
		
		Soul = new ItemSoul(30000-256).setUnlocalizedName("soulItem").setCreativeTab(this.ACTab);
		Space = new ItemSpace(30001-256).setUnlocalizedName("spaceItem").setCreativeTab(this.ACTab);
		
		FField = new BlockFField(1240).setUnlocalizedName("ffield").setBlockUnbreakable().setLightValue(0.4F).setCreativeTab(this.ACTab);
		IrnTnk = new BlockIrnTnk(1241).setUnlocalizedName("irntnk").setHardness(6F).setCreativeTab(this.ACTab);
		
		TempSystem = new ACSystem(1000,1000);
		
		GameRegistry.registerBlock(FField, "ForceField");
		GameRegistry.registerBlock(IrnTnk, "IronTank");
		
		GameRegistry.registerTileEntity(TileIrnTnk.class, "IronTankTile");
		
		GameRegistry.addRecipe(new ItemStack(Soul, 8), new Object[]{ "111", "101", "111", Character.valueOf('0'), Block.slowSand,  Character.valueOf('1'), Item.glassBottle});
		
		GameRegistry.addRecipe(new ItemStack(FField, 1), new Object[]{ "111", "202", "111", Character.valueOf('0'), Block.bedrock, Character.valueOf('1'), Block.glass, Character.valueOf('2'), Item.redstone});
		GameRegistry.addRecipe(new ItemStack(IrnTnk, 1), new Object[]{ "#1#", "202", "#1#", Character.valueOf('0'), Block.glass, Character.valueOf('1'), Item.ingotIron, Character.valueOf('2'), Block.blockSteel});

		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 55), new Object[]{ Item.slimeBall, Item.slimeBall, Soul});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 54), new Object[]{ Item.rottenFlesh, Item.rottenFlesh, Soul});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 51), new Object[]{ Item.arrow, Item.arrow, Item.bone, Item.bone, Soul});
		
		LanguageRegistry.addName(Soul, "Soul in a Bottle");
		LanguageRegistry.addName(Space, "Contained Space");
		
		LanguageRegistry.addName(FField, "Force Field");
		LanguageRegistry.addName(IrnTnk, "Iron Tank");
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.ACTab", "en_US", "Annihilation Craft");
		
		MinecraftForge.setBlockHarvestLevel(IrnTnk, "pickaxe", 2);
		}
	}
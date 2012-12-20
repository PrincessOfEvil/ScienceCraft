package lazmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "AnnihilationCraft", name = "Annihilation Craft", version = "0.1 alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class annihilationcraft
	{
	public static Block ffield;
	public static Block irtnk;
	
	public static Item soul;
	public static Item space;
			
	@SidedProxy(clientSide = "lazmod.lazClient", serverSide= "lazmod.lazProxy")
	public static lazProxy proxy;

	@Init
	public void load(FMLInitializationEvent event)
		{
		proxy.registerRenderers();
		
		soul = new ItemSoul(3000).setItemName("soulItem");
		space = new ItemSpace(3001).setItemName("spaceItem");
		
		ffield = new BlockFfield(1240, 0).setBlockUnbreakable().setHardness(6000000F).setLightValue(0.4F).setBlockName("ffield");
		irtnk = new BlockIrTnk(1241, 0).setHardness(6F).setBlockName("irtnk");
		
		GameRegistry.registerBlock(ffield);
		GameRegistry.registerBlock(irtnk);

		GameRegistry.addRecipe(new ItemStack(soul, 8), new Object[]{ "111", "101", "111", Character.valueOf('0'), Block.slowSand,  Character.valueOf('1'), Item.glassBottle});
		
		GameRegistry.addRecipe(new ItemStack(ffield, 1), new Object[]{ "111", "202", "111", Character.valueOf('0'), Block.bedrock, Character.valueOf('1'), Block.glass, Character.valueOf('2'), Item.redstone});
		GameRegistry.addRecipe(new ItemStack(irtnk, 1), new Object[]{ "#1#", "202", "#1#", Character.valueOf('0'), Block.glass, Character.valueOf('1'), Item.ingotIron, Character.valueOf('2'), Block.blockSteel});

		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 55), new Object[]{ Item.slimeBall, Item.slimeBall, soul});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 54), new Object[]{ Item.rottenFlesh, Item.rottenFlesh, soul});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 51), new Object[]{ Item.arrow, Item.arrow, Item.bone, Item.bone, soul});
		
		LanguageRegistry.addName(soul, "Soul in a Bottle");
		LanguageRegistry.addName(space, "Contained Space");
		
		LanguageRegistry.addName(ffield, "Force Field");
		LanguageRegistry.addName(irtnk, "Iron Tank");
		
		MinecraftForge.setBlockHarvestLevel(irtnk, "pickaxe", 2);
		}
	}
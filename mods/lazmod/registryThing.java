package mods.lazmod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class registryThing
	{
	protected registryThing() {}
	
	public static Block FField		= HighEnergyCraft.FField;
	public static Block IrnTnk		= HighEnergyCraft.IrnTnk;
	public static Block BlockyBlock	= HighEnergyCraft.BlockyBlock;
	
	public static Item Soul			= HighEnergyCraft.Soul;
	public static Item Space		= HighEnergyCraft.Space;
	
	protected void addRecipes()
		{
		GameRegistry.addRecipe(new ItemStack(Soul, 8), new Object[]{ "111", "101", "111", Character.valueOf('0'), Block.slowSand,  Character.valueOf('1'), Item.glassBottle});
		
		GameRegistry.addRecipe(new ItemStack(FField, 1), new Object[]{ "111", "202", "111", Character.valueOf('0'), Block.bedrock, Character.valueOf('1'), Block.glass, Character.valueOf('2'), Item.redstone});
		GameRegistry.addRecipe(new ItemStack(IrnTnk, 1), new Object[]{ "#1#", "202", "#1#", Character.valueOf('0'), Block.glass, Character.valueOf('1'), Item.ingotIron, Character.valueOf('2'), Block.blockIron});

		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 55), new Object[]{ Item.slimeBall, Item.slimeBall, Soul});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 54), new Object[]{ Item.rottenFlesh, Item.rottenFlesh, Soul});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 51), new Object[]{ Item.arrow, Item.arrow, Item.bone, Item.bone, Soul});
		}
	
	protected void addNames()
		{
		LanguageRegistry.addName(FField, "Force Field");
		LanguageRegistry.addName(IrnTnk, "Iron Tank");
		LanguageRegistry.addName(BlockyBlock, "Type-A Blocks");
		
		LanguageRegistry.addName(Soul, "Soul in a Bottle");
		LanguageRegistry.addName(Space, "Contained Space");
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.ACTab", "en_US", "Annihilation Craft");
		}
	
	protected void registerThings()
		{
		GameRegistry.registerBlock(FField, "ForceField");
		GameRegistry.registerBlock(IrnTnk, "IronTank");
		
		GameRegistry.registerTileEntity(TileIrnTnk.class, "IronTankTile");
		}
	
	}

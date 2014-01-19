package lazmod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler
	{
	/*
	 *	
	 */
	public ItemStack isCrafting		= new ItemStack(ScienceCraft.CraftingItem, 1, 0);
	public ItemStack isSoul			= new ItemStack(ScienceCraft.CraftingItem, 1, 1);
	public ItemStack isSpace		= new ItemStack(ScienceCraft.CraftingItem, 1, 2);

	public ItemStack isIron			= new ItemStack(ScienceCraft.CraftingItem, 1, 3);
	public ItemStack isGold			= new ItemStack(ScienceCraft.CraftingItem, 1, 4);
	
	public ItemStack isIron2		= new ItemStack(ScienceCraft.CraftingItem, 2, 3);
	public ItemStack isGold2		= new ItemStack(ScienceCraft.CraftingItem, 2, 4);

	public ItemStack isDerivium		= new ItemStack(ScienceCraft.Derivium, 1);
	public ItemStack isEmmitium		= new ItemStack(ScienceCraft.Emmitium, 1);
	
	protected RecipeHandler() {}
	
	protected void addRecipes()
		{
		
		/*
		 *	Old ML recipes
		 */
		
		GameRegistry.addShapelessRecipe(new ItemStack(ScienceCraft.CraftingItem, 8, 1), new Object[]{Block.slowSand, Item.glassBottle, Item.glassBottle, Item.glassBottle, Item.glassBottle, Item.glassBottle, Item.glassBottle, Item.glassBottle, Item.glassBottle});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 55), new Object[]{ Item.slimeBall, Item.slimeBall, isSoul});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 54), new Object[]{ Item.rottenFlesh, Item.rottenFlesh, isSoul});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 51), new Object[]{ Item.arrow, Item.arrow, Item.bone, Item.bone, isSoul});

		GameRegistry.addRecipe(new ItemStack(ScienceCraft.FField, 1), new Object[]{ "111", "202", "111", Character.valueOf('0'), Block.bedrock, Character.valueOf('1'), Block.glass, Character.valueOf('2'), Item.redstone});
		
		/*
		 *	Generic Tiles
		 */
		
		GameRegistry.addRecipe(new ItemStack(ScienceCraft.IrnTnk, 1), new Object[]{ "#11", "323", "11#", Character.valueOf('1'), Item.ingotIron, Character.valueOf('2'), Block.blockIron, Character.valueOf('3'), Item.redstone});
		GameRegistry.addRecipe(new ItemStack(ScienceCraft.WtrSrc, 1), new Object[]{ "#11", "323", "11#", Character.valueOf('1'), Item.ingotIron, Character.valueOf('2'), Item.bucketWater, Character.valueOf('3'), Item.redstone});

		
		/*
		 *	Solar machines
		 */
		
		
	
		/*	
		 *	Solar recipes
		 */
		// Furnace
		ScienceCraft.DateHandler.BlockyCraftHandler[0].addResult(isIron, new ItemStack(Item.ingotIron));
		ScienceCraft.DateHandler.BlockyCraftHandler[0].addResult(isGold, new ItemStack(Item.ingotGold));
		
		// Smasher
		ScienceCraft.DateHandler.BlockyCraftHandler[1].addResult(new ItemStack(Block.stone			), new ItemStack(Block.cobblestone	));
		ScienceCraft.DateHandler.BlockyCraftHandler[1].addResult(new ItemStack(Block.cobblestone	), new ItemStack(Block.sand			));
		ScienceCraft.DateHandler.BlockyCraftHandler[1].addResult(new ItemStack(Block.glass			), new ItemStack(Block.sand			));
		
		ScienceCraft.DateHandler.BlockyCraftHandler[1].addResult(new ItemStack(Block.oreIron		), isIron2							 );
		ScienceCraft.DateHandler.BlockyCraftHandler[1].addResult(new ItemStack(Block.oreGold		), isGold2							 );
		
		// LavaGen
		ScienceCraft.DateHandler.BlockyCraftHandler[2].addResult(new ItemStack(Block.obsidian		), new ItemStack(Block.lavaMoving));
		}
	}

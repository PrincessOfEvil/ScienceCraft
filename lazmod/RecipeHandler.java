package lazmod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler
	{
	/*
	 *	
	 */
	public ItemStack	isCrafting	= new ItemStack(ScienceCraft.CraftingItem, 1, 0);
	public ItemStack	isSoul		= new ItemStack(ScienceCraft.CraftingItem, 1, 1);
	public ItemStack	isSpace		= new ItemStack(ScienceCraft.CraftingItem, 1, 2);
	
	public ItemStack	isIron		= new ItemStack(ScienceCraft.CraftingItem, 1, 3);
	public ItemStack	isGold		= new ItemStack(ScienceCraft.CraftingItem, 1, 4);
	
	public ItemStack	isIron2		= new ItemStack(ScienceCraft.CraftingItem, 2, 3);
	public ItemStack	isGold2		= new ItemStack(ScienceCraft.CraftingItem, 2, 4);
	
	public ItemStack	isDerivium	= new ItemStack(ScienceCraft.Derivium, 1);
	public ItemStack	isEmmitium	= new ItemStack(ScienceCraft.Emmitium, 1);
	
	protected RecipeHandler()
		{}
	
	protected void addRecipes()
		{
		
		/*
		 * Old ML recipes
		 */
		
		GameRegistry.addShapelessRecipe(new ItemStack(ScienceCraft.CraftingItem, 8, 1), new Object[] { Blocks.soul_sand, Items.glass_bottle, Items.glass_bottle, Items.glass_bottle, Items.glass_bottle, Items.glass_bottle, Items.glass_bottle, Items.glass_bottle, Items.glass_bottle });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 55), new Object[] { Items.slime_ball, Items.slime_ball, isSoul });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 54), new Object[] { Items.rotten_flesh, Items.rotten_flesh, isSoul });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 51), new Object[] { Items.arrow, Items.arrow, Items.bone, Items.bone, isSoul });
		
		GameRegistry.addRecipe(new ItemStack(ScienceCraft.FField, 1), new Object[] { "111", "202", "111", Character.valueOf('0'), Blocks.bedrock, Character.valueOf('1'), Blocks.glass, Character.valueOf('2'), Items.redstone });
		
		/*
		 * Generic Tiles
		 */
		
		GameRegistry.addRecipe(new ItemStack(ScienceCraft.IrnTnk, 1), new Object[] { "#11", "323", "11#", Character.valueOf('1'), Items.iron_ingot, Character.valueOf('2'), Blocks.iron_block, Character.valueOf('3'), Items.redstone });
		GameRegistry.addRecipe(new ItemStack(ScienceCraft.WtrSrc, 1), new Object[] { "#11", "323", "11#", Character.valueOf('1'), Items.iron_ingot, Character.valueOf('2'), Items.water_bucket, Character.valueOf('3'), Items.redstone });
		
		/*
		 * Solar machines
		 */
		
		/*
		 * Solar recipes
		 */
		}
	}

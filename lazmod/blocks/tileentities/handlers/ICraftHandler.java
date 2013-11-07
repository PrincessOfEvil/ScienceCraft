package lazmod.blocks.tileentities.handlers;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public interface ICraftHandler

	{
	void addResult(ItemStack input, ItemStack output);
	ItemStack getCraftingResult(ItemStack input);
//	public static final ICraftHandler staticInst();
	}
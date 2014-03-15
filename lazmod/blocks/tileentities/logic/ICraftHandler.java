package lazmod.blocks.tileentities.logic;

import net.minecraft.item.ItemStack;

public interface ICraftHandler

	{
	void addResult(ItemStack input, ItemStack output);
	
	ItemStack getCraftingResult(ItemStack input);
	// public static final ICraftHandler staticInst();
	}
package lazmod.blocks.tileentities.handlers;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import lazmod.blocks.tileentities.handlers.ICraftHandler;

public class CraftFurnaceHandler implements ICraftHandler
	{
    private static final CraftFurnaceHandler craftBase = new CraftFurnaceHandler();
	
	public static final ICraftHandler staticInst()
		{
		return craftBase;
		}
    
	@Override
	public ItemStack getCraftingResult(ItemStack input)
		{
		return FurnaceRecipes.smelting().getSmeltingResult(input);
		}

	@Override
	public void addResult(ItemStack input, ItemStack output)
		{
		FurnaceRecipes.smelting().addSmelting(input.itemID, input.getItemDamage(), output, 0.0f);
		}
	}

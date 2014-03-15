package lazmod.blocks.tileentities.logic;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftFurnaceHandler implements ICraftHandler
	{
	private static final CraftFurnaceHandler	craftBase	= new CraftFurnaceHandler();

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
		GameRegistry.addSmelting(input, output, 0.0f);
		}
	}

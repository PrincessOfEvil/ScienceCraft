package lazmod.blocks.tileentities.logic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.item.ItemStack;

public class CraftLavaGenHandler implements ICraftHandler
	{
    private static final CraftLavaGenHandler craftBase = new CraftLavaGenHandler();
	private HashMap<List<Integer>, ItemStack> craftList = new HashMap<List<Integer>, ItemStack>();
	
	public static final ICraftHandler staticInst()
		{
		return craftBase;
		}
	
	@Override
    public ItemStack getCraftingResult(ItemStack input) 
		{
        if (input == null)
        	{
            return null;
        	}
        return (ItemStack)craftList.get(Arrays.asList(input.itemID, input.getItemDamage()));
		}

	
	@Override
	public void addResult(ItemStack input, ItemStack output)
		{
		craftList.put(Arrays.asList(input.itemID, input.getItemDamage()),output);
		}
	}

package lazmod.blocks.tileentities.logic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;

public class CraftSmasherHandler implements ICraftHandler
	{
	private static final CraftSmasherHandler	craftBase	= new CraftSmasherHandler();
	private Map<ItemStack, ItemStack>			craftList	= new HashMap<ItemStack, ItemStack>();

	public static final ICraftHandler staticInst()
		{
		return craftBase;
		}

	@Override
	public ItemStack getCraftingResult(ItemStack stack)
		{
		Iterator<?> iterator = craftList.entrySet().iterator();
		Entry<?, ?> entry;

		do
			{
			if (!iterator.hasNext()) { return null; }

			entry = (Entry<?, ?>) iterator.next();
			}
		while (!isEqual(stack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
		}

	private boolean isEqual(ItemStack stack1, ItemStack stack2)
		{
		return stack1.getItem() == stack2.getItem() && (stack1.getItemDamage() == 32767 || stack1.getItemDamage() == stack2.getItemDamage());
		}

	@Override
	public void addResult(ItemStack input, ItemStack output)
		{
		craftList.put(input, output);
		}
	}
package lazmod.items;

import java.util.List;

import lazmod.ScienceCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemCrafting extends Item
	{
	private IIcon[]	iconSaver;
	public boolean	hasSubtypes	= true;

	private byte	itemNumber	= ScienceCraft.DateHandler.CraftingItemNumber;

	public ItemCrafting()
		{
		super();
		setHasSubtypes(true);
		}

	@Override
	public void registerIcons(IIconRegister iconRegister)
		{
		iconSaver = new IIcon[itemNumber];

		iconSaver[0] = iconRegister.registerIcon("lazmod:itemDummy");
		iconSaver[1] = iconRegister.registerIcon("lazmod:itemSoul");
		iconSaver[2] = iconRegister.registerIcon("lazmod:itemSpace");

		iconSaver[3] = iconRegister.registerIcon("lazmod:itemDustIron");
		iconSaver[4] = iconRegister.registerIcon("lazmod:itemDustGold");
		}

	@Override
	public IIcon getIconFromDamage(int i)
		{
		if (iconSaver != null)
			{
			return iconSaver[i];
			}
		iconSaver = new IIcon[itemNumber];
		return iconSaver[i];
		}

	@Override
	public boolean requiresMultipleRenderPasses()
		{
		return false;
		}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void getSubItems(Item par1, CreativeTabs tab, List SubItems)
		{
		for (int tItemId = 1; tItemId < itemNumber; tItemId++)
			{
			SubItems.add(new ItemStack(par1, 1, tItemId));
			}
		}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
		{
		return ScienceCraft.DateHandler.CraftingLocalization[par1ItemStack.getItemDamage()];
		}
	}
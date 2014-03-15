package lazmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SC_CreativeTab extends CreativeTabs
	{
	public SC_CreativeTab(String name)
		{
		super(name);
		}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
		{
		return ScienceCraft.CraftingItem;
		}
	}

package mods.lazmod;

import net.minecraft.creativetab.CreativeTabs;
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
        public int getTabIconItemIndex()
        	{
        	return ScienceCraft.CraftingItem.itemID;
        	}
	}

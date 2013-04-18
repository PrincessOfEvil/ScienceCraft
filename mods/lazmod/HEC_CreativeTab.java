package mods.lazmod;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HEC_CreativeTab extends CreativeTabs
	{
    	public HEC_CreativeTab(String name)
    		{
            super(name);
    		}
        @Override
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
        	{
        	return HighEnergyCraft.Space.itemID;
        	}
	}

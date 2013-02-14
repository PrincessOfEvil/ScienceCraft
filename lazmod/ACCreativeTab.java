package lazmod;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ACCreativeTab extends CreativeTabs
	{
    	public ACCreativeTab(String name)
    		{
            super(name);
    		}
        @Override
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
        	{
        	return AnnihilationCraft.Space.itemID;
        	}
	}

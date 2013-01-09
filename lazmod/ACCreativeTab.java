package lazmod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

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

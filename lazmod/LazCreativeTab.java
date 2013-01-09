package lazmod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class LazCreativeTab extends CreativeTabs
	{
    	public LazCreativeTab(int id, String name)
    		{
            super(id, name);
    		}
        @Override
        @SideOnly(Side.CLIENT)
        public String getTranslatedTabLabel()
        {
                return  "Annihilation Craft";
        }
        @Override
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
        	{
        	return AnnihilationCraft.Space.itemID;
        	}

	}

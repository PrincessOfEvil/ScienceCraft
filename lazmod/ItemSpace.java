package lazmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;

public class ItemSpace extends Item
	{
    public ItemSpace(int i)
    	{
        super(i);
        maxStackSize = 64;
		setIconIndex(1);
		}
    public String getTextureFile()
    {
            return ACProxy.ITEMS1_PNG;
    }
	}
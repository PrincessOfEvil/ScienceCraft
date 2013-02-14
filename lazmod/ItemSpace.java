package lazmod;

import net.minecraft.item.Item;

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
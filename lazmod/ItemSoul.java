package lazmod;

import net.minecraft.item.Item;

public class ItemSoul extends Item
	{
    public ItemSoul(int i)
    	{
        super(i);
        maxStackSize = 8;
        setIconIndex(0);
        }
    public String getTextureFile()
    {
            return ACProxy.ITEMS1_PNG;
    }
	}
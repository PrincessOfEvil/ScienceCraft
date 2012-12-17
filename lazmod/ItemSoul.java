package lazmod;

import static cpw.mods.fml.common.Side.CLIENT;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;

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
            return lazProxy.ITEMS1_PNG;
    }
	}
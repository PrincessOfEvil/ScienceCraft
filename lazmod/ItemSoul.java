package lazmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;

public class ItemSoul extends Item
	{
    public ItemSoul(int i)
    	{
        super(i);
        maxStackSize = 8;
		this.setCreativeTab(AnnihilationCraft.LazTab);
        setIconIndex(0);
        }
    public String getTextureFile()
    {
            return lazProxy.ITEMS1_PNG;
    }
	}
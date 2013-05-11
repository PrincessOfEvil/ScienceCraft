package mods.lazmod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemSpace extends Item
	{
    public ItemSpace(int i)
    	{
        super(i);
        maxStackSize = 64;
		}
    @Override
    public void registerIcons(IconRegister iconRegister)
    	{
    	itemIcon = iconRegister.registerIcon("lazmod:itemSpace");
    	}
	}
package mods.lazmod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemSoul extends Item
	{
    public ItemSoul(int i)
    	{
    	super(i);
    	maxStackSize = 8;
        }
    @Override
    public void updateIcons(IconRegister iconRegister)
    	{
    	iconIndex = iconRegister.registerIcon("lazmod:itemSoul");
    	}
	}
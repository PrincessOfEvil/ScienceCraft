package mods.lazmod;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemCrafting extends Item
	{
	private Icon[] iconSaver;
	public boolean hasSubtypes = true;
	
	private byte itemNumber = HighEnergyCraft.DateHandler.CraftingItemNumber;
	
    public ItemCrafting(int i)
    	{
    	super(i);
        }
    @Override
    public void registerIcons(IconRegister iconRegister)
    	{
    	iconSaver = new Icon[itemNumber];
    	
    	iconSaver[0] = iconRegister.registerIcon("lazmod:itemDummy");
    	iconSaver[1] = iconRegister.registerIcon("lazmod:itemSoul");
    	iconSaver[2] = iconRegister.registerIcon("lazmod:itemSpace");
    	}
    @Override
    public Icon getIconFromDamage(int i)
    	{
			return iconSaver[i];
    	}
    
	@Override
	public void getSubItems(int par1, CreativeTabs tab, List subItems)
		{
		for (int tItemId = 0; tItemId < itemNumber; tItemId++)
			{
			subItems.add(new ItemStack(par1, 1, tItemId));
			}
		}
	public String getUnlocalizedName(ItemStack par1ItemStack)
		{
		return HighEnergyCraft.DateHandler.CraftingLocalization[par1ItemStack.getItemDamage()];
		}
	}
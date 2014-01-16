package lazmod.items;

import java.util.List;

import lazmod.ScienceCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class ItemObsidianPick extends ItemPickaxe 
	{
	public ItemObsidianPick(int par1)
		{
		super(par1, ScienceCraft.SC_OBSIDIAN);
		}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
	    {
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		NBTTagList nbttaglist = par1ItemStack.getEnchantmentTagList();

		if (nbttaglist != null)
			{
			for (int i = 0; i < nbttaglist.tagCount(); ++i)
				{
				short short1 = ((NBTTagCompound)nbttaglist.tagAt(i)).getShort("id");
				short short2 = ((NBTTagCompound)nbttaglist.tagAt(i)).getShort("lvl");
				String Ench = ScienceCraft.DateHandler.EvilEnchantLocalization[short1];
				
				if (Enchantment.enchantmentsList[short1] != null)
	                {
					par3List.add(Ench != null ? Ench + ' ' + short2 : Enchantment.enchantmentsList[short1].getTranslatedName(short2));
	                }
				}
			par3List.add(" ");
	        }
	    }
	
    @Override
    public void registerIcons(IconRegister iconRegister)
    	{
    	itemIcon = iconRegister.registerIcon("lazmod:itemObsPick");
    	}
	}

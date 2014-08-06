package lazmod.items;

import java.util.List;

import lazmod.ScienceCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;

public class ItemObsidianPick extends ItemPickaxe
	{
	public ItemObsidianPick()
		{
		super(ScienceCraft.SC_OBSIDIAN);
		}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
		{
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		NBTTagList nbttaglist = par1ItemStack.getEnchantmentTagList();
		
		if (nbttaglist != null)
			{
			for (int i = 0; i < nbttaglist.tagCount(); ++i)
				{
				short short1 = nbttaglist.getCompoundTagAt(i).getShort("id");
				short short2 = nbttaglist.getCompoundTagAt(i).getShort("lvl");
				String Ench = ScienceCraft.dataHandler.EvilEnchantNames[short1];
				
				if (Enchantment.enchantmentsList[short1] != null)
					{
					par3List.add(Ench != null ? Ench + ' ' + short2 : Enchantment.enchantmentsList[short1].getTranslatedName(short2));
					}
				}
			par3List.add(" ");
			}
		}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
		{
		itemIcon = iconRegister.registerIcon("lazmod:itemObsPick");
		}
	}

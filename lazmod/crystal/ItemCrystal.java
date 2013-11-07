package lazmod.crystal;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCrystal extends ItemBlock
	{
	public ItemCrystal(int par1) 
		{
		super(par1);
		}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) 
		{
		if (itemStack.stackTagCompound != null)
			{
			list.add("Size: " + itemStack.stackTagCompound.getInteger("Size"));
			}
		else
			{
			list.add("Size: 2");
			}
		}
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
		{
		return EnumRarity.rare;
		}
	}

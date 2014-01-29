package lazmod.crystal;

import java.util.List;

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
	public EnumRarity getRarity(ItemStack par1ItemStack)
		{
		return EnumRarity.rare;
		}
	}

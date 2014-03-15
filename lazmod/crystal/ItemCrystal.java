package lazmod.crystal;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCrystal extends ItemBlock
	{
	public ItemCrystal(Block par1)
		{
		super(par1);
		}
	
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
		{
		return EnumRarity.rare;
		}
	}

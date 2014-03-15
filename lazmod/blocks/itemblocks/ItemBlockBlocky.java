package lazmod.blocks.itemblocks;

import lazmod.ScienceCraft;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBlocky extends ItemBlock
	{

	public ItemBlockBlocky(Block id)
		{
		super(id);
		setHasSubtypes(true);
		}

	@Override
	public int getMetadata(int damageValue)
		{
		return damageValue;
		}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
		{
		return ScienceCraft.DateHandler.BlockyLocalization[par1ItemStack.getItemDamage()];
		}
	}

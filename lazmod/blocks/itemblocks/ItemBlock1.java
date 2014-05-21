package lazmod.blocks.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlock1 extends ItemBlock
	{
	
	public ItemBlock1(Block id)
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
		return "tile.";
		}
	}

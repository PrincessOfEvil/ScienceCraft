package mods.lazmod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageHandler
	{
	protected LanguageHandler() {}
	
	private void forL(String[] Localization, byte Amount, Object toName)
		{
		if (toName instanceof Block)
			{
			for (byte meta = 0; meta < Amount; meta++)
				{
				ItemStack IS = new ItemStack((Block) toName, 1, meta);
				LanguageRegistry.addName(IS, Localization[meta]);
				}
			}
		else if (toName instanceof Item)
			{
			for (byte meta = 0; meta < Amount; meta++)
				{
				ItemStack IS = new ItemStack((Item) toName, 1, meta);
				LanguageRegistry.addName(IS, Localization[meta]);
				}
			}
		}
	
	protected void addNames()
		{
		LanguageRegistry.addName(HighEnergyCraft.FField,		"Force Field"); //I need to use strings.
		LanguageRegistry.addName(HighEnergyCraft.IrnTnk,		"Iron Tank");
		LanguageRegistry.addName(HighEnergyCraft.BlockyBlock,	"Type-A TE Blocks");
		
		forL(HighEnergyCraft.DateHandler.BlockyLocalization,HighEnergyCraft.DateHandler.BlockyBlockTypeAmount,HighEnergyCraft.BlockyBlock);
		forL(HighEnergyCraft.DateHandler.CraftingLocalization,HighEnergyCraft.DateHandler.CraftingItemNumber,HighEnergyCraft.CraftingItem);
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.ACTab", "en_US", "Annihilation Craft");
		}
	}
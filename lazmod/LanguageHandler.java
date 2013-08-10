package lazmod;

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
		LanguageRegistry.addName(ScienceCraft.FField,		"Force Field"); //TODO: I need to use strings. And load them. Later.
		LanguageRegistry.addName(ScienceCraft.IrnTnk,		"Iron Tank");
		LanguageRegistry.addName(ScienceCraft.BlockyBlock,	"Type-A TE Blocks");
		
		LanguageRegistry.addName(ScienceCraft.Derivium,	"Derivium");
		LanguageRegistry.addName(ScienceCraft.Emmitium,	"Emmitium");
		
		forL(ScienceCraft.DateHandler.BlockyLocalization,ScienceCraft.DateHandler.BlockyBlockTypeAmount,ScienceCraft.BlockyBlock);
		forL(ScienceCraft.DateHandler.CraftingLocalization,ScienceCraft.DateHandler.CraftingItemNumber,ScienceCraft.CraftingItem);
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.SCTab", "en_US", "Science Craft");
		}
	}
package mods.lazmod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RegistryHandler
	{
	public ItemStack isCrafting		= new ItemStack(HighEnergyCraft.CraftingItem, 1, 0); //is is ItemStack.
	public ItemStack isSoul			= new ItemStack(HighEnergyCraft.CraftingItem, 1, 1);
	public ItemStack isSpace		= new ItemStack(HighEnergyCraft.CraftingItem, 1, 2);

	protected RegistryHandler() {}
	
	protected void registerThings()
		{
		GameRegistry.registerBlock(HighEnergyCraft.FField, "ForceField");
		GameRegistry.registerBlock(HighEnergyCraft.IrnTnk, "IronTank");
		GameRegistry.registerBlock(HighEnergyCraft.BlockyBlock, ItemBlockBlocky.class, "BlockyBlock");
		
		GameRegistry.registerTileEntity(TileIrnTnk.class, "IronTankTile");
        GameRegistry.registerTileEntity(TileBlockyBlock.class, "BlockyBlockTile");
        
        NetworkRegistry.instance().registerGuiHandler(this, new HEC_GuiHandler());
		}
	
	}

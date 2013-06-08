package mods.lazmod;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegistryHandler
	{
	public ItemStack isCrafting		= new ItemStack(ScienceCraft.CraftingItem, 1, 0); //is is ItemStack.
	public ItemStack isSoul			= new ItemStack(ScienceCraft.CraftingItem, 1, 1);
	public ItemStack isSpace		= new ItemStack(ScienceCraft.CraftingItem, 1, 2);

	protected RegistryHandler() {}
	
	protected void registerThings()
		{
		GameRegistry.registerBlock(ScienceCraft.FField, "ForceField");
		GameRegistry.registerBlock(ScienceCraft.IrnTnk, "IronTank");
		GameRegistry.registerBlock(ScienceCraft.BlockyBlock, ItemBlockBlocky.class, "BlockyBlock");
		
		GameRegistry.registerBlock(ScienceCraft.Emmitium, "Emmitium");
		GameRegistry.registerBlock(ScienceCraft.Derivium, "Derivium");
		
		
		GameRegistry.registerTileEntity(TileIrnTnk.class, "IronTankTile");
        GameRegistry.registerTileEntity(TileBlockyBlock.class, "BlockyBlockTile");

        GameRegistry.registerTileEntity(TileCrystal.class, "CrystalTile");
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileCrystal.class, new TileCrystalRenderer());
        MinecraftForgeClient.registerItemRenderer(ScienceCraft.Derivium.blockID, new ItemCrystalRenderer("Derivium"));
        MinecraftForgeClient.registerItemRenderer(ScienceCraft.Emmitium.blockID, new ItemCrystalRenderer("Emmitium"));
        
        
        NetworkRegistry.instance().registerGuiHandler(this, new SC_GuiHandler());
		}
	
	}

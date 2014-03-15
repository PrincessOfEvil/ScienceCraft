package lazmod;

import lazmod.blocks.itemblocks.ItemBlockBlocky;
import lazmod.blocks.itemblocks.ItemBlockIrnTnk;
import lazmod.blocks.tileentities.TileBlockyBlock;
import lazmod.blocks.tileentities.TileIrnTnk;
import lazmod.blocks.tileentities.TileWtrSrc;
import lazmod.crystal.ItemCrystal;
import lazmod.crystal.ItemCrystalRenderer;
import lazmod.crystal.TileCrystal;
import lazmod.crystal.TileCrystalRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegistryHandler
	{
	public ItemStack	isCrafting	= new ItemStack(ScienceCraft.CraftingItem, 1, 0);	// is is ItemStack.
	public ItemStack	isSoul		= new ItemStack(ScienceCraft.CraftingItem, 1, 1);
	public ItemStack	isSpace		= new ItemStack(ScienceCraft.CraftingItem, 1, 2);
	
	protected RegistryHandler()
		{}
	
	protected void registerThings()
		{
		GameRegistry.registerBlock(ScienceCraft.FField, "ForceField");
		GameRegistry.registerBlock(ScienceCraft.IrnTnk, ItemBlockIrnTnk.class, "IronTank");
		GameRegistry.registerBlock(ScienceCraft.WtrSrc, "WaterSource");
		GameRegistry.registerBlock(ScienceCraft.CrystF, "CrystalF");
		
		GameRegistry.registerBlock(ScienceCraft.BlockyBlock, ItemBlockBlocky.class, "BlockyBlock");
		
		GameRegistry.registerBlock(ScienceCraft.Derivium, ItemCrystal.class, "Derivium");
		GameRegistry.registerBlock(ScienceCraft.Emmitium, ItemCrystal.class, "Emmitium");
		
		GameRegistry.registerItem(ScienceCraft.CraftingItem, "CraftingItem");
		GameRegistry.registerItem(ScienceCraft.ObsidianPick, "ObsidianPick");
		
		GameRegistry.registerTileEntity(TileIrnTnk.class, "IronTankTile");
		GameRegistry.registerTileEntity(TileWtrSrc.class, "WaterSrcTile");
		
		GameRegistry.registerTileEntity(TileBlockyBlock.class, "BlockyBlockTile");
		
		GameRegistry.registerTileEntity(TileCrystal.class, "CrystalTile");
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileCrystal.class, new TileCrystalRenderer());
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ScienceCraft.Derivium), new ItemCrystalRenderer("Derivium"));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ScienceCraft.Emmitium), new ItemCrystalRenderer("Emmitium"));
		
		// MinecraftForgeClient.registerItemRenderer(ScienceCraft.CraftingItem.itemID,
		// new CraftingItemRenderer());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(ScienceCraft.instance, new GuiHandler());
		
		MinecraftForge.EVENT_BUS.register(new EventListener());
		}
	
	}

package lazmod;

import lazmod.blocks.itemblocks.ItemBlockIrnTnk;
import lazmod.blocks.renderer.ConnectedGlassRenderer;
import lazmod.blocks.tileentities.TileIrnTnk;
import lazmod.blocks.tileentities.TileSolar;
import lazmod.blocks.tileentities.TileWtrSrc;
import lazmod.crystal.ItemCrystal;
import lazmod.crystal.ItemCrystalRenderer;
import lazmod.crystal.TileCrystal;
import lazmod.crystal.TileCrystalRenderer;
import lazmod.items.renderer.CraftingItemRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegistryHandler
	{
	public ItemStack	isCrafting	= new ItemStack(ScienceCraft.CraftingItem, 1, 0);	// is is ItemStack.
	public ItemStack	isSoul		= new ItemStack(ScienceCraft.CraftingItem, 1, 1);
	public ItemStack	isSpace		= new ItemStack(ScienceCraft.CraftingItem, 1, 2);
	
	public static int	connectedGlassRenderType;
	public static int	connectedGlassRenderPass;
	
	protected RegistryHandler()
		{}
	
	protected void registerThings()
		{
		GameRegistry.registerBlock(ScienceCraft.FField, "ForceField");
		GameRegistry.registerBlock(ScienceCraft.IrnTnk, ItemBlockIrnTnk.class, "IronTank");
		GameRegistry.registerBlock(ScienceCraft.WtrSrc, "WaterSource");
		GameRegistry.registerBlock(ScienceCraft.CrystF, "CrystalF");
		GameRegistry.registerBlock(ScienceCraft.CGlass, "ConnectedGlass");
		
		GameRegistry.registerBlock(ScienceCraft.SolarFurnace, "SolarFurnace");
		GameRegistry.registerBlock(ScienceCraft.SolarSmasher, "SolarSmasher");
		GameRegistry.registerBlock(ScienceCraft.SolarLavaGen, "SolarLavaGen");
		
		GameRegistry.registerBlock(ScienceCraft.Derivium, ItemCrystal.class, "Derivium");
		GameRegistry.registerBlock(ScienceCraft.Emmitium, ItemCrystal.class, "Emmitium");
		
		GameRegistry.registerItem(ScienceCraft.CraftingItem, "CraftingItem");
		GameRegistry.registerItem(ScienceCraft.ObsidianPick, "ObsidianPick");
		
		GameRegistry.registerBlock(ScienceCraft.EnergyFluidBlock, "EnergyFluid");
		
		GameRegistry.registerTileEntity(TileIrnTnk.class, "IronTankTile");
		GameRegistry.registerTileEntity(TileWtrSrc.class, "WaterSrcTile");
		
		GameRegistry.registerTileEntity(TileSolar.class, "SolarTile");
		
		GameRegistry.registerTileEntity(TileCrystal.class, "CrystalTile");
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileCrystal.class, new TileCrystalRenderer());
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ScienceCraft.Derivium), new ItemCrystalRenderer("Derivium"));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ScienceCraft.Emmitium), new ItemCrystalRenderer("Emmitium"));
		
		connectedGlassRenderType = RenderingRegistry.getNextAvailableRenderId();
		
		RenderingRegistry.registerBlockHandler(new ConnectedGlassRenderer());
		
		MinecraftForgeClient.registerItemRenderer(ScienceCraft.CraftingItem, new CraftingItemRenderer());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(ScienceCraft.instance, new GuiHandler());
		}
	
	}

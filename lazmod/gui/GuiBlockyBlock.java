package lazmod.gui;

import lazmod.ScienceCraft;
import lazmod.blocks.containers.ContainerBlockyBlock;
import lazmod.blocks.tileentities.TileBlockyBlock;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiBlockyBlock extends GuiContainer
	{
	private int id;
	private TileBlockyBlock TE;
	
    public GuiBlockyBlock (InventoryPlayer inventoryPlayer, TileBlockyBlock tileEntity)
    	{
    	super(new ContainerBlockyBlock(inventoryPlayer, tileEntity));
    	id = tileEntity.blockMeta;
    	TE = tileEntity;
    	}

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2)
    	{
    	fontRenderer.drawString(ScienceCraft.DateHandler.BlockyLocalization[id], 8, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    	fontRenderer.drawString(TE.getCharge()+"", 8, 16, 4210752);
    	}

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    	{
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(new ResourceLocation("lazmod:textures/gui/"+ScienceCraft.DateHandler.BlockyBlockTypeName[id]+".png"));
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        
        if (TE.isUsing)
        	{
        	this.drawTexturedModalRect(x + 79, y + 29, xSize, 0, 24, 24);
        	}
    	}
	}

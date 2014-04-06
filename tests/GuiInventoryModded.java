package tests;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiInventoryModded extends GuiInventory
	{
	protected static final ResourceLocation inv = new ResourceLocation("tests:textures/gui/inventory.png");
	
	public GuiInventoryModded(EntityPlayer par1EntityPlayer)
        {
        super(par1EntityPlayer);
        }
    
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    	{
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(inv);
        int k = this.guiLeft;
        int l = this.guiTop;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        func_147046_a(k + 51, l + 75, 30, (float)(k + 51) - this.xSize, (float)(l + 75 - 50) - this.ySize, this.mc.thePlayer);
    	}
	}
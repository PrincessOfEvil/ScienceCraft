package lazmod.items.renderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

public class CraftingItemRenderer implements IItemRenderer 
	{
    private static RenderItem renderItem = new RenderItem();

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
		{
        return type == ItemRenderType.INVENTORY;
		}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
		{
		return false;
		}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
		{	    
        GL11.glEnable(GL11.GL_BLEND);
        
        
        
	    GL11.glDisable(GL11.GL_BLEND);
		}
	}

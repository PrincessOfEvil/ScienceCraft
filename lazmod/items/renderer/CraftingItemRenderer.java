package lazmod.items.renderer;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

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

package lazmod.items.renderer;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class CraftingItemRenderer implements IItemRenderer
	{
	
	private static RenderItem	renderItem	= RenderItem.getInstance();
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
		{
		return true;
		}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
		{
		return false;
		}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
		{
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		//render
		switch (type)
			{
			case INVENTORY:
				{
				IIcon icon = item.getIconIndex();
				renderItem.renderIcon(0, 0, icon, 16, 16);
				break;
				}
			case ENTITY:
				{
				EntityItem entityitem = (EntityItem) data[1];
				entityitem.setEntityItemStack(item);
				RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
				break;
				}
			case EQUIPPED:
				{
				
				break;
				}
			case EQUIPPED_FIRST_PERSON:
				{
				
				break;
				}
			default:break;
			}
		GL11.glPopAttrib();
		GL11.glPopMatrix();
		}
	
	}

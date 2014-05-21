package lazmod.crystal;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemCrystalRenderer implements IItemRenderer
	{
	private ModelCrystal	modelCrystal;
	
	public ItemCrystalRenderer(String type)
		{
		modelCrystal = new ModelCrystal(type);
		}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
		{
		return true;
		}
	
	private void renderCrystal(float x, float y, float z, float scale)
		{
		GL11.glPushMatrix();
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GL11.glTranslatef(x, y - 0.75f, z);
		GL11.glScalef(scale * 3f, scale * 3f, scale * 3f);
		
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("lazmod:textures/crystals/crystal" + modelCrystal.type + ".png"));
		
		modelCrystal.render();
		
		GL11.glDisable(GL11.GL_BLEND);
		
		GL11.glEnable(GL11.GL_LIGHTING);
		
		GL11.glPopMatrix();
		}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
		{
		switch (type)
			{
			case ENTITY:
				{
				renderCrystal(0f, 0f, 0f, 0.5f);
				return;
				}
			
			case EQUIPPED:
				{
				renderCrystal(0f, 1f, 1f, 0.5f);
				return;
				}
			
			case INVENTORY:
				{
				renderCrystal(0f, 0f, 0f, 0.5f);
				return;
				}
			
			default:
				return;
			}
		}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
		{
		return true;
		}
	}

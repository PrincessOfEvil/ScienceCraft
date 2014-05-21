package lazmod.blocks.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class ConnectedGlassRenderer implements ISimpleBlockRenderingHandler
	{
	
	@Override
	public int getRenderId()
		{
		return 0;
		}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
		{}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
		{
		
		return true;
		}
	
	@Override
	public boolean shouldRender3DInInventory(int modelId)
		{
		return true;
		}
	
	private void renderAnything(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
		{
		
		}
	}

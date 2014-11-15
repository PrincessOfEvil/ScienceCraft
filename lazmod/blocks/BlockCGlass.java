package lazmod.blocks;

import lazmod.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCGlass extends Block
	{
	public BlockCGlass()
		{
		super(Material.glass);
		setBlockTextureName("lazmod:blockCGlass");
		}
	
	@Override
	public boolean canRenderInPass(int pass)
		{
		return RegistryHandler.connectedGlassRenderPass == pass;
		}
	
	@Override
	public int getRenderBlockPass()
		{
		return 0;
		}
	
	@Override
	public int getRenderType()
		{
		return RegistryHandler.connectedGlassRenderType;
		}
	
	@Override
	public boolean isOpaqueCube()
		{
		return false;
		}
	
	@Override
	public boolean renderAsNormalBlock()
		{
		return false;
		}
	}

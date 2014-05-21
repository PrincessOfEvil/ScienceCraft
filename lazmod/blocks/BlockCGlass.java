package lazmod.blocks;

import lazmod.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCGlass extends Block
	{
	public BlockCGlass()
		{
		super(Material.glass);
		}
	
	@Override
	public boolean canRenderInPass(int pass)
		{
		RegistryHandler.connectedGlassRenderPass = pass;
		return true;
		}
	
	@Override
	public int getRenderBlockPass()
		{
		return 1;
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

package lazmod.blocks;

import lazmod.blocks.tileentities.TileWtrSrc;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWtrSrc extends BlockContainer {

	private Icon[] iconSaver;
	
	public BlockWtrSrc(int par1)
		{
		super(par1, Material.iron);
		}

	@Override
	public TileEntity createNewTileEntity(World world)
		{
		return new TileWtrSrc();
		}
	@Override
    public void registerIcons(IconRegister par1IconRegister)
    	{
    	iconSaver = new Icon[2];
    	
    	iconSaver[0] = par1IconRegister.registerIcon("lazmod:blockWtrSrcTB");
    	iconSaver[1] = par1IconRegister.registerIcon("lazmod:blockWtrSrcSide");
    	}
	@Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int blockSide)
		{
		if (blockSide == 0)
			{
			return iconSaver[0];
			}
		if (blockSide == 1)
			{
			return iconSaver[0];
			}
		else
			{
			return iconSaver[1];
			}
		} 
	@Override
	public Icon getIcon(int blockSide, int metadata)
		{
		if (blockSide == 0)
			{
			return iconSaver[0];
			}
		if (blockSide == 1)
			{
			return iconSaver[0];
			}
		else
			{
			return iconSaver[1];
			}
		}
}

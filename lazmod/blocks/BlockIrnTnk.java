package lazmod.blocks;

import java.util.Random;

import lazmod.ScienceCraft;
import lazmod.blocks.tileentities.TileIrnTnk;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockIrnTnk extends BlockContainer //TODO: Actual tank
	{
	public BlockIrnTnk(int i)
		{
		super(i, Material.iron); //TODO: Material... Maybe.
		}
	
	private Icon[] iconSaver;

	@Override
	public int idDropped(int i, Random random, int j)
		{
		return ScienceCraft.IrnTnk.blockID; //TODO: Save liquid
		}
	@Override
	public int quantityDropped(Random random)
		{
		return 1;
		}
	@Override
	public TileEntity createNewTileEntity(World var1)
		{
		return new TileIrnTnk(32);
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
	

    public void registerIcons(IconRegister par1IconRegister)
    	{
    	iconSaver = new Icon[2];

    	iconSaver[0] = par1IconRegister.registerIcon("lazmod:blockIrnTnkTB");
    	iconSaver[1] = par1IconRegister.registerIcon("lazmod:blockIrnTnkSide");
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
	
	
	
	//private boolean localFlag;
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
		{
		return true;
		}
	}
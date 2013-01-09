package lazmod;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;

public class BlockIrnTnk extends Block //TODO: Actual tank
	{
	public BlockIrnTnk(int i, int j)
		{
		super(i, j, Material.glass); //TODO: Material
		}

	@Override
	public int idDropped(int i, Random random, int j)
		{
		return AnnihilationCraft.IrnTnk.blockID;
		}
	@Override
	public int quantityDropped(Random random)
		{
		return 1;
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
	
	@Override
    public String getTextureFile()
    	{
    	return ACProxy.BLOCKS1_PNG;
    	}
	@Override
	public int getBlockTextureFromSideAndMetadata(int i, int j)
		{
		return getBlockTextureFromSide(i);
		}
	@Override
	public int getBlockTextureFromSide(int i)
		{
		if (i == 0)
			{
			return 17;
			}
		if (i == 1)
			{
			return 17;
			}
		else
			{
			return 16;
			}
		}

	}
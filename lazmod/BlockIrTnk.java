package lazmod;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;

public class BlockIrTnk extends Block
	{
	public BlockIrTnk(int i, int j)
		{
		super(i, j, Material.glass); //TODO: Material
		this.setCreativeTab(CreativeTabs.tabBlock);
		}
	@Override
	public int idDropped(int i, Random random, int j)
		{
		return 0;
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
	public int getRenderBlockPass()
		{
		return 1;
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
			return mod_forcefield.texTop;
			}
		if (i == 1)
			{
			return mod_forcefield.texTop;
			}
		else
			{
			return mod_forcefield.texSides;
			}
		}
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
		{
		int i1 = iblockaccess.getBlockId(i, j, k);
		if(!localFlag && i1 == blockID)
			{
			return false;
			} else
			{
			return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
			}
        }

	private boolean localFlag;

	}
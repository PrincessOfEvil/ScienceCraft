package net.minecraft.src;

import java.util.Random;

public class BlockIrTnk extends Block
	{
	public BlockIrTnk(int i, int j)
		{
		super(i, j, Material.glass);
                                this.setCreativeTab(CreativeTabs.tabBlock);
		}
	public int idDropped(int i, Random random, int j)
		{
		return mod_forcefield.irtnk.blockID;
		}
	public int quantityDropped(Random random)
		{
		return 1;
		}
		
	public boolean isOpaqueCube()
		{
		return false;
		}
	public boolean renderAsNormalBlock()
		{
		return false;
		}
	public int getRenderBlockPass()
		{
		return 1;
		}
	public int getBlockTextureFromSideAndMetadata(int i, int j)
		{
		return getBlockTextureFromSide(i);
		}
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
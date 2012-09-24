package net.minecraft.src;

import java.util.Random;

public class BlockFfield extends Block
	{
	public BlockFfield(int i, int j)
		{
		super(i, j, Material.glass);
                                this.setCreativeTab(CreativeTabs.tabBlock);
		}
	public int idDropped(int i, Random random, int j)
		{
		return mod_forcefield.ffield.blockID;
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
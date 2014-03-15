package lazmod.blocks;

import lazmod.blocks.tileentities.TileWtrSrc;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockWtrSrc extends BlockContainer
	{

	private IIcon[]	iconSaver;

	public BlockWtrSrc()
		{
		super(Material.iron);
		setHarvestLevel("pickaxe", 2);
		}

	@Override
	public TileEntity createNewTileEntity(World world, int i)
		{
		return new TileWtrSrc();
		}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
		{
		iconSaver = new IIcon[2];

		iconSaver[0] = par1IconRegister.registerIcon("lazmod:blockWtrSrcTB");
		iconSaver[1] = par1IconRegister.registerIcon("lazmod:blockWtrSrcSide");
		}

	@Override
	public IIcon getIcon(int blockSide, int metadata)
		{
		if (blockSide == 0) { return iconSaver[0]; }
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

package mods.lazmod;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Crystal extends BlockContainer
	{
	public String Type;
	
	public Crystal(int Int, String string)
		{
		super(Int, Material.glass);
		Type = string;
		}
	
	@Override
	public boolean canDragonDestroy(World world, int x, int y, int z)
		{
		return false;
		}
	
	@Override
    public int getMobilityFlag()
		{
    	return 2;
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
	public int getRenderType()
		{
		return -1;
		}
	
	@Override
	public boolean hasTileEntity()
		{
		return true;
		}
	@Override
	public TileEntity createNewTileEntity(World world)
		{
		return new TileCrystal(Type);
		}
	}

package lazmod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFField extends Block
	{
	public BlockFField(int i)
		{
		super(i, Material.glass); //TODO: Material
        this.slipperiness = 1.1F; //Enough to not slow down
        this.blockParticleGravity = 0.0F;
        this.setLightOpacity(1);
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
	public int idDropped(int i, Random random, int j)
		{
		return 0;
		}
	@Override
	public int quantityDropped(Random random)
		{
		return 0;
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
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
		{
		return true;
		}
	
	@Override
	public void registerIcons(IconRegister IconRegister)
		{
		this.blockIcon = IconRegister.registerIcon("lazmod:blockFField");
		}

	}
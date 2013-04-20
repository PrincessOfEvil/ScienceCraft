package mods.lazmod;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;

public class BlockFField extends Block
	{
	public BlockFField(int i)
		{
		super(i, Material.glass); //TODO: Material
        this.slipperiness = 1F;
        this.blockParticleGravity = 0.0F;
        this.setLightOpacity(1);
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
		return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
		}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
		{
		this.blockIcon = par1IconRegister.registerIcon("lazmod:blockFField");
		}

	}
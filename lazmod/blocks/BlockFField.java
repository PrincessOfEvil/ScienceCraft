package lazmod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.IBlockAccess;

public class BlockFField extends Block
	{
	public BlockFField()
		{
		super(Material.glass); // TODO: Material
		slipperiness = 1.1F; // Enough to not slow down
		blockParticleGravity = 0.0F;
		setLightOpacity(1);
		}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
		{
		if (entity instanceof EntityDragon) { return false; }
		return true;
		}
	
	@Override
	public int getMobilityFlag()
		{
		return 2;
		}
	
	@Override
	public int getRenderBlockPass()
		{
		return 1;
		}
	
	@Override
	public boolean isOpaqueCube()
		{
		return false;
		}
	
	@Override
	public int quantityDropped(Random random)
		{
		return 0;
		}
	
	@Override
	public void registerBlockIcons(IIconRegister IconRegister)
		{
		blockIcon = IconRegister.registerIcon("lazmod:blockFField");
		}
	
	@Override
	public boolean renderAsNormalBlock()
		{
		return false;
		}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
		{
		return true;
		}
	
	}
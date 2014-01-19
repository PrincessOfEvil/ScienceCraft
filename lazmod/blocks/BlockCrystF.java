package lazmod.blocks;

import java.util.Random;

import lazmod.ScienceCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCrystF extends Block
	{
	private Icon[] iconSaver;
	public BlockCrystF(int par1)
		{
		super(par1, Material.rock);
		}
	
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
		{
		if (!par1World.isRemote)
			{
			if (par5EntityPlayer.getHeldItem() != null)
				{
				if (par5EntityPlayer.getHeldItem().getItem() == Item.coal || par5EntityPlayer.getHeldItem().getItem() ==  Item.diamond)
					{
					Random rnd = new Random();
					par5EntityPlayer.getHeldItem().splitStack(1);
					switch (rnd.nextInt(2))
						{
						case 0: par1World.spawnEntityInWorld(new EntityItem(par1World, x+0.5, y+1, z+0.5, new ItemStack(ScienceCraft.Derivium))); break;
						case 1: par1World.spawnEntityInWorld(new EntityItem(par1World, x+0.5, y+1, z+0.5, new ItemStack(ScienceCraft.Emmitium))); break;
						}
					
					return true;
					}
				}
			}
		return false;
		}
	@Override
    public void registerIcons(IconRegister par1IconRegister)
    	{
    	iconSaver = new Icon[2];
    	
    	iconSaver[0] = par1IconRegister.registerIcon("lazmod:blockCFTop");
    	iconSaver[1] = par1IconRegister.registerIcon("furnace_top");
    	}
	@Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int blockSide)
		{
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

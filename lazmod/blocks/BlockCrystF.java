package lazmod.blocks;

import java.util.Random;

import lazmod.ScienceCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCrystF extends Block
	{
	private IIcon[]	iconSaver;
	
	public BlockCrystF()
		{
		super(Material.rock);
		setHarvestLevel("pickaxe", 1);
		}
	
	@Override
	public IIcon getIcon(int blockSide, int metadata)
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
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
		{
		if (!par1World.isRemote)
			{
			if (par5EntityPlayer.getHeldItem() != null)
				{
				if (par5EntityPlayer.getHeldItem().getItem() == Items.coal || par5EntityPlayer.getHeldItem().getItem() == Items.diamond)
					{
					Random rnd = new Random();
					par5EntityPlayer.getHeldItem().splitStack(1);
					switch (rnd.nextInt(2))
						{
						case 0:
							EntityItem ed = new EntityItem(par1World, x + 0.5, y + 1, z + 0.5, new ItemStack(ScienceCraft.Derivium));
							ed.addVelocity(0, 2, 0);
							par1World.spawnEntityInWorld(ed);
							break;
						case 1:
							EntityItem ee = new EntityItem(par1World, x + 0.5, y + 1, z + 0.5, new ItemStack(ScienceCraft.Emmitium));
							ee.addVelocity(0, 2, 0);
							par1World.spawnEntityInWorld(ee);
							break;
						}
					
					return true;
					}
				}
			}
		return false;
		}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
		{
		iconSaver = new IIcon[2];
		
		iconSaver[0] = par1IconRegister.registerIcon("lazmod:blockCFTop");
		iconSaver[1] = par1IconRegister.registerIcon("furnace_top");
		}
	}

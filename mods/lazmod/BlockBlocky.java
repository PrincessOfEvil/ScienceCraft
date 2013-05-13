package mods.lazmod;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlocky extends BlockContainer // TODO: TE, multiblock. It'll be Solar-powered Furnace right now.
	{
	public BlockBlocky(int par1) 
		{
		super(par1, Material.iron);
		}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int unknown, CreativeTabs tab, List subItems)
		{
		for (int ix = 0; ix < 1; ix++)
			{
			subItems.add(new ItemStack(this, 1, ix));
			}
		}
	
	@Override
	public TileEntity createNewTileEntity(World var1)
		{
		return new TileBlockyBlock(0);
		}
	
	@Override
	public int damageDropped (int metadata) 
		{
		return metadata;
		}
	
	private Icon[] iconSaver;
	
    public void registerIcons(IconRegister par1IconRegister)
		{
    	iconSaver = new Icon[3];

    	iconSaver[0] = par1IconRegister.registerIcon("lazmod:block"+"TB");
		iconSaver[1] = par1IconRegister.registerIcon("lazmod:block"+"Face");
		iconSaver[2] = par1IconRegister.registerIcon("lazmod:block"+"Side");
		}
    @Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int blockSide)
		{
    	if (blockSide == 0)
    		{
    		return iconSaver[0];
    		}
    	if (blockSide == 1)
			{
    		return iconSaver[0];
			}
    	if (blockSide == 2)
			{
    		return iconSaver[1];
			}
    	else
			{
    		return iconSaver[2];
			}
		}
	public Icon getIcon(int blockSide, int metadata)
		{
    	if (blockSide == 0)
    		{
    		return iconSaver[0];
    		}
    	if (blockSide == 1)
			{
    		return iconSaver[0];
			}
    	if (blockSide == 2)
			{
    		return iconSaver[1];
			}
    	else
			{
    		return iconSaver[2];
			}
		}
	}

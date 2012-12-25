package lazmod;

import static cpw.mods.fml.relauncher.Side.CLIENT;

import java.util.Random;

import cpw.mods.fml.client.TextureFXManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.src.ModLoader;
import net.minecraft.world.IBlockAccess;

public class BlockFfield extends Block
	{
	public BlockFfield(int i, int j)
		{
		super(i, j, Material.glass); //TODO: Material
		this.setCreativeTab(CreativeTabs.tabBlock);
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
	private boolean localFlag;
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
		{
		int i1 = iblockaccess.getBlockId(i, j, k);
		if(!localFlag && i1 == blockID)
			{
			return false;
			}
		else
			{
			return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
			}
        }
	
	@Override
    public String getTextureFile()
    {
            return lazProxy.BLOCKS1_PNG;
    }
	@Override
	public int getBlockTextureFromSide(int i)
		{
		return 0;
		}
    @SideOnly(Side.CLIENT)
    public void registerAnimation(Minecraft minecraft) {
    	ModLoader.addAnimation(new TextureFfieldFX());
    } 
	}
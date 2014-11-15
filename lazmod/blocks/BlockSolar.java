package lazmod.blocks;

import lazmod.DataHandler;
import lazmod.blocks.tileentities.TileSolar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
* For the brave souls who get this far: You are the chosen ones,
* the valiant knights of programming who toil away, without rest,
* fixing our most awful code. To you, true saviors, kings of men,
* I say this: never gonna give you up, never gonna let you down,
* never gonna run around and desert you. Never gonna make you cry,
* never gonna say goodbye. Never gonna tell a lie and hurt you.
* 
* Yep, this code is awful. Deal with it or make PRs.
*/

public class BlockSolar extends BlockContainer
	{
	public final byte	type;
	private IIcon		face;
	private IIcon		sides[];
	
	public BlockSolar(int i)
		{
		super(Material.rock);
		type = (byte) i;
		face = DataHandler.SolarFaceIcons[i];
		sides = DataHandler.SolarOtherIcons;
		this.setBlockBounds(0.125f, 0.125f, 0.125f, 0.875f, 0.875f, 0.875f);
		}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
		{
		return new TileSolar(type);
		}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack)
		{
		super.onBlockPlacedBy(world, x, y, z, entityLiving, itemStack);
		}
	
	@Override
	public void registerBlockIcons(IIconRegister IconRegister)
		{
		face = IconRegister.registerIcon("lazmod:blockSolar" + DataHandler.SolarNames[type] + "Face");
		sides[0] = IconRegister.registerIcon("lazmod:blockSolarTop");
		sides[1] = IconRegister.registerIcon("lazmod:blockSolarBottom");
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
	public IIcon getIcon(int blockSide, int metadata)
		{
		IIcon temp = null;
		final int meta = metadata;
		switch (blockSide)
			{
			case 0: case 1:
				temp = sides[blockSide];
				break;
			default:
				temp = face;
				break;
			}
		return temp;
		}
	}

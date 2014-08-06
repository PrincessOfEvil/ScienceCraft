package lazmod.blocks;

import lazmod.DataHandler;
import lazmod.blocks.tileentities.CESTileEntity;
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
		}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
		{
		return new TileSolar(type);
		}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack)
		{
		if (!world.isRemote)
			{
			((CESTileEntity) world.getTileEntity(x, y, z)).tileRegister(((EntityPlayer) entityLiving));
			}
		super.onBlockPlacedBy(world, x, y, z, entityLiving, itemStack);
		}
	
	@Override
	public void registerBlockIcons(IIconRegister IconRegister)
		{
		face = IconRegister.registerIcon("lazmod:blockSolar" + DataHandler.SolarNames[type] + "Face");
		sides[0] = IconRegister.registerIcon("lazmod:blockSolarTop");
		sides[1] = IconRegister.registerIcon("lazmod:blockSolarBottom");
		sides[2] = IconRegister.registerIcon("lazmod:blockSolarSide");
		}
	
	@Override
	public IIcon getIcon(int blockSide, int metadata)
		{
		IIcon temp = null;
		final int meta = metadata;
		switch (blockSide)
			{
			case 0:
			case 1:
				temp = sides[blockSide];
				break;
			default:
				if (blockSide == metadata+2)
					{
					temp = face;
					}
				else
					{
					temp = sides[2];
					}
				break;
			}
		return temp;
		}
	}

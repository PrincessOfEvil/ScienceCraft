package lazmod.crystal;

import lazmod.blocks.tileentities.CESTileEntity;
import lazmod.blocks.tileentities.TileIrnTnk;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Crystal extends BlockContainer
	{
	public String			type;
	private IIcon			icon;
	
	public Crystal(String Type)
		{
		super(Material.glass);
		type = Type;
		minX = 0.25;
		minY = 0.0;
		minZ = 0.25;
		maxX = 0.75;
		maxY = 0.5;
		maxZ = 0.75;
		}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
		{
		return false;
		}
	
	@Override
	public TileEntity createNewTileEntity(World world, int intgr)
		{
		return new TileCrystal(type);
		}
	
	@Override
	public IIcon getIcon(int blockSide, int metadata)
		{
		return icon;
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
	public boolean isOpaqueCube()
		{
		return false;
		}
	
	@Override
	public void onBlockHarvested(World par1World, int x, int y, int z, int meta, EntityPlayer par6EntityPlayer)
		{
		TileCrystal tile = (TileCrystal) par1World.getTileEntity(x, y, z);
		tile.undoCharge();
		
		super.onBlockHarvested(par1World, x, y, z, meta, par6EntityPlayer);
		}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itCEStack)
		{
		EntityPlayer player = (EntityPlayer) entityliving;
		CESTileEntity tile = (CESTileEntity) world.getTileEntity(x, y, z);
		tile.tileRegister(player);
		super.onBlockPlacedBy(world, x, y, z, entityliving, itCEStack);
		}
	
	@Override
	public void registerBlockIcons(IIconRegister IconRegister)
		{
		icon = IconRegister.registerIcon("lazmod:crystal" + type);
		}
	
	@Override
	public boolean renderAsNormalBlock()
		{
		return false;
		}
	}

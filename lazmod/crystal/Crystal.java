package lazmod.crystal;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Crystal extends BlockContainer
	{
	public String type;
	public float size = 2;
	public Double sieT;
	public TileCrystal tile;
	private EntityPlayer player; 
	
	public Crystal(int Int, String Type)
		{
		super(Int, Material.glass);
		type = Type;
		sieT = 0.5 - (size / 8);
		minX = sieT.doubleValue();
		sieT= 0.0;
		minY = sieT.doubleValue();
		sieT=  0.5 - (size / 8) ;
		minZ = sieT.doubleValue();
		sieT= 0.5 + (size / 8);
		maxX = sieT.doubleValue();
		sieT= (double) (size / 4);
		maxY = sieT.doubleValue();
		sieT= 0.5 + (size / 8);
		maxZ = sieT.doubleValue();
		}
	
	@Override
	public boolean canDragonDestroy(World world, int x, int y, int z)
		{
		return false;
		}
	
	@Override
	public void getSubBlocks(int unknown, CreativeTabs tab, List subItems)
	{
	for (int sz = 1; sz < 5; sz++)
		{
		NBTTagCompound data = new NBTTagCompound();
		data.setInteger("Size", sz);
		ItemStack stack = new ItemStack(this, 1);
		stack.setTagCompound(data);
		subItems.add(stack);
		}
	}
	
	@Override
    public int getMobilityFlag()
		{
    	return 2;
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
	public TileEntity createNewTileEntity(World world)
		{
		return tile = new TileCrystal((int) size,type);
		}
	
	@Override
	public void registerIcons(IconRegister IconRegister)
		{
		this.blockIcon = IconRegister.registerIcon("lazmod:crystal"+type);
		}
	
	@Override
    public void onBlockHarvested(World par1World, int x, int y, int z, int meta, EntityPlayer par6EntityPlayer) 
		{
		tile = (TileCrystal) par1World.getBlockTileEntity(x, y, z);
        tile.undoCharge();
        
        super.onBlockHarvested(par1World, x, y, z, meta, par6EntityPlayer);
		}
	
	@Override
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int x, int y, int z, int st)
		{
		ItemStack itemstack = this.createStackedBlock(st);
		if (itemstack != null)
			{            
			NBTTagCompound data = new NBTTagCompound();
        
			data.setInteger("Size", (int) size);
			
	    	itemstack.setTagCompound(data);
    	
	    	par2EntityPlayer.addStat(StatList.mineBlockStatArray[this.blockID], 1);
	    	par2EntityPlayer.addExhaustion(0.025F);
        
	    	this.dropBlockAsItem_do(par1World, x, y, z, itemstack);
			}
        }
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemstack)
		{
		player = (EntityPlayer) entityliving;
		tile.tileRegister(player.username);
		
		if (itemstack.stackTagCompound != null)
			{
			NBTTagCompound data = itemstack.stackTagCompound;
        
			size = data.getInteger("Size");
			}
		else
			{
			size = 2;
			}
		super.onBlockPlacedBy(world, x, y, z, entityliving, itemstack);
		}
    } 


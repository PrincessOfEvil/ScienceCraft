package lazmod.crystal;

import lazmod.blocks.tileentities.TileIrnTnk;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class Crystal extends BlockContainer
	{
	public String type;
	public float size;
	public Double sieT;
	public TileCrystal TE; 
	
	public Crystal(int Int, String Type)
		{
		super(Int, Material.glass);
		type = Type;
		size = 2;
		sieT = 0.5 - (size / 16);
		minX = sieT.doubleValue();
		sieT= 0.0;
		minY = sieT.doubleValue();
		sieT=  0.5 - (size / 16) ;
		minZ = sieT.doubleValue();
		sieT= 0.5 + (size / 16);
		maxX = sieT.doubleValue();
		sieT= (double) (size / 8);
		maxY = sieT.doubleValue();
		sieT= 0.5 + (size / 16);
		maxZ = sieT.doubleValue();
		}
	
	@Override
	public boolean canDragonDestroy(World world, int x, int y, int z)
		{
		return false;
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
		return TE = new TileCrystal((int) size,type);
		}
	
	@Override
	public void registerIcons(IconRegister IconRegister)
		{
		this.blockIcon = IconRegister.registerIcon("lazmod:crystal"+type);
		}
	
	@Override
    public void onBlockHarvested(World par1World, int x, int y, int z, int meta, EntityPlayer par6EntityPlayer) 
		{
		TE = (TileCrystal) par1World.getBlockTileEntity(x, y, z);
		
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
		super.onBlockPlacedBy(world, x, y, z, entityliving, itemstack);
		
		if (itemstack.stackTagCompound != null)
			{
			NBTTagCompound data = itemstack.stackTagCompound;
        
			size = data.getInteger("Size");
			}
		else
			{
			size = 2;
			}
		}
    } 


package lazmod.blocks;

import java.util.Random;

import lazmod.ScienceCraft;
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
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class BlockIrnTnk extends BlockContainer //TODO: Actual tank
	{
	public TileIrnTnk tile;
	
	public BlockIrnTnk(int i)
		{
		super(i, Material.iron); //TODO: Material... Maybe.
		}
	
	private Icon[] iconSaver;

	@Override
	public int idDropped(int i, Random random, int j)
		{
		return ScienceCraft.IrnTnk.blockID; //TODO: Save liquid
		}
	@Override
	public int quantityDropped(Random random)
		{
		return 1;
		}
	@Override
	public TileEntity createNewTileEntity(World var1)
		{
		return tile = new TileIrnTnk(32);
		}
	
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
		{
        FluidTank tank = tile.tank;
		
		if (tank.getFluid() != null)
			{
			int amount = tank.getFluidAmount();
			
			par5EntityPlayer.addChatMessage("-------");
			par5EntityPlayer.addChatMessage("Fluid = " + tank.getFluid().getFluid().getName());
			switch ((int)(amount/8000f))
				{
				case 0: par5EntityPlayer.addChatMessage("§9Fluid amount = " + ((Integer)amount).toString());
				break;
				case 1: par5EntityPlayer.addChatMessage("§aFluid amount = " + ((Integer)amount).toString());
				break;
				case 2: par5EntityPlayer.addChatMessage("§eFluid amount = " + ((Integer)amount).toString());
				break;
				case 3: par5EntityPlayer.addChatMessage("§6Fluid amount = " + ((Integer)amount).toString());
				break;
				case 4: par5EntityPlayer.addChatMessage("§cFluid amount = " + ((Integer)amount).toString());
				break;
				default:
				break;
				}
			par5EntityPlayer.addChatMessage("-------");
			}
		return true;
		}
	
	@Override
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int x, int y, int z, int st)
    	{
        ItemStack itemstack = this.createStackedBlock(st);
        if (itemstack != null)
            {            
            NBTTagCompound data = new NBTTagCompound();
            
            data.setInteger("Capacity", tile.tank.getCapacity());
            
        	if (tile.tank.getFluid() != null)
        		{
        		tile.tank.getFluid().writeToNBT(data);
        		}
            else
            	{
            	data.setString("Empty", "");
            	}
        	
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
        
			tile.tank.setCapacity(data.getInteger("Capacity"));
        	
			if (!data.hasKey("Empty"))
				{
				FluidStack fluid = FluidStack.loadFluidStackFromNBT(data);

				if (fluid != null)
					{
					tile.tank.setFluid(fluid);
					}
				}
			}
		}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister)
    	{
    	iconSaver = new Icon[2];
    	
    	iconSaver[0] = par1IconRegister.registerIcon("lazmod:blockIrnTnkTB");
    	iconSaver[1] = par1IconRegister.registerIcon("lazmod:blockIrnTnkSide");
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
		else
			{
			return iconSaver[1];
			}
		} 
	@Override
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
		else
			{
			return iconSaver[1];
			}
		}
	}
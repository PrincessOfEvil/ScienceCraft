package lazmod.blocks;

import java.util.Random;

import lazmod.DataHandler;
import lazmod.ScienceCraft;
import lazmod.blocks.tileentities.TileIrnTnk;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class BlockIrnTnk extends BlockContainer
	{
	private IIcon[]	icons;
	
	public BlockIrnTnk()
		{
		super(Material.iron);
		setHarvestLevel("pickaxe", 2);
		}
	
	@Override
	public int quantityDropped(Random random)
		{
		return 0;
		}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int i)
		{
		return new TileIrnTnk(DataHandler.IrnTnkDfltCapacity);
		}
	
	@Override
	public IIcon getIcon(int blockSide, int metadata)
		{
		if (blockSide == 0 || blockSide == 1)
			{
			return icons[0];
			}
		else
			{
			return icons[1];
			}
		}
	
	// Stolen from BC.
	private static ItemStack consumeItem(ItemStack stack)
		{
		if (stack.stackSize == 1)
			{
			if (stack.getItem().hasContainerItem(stack))
				{
				return stack.getItem().getContainerItem(stack);
				}
			else
				{
				return null;
				}
			}
		else
			{
			stack.splitStack(1);

			return stack;
			}
		}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9)
		{
		TileIrnTnk tile = (TileIrnTnk) world.getTileEntity(x, y, z);
		ItemStack current = entityPlayer.inventory.getCurrentItem();
		
		boolean truå = false;
		
		if (current != null)
			{
			if (current.isItemEqual(new ItemStack(ScienceCraft.CraftingItem, 1, 2)))
				{
				tile.tank.setCapacity(tile.tank.getCapacity() + DataHandler.IrnTnkDfltCapacity);
				if (!entityPlayer.capabilities.isCreativeMode)
					{
					entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, consumeItem(current));
					}
				truå = true;
				}
			else
				{
				FluidStack liquid = FluidContainerRegistry.getFluidForFilledItem(current);
				if (liquid != null)
					{
					int qty = tile.fill(ForgeDirection.UNKNOWN, liquid, true);

					if (qty != 0 && !entityPlayer.capabilities.isCreativeMode)
						{
						entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, consumeItem(current));
						}
					truå = true;
					}
				}
			}
		
		FluidTank tank = tile.tank;
		
		if (tank.getFluid() != null && !world.isRemote)
			{
			int amount = tank.getFluidAmount();
			
			String f = "";
			
			switch ((int) (amount / tank.getCapacity() / 4))
				{
				case 0:
					f = "§9";
					break;
				case 1:
					f = "§a";
					break;
				case 2:
					f = "§e";
					break;
				case 3:
					f = "§6";
					break;
				case 4:
					f = "§c";
					break;
				default:
					break;
				}
			entityPlayer.addChatMessage(new ChatComponentText(f + tank.getFluid().getFluid().getName() + " : " + ((Integer) amount).toString() + "/" + ((Integer) tank.getCapacity()).toString()));
			truå = true;
			}
		return truå;
		}
	
	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer entityPlayer)
		{
		if (!world.isRemote)
			{
			ItemStack itCEStack = createStackedBlock(meta);
			if (itCEStack != null)
				{
				TileIrnTnk tile = (TileIrnTnk) world.getTileEntity(x, y, z);
				
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
				
				itCEStack.setTagCompound(data);
				
				itCEStack.setItemDamage(DataHandler.IrnTnkDfltCapacity - tile.tank.getFluidAmount()*DataHandler.IrnTnkDfltCapacity/tile.tank.getCapacity());
				
				entityPlayer.addStat(StatList.mineBlockStatArray[getIdFromBlock(this)], 1);
				entityPlayer.addExhaustion(0.025F);
				
				this.dropBlockAsItem(world, x, y, z, itCEStack);
				}
			super.onBlockHarvested(world, x, y, z, meta, entityPlayer);
			}
		}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itCEStack)
		{
		super.onBlockPlacedBy(world, x, y, z, entityliving, itCEStack);
		
		if (itCEStack.stackTagCompound != null)
			{
			TileIrnTnk tile = (TileIrnTnk) world.getTileEntity(x, y, z);
			
			NBTTagCompound data = itCEStack.stackTagCompound;
			
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
	public void registerBlockIcons(IIconRegister IconRegister)
		{
		icons = new IIcon[2];
		
		icons[0] = IconRegister.registerIcon("lazmod:blockIrnTnkTB");
		icons[1] = IconRegister.registerIcon("lazmod:blockIrnTnkSide");
		}
	}
package lazmod.blocks;

import java.util.Random;

import buildcraft.BuildCraftCore;
import buildcraft.core.inventory.InvUtils;
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
		return new TileIrnTnk(32);
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
			if (stack.getItem().hasContainerItem())
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
		if (!world.isRemote)
			{
			TileIrnTnk tile = (TileIrnTnk) world.getTileEntity(x, y, z);
			ItemStack current = entityPlayer.inventory.getCurrentItem();
			
			if (current != null)
				{
				FluidStack liquid = FluidContainerRegistry.getFluidForFilledItem(current);
				if (liquid != null)
					{
					int qty = tile.fill(ForgeDirection.UNKNOWN, liquid, true);

					if (qty != 0 && !entityPlayer.capabilities.isCreativeMode)
						{
						entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, consumeItem(current));
						}
					}
				}
			
			FluidTank tank = tile.tank;
			
			if (tank.getFluid() != null)
				{
				int amount = tank.getFluidAmount();
				
				entityPlayer.addChatMessage(new ChatComponentText("-------"));
				entityPlayer.addChatMessage(new ChatComponentText("Fluid = " + tank.getFluid().getFluid().getName()));
				switch ((int) (amount / 8000f))
					{
					case 0:
						entityPlayer.addChatMessage(new ChatComponentText("§9Fluid amount = " + ((Integer) amount).toString()));
						break;
					case 1:
						entityPlayer.addChatMessage(new ChatComponentText("§aFluid amount = " + ((Integer) amount).toString()));
						break;
					case 2:
						entityPlayer.addChatMessage(new ChatComponentText("§eFluid amount = " + ((Integer) amount).toString()));
						break;
					case 3:
						entityPlayer.addChatMessage(new ChatComponentText("§6Fluid amount = " + ((Integer) amount).toString()));
						break;
					case 4:
						entityPlayer.addChatMessage(new ChatComponentText("§cFluid amount = " + ((Integer) amount).toString()));
						break;
					default:
						break;
					}
				entityPlayer.addChatMessage(new ChatComponentText("-------"));
				return true;
				}
			}
		return false;
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
				
				itCEStack.setItemDamage(32000 - tile.tank.getFluidAmount());
				
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
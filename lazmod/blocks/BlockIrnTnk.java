package lazmod.blocks;

import java.util.Random;

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
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class BlockIrnTnk extends BlockContainer
	{
	public TileIrnTnk	tile;
	private IIcon[]		iconSaver;

	public BlockIrnTnk()
		{
		super(Material.iron);
		setHarvestLevel("pickaxe", 2);
		}

	@Override
	public int quantityDropped(Random random)
		{
		return 1;
		}

	@Override
	public TileEntity createNewTileEntity(World var1, int i)
		{
		return tile = new TileIrnTnk(32);
		}

	@Override
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
		{
		if (!par1World.isRemote)
			{
			tile = (TileIrnTnk) par1World.getTileEntity(x, y, z);
			if (tile == null)
				{
				System.out.println("BIT:FUUUUUUK");
				}

			FluidTank tank = tile.tank;

			if (tank.getFluid() != null)
				{
				int amount = tank.getFluidAmount();

				par5EntityPlayer.addChatMessage(new ChatComponentText("-------"));
				par5EntityPlayer.addChatMessage(new ChatComponentText("Fluid = " + tank.getFluid().getFluid().getName()));
				switch ((int) (amount / 8000f))
					{
					case 0:
					par5EntityPlayer.addChatMessage(new ChatComponentText("§9Fluid amount = " + ((Integer) amount).toString()));
					break;
					case 1:
					par5EntityPlayer.addChatMessage(new ChatComponentText("§aFluid amount = " + ((Integer) amount).toString()));
					break;
					case 2:
					par5EntityPlayer.addChatMessage(new ChatComponentText("§eFluid amount = " + ((Integer) amount).toString()));
					break;
					case 3:
					par5EntityPlayer.addChatMessage(new ChatComponentText("§6Fluid amount = " + ((Integer) amount).toString()));
					break;
					case 4:
					par5EntityPlayer.addChatMessage(new ChatComponentText("§cFluid amount = " + ((Integer) amount).toString()));
					break;
					default:
					break;
					}
				par5EntityPlayer.addChatMessage(new ChatComponentText("-------"));
				return true;
				}
			}
		return false;
		}

	@Override
	public void onBlockHarvested(World par1World, int x, int y, int z, int meta, EntityPlayer par6EntityPlayer)
		{
		tile = (TileIrnTnk) par1World.getTileEntity(x, y, z);

		super.onBlockHarvested(par1World, x, y, z, meta, par6EntityPlayer);
		}

	@Override
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int x, int y, int z, int st)
		{
		ItemStack itCEStack = createStackedBlock(st);
		if (itCEStack != null)
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

			itCEStack.setTagCompound(data);

			itCEStack.setItemDamage(32000 - tile.tank.getFluidAmount());

			par2EntityPlayer.addStat(StatList.mineBlockStatArray[getIdFromBlock(this)], 1);
			par2EntityPlayer.addExhaustion(0.025F);

			this.dropBlockAsItem(par1World, x, y, z, itCEStack);
			}
		}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itCEStack)
		{
		super.onBlockPlacedBy(world, x, y, z, entityliving, itCEStack);

		if (itCEStack.stackTagCompound != null)
			{
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
		iconSaver = new IIcon[2];
		
		iconSaver[0] = IconRegister.registerIcon("lazmod:blockIrnTnkTB");
		iconSaver[1] = IconRegister.registerIcon("lazmod:blockIrnTnkSide");
		}
	
	@Override
	public IIcon getIcon(int blockSide, int metadata)
		{
		if (blockSide == 0 || blockSide == 1) { return iconSaver[0]; }
		else
			{
			return iconSaver[1];
			}
		}
	}
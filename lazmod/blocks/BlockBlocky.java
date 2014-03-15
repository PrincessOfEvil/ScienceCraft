package lazmod.blocks;

import java.util.List;
import java.util.Random;

import lazmod.DataHandler;
import lazmod.ScienceCraft;
import lazmod.blocks.tileentities.TileBlockyBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockBlocky extends BlockContainer // TODO: TE, multiblock almost
// implemented. It'll be
// Solar-powered Furnace right
// now.
	{
	public BlockBlocky()
		{
		super(Material.rock);
		setHarvestLevel("pickaxe", 1);
		}
	
	public TileBlockyBlock	tile;
	private EntityPlayer	player;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(Item item, CreativeTabs tab, List subItems)
		{
		for (int ix = 0; ix < DataHandler.BlockyBlockTypeAmount; ix++)
			{
			subItems.add(new ItemStack(this, 1, ix));
			}
		}
	
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack)
		{
		player = (EntityPlayer) par5EntityLiving;
		tile.tileRegister(player.getGameProfile().getName());
		super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLiving, par6ItemStack);
		}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
		{
		return tile = new TileBlockyBlock(var2);
		}
	
	@Override
	public int damageDropped(int metadata)
		{
		return metadata;
		}
	
	private IIcon[][]	iconSaver;
	private byte		blockTypeAmount	= DataHandler.BlockyBlockTypeAmount;
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
		{
		iconSaver = new IIcon[blockTypeAmount][4];
		
		for (int tItemId = 0; tItemId < blockTypeAmount; tItemId++)
			{
			iconSaver[tItemId][0] = par1IconRegister.registerIcon("lazmod:block" + ScienceCraft.dataHandler.BlockyBlockTypeName[tItemId] + "Bottom");
			iconSaver[tItemId][1] = par1IconRegister.registerIcon("lazmod:block" + ScienceCraft.dataHandler.BlockyBlockTypeName[tItemId] + "Top");
			iconSaver[tItemId][2] = par1IconRegister.registerIcon("lazmod:block" + ScienceCraft.dataHandler.BlockyBlockTypeName[tItemId] + "Face");
			iconSaver[tItemId][3] = par1IconRegister.registerIcon("lazmod:block" + ScienceCraft.dataHandler.BlockyBlockTypeName[tItemId] + "Side");
			}
		}
	
	@Override
	public IIcon getIcon(int blockSide, int metadata)
		{
		if (blockSide == 0)
			{
			return iconSaver[metadata][0];
			}
		if (blockSide == 1)
			{
			return iconSaver[metadata][1];
			}
		if (blockSide == 3)
			{
			return iconSaver[metadata][2];
			}
		else
			{
			return iconSaver[metadata][3];
			}
		}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6)
		{
		dropItems(world, x, y, z);
		tile.undoCharge();
		super.breakBlock(world, x, y, z, par5, par6);
		}
	
	private void dropItems(World world, int x, int y, int z)
		{
		Random rand = new Random();
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (!(tileEntity instanceof IInventory))
			{
			return;
			}
		IInventory inventory = (IInventory) tileEntity;
		
		for (int i = 0; i < inventory.getSizeInventory(); i++)
			{
			ItemStack item = inventory.getStackInSlot(i);
			
			if (item != null && item.stackSize > 0)
				{
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;
				
				EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
				
				if (item.hasTagCompound())
					{
					entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
					}
				
				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
				}
			}
		}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are)
		{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking())
			{
			return false;
			}
		player.openGui(ScienceCraft.instance, 0, world, x, y, z);
		return true;
		}
	
	}

package lazmod.blocks.containers;

import lazmod.ScienceCraft;
import lazmod.blocks.tileentities.TileBlockyBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerBlockyBlock extends Container
	{
	private int					id;

	protected TileBlockyBlock	tileEntity;

	private int					lastCharge;
	private int					lastBlockMeta;

	public ContainerBlockyBlock(InventoryPlayer inventoryPlayer, TileBlockyBlock te)
		{
		tileEntity = te;

		id = te.blockMeta;

		for (byte ctr = 0; ctr < ScienceCraft.DateHandler.BlockyISamount[id]; ctr++)
			{
			if (ScienceCraft.DateHandler.BlockyDangerSlot[id] == ctr)
				{
				addSlotToContainer(new SlotFurnace(inventoryPlayer.player, te, ctr, ScienceCraft.DateHandler.BlockySlotCoordX[id][ctr], ScienceCraft.DateHandler.BlockySlotCoordY[id][ctr]));
				}
			else
				{
				addSlotToContainer(new Slot(te, ctr, ScienceCraft.DateHandler.BlockySlotCoordX[id][ctr], ScienceCraft.DateHandler.BlockySlotCoordY[id][ctr]));
				}
			}

		bindPlayerInventory(inventoryPlayer);
		}

	@Override
	public boolean canInteractWith(EntityPlayer player)
		{
		return tileEntity.isUseableByPlayer(player);
		}

	@Override
	public void addCraftingToCrafters(ICrafting par1ICrafting)
		{
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, tileEntity.getCharge());
		par1ICrafting.sendProgressBarUpdate(this, 1, tileEntity.blockMeta);
		}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int codifier, int amount)
		{
		if (codifier == 0)
			{
			tileEntity.setCharge(amount);
			}
		if (codifier == 1)
			{
			tileEntity.blockMeta = amount;
			}
		}

	@Override
	public void detectAndSendChanges()
		{
		super.detectAndSendChanges();

		for (int i = 0; i < crafters.size(); ++i)
			{
			ICrafting icrafting = (ICrafting) crafters.get(i);

			if (lastCharge != tileEntity.getCharge())
				{
				icrafting.sendProgressBarUpdate(this, 0, tileEntity.getCharge());
				}

			if (lastBlockMeta != tileEntity.blockMeta)
				{
				icrafting.sendProgressBarUpdate(this, 1, tileEntity.blockMeta);
				}
			}

		lastCharge = tileEntity.getCharge();
		lastBlockMeta = tileEntity.blockMeta;
		}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
		{
		for (int i = 0; i < 3; i++)
			{
			for (int j = 0; j < 9; j++)
				{
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
				}
			}

		for (int i = 0; i < 9; i++)
			{
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
			}
		}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot)
		{
		return null;
		}

	}

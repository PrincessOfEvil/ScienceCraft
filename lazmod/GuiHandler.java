package lazmod;

import lazmod.blocks.containers.ContainerBlockyBlock;
import lazmod.blocks.tileentities.TileBlockyBlock;
import lazmod.gui.GuiBlockyBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler 
	{
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    	{
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity instanceof TileBlockyBlock)
        	{
            return new ContainerBlockyBlock(player.inventory, (TileBlockyBlock) tileEntity);
            }
        return null;
    	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
		{
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity instanceof TileBlockyBlock)
        	{
        	return new GuiBlockyBlock(player.inventory, (TileBlockyBlock) tileEntity);
        	}
        return null;
		}
	}

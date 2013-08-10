package lazmod;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.TileFluidHandler;

public class TankTest extends BlockContainer
	{
	public TankTest(int par1)
		{
		super(par1, Material.glass);
		}

	@Override
	public TileEntity createNewTileEntity(World world)
		{
		return new TileFluidHandler();
		}

    public void registerIcons(IconRegister par1IconRegister)
    	{
    	blockIcon = par1IconRegister.registerIcon("lazmod:blockIrnTnkTB");
    	}
	}

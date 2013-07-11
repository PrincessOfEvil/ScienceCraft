package lazmod.crystal;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileCrystalRenderer extends TileEntitySpecialRenderer
	{
    private ModelCrystal modelCrystal; 
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
    	{
    	if(tileEntity instanceof TileCrystal)
    		{
    		TileCrystal tileCrystal = (TileCrystal)tileEntity;
    		modelCrystal = new ModelCrystal(tileCrystal.Type);
    		modelCrystal.render(tileCrystal, x, y, z);
    		}
	    }
	}

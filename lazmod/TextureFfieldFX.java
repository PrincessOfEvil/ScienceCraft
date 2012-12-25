package lazmod;

import java.io.IOException;

import javax.imageio.ImageIO;

import cpw.mods.fml.client.FMLTextureFX;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TextureFfieldFX extends FMLTextureFX
	{
	public TextureFfieldFX()
		{
        super(annihilationcraft.ffield.blockIndexInTexture);
		setup();
		}
    
	int tickCounter = 0;
    @Override
    public void setup()
    {
        super.setup();
        tickCounter = 0;
    }
    public void onTick()
    	{
        ++this.tickCounter;
        if (tickCounter > 15)
        	{
        	tickCounter = 0;
        	}
    	}
	}

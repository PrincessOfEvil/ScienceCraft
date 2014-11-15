package lazmod.crystal;

import net.minecraft.tileentity.TileEntity;

public class TileCrystal extends TileEntity
	{
	public String	type;
	public int		size;
	
	public TileCrystal()
		{}
	
	public TileCrystal(String cType)
		{
		type = cType;
		}
	}
package lazmod.crystal;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileCrystal extends TileEntity
	{
	public String type;
	public int size;
	
	public TileCrystal(){}
	
	public TileCrystal(int Size,String Type)
		{
		size = Size;
		type = Type;
		}
	
	@Override
	public void readFromNBT(NBTTagCompound data)
		{
		super.readFromNBT(data);
		size = data.getInteger("Size");
		type = data.getString("Type");
		}

	@Override
	public void writeToNBT(NBTTagCompound data)
		{
		super.writeToNBT(data);
		data.setInteger("Size", size);
		data.setString("Type", type);
		}
	}
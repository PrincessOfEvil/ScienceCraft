package lazmod.multipart;

import lazmod.ScienceCraft;
import net.minecraft.block.Block;
import codechicken.lib.vec.Cuboid6;
import codechicken.multipart.minecraft.McMetaPart;

public class SolarController extends McMetaPart
	{
	
	public SolarController() {System.out.println(this);}
	
	@Override
	public Cuboid6 getBounds()
		{
		return new Cuboid6(0.125f, 0.125f, 0.125f, 0.875f, 0.875f, 0.875f);
		}
	
	@Override
	public Block getBlock()
		{
		return ScienceCraft.SolarFurnace;
		}
	
	@Override
	public String getType()
		{
		return "SC:SolarController";
		}
	
	}
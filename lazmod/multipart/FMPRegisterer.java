package lazmod.multipart;

import java.util.Arrays;

import lazmod.ScienceCraft;
import lazmod.blocks.BlockSolar;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import codechicken.lib.vec.BlockCoord;
import codechicken.multipart.MultiPartRegistry.IPartConverter;
import codechicken.multipart.MultiPartRegistry.IPartFactory;
import codechicken.multipart.minecraft.TorchPart;
import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.TMultiPart;

public class FMPRegisterer implements IPartFactory, IPartConverter
	{

	@Override
	public TMultiPart createPart(String name, boolean client)
		{
		if(name.equals("SC:SolarController")) return new SolarController();
		return null;
		}

    public void init()
    	{
        MultiPartRegistry.registerConverter(this);
        MultiPartRegistry.registerParts(this, new String[]{
                "SC:SolarController"
            });
    	}
	
	@Override
	public Iterable<Block> blockTypes()
		{
	    return Arrays.asList(ScienceCraft.SolarFurnace);

		}

	@Override
	public TMultiPart convert(World world, BlockCoord pos)
		{
        Block b = world.getBlock(pos.x, pos.y, pos.z);
        int meta = world.getBlockMetadata(pos.x, pos.y, pos.z);
        if (b instanceof BlockSolar)
        	{
            return new SolarController();
        	}
		return null;
		}
	
	}

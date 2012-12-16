package lazmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;

public class mod_forcefield extends BaseMod
	{
	public static Block ffield = new BlockFfield(1240, 0).setBlockUnbreakable().setHardness(6000000F).setLightValue(0.4F).setBlockName("ffield");
	public static Block irtnk = new BlockIrTnk(1241, 0).setBlockUnbreakable().setHardness(6000000F).setBlockName("irtnk");
	public static int texTop=ModLoader.addOverride("/terrain.png", "/lazmod/iron_tank_t.png");
	public static int texSides=ModLoader.addOverride("/terrain.png", "/lazmod/iron_tank_s.png");
	public String getVersion()
        	{
        	return "0.1 alpha";
        	}
	public void load()
		{	
		ModLoader.registerBlock(ffield);
		ModLoader.registerBlock(irtnk);
		ModLoader.addName(ffield, "Force Field");
		ModLoader.addName(irtnk, "Iron Tank");
		ModLoader.addRecipe(new ItemStack(ffield, 64), new Object[]{ "111", "202", "111", Character.valueOf('1'), Block.glass, Character.valueOf('0'), Block.bedrock, Character.valueOf('2'), Item.redstone});	
		ffield.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/lazmod/ffield.png");
		}
	}
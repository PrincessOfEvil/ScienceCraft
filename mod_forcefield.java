package net.minecraft.src;

public class mod_forcefield extends BaseMod
	{
	public static Block ffield = new BlockFfield(1240, 0).setBlockUnbreakable().setHardness(6000000F).setLightValue(0.4F).setBlockName("ffield");
	public static Block irtnk = new BlockIrTnk(1241, 0).setBlockUnbreakable().setHardness(6000000F).setLightValue(0.4F).setBlockName("ffield");
	public String getVersion()
        	{
        	return "0.1 alpha";
        	}
	public void load()
		{	
		ModLoader.registerBlock(ffield);
		ModLoader.addName(ffield, "Force Field");
		ModLoader.addName(irtnk, "Iron Tank");
		ModLoader.addRecipe(new ItemStack(ffield, 64), new Object[]{ "111", "202", "111", Character.valueOf('1'), Block.glass, Character.valueOf('0'), Block.bedrock, Character.valueOf('2'), Item.redstone});	
		ffield.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/lazmod/ffield.png");
		irtnk.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/lazmod/iron_tank.png")
		}
	}
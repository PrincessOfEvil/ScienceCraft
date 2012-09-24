package net.minecraft.src;
public class mod_creggs extends BaseMod
{
public static final Item soulItem = new ItemSoul(3000).setItemName("soulItem");

public String getVersion()
{
  return "0.1 alpha";
}

public void load()
{

ModLoader.addName(soulItem, "Soul in a Bottle");
soulItem.iconIndex = ModLoader.addOverride("/gui/items.png", "/lazmod/soul.png");

ModLoader.addRecipe(new ItemStack(soulItem, 8), new Object[]{ "XXX", "XZX", "XXX",  Character.valueOf('X'), Item.glassBottle, Character.valueOf('Z'), Block.slowSand});
ModLoader.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 55), new Object[]{ Item.slimeBall, Item.slimeBall, soulItem});
ModLoader.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 54), new Object[]{ Item.rottenFlesh, Item.rottenFlesh, soulItem});
ModLoader.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 51), new Object[]{ Item.arrow, Item.arrow, Item.bone, Item.bone, soulItem});
}
}
package tests;

import java.util.Random;

import lazmod.ScienceCraft;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
 
public class RubinOreGenerator implements IWorldGenerator {
 
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId) {
        case -1:
        generateNether();
        break;
        case 0:
        generateSurface(world, random, chunkX*16, chunkZ*16);
        break;
        case 1:
        generateEnd();
        break;
        }
    }
 
    public void generateNether() {
        //were not doing ore ore in the nether
        }
 
        public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
	        {
	        for (int i = 0; i < 10; i++) {
	        int randPosX = chunkX + rand.nextInt(16);
	        int randPosY = rand.nextInt(15);
	        int randPosZ = chunkZ + rand.nextInt(16);
	 
	        (new WorldGenMinable(ScienceCraft.FField, 0, 20, Blocks.stone)).generate(world, rand,
	        randPosX, randPosY, randPosZ);
	        }
        }
 
        public void generateEnd() {
        //were not going to generate in the end either
        }
}
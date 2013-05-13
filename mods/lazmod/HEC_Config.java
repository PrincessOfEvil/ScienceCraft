package mods.lazmod;

import java.io.File;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class HEC_Config
	{
	public Configuration config;
	
	public HEC_Config(FMLPreInitializationEvent event, String file)
		{
        config = new Configuration(new File(event.getModConfigurationDirectory(), file));

        config.load();
		}
	}

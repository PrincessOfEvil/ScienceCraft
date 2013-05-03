package mods.lazmod;

import java.io.File;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.event.Event;

public class HEC_Config
	{
	public Configuration config;
	
	public HEC_Config(FMLPreInitializationEvent event, String file)
		{
        config = new Configuration(new File(event.getModConfigurationDirectory(), file));

        config.load();
		}
	}

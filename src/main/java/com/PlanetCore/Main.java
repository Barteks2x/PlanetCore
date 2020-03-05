package com.PlanetCore;


import com.PlanetCore.init.ModSmelting;
import com.PlanetCore.proxy.CommonProxy;
import com.PlanetCore.util.Reference;
import com.PlanetCore.util.handlers.RegistryHandler;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;



import java.io.File;



@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

	@Instance
	public static Main instance;


	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy proxy;


	
	public static File config;



	static { FluidRegistry.enableUniversalBucket(); }



	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.preInitRegistries(event);
	}
	
	@EventHandler
    public static void init(FMLInitializationEvent event) {
		ModSmelting.init();
		RegistryHandler.initRegistries(event);
    }


	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		RegistryHandler.posInitRegistries(event);
	}
	
	
}
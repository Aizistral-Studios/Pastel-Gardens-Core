package com.aizistral.pastelgardens;

import com.aizistral.pastelgardens.handlers.ClientConfigHandler;
import com.aizistral.pastelgardens.handlers.PGCEventHandler;

import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PastelGardensCore.MODID)
public class PastelGardensCore {
	public static final String MODID = "pastelgardens";

	public PastelGardensCore() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onLoadComplete);

		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new PGCEventHandler());

		ClientConfigHandler.constructConfig();
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigHandler.clientConfig);
	}

	private void onLoadComplete(final FMLLoadCompleteEvent event) {
		// NO-OP
	}

	private void setup(final FMLCommonSetupEvent event) {
		// NO-OP
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		// NO-OP
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {
		// NO-OP
	}

	private void processIMC(final InterModProcessEvent event) {
		// NO-OP
	}

}

package com.imz.favourite_tags.network;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Setup {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(NetworkHandler::registerMessage);
    }
}

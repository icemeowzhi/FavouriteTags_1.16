package com.imz.favourite_tags.tag;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class TagsInitializer {
    private static final Logger LOGGER = LogManager.getLogger();




    @SubscribeEvent
    public static void regTags(final FMLCommonSetupEvent event){
        LOGGER.info("registering tags!");

    }
}

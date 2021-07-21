package com.imz.favourite_tags;

import com.imz.favourite_tags.network.NetworkHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.SimpleMessage;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("favourite_tags")
public class Main
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Main() {
        LOGGER.info("Loading FavouriteTags 1.16...");
        MinecraftForge.EVENT_BUS.register(this);
    }

    /*
    //管理一些组件的注册
    @SubscribeEvent
    public void setup(final FMLCommonSetupEvent event)
    {
        //网络组件注册
        event.enqueueWork(NetworkHandler::registerMessage);
    }

     */

}

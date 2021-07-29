package com.imz.favourite_tags;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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



}

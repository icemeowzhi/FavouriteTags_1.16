package com.imz.favourite_tags;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("favourite_tags")
public class FavouriteTag
{
    public static final String MODID = "favourite_tags";
    private static final Logger LOGGER = LogManager.getLogger();

    public FavouriteTag() {
        LOGGER.info("Loading FavouriteTags 1.16...");
        LOGGER.info("FavouriteTags is still in progress.If you find something wrong, please report bug via Github.");
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ITextComponent translationKey(String... strings){
        StringBuilder translationKeyBuilder = new StringBuilder(MODID);
        for (String str : strings){
            translationKeyBuilder.append(".").append(str);
        }
        return new TranslationTextComponent(translationKeyBuilder.toString());
    }
}

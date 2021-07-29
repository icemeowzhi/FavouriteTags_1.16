package com.imz.favourite_tags.modsupport;

import com.imz.favourite_tags.tag.FoodTagInitializer;
import com.imz.favourite_tags.tag.ITag;
import com.imz.favourite_tags.tag.TagInitializer;
import com.nmmoc7.theelixir.RegistryHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ElixirFoodTagInitializer {

    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event) {

        if (!ModList.get().isLoaded("the_elixir")) {
            return;
        }

        FoodTagInitializer.register(RegistryHandler.MANGO_FOOD,new ITag[]{TagInitializer.fruit});
    }
}

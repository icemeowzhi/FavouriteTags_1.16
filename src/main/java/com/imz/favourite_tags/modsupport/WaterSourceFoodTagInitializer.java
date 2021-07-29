package com.imz.favourite_tags.modsupport;

import com.imz.favourite_tags.tag.FoodTagInitializer;
import com.imz.favourite_tags.tag.ITag;
import com.imz.favourite_tags.tag.TagInitializer;
import gloridifice.watersource.registry.ItemRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WaterSourceFoodTagInitializer {
    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event) {

        if (!ModList.get().isLoaded("watersource")) {
            return;
        }

        FoodTagInitializer.register(ItemRegistry.itemCoconutPiece,new ITag[]{TagInitializer.fruit,TagInitializer.coconut});
        FoodTagInitializer.register(ItemRegistry.itemCoconutChicken,new ITag[]{TagInitializer.chicken,TagInitializer.meat,TagInitializer.coconut});
    }
}

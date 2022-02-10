package com.imz.favourite_tags.modsupport;

import com.imz.favourite_tags.foodtag.FoodTag;
import com.imz.favourite_tags.intance.TagInitializer;
import com.imz.favourite_tags.intance.TaggedFoodInitializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WaterSourceFoodTagInitializer {
    public static final String MODID = "watersource";
    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event) {

        if (!ModList.get().isLoaded(MODID)) {
            return;
        }

        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"coconut_piece")),new FoodTag[]{TagInitializer.fruit,TagInitializer.coconut});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"coconut_chicken")),new FoodTag[]{TagInitializer.chicken,TagInitializer.meat,TagInitializer.coconut});

    }
}

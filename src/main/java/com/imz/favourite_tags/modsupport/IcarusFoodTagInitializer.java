package com.imz.favourite_tags.modsupport;

import com.imz.favourite_tags.tag.FoodTagInitializer;
import com.imz.favourite_tags.tag.ITag;
import com.imz.favourite_tags.tag.TagInitializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IcarusFoodTagInitializer {
    public static final String MODID = "locusazzurro_icaruswings";

    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event) {

        if (!ModList.get().isLoaded(MODID)) {
            return;
        }

        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"mead")), new ITag[]{TagInitializer.wine,TagInitializer.honey,TagInitializer.golden});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"zephir_infused_mead")), new ITag[]{TagInitializer.wine,TagInitializer.honey,TagInitializer.golden});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"nether_infused_mead")), new ITag[]{TagInitializer.wine,TagInitializer.honey,TagInitializer.golden});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"void_infused_mead")), new ITag[]{TagInitializer.wine,TagInitializer.honey,TagInitializer.golden});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"golden_apple_infused_mead")), new ITag[]{TagInitializer.wine,TagInitializer.honey,TagInitializer.golden});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"herbs_infused_mead")), new ITag[]{TagInitializer.wine,TagInitializer.honey,TagInitializer.golden});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"beeswax")), new ITag[]{TagInitializer.honey});


    }
}

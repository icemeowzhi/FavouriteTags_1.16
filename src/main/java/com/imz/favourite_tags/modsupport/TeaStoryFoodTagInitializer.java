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
public class TeaStoryFoodTagInitializer {

    public static final String MODID = "teastory";
    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event) {

        if (!ModList.get().isLoaded(MODID)) {
            return;
        }

        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"dried_beetroot")),new ITag[]{TagInitializer.beet,TagInitializer.vegetable,TagInitializer.dried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"dried_carrot")),new ITag[]{TagInitializer.carrot,TagInitializer.vegetable,TagInitializer.dried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"beef_jerky")),new ITag[]{TagInitializer.beef,TagInitializer.meat,TagInitializer.dried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"pork_jerky")),new ITag[]{TagInitializer.pork,TagInitializer.meat,TagInitializer.dried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"chicken_jerky")),new ITag[]{TagInitializer.chicken,TagInitializer.meat,TagInitializer.dried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"rabbit_jerky")),new ITag[]{TagInitializer.rabbit,TagInitializer.meat,TagInitializer.dried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"mutton_jerky")),new ITag[]{TagInitializer.mutton,TagInitializer.meat,TagInitializer.dried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"raisins")),new ITag[]{TagInitializer.grape,TagInitializer.fruit,TagInitializer.dried,TagInitializer.sweet});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"grapes")),new ITag[]{TagInitializer.grape,TagInitializer.fruit,TagInitializer.sweet});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"cucumber")),new ITag[]{TagInitializer.cucumber,TagInitializer.vegetable});
    }
}

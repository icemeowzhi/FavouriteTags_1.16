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
public class TeaStoryFoodTagInitializer {

    public static final String MODID = "teastory";
    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event) {

        if (!ModList.get().isLoaded(MODID)) {
            return;
        }

        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"dried_beetroot")),new FoodTag[]{TagInitializer.beet,TagInitializer.vegetable,TagInitializer.dried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"dried_carrot")),new FoodTag[]{TagInitializer.carrot,TagInitializer.vegetable,TagInitializer.dried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"beef_jerky")),new FoodTag[]{TagInitializer.beef,TagInitializer.meat,TagInitializer.dried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"pork_jerky")),new FoodTag[]{TagInitializer.pork,TagInitializer.meat,TagInitializer.dried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"chicken_jerky")),new FoodTag[]{TagInitializer.chicken,TagInitializer.meat,TagInitializer.dried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"rabbit_jerky")),new FoodTag[]{TagInitializer.rabbit,TagInitializer.meat,TagInitializer.dried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"mutton_jerky")),new FoodTag[]{TagInitializer.mutton,TagInitializer.meat,TagInitializer.dried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"raisins")),new FoodTag[]{TagInitializer.grape,TagInitializer.fruit,TagInitializer.dried,TagInitializer.sweet});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"grapes")),new FoodTag[]{TagInitializer.grape,TagInitializer.fruit,TagInitializer.sweet});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"cucumber")),new FoodTag[]{TagInitializer.cucumber,TagInitializer.vegetable});
    }
}

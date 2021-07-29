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
public class WaterSourceFoodTagInitializer {
    public static final String MODID = "watersource";
    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event) {

        if (!ModList.get().isLoaded("watersource")) {
            return;
        }

        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"coconut_piece")),new ITag[]{TagInitializer.fruit,TagInitializer.coconut});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"coconut_chicken")),new ITag[]{TagInitializer.chicken,TagInitializer.meat,TagInitializer.coconut});

        //FoodTagInitializer.register(ItemRegistry.itemCoconutPiece,new ITag[]{TagInitializer.fruit,TagInitializer.coconut});
        //FoodTagInitializer.register(ItemRegistry.itemCoconutChicken,new ITag[]{TagInitializer.chicken,TagInitializer.meat,TagInitializer.coconut});
    }
}

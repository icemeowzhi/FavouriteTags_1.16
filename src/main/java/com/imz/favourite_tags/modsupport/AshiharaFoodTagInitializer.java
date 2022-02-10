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
public class AshiharaFoodTagInitializer {
    public static final String MODID = "ashihara";

    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event) {

        if (!ModList.get().isLoaded(MODID)) {
            return;
        }

        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"aqua")), new FoodTag[]{TagInitializer.meme});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"dirt_ball_don")), new FoodTag[]{TagInitializer.meme,TagInitializer.rice});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"dirt_ball")), new FoodTag[]{TagInitializer.meme});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"sakura")), new FoodTag[]{TagInitializer.sakura});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"sakuramochi")),new FoodTag[]{TagInitializer.sakura,TagInitializer.rice});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"cooked_rice")),new FoodTag[]{TagInitializer.rice});


    }
}

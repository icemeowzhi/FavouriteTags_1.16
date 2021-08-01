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
public class AshiharaFoodTagInitializer {
    public static final String MODID = "ashihara";

    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event) {

        if (!ModList.get().isLoaded(MODID)) {
            return;
        }

        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"aqua")), new ITag[]{TagInitializer.secret});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"dirt_ball_don")), new ITag[]{TagInitializer.secret,TagInitializer.rice});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"dirt_ball")), new ITag[]{TagInitializer.secret});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"sakura")), new ITag[]{TagInitializer.sakura});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"sakuramochi")),new ITag[]{TagInitializer.sakura,TagInitializer.rice});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"cooked_rice")),new ITag[]{TagInitializer.rice});


    }
}

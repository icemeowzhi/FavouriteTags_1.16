package com.imz.favourite_tags.modsupport;

import com.imz.favourite_tags.tag.FoodTagInitializer;
import com.imz.favourite_tags.tag.ITag;
import com.imz.favourite_tags.tag.TagInitializer;
import kogasastudio.ashihara.item.ItemRegistryHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AshiharaFoodTagInitializer {
    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event) {

        if (!ModList.get().isLoaded("ashihara")) {
            return;
        }

        FoodTagInitializer.register(ItemRegistryHandler.MINATO_AQUA.get(), new ITag[]{TagInitializer.secret});
        FoodTagInitializer.register(ItemRegistryHandler.DIRT_BALL_DON.get(), new ITag[]{TagInitializer.secret,TagInitializer.rice});
        FoodTagInitializer.register(ItemRegistryHandler.DIRT_BALL.get(), new ITag[]{TagInitializer.secret});
        FoodTagInitializer.register(ItemRegistryHandler.SAKURA.get(), new ITag[]{TagInitializer.sakura});
        FoodTagInitializer.register(ItemRegistryHandler.SAKURAMOCHI.get(),new ITag[]{TagInitializer.sakura,TagInitializer.rice});
        FoodTagInitializer.register(ItemRegistryHandler.COOKED_RICE.get(),new ITag[]{TagInitializer.rice});

    }
}

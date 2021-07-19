package com.imz.favourite_tags.tag;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FoodTagInitializer {

    public static HashMap<Item, ITag[]> tagMap = new HashMap<>(); //use FoodTag()

    @SubscribeEvent
    public static void registerTagsOfFood(FMLCommonSetupEvent event){
        register(Items.APPLE,new ITag[]{TagInitializer.apple,TagInitializer.fruit});
        register(Items.GOLDEN_APPLE,new ITag[]{TagInitializer.apple,TagInitializer.fruit});
    }

    public static void register(Item item, ITag[] tags){
        tagMap.put(item,tags);
    }

}

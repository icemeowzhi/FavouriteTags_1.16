package com.imz.favourite_tags.intance;

import com.imz.favourite_tags.FavouriteTag;
import com.imz.favourite_tags.foodtag.FoodTag;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author icemeowzhi
 * @date 2021/9/2
 * @apiNote
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,modid = FavouriteTag.MODID)
public class TaggedFoodInitializer {

    public static final Map<Item, FoodTag[]> FOOD_TAG_MAP = new HashMap<>();

    public static Map<Item, FoodTag[]> getFoodTagMap() {
        return FOOD_TAG_MAP;
    }

    @SubscribeEvent
    public static void registerTaggedFood(FMLCommonSetupEvent event){
        register(Items.APPLE,new FoodTag[]{TagInitializer.apple});
    }

    public static void register(Item item, FoodTag[] tags){FOOD_TAG_MAP.put(item,tags);}


}

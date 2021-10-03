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
        register(Items.APPLE                  ,new FoodTag[]{TagInitializer.apple});
        register(Items.GOLDEN_APPLE           ,new FoodTag[]{TagInitializer.apple,TagInitializer.fruit,TagInitializer.sweet,TagInitializer.golden});
        register(Items.BAKED_POTATO           ,new FoodTag[]{TagInitializer.fried,TagInitializer.carbohydrate,TagInitializer.potato});
        register(Items.POTATO                 ,new FoodTag[]{TagInitializer.potato,TagInitializer.carbohydrate});
        register(Items.POISONOUS_POTATO       ,new FoodTag[]{TagInitializer.potato,TagInitializer.carbohydrate});
        register(Items.MELON_SLICE            ,new FoodTag[]{TagInitializer.watermelon,TagInitializer.fruit,TagInitializer.sweet});
        register(Items.CARROT                 ,new FoodTag[]{TagInitializer.carrot,TagInitializer.vegetable});
        register(Items.BEETROOT               ,new FoodTag[]{TagInitializer.beet,TagInitializer.sweet,TagInitializer.vegetable});
        register(Items.BEETROOT_SOUP          ,new FoodTag[]{TagInitializer.beet,TagInitializer.sweet,TagInitializer.vegetable,TagInitializer.soup});
        register(Items.BEEF                   ,new FoodTag[]{TagInitializer.beef,TagInitializer.meat,TagInitializer.raw});
        register(Items.COOKED_BEEF            ,new FoodTag[]{TagInitializer.beef,TagInitializer.fried,TagInitializer.meat});
        register(Items.MUTTON                 ,new FoodTag[]{TagInitializer.mutton,TagInitializer.meat,TagInitializer.raw});
        register(Items.COOKED_MUTTON          ,new FoodTag[]{TagInitializer.mutton,TagInitializer.fried,TagInitializer.meat});
        register(Items.PORKCHOP               ,new FoodTag[]{TagInitializer.pork,TagInitializer.meat,TagInitializer.raw});
        register(Items.COOKED_PORKCHOP        ,new FoodTag[]{TagInitializer.pork,TagInitializer.fried,TagInitializer.meat});
        register(Items.BREAD                  ,new FoodTag[]{TagInitializer.cereal,TagInitializer.carbohydrate});
        register(Items.CHICKEN                ,new FoodTag[]{TagInitializer.chicken,TagInitializer.meat,TagInitializer.raw});
        register(Items.COOKED_CHICKEN         ,new FoodTag[]{TagInitializer.chicken,TagInitializer.fried,TagInitializer.meat});
        register(Items.RABBIT                 ,new FoodTag[]{TagInitializer.rabbit,TagInitializer.meat,TagInitializer.raw});
        register(Items.COOKED_RABBIT          ,new FoodTag[]{TagInitializer.rabbit,TagInitializer.fried,TagInitializer.meat});
        register(Items.CHORUS_FRUIT           ,new FoodTag[]{TagInitializer.chorus,TagInitializer.fruit});
        register(Items.COD                    ,new FoodTag[]{TagInitializer.fish,TagInitializer.meat,TagInitializer.raw});
        register(Items.COOKED_COD             ,new FoodTag[]{TagInitializer.fish,TagInitializer.fried,TagInitializer.meat});
        register(Items.SALMON                 ,new FoodTag[]{TagInitializer.fish,TagInitializer.raw});
        register(Items.COOKED_SALMON          ,new FoodTag[]{TagInitializer.fish,TagInitializer.fried,TagInitializer.meat});
        register(Items.COOKIE                 ,new FoodTag[]{TagInitializer.cereal,TagInitializer.cocoa,TagInitializer.fried});
        register(Items.GOLDEN_CARROT          ,new FoodTag[]{TagInitializer.carrot,TagInitializer.vegetable,TagInitializer.golden});
        register(Items.HONEY_BOTTLE           ,new FoodTag[]{TagInitializer.sweet,TagInitializer.honey});
        register(Items.MUSHROOM_STEW          ,new FoodTag[]{TagInitializer.mushroom,TagInitializer.soup,TagInitializer.vegetable});
        register(Items.DRIED_KELP             ,new FoodTag[]{TagInitializer.kelp,TagInitializer.vegetable});
        register(Items.PUFFERFISH             ,new FoodTag[]{TagInitializer.fish,TagInitializer.raw});
        register(Items.PUMPKIN_PIE            ,new FoodTag[]{TagInitializer.pumpkin,TagInitializer.sweet,TagInitializer.baked,TagInitializer.cereal,TagInitializer.egg});
        register(Items.ROTTEN_FLESH           ,new FoodTag[]{TagInitializer.meat,TagInitializer.rotten,TagInitializer.raw});
        register(Items.SPIDER_EYE             ,new FoodTag[]{TagInitializer.raw,TagInitializer.monster});
        register(Items.SWEET_BERRIES          ,new FoodTag[]{TagInitializer.fruit,TagInitializer.berry,TagInitializer.sweet});
        register(Items.TROPICAL_FISH          ,new FoodTag[]{TagInitializer.fish,TagInitializer.raw});
        register(Items.RABBIT_STEW            ,new FoodTag[]{TagInitializer.meat,TagInitializer.rabbit,TagInitializer.soup});
        register(Items.ENCHANTED_GOLDEN_APPLE ,new FoodTag[]{TagInitializer.apple,TagInitializer.fruit,TagInitializer.sweet,TagInitializer.golden});
        register(Items.CAKE                   ,new FoodTag[]{TagInitializer.cake,TagInitializer.milk});
    }

    public static void register(Item item, FoodTag[] tags){FOOD_TAG_MAP.put(item,tags);}


}

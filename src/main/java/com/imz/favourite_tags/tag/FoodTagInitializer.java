package com.imz.favourite_tags.tag;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FoodTagInitializer {

    public static HashMap<Item, ITag[]> tagMap = new HashMap<>();

    @SubscribeEvent
    public static void registerTagsOfFood(FMLCommonSetupEvent event){
        register(Items.APPLE,new ITag[]{TagInitializer.apple,TagInitializer.fruit,TagInitializer.sweet});
        register(Items.GOLDEN_APPLE,new ITag[]{TagInitializer.apple,TagInitializer.fruit,TagInitializer.sweet,TagInitializer.golden});
        register(Items.BAKED_POTATO,new ITag[]{TagInitializer.fried,TagInitializer.carbohydrate,TagInitializer.potato});
        register(Items.POTATO,new ITag[]{TagInitializer.potato,TagInitializer.carbohydrate});
        register(Items.POISONOUS_POTATO,new ITag[]{TagInitializer.potato,TagInitializer.carbohydrate});
        register(Items.MELON_SLICE,new ITag[]{TagInitializer.watermelon,TagInitializer.fruit,TagInitializer.sweet});
        register(Items.CARROT,new ITag[]{TagInitializer.carrot,TagInitializer.vegetable});
        register(Items.BEETROOT,new ITag[]{TagInitializer.beet,TagInitializer.sweet,TagInitializer.vegetable});
        register(Items.BEETROOT_SOUP,new ITag[]{TagInitializer.beet,TagInitializer.sweet,TagInitializer.vegetable,TagInitializer.soup});
        register(Items.BEEF,new ITag[]{TagInitializer.beef,TagInitializer.meat,TagInitializer.raw});
        register(Items.COOKED_BEEF,new ITag[]{TagInitializer.beef,TagInitializer.fried,TagInitializer.meat});
        register(Items.MUTTON,new ITag[]{TagInitializer.mutton,TagInitializer.meat,TagInitializer.raw});
        register(Items.COOKED_MUTTON,new ITag[]{TagInitializer.mutton,TagInitializer.fried,TagInitializer.meat});
        register(Items.PORKCHOP,new ITag[]{TagInitializer.pork,TagInitializer.meat,TagInitializer.raw});
        register(Items.COOKED_PORKCHOP,new ITag[]{TagInitializer.pork,TagInitializer.fried,TagInitializer.meat});
        register(Items.BREAD,new ITag[]{TagInitializer.cereal,TagInitializer.carbohydrate});
        register(Items.CHICKEN,new ITag[]{TagInitializer.chicken,TagInitializer.meat,TagInitializer.raw});
        register(Items.COOKED_CHICKEN,new ITag[]{TagInitializer.chicken,TagInitializer.fried,TagInitializer.meat});
        register(Items.RABBIT,new ITag[]{TagInitializer.rabbit,TagInitializer.meat,TagInitializer.raw});
        register(Items.COOKED_RABBIT,new ITag[]{TagInitializer.rabbit,TagInitializer.fried,TagInitializer.meat});
        register(Items.CHORUS_FRUIT,new ITag[]{TagInitializer.chorus,TagInitializer.fruit});
        register(Items.COD,new ITag[]{TagInitializer.fish,TagInitializer.meat,TagInitializer.raw});
        register(Items.COOKED_COD,new ITag[]{TagInitializer.fish,TagInitializer.fried,TagInitializer.meat});
        register(Items.SALMON,new ITag[]{TagInitializer.fish,TagInitializer.raw});
        register(Items.COOKED_SALMON,new ITag[]{TagInitializer.fish,TagInitializer.fried,TagInitializer.meat});
        register(Items.COOKIE,new ITag[]{TagInitializer.cereal,TagInitializer.cocoa,TagInitializer.fried});
        register(Items.GOLDEN_CARROT,new ITag[]{TagInitializer.carrot,TagInitializer.vegetable,TagInitializer.golden});
        register(Items.HONEY_BOTTLE,new ITag[]{TagInitializer.sweet,TagInitializer.honey});
        register(Items.MUSHROOM_STEW,new ITag[]{TagInitializer.mushroom,TagInitializer.soup,TagInitializer.vegetable});
        register(Items.DRIED_KELP,new ITag[]{TagInitializer.kelp,TagInitializer.vegetable});
        register(Items.PUFFERFISH,new ITag[]{TagInitializer.fish,TagInitializer.raw});
        register(Items.PUMPKIN_PIE,new ITag[]{TagInitializer.pumpkin,TagInitializer.sweet,TagInitializer.baked,TagInitializer.cereal,TagInitializer.egg});
        register(Items.ROTTEN_FLESH,new ITag[]{TagInitializer.meat,TagInitializer.rotten,TagInitializer.raw});
        register(Items.SPIDER_EYE,new ITag[]{TagInitializer.raw,TagInitializer.monster});
        register(Items.SWEET_BERRIES,new ITag[]{TagInitializer.fruit,TagInitializer.berry,TagInitializer.sweet});
        register(Items.TROPICAL_FISH,new ITag[]{TagInitializer.fish,TagInitializer.raw});
        register(Items.RABBIT_STEW,new ITag[]{TagInitializer.meat,TagInitializer.rabbit,TagInitializer.soup});
        register(Items.ENCHANTED_GOLDEN_APPLE,new ITag[]{TagInitializer.apple,TagInitializer.fruit,TagInitializer.sweet,TagInitializer.golden});


    }

    public static void register(Item item, ITag[] tags){
        tagMap.put(item,tags);
    }

}

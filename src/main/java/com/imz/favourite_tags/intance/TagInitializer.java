package com.imz.favourite_tags.intance;

import com.imz.favourite_tags.FavouriteTag;
import com.imz.favourite_tags.foodtag.FoodTag;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author icemeowzhi
 * @date 2021/9/2
 * @apiNote
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,modid = FavouriteTag.MODID)
public class TagInitializer {

    public static final List<FoodTag> ALL_FOOD_TAGS = new ArrayList<>();

    public static List<FoodTag> getAllFoodTags() {
        return ALL_FOOD_TAGS;
    }
    //ingredient
    public static FoodTag apple        ;
    public static FoodTag beef         ;
    public static FoodTag chicken      ;
    public static FoodTag mutton       ;
    public static FoodTag pork         ;
    public static FoodTag fish         ;
    public static FoodTag rabbit       ;
    public static FoodTag watermelon   ;
    public static FoodTag carrot       ;
    public static FoodTag cake         ;
    public static FoodTag potato       ;
    public static FoodTag beet         ;
    public static FoodTag chorus       ;
    public static FoodTag cocoa        ;
    public static FoodTag mushroom     ;
    public static FoodTag kelp         ;
    public static FoodTag pumpkin      ;
    public static FoodTag egg          ;
    public static FoodTag honey        ;
    public static FoodTag frog         ;
    public static FoodTag milk         ;
    public static FoodTag asparagus    ;
    public static FoodTag coffee       ;
    public static FoodTag bacon        ;
    public static FoodTag onion        ;
    public static FoodTag tea          ;
    public static FoodTag tomato       ;
    public static FoodTag chili        ;
    public static FoodTag eggplant     ;
    public static FoodTag coconut      ;
    public static FoodTag sakura       ;
    public static FoodTag meme         ;
    public static FoodTag grape        ;
    public static FoodTag cucumber     ;
    public static FoodTag paimon       ;

    //category
    public static FoodTag meat         ;
    public static FoodTag fruit        ;
    public static FoodTag vegetable    ;
    public static FoodTag cereal       ;
    public static FoodTag raw          ;
    public static FoodTag soup         ;
    public static FoodTag rotten       ;
    public static FoodTag carbohydrate ;
    public static FoodTag rice         ;
    public static FoodTag processed_raw;
    public static FoodTag berry        ;
    public static FoodTag hot_drink    ;
    public static FoodTag monster      ;
    public static FoodTag sauce        ;
    public static FoodTag wine         ;

    //taste
    public static FoodTag sweet        ;
    public static FoodTag salty        ;
    public static FoodTag sweet_and_salty ;
    public static FoodTag spicy        ;
    public static FoodTag cold         ;

    //cooking method
    public static FoodTag dried        ;
    public static FoodTag smoked       ;
    public static FoodTag salad        ;
    public static FoodTag fried        ;
    public static FoodTag baked        ;
    public static FoodTag golden       ;

    public static FoodTag registerFoodTag(String registryName, FoodTag.EnumFoodTagType tagType, boolean disableLike , boolean disableDislike){
        FoodTag foodTag = new FoodTag(registryName,tagType,disableLike,disableDislike);
        ALL_FOOD_TAGS.add(foodTag);
        return foodTag;
    }

    public static FoodTag registerFoodTag(String registryName, FoodTag.EnumFoodTagType tagType){
        FoodTag foodTag = new FoodTag(registryName,tagType,false,false);
        ALL_FOOD_TAGS.add(foodTag);
        return foodTag;
    }

    public static FoodTag registerIngredientTag(String registryName){
        FoodTag foodTag = new FoodTag(registryName, FoodTag.EnumFoodTagType.INGREDIENT,false,false);
        ALL_FOOD_TAGS.add(foodTag);
        return foodTag;
    }

    public static FoodTag registerCategoryTag(String registryName){
        FoodTag foodTag = new FoodTag(registryName, FoodTag.EnumFoodTagType.CATEGORY,false,false);
        ALL_FOOD_TAGS.add(foodTag);
        return foodTag;
    }

    public static FoodTag registerTasteTag(String registryName){
        FoodTag foodTag = new FoodTag(registryName, FoodTag.EnumFoodTagType.TASTE,false,false);
        ALL_FOOD_TAGS.add(foodTag);
        return foodTag;
    }

    public static FoodTag registerCookingMethodTag(String registryName){
        FoodTag foodTag = new FoodTag(registryName, FoodTag.EnumFoodTagType.COOKING_METHOD,false,false);
        ALL_FOOD_TAGS.add(foodTag);
        return foodTag;
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerIngredientFoodTagEvent(FMLCommonSetupEvent event){
        apple      = registerIngredientTag("apple");
        beef       = registerIngredientTag("beef");
        chicken    = registerIngredientTag("chicken");
        mutton     = registerIngredientTag("mutton");
        pork       = registerIngredientTag("pork");
        fish       = registerIngredientTag("fish");
        rabbit     = registerIngredientTag("rabbit");
        watermelon = registerIngredientTag("watermelon");
        carrot     = registerIngredientTag("carrot");
        cake       = registerIngredientTag("cake");
        potato     = registerIngredientTag("potato");
        beet       = registerIngredientTag("beet");
        chorus     = registerIngredientTag("chorus");
        cocoa      = registerIngredientTag("cocoa");
        mushroom   = registerIngredientTag("mushroom");
        kelp       = registerIngredientTag("kelp");
        pumpkin    = registerIngredientTag("pumpkin");
        egg        = registerIngredientTag("egg");
        honey      = registerIngredientTag("honey");
        frog       = registerIngredientTag("frog");
        milk       = registerIngredientTag("milk");
        asparagus  = registerIngredientTag("asparagus");
        coffee     = registerIngredientTag("coffee");
        bacon      = registerIngredientTag("bacon");
        onion      = registerIngredientTag("onion");
        tea        = registerIngredientTag("tea");
        tomato     = registerIngredientTag("tomato");
        chili      = registerIngredientTag("chili");
        eggplant   = registerIngredientTag("eggplant");
        coconut    = registerIngredientTag("coconut");
        sakura     = registerIngredientTag("sakura");
        meme = registerIngredientTag("secret");
        grape      = registerIngredientTag("grape");
        cucumber   = registerIngredientTag("cucumber");
        paimon     = registerIngredientTag("paimon");
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerCategoryFoodTagEvent(FMLCommonSetupEvent event){
        meat          = registerCategoryTag("meat");
        fruit         = registerCategoryTag("fruit");
        vegetable     = registerCategoryTag("vegetable");
        cereal        = registerCategoryTag("cereal");
        raw           = registerCategoryTag("raw");
        soup          = registerCategoryTag("soup");
        rotten        = registerCategoryTag("rotten");
        carbohydrate  = registerCategoryTag("carbohydrate");
        rice          = registerCategoryTag("rice");
        processed_raw = registerCategoryTag("processed_raw");
        berry         = registerCategoryTag("berry");
        hot_drink     = registerCategoryTag("hot_drink");
        monster       = registerCategoryTag("monster");
        sauce         = registerCategoryTag("sauce");
        wine          = registerCategoryTag("wine");
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerTasteFoodTagEvent(FMLCommonSetupEvent event){
        sweet           = registerTasteTag("sweet");
        salty           = registerTasteTag("salty");
        sweet_and_salty = registerTasteTag("sweet_and_salty");
        spicy           = registerTasteTag("spicy");
        cold            = registerTasteTag("cold");
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerCookingMethodFoodTagEvent(FMLCommonSetupEvent event){
        dried        = registerCookingMethodTag("dried");
        smoked       = registerCookingMethodTag("smoked");
        salad        = registerCookingMethodTag("salad");
        fried        = registerCookingMethodTag("fried");
        baked        = registerCookingMethodTag("baked");
        golden       = registerCookingMethodTag("golden");
    }

}

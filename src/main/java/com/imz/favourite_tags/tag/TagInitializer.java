package com.imz.favourite_tags.tag;


import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.ArrayList;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TagInitializer {
    private static final ArrayList<ITag> allTag = new ArrayList<>();
    private static final HashMap<String, TranslationTextComponent> displayNames = new HashMap<>();

    public static ArrayList<ITag> getAllTag() {
        return allTag;
    }

    public static HashMap<String, TranslationTextComponent> getDisplayNames() {
        return displayNames;
    }

    // categories
    public static FoodTag meat = new FoodTag("meat",EnumTagGroup.FOODS_BOTH);
    public static FoodTag fruit = new FoodTag("fruit",EnumTagGroup.FOODS_BOTH);
    public static FoodTag vegetable = new FoodTag("vegetable",EnumTagGroup.FOODS_BOTH);
    public static FoodTag cereal = new FoodTag("cereal",EnumTagGroup.FOODS_BOTH);
    public static FoodTag roasted = new FoodTag("roasted",EnumTagGroup.FOODS_BOTH);
    public static FoodTag golden = new FoodTag("golden",EnumTagGroup.FOODS_LIKE);
    public static FoodTag raw = new FoodTag("raw",EnumTagGroup.FOODS_DISLIKE);
    public static FoodTag soup = new FoodTag("soup",EnumTagGroup.FOODS_BOTH);
    public static FoodTag rotten = new FoodTag("rotten",EnumTagGroup.FOODS_DISLIKE);
    public static FoodTag carbohydrate = new FoodTag("carbohydrate",EnumTagGroup.FOODS_BOTH);
    public static FoodTag rice = new FoodTag("rice",EnumTagGroup.FOODS_BOTH);
    public static FoodTag processed_raw = new FoodTag("processed_raw",EnumTagGroup.FOODS_BOTH);
    public static FoodTag berry = new FoodTag("berry",EnumTagGroup.FOODS_BOTH);

    public static FoodTag apple = new FoodTag("apple",EnumTagGroup.FOODS_BOTH);
    public static FoodTag beef = new FoodTag("beef",EnumTagGroup.FOODS_BOTH);
    public static FoodTag chicken = new FoodTag("chicken",EnumTagGroup.FOODS_BOTH);
    public static FoodTag mutton = new FoodTag("mutton",EnumTagGroup.FOODS_BOTH);
    public static FoodTag pork = new FoodTag("pork",EnumTagGroup.FOODS_BOTH);
    public static FoodTag fish = new FoodTag("fish",EnumTagGroup.FOODS_BOTH);
    public static FoodTag rabbit = new FoodTag("rabbit",EnumTagGroup.FOODS_BOTH);
    public static FoodTag watermelon = new FoodTag("watermelon",EnumTagGroup.FOODS_BOTH);
    public static FoodTag carrot = new FoodTag("carrot",EnumTagGroup.FOODS_BOTH);
    public static FoodTag cake = new FoodTag("cake",EnumTagGroup.FOODS_BOTH);
    public static FoodTag potato = new FoodTag("potato",EnumTagGroup.FOODS_BOTH);
    public static FoodTag beet = new FoodTag("beet",EnumTagGroup.FOODS_BOTH);
    public static FoodTag chorus = new FoodTag("chorus",EnumTagGroup.FOODS_BOTH);
    public static FoodTag cocoa = new FoodTag("cocoa",EnumTagGroup.FOODS_BOTH);
    public static FoodTag mushroom = new FoodTag("mushroom",EnumTagGroup.FOODS_BOTH);
    public static FoodTag kelp = new FoodTag("kelp",EnumTagGroup.FOODS_BOTH);
    public static FoodTag pumpkin = new FoodTag("pumpkin",EnumTagGroup.FOODS_BOTH);

    public static FoodTag sweet = new FoodTag("sweet",EnumTagGroup.FOODS_BOTH);
    public static FoodTag salty = new FoodTag("salty",EnumTagGroup.FOODS_BOTH);
    public static FoodTag sweet_and_salty = new FoodTag("sweet_and_salty",EnumTagGroup.FOODS_BOTH);


    @SubscribeEvent
    public static void registerTag(FMLCommonSetupEvent event){
        event.setPhase(EventPriority.HIGH);
        register(meat);
        register(fruit);
        register(vegetable);
        register(cereal);
        register(roasted);
        register(golden);
        register(raw);
        register(soup);
        register(rotten);
        register(carbohydrate);
        register(rice);
        register(processed_raw);
        register(berry);

        register(apple);
        register(beef);
        register(chicken);
        register(mutton);
        register(pork);
        register(fish);
        register(rabbit);
        register(watermelon);
        register(carrot);
        register(cake);
        register(potato);
        register(beet);
        register(chorus);
        register(cocoa);
        register(mushroom);
        register(kelp);
        register(pumpkin);


        register(sweet);
        register(salty);
        register(sweet_and_salty);
    }

    private static void register(ITag tag, TranslationTextComponent displayName){
        allTag.add(tag);
        displayNames.put(tag.getRegistryName(),displayName);
    }

    private static void register(ITag tag){
        allTag.add(tag);
        displayNames.put(tag.getRegistryName(),translationKey(tag.getRegistryName()));
    }

    private static TranslationTextComponent translationKey(String name){return new TranslationTextComponent("tag."+name+".name");}
}

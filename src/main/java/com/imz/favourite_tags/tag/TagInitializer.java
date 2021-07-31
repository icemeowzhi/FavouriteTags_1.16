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
    public static FoodTag fried = new FoodTag("fried",EnumTagGroup.FOODS_BOTH);
    public static FoodTag golden = new FoodTag("golden",EnumTagGroup.FOODS_LIKE);
    public static FoodTag raw = new FoodTag("raw",EnumTagGroup.FOODS_DISLIKE);
    public static FoodTag soup = new FoodTag("soup",EnumTagGroup.FOODS_BOTH);
    public static FoodTag rotten = new FoodTag("rotten",EnumTagGroup.FOODS_DISLIKE);
    public static FoodTag carbohydrate = new FoodTag("carbohydrate",EnumTagGroup.FOODS_BOTH);
    public static FoodTag rice = new FoodTag("rice",EnumTagGroup.FOODS_BOTH);
    public static FoodTag processed_raw = new FoodTag("processed_raw",EnumTagGroup.FOODS_BOTH);
    public static FoodTag berry = new FoodTag("berry",EnumTagGroup.FOODS_BOTH);
    public static FoodTag smoked = new FoodTag("smoked",EnumTagGroup.FOODS_BOTH);
    public static FoodTag salad = new FoodTag("salad",EnumTagGroup.FOODS_BOTH);
    public static FoodTag hot_drink = new FoodTag("hot_drink",EnumTagGroup.FOODS_BOTH);
    public static FoodTag monster = new FoodTag("monster",EnumTagGroup.FOODS_BOTH);
    public static FoodTag baked = new FoodTag("baked",EnumTagGroup.FOODS_BOTH);
    public static FoodTag sauce = new FoodTag("sauce",EnumTagGroup.FOODS_BOTH);
    public static FoodTag wine = new FoodTag("wine",EnumTagGroup.FOODS_BOTH);
    public static FoodTag dried = new FoodTag("dried",EnumTagGroup.FOODS_BOTH);

    public static FoodTag apple = new FoodTag("apple",EnumTagGroup.FOODS_BOTH);
    public static FoodTag beef = new FoodTag("beef",EnumTagGroup.FOODS_BOTH);
    public static FoodTag chicken = new FoodTag("chicken",EnumTagGroup.FOODS_BOTH);
    public static FoodTag mutton = new FoodTag("mutton",EnumTagGroup.FOODS_BOTH);
    public static FoodTag pork = new FoodTag("pork",EnumTagGroup.FOODS_BOTH);
    public static FoodTag fish = new FoodTag("fish",EnumTagGroup.FOODS_BOTH);
    public static FoodTag rabbit = new FoodTag("rabbit",EnumTagGroup.FOODS_BOTH);
    public static FoodTag watermelon = new FoodTag("watermelon",EnumTagGroup.FOODS_BOTH);
    public static FoodTag carrot = new FoodTag("carrot",EnumTagGroup.FOODS_BOTH);
    public static FoodTag cake = new FoodTag("cake",EnumTagGroup.FOODS_BOTH); //not done yet
    public static FoodTag potato = new FoodTag("potato",EnumTagGroup.FOODS_BOTH);
    public static FoodTag beet = new FoodTag("beet",EnumTagGroup.FOODS_BOTH);
    public static FoodTag chorus = new FoodTag("chorus",EnumTagGroup.FOODS_BOTH);
    public static FoodTag cocoa = new FoodTag("cocoa",EnumTagGroup.FOODS_BOTH);
    public static FoodTag mushroom = new FoodTag("mushroom",EnumTagGroup.FOODS_BOTH);
    public static FoodTag kelp = new FoodTag("kelp",EnumTagGroup.FOODS_BOTH);
    public static FoodTag pumpkin = new FoodTag("pumpkin",EnumTagGroup.FOODS_BOTH);
    public static FoodTag egg = new FoodTag("egg",EnumTagGroup.FOODS_BOTH);
    public static FoodTag honey = new FoodTag("honey",EnumTagGroup.FOODS_BOTH);
    public static FoodTag frog = new FoodTag("frog",EnumTagGroup.FOODS_BOTH);
    public static FoodTag milk = new FoodTag("milk",EnumTagGroup.FOODS_BOTH);
    public static FoodTag asparagus = new FoodTag("asparagus",EnumTagGroup.FOODS_BOTH);
    public static FoodTag coffee = new FoodTag("coffee",EnumTagGroup.FOODS_BOTH);
    public static FoodTag bacon = new FoodTag("bacon",EnumTagGroup.FOODS_BOTH);
    public static FoodTag onion = new FoodTag("onion",EnumTagGroup.FOODS_BOTH);
    public static FoodTag tea = new FoodTag("tea",EnumTagGroup.FOODS_BOTH);
    public static FoodTag tomato = new FoodTag("tomato",EnumTagGroup.FOODS_BOTH);
    public static FoodTag chili = new FoodTag("chili",EnumTagGroup.FOODS_BOTH);
    public static FoodTag eggplant = new FoodTag("eggplant",EnumTagGroup.FOODS_BOTH);
    public static FoodTag coconut = new FoodTag("coconut",EnumTagGroup.FOODS_BOTH);
    public static FoodTag sakura = new FoodTag("sakura",EnumTagGroup.FOODS_BOTH);
    public static FoodTag secret = new FoodTag("secret",EnumTagGroup.FOODS_LIKE);
    public static FoodTag grape = new FoodTag("grape",EnumTagGroup.FOODS_BOTH);
    public static FoodTag cucumber = new FoodTag("cucumber",EnumTagGroup.FOODS_BOTH);
    public static FoodTag paimon = new FoodTag("paimon",EnumTagGroup.FOODS_LIKE);

    public static FoodTag sweet = new FoodTag("sweet",EnumTagGroup.FOODS_BOTH);
    public static FoodTag salty = new FoodTag("salty",EnumTagGroup.FOODS_BOTH);
    public static FoodTag sweet_and_salty = new FoodTag("sweet_and_salty",EnumTagGroup.FOODS_BOTH);
    public static FoodTag spicy = new FoodTag("spicy",EnumTagGroup.FOODS_BOTH);

    public static FoodTag cold = new FoodTag("cold",EnumTagGroup.FOODS_BOTH);


    @SubscribeEvent
    public static void registerTag(FMLCommonSetupEvent event){
        event.setPhase(EventPriority.HIGH);
        register(meat);
        register(fruit);
        register(vegetable);
        register(cereal);
        register(fried);
        register(golden);
        register(raw);
        register(soup);
        register(rotten);
        register(carbohydrate);
        register(rice);
        register(processed_raw);
        register(berry);
        register(smoked);
        register(salad);
        register(hot_drink);
        register(monster);
        register(baked);
        register(sauce);
        register(wine);
        register(dried);

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
        register(egg);
        register(honey);
        register(frog);
        register(milk);
        register(asparagus);
        register(coffee);
        register(bacon);
        register(onion);
        register(tea);
        register(tomato);
        register(chili);
        register(eggplant);
        register(coconut);
        register(sakura);
        register(secret);
        register(grape);
        register(cucumber);
        register(paimon);

        register(sweet);
        register(salty);//no usage
        register(sweet_and_salty);//no usage
        register(spicy);

        register(cold);
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

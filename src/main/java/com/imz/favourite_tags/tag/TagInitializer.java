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

    public static FoodTag apple = new FoodTag("apple",EnumTagGroup.FOODS_BOTH);


    @SubscribeEvent
    public static void registerTag(FMLCommonSetupEvent event){
        event.setPhase(EventPriority.HIGH);
        register(meat,new TranslationTextComponent("tag.meat.name"));
        register(fruit,new TranslationTextComponent("tag.fruit.name"));
        register(vegetable,new TranslationTextComponent("tag.vegetable.name"));
        register(cereal,new TranslationTextComponent("tag.cereal.name"));
        register(apple,new TranslationTextComponent("tag.apple.name"));
    }

    private static void register(ITag tag, TranslationTextComponent displayName){
        allTag.add(tag);
        displayNames.put(tag.getRegistryName(),displayName);
    }
}

package com.imz.favourite_tags.tag;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.Arrays;

public class TagInitializer {
    public static FoodTag apple = new FoodTag("apple","apple",EnumTagLevel.EPIC, Items.APPLE);
    public static FoodTag cookedMeatTag = new FoodTag("cooked_meat","Cooked meat",EnumTagLevel.RARE,new ArrayList<Item>(Arrays.asList(Items.COOKED_BEEF,Items.COOKED_CHICKEN)));
}

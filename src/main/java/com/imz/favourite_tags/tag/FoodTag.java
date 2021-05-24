package com.imz.favourite_tags.tag;

import net.minecraft.item.Item;

import java.util.ArrayList;

public class FoodTag implements ITag{

    //Define food tags

    String registryName;
    String displayName;
    EnumTagLevel tagLevel;
    ArrayList<Item> range = new ArrayList<>();

    @Override
    public String toString() {
        return "FoodTag{" +
                "displayName='" + displayName + '\'' +
                '}';
    }

    public FoodTag(String registryName , String displayName , EnumTagLevel tagLevel , ArrayList<Item> range) {
        this.registryName = registryName;
        this.displayName = displayName;
        this.tagLevel = tagLevel;
        this.range = range;
    }

    public FoodTag(String registryName , String displayName , EnumTagLevel tagLevel , Item range) {
        this.registryName = registryName;
        this.displayName = displayName;
        this.tagLevel = tagLevel;
        this.range.add(range);
    }

    @Override
    public String getRegistryName() {
        return registryName;
    }

    @Override
    public void setRegistryName(String registryName) {
        this.registryName = registryName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public EnumTagLevel getTagLevel() {
        return tagLevel;
    }

    @Override
    public void setTagLevel(EnumTagLevel tagLevel) {
        this.tagLevel = tagLevel;
    }


}

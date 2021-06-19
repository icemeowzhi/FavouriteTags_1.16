package com.imz.favourite_tags.tag;

import net.minecraft.item.Item;

import java.util.ArrayList;

public class FoodTag implements ITag{

    //Define food tags

    String registryName;
    String displayName;
    EnumTagRarity tagRarity;

    @Override
    public String toString() {
        return "FoodTag{" +
                "displayName='" + displayName + '\'' +
                ",rarity='" + tagRarity + '\'' +
                '}';
    }

    public FoodTag(String registryName , String displayName , EnumTagRarity tagRarity) {
        this.registryName = registryName;
        this.displayName = displayName;
        this.tagRarity = tagRarity;
    }

    public FoodTag(String registryName , String displayName) {
        this.registryName = registryName;
        this.displayName = displayName;
        this.tagRarity = EnumTagRarity.COMMON;
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
    public EnumTagRarity getTagRarity() {
        return tagRarity;
    }

    @Override
    public void setTagRarity(EnumTagRarity tagRarity) {
        this.tagRarity = tagRarity;
    }


}

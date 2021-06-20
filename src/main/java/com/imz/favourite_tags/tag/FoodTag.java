package com.imz.favourite_tags.tag;

import net.minecraft.nbt.CompoundNBT;

public class FoodTag implements ITag{

    //Define food tags

    String registryName;
    String displayName;
    EnumTagRarity tagRarity;
    EnumTagGroup group;

    @Override
    public String toString() {
        return "FoodTag{" +
                "displayName='" + displayName + '\'' +
                ",rarity='" + tagRarity + '\'' +
                '}';
    }

    public FoodTag(String registryName , String displayName,EnumTagGroup group) {
        this.registryName = registryName;
        this.displayName = displayName;
        this.group = group;
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

    @Override
    public ITag withRarity(EnumTagRarity tagRarity) {
        this.tagRarity = tagRarity;
        return this;
    }
    @Override
    public EnumTagGroup getGroup() {
        return group;
    }

    @Override
    public void setGroup(EnumTagGroup group) {
        this.group = group;
    }


    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putString("tag",registryName);
        compoundNBT.putInt("rarity",tagRarity.ordinal());
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        registryName = nbt.getString("tag");
        tagRarity = EnumTagRarity.values()[nbt.getInt("rarity")];
    }
}

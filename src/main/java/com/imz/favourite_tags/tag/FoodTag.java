package com.imz.favourite_tags.tag;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.TranslationTextComponent;

public class FoodTag implements ITag{

    //Define food tags

    String registryName;
    EnumTagRarity tagRarity;
    EnumTagGroup group;

    @Override
    public String toString() {
        return "FoodTag{" +
                "name='" + registryName + '\'' +
                ",rarity='" + tagRarity + '\'' +
                '}';
    }

    public FoodTag(String registryName, EnumTagGroup group) {
        this.registryName = registryName;
        this.group = group;
        this.tagRarity = EnumTagRarity.COMMON;
    }

    //create a default tag
    public FoodTag(){
        this.registryName = "registryName";
        this.group = EnumTagGroup.NONE;
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
    public TranslationTextComponent getDisplayName() {
        return TagInitializer.getDisplayNames().get(registryName);
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

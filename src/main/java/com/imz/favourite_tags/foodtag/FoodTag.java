package com.imz.favourite_tags.foodtag;

import com.imz.favourite_tags.FavouriteTag;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * @author icemeowzhi
 * @date 2021/9/2
 * @apiNote
 */
public class FoodTag implements INBTSerializable<CompoundNBT>,ITag
{
    String registryName;
    EnumFoodTagType tagType;
    boolean disableLike;
    boolean disableDislike;

    public FoodTag(String registryName, EnumFoodTagType tagType, boolean disableLike, boolean disableDislike) {
        this.registryName = registryName;
        this.tagType = tagType;
        this.disableLike = disableLike;
        this.disableDislike = disableDislike;
    }

    public FoodTag(CompoundNBT nbt){
        deserializeNBT(nbt);
    }

    @Override
    public String getRegistryName() {
        return registryName;
    }

    @Override
    public ITextComponent getDisplayName() {
        return FavouriteTag.translationKey("tag",registryName,"name");
    }

    public EnumFoodTagType getTagType() {
        return tagType;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putString("tag",registryName);
        nbt.putInt("type",tagType.ordinal());
        nbt.putBoolean("disableLike",disableLike);
        nbt.putBoolean("disableDislike",disableDislike);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        registryName = nbt.getString("tag");
        tagType = EnumFoodTagType.values()[nbt.getInt("type")];
        disableLike = nbt.getBoolean("disableLike");
        disableDislike = nbt.getBoolean("disableDislike");
    }

    @Override
    public String toString() {
        return "FoodTag{" +
                "registryName = '" + registryName + '\'' +
                ", tagType = " + tagType +
                '}';
    }

    public boolean match(FoodTag other) {
        return getRegistryName().equals(other.getRegistryName());
    }

    public enum EnumFoodTagType {
        INGREDIENT    (FavouriteTag.translationKey("tag.type.ingredient.name")),
        CATEGORY      (FavouriteTag.translationKey("tag.type.category.name")),
        TASTE         (FavouriteTag.translationKey("tag.type.taste.name")),
        COOKING_METHOD(FavouriteTag.translationKey("tag.type.cooking_method.name"));
        ITextComponent displayName;
        EnumFoodTagType(ITextComponent displayName){
            this.displayName = displayName;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FoodTag){
            return ((FoodTag) obj).getRegistryName().equals(getRegistryName());
        }
        return false;
    }
}

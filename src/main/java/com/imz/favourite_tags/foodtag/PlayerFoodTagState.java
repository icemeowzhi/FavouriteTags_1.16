package com.imz.favourite_tags.foodtag;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
public class PlayerFoodTagState implements INBTSerializable<CompoundNBT> {
    boolean hasRarity;
    EnumRarity rarity;
    boolean isUniqueTag;

    public PlayerFoodTagState( boolean hasRarity, EnumRarity rarity, boolean isUniqueTag) {
        this.hasRarity = hasRarity;
        this.rarity = rarity;
        this.isUniqueTag = isUniqueTag;
    }

    public PlayerFoodTagState(CompoundNBT nbt){
        deserializeNBT(nbt);
    }

    public boolean isHasRarity() {
        return hasRarity;
    }

    public void setHasRarity(boolean hasRarity) {
        this.hasRarity = hasRarity;
    }

    public EnumRarity getRarity() {
        return rarity;
    }

    public void setRarity(EnumRarity rarity) {
        this.rarity = rarity;
    }

    public boolean isUniqueTag() {
        return isUniqueTag;
    }

    public void setUniqueTag(boolean uniqueTag) {
        isUniqueTag = uniqueTag;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putBoolean("has_rarity",hasRarity);
        compoundNBT.putInt("rarity",rarity.ordinal());
        compoundNBT.putBoolean("unique",isUniqueTag);
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        hasRarity = nbt.getBoolean("has_rarity");
        rarity = EnumRarity.values()[nbt.getInt("rarity")];
        isUniqueTag = nbt.getBoolean("unique");
    }
}

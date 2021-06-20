package com.imz.favourite_tags.tag;

import com.imz.favourite_tags.Utils.Constants;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.INBTType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.io.DataOutput;
import java.io.IOException;

public enum EnumTagRarity{
    COMMON(new TranslationTextComponent(Constants.MODID + ".tag.rarity.common")),
    UNCOMMON(new TranslationTextComponent(Constants.MODID+ ".tag.rarity.uncommon")),
    RARE(new TranslationTextComponent(Constants.MODID+ ".tag.rarity.rare")),
    EPIC(new TranslationTextComponent(Constants.MODID+ ".tag.rarity.epic"));

    TranslationTextComponent displayName;
    EnumTagRarity(TranslationTextComponent displayName){
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        switch (this){
            case EPIC:
                return "epic";
            case RARE:
                return "rare";
            case UNCOMMON:
                return "uncommon";
            default:
                return "common";
        }
    }
}

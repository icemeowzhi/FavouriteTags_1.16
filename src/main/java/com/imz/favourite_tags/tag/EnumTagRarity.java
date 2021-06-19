package com.imz.favourite_tags.tag;

import com.imz.favourite_tags.Utils.Constants;
import net.minecraft.util.text.TranslationTextComponent;

public enum EnumTagRarity {
    COMMON(new TranslationTextComponent(Constants.MODID + ".tag.rarity.common")),
    UNCOMMON(new TranslationTextComponent(Constants.MODID+ ".tag.rarity.uncommon")),
    RARE(new TranslationTextComponent(Constants.MODID+ ".tag.rarity.rare")),
    EPIC(new TranslationTextComponent(Constants.MODID+ ".tag.rarity.epic"));

    TranslationTextComponent displayName;
    EnumTagRarity(TranslationTextComponent displayName){
        this.displayName = displayName;
    }
}

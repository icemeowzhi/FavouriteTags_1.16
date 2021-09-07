package com.imz.favourite_tags.foodtag;

import com.imz.favourite_tags.FavouriteTag;
import net.minecraft.util.text.ITextComponent;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
public enum EnumRarity {
    COMMON(FavouriteTag.translationKey("tag.rarity.common")),
    UNCOMMON(FavouriteTag.translationKey("tag.rarity,uncommon")),
    RARE(FavouriteTag.translationKey("tag.rarity,rare")),
    EPIC(FavouriteTag.translationKey("tag.rarity.epic"));

    ITextComponent displayName;
    EnumRarity(ITextComponent displayName){
        this.displayName = displayName;
    }

}
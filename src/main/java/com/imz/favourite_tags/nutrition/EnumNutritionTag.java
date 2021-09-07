package com.imz.favourite_tags.nutrition;

import com.imz.favourite_tags.FavouriteTag;
import net.minecraft.util.text.ITextComponent;

/**
 * @author icemeowzhi
 * @date 2021/9/2
 * @apiNote
 */
//TODO:营养系统
public enum EnumNutritionTag {
    GRAIN     (FavouriteTag.translationKey("tag.nutrition.grain.name")),
    VEGETABLE (FavouriteTag.translationKey("tag.nutrition.vegetable.name")),
    PROTEIN   (FavouriteTag.translationKey("tag.nutrition.protein.name")),
    MILK      (FavouriteTag.translationKey("tag.nutrition.milk.name")),
    FRUIT     (FavouriteTag.translationKey("tag.nutrition.fruit.name"));

    ITextComponent displayName;
    EnumNutritionTag(ITextComponent displayName){
        this.displayName = displayName;
    }
}

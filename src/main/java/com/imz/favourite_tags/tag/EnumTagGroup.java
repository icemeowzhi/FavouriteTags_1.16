package com.imz.favourite_tags.tag;

public enum EnumTagGroup {
    FOODS_LIKE(EnumCategory.INTEREST),FOODS_DISLIKE(EnumCategory.INTEREST),FOODS_BOTH(EnumCategory.INTEREST),FOOD_ITEM_TAG(EnumCategory.ITEM_TAG),NONE(EnumCategory.NONE);
    //FOOD_ITEM_TAG just use for register food tags,which can contain tags of FOODS_LIKE,FOODS_DISLIKE,FOODS_BOTH
    private final EnumCategory category;

    EnumTagGroup(EnumCategory category){
        this.category = category;
    }

    public EnumCategory getCategory(){
        return category;
    }
}
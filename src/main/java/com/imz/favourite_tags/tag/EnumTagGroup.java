package com.imz.favourite_tags.tag;

public enum EnumTagGroup {
    FOODS_LIKE(EnumCategory.INTEREST),FOODS_DISLIKE(EnumCategory.INTEREST);

    //TODO:getTags()
    private final EnumCategory category;

    EnumTagGroup(EnumCategory category){
        this.category = category;
    }

    EnumCategory getCategory(){
        return category;
    }
}

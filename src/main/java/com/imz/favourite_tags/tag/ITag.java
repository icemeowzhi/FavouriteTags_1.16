package com.imz.favourite_tags.tag;


public interface ITag {
    //basic tag behaviour
    String getRegistryName();
    void setRegistryName(String registryName);

    String getDisplayName();
    void setDisplayName(String displayName);

    EnumTagRarity getTagRarity();
    void setTagRarity(EnumTagRarity tagLevel);

}

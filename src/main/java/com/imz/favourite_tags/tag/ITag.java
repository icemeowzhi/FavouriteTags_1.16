package com.imz.favourite_tags.tag;

import org.lwjgl.system.CallbackI;

public interface ITag {
    //basic tag behaviour
    String getRegistryName();
    void setRegistryName(String registryName);

    String getDisplayName();
    void setDisplayName(String displayName);

    EnumTagLevel getTagLevel();
    void setTagLevel(EnumTagLevel tagLevel);

}

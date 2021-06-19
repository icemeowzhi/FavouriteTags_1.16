package com.imz.favourite_tags.tag;


import java.util.ArrayList;

public interface ITags {
    //basic tags behaviour

    EnumTagGroup getTagsGroup();

    ArrayList<ITag> getAllTags();
    ITag getTag(String tagRegistryName);

    boolean hasTag(String tagRegistryName);
    boolean hasTag(ITag tag);
    boolean addTags(ArrayList<ITag> tags);
    boolean delTags(ArrayList<ITag> tags);

    boolean addTag(ITag tag);
    boolean delTag(ITag tag);

}

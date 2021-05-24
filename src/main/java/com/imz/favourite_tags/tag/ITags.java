package com.imz.favourite_tags.tag;


import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.HashMap;

public interface ITags {
    //basic tags behaviour

    EnumTagGroup getTagsGroup();

    HashMap<TagsTopic, ArrayList<ITag>> getTopicAndTags();
    void setTopicAndTags(HashMap<TagsTopic,ArrayList<ITag>> tags);
    void addTopicAndTags(TagsTopic topic,ArrayList<ITag> tags);
    void addTags(TagsTopic topic,ArrayList<ITag> tags);
    void delTags(TagsTopic topic,ArrayList<ITag> tags);
    void addTag(TagsTopic topic,ITag tag);
    void delTag(TagsTopic topic,ITag tag);

    boolean hasTopic(TagsTopic topic);
    boolean hasTag(TagsTopic topic, ITag tag);
    ITag getTag(TagsTopic topic, String tagRegistryName);


    class TagsTopic{

        String registryName;
        String displayName;

        @Override
        public String toString() {
            return "TagsTopic{" +
                    "displayName='" + displayName + '\'' +
                    '}';
        }

        public TagsTopic(String registryName, String displayName) {
            this.registryName = registryName;
            this.displayName = displayName;
        }

        public String getRegistryName() {
            return registryName;
        }

        public void setRegistryName(String registryName) {
            this.registryName = registryName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }
}

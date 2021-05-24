package com.imz.favourite_tags.tag;

import java.util.ArrayList;
import java.util.HashMap;

public class FoodTags implements ITags{

    EnumTagGroup tagGroup = EnumTagGroup.FOODS;
    HashMap<TagsTopic, ArrayList<ITag>> topicAndTags = new HashMap<>();



    @Override
    public EnumTagGroup getTagsGroup() {
        return tagGroup;
    }

    @Override
    public HashMap<TagsTopic, ArrayList<ITag>> getTopicAndTags() {
        return topicAndTags;
    }

    @Override
    public void setTopicAndTags(HashMap<TagsTopic, ArrayList<ITag>>tags) {
        topicAndTags = tags;
    }

    @Override
    public void addTopicAndTags(TagsTopic topic, ArrayList<ITag> tags) {
        topicAndTags.put(topic,tags);
    }

    @Override
    public void addTags(TagsTopic topic, ArrayList<ITag> tags) {
        topicAndTags.get(topic).addAll(tags);
    }

    @Override
    public void delTags(TagsTopic topic, ArrayList<ITag> tags) {
        topicAndTags.get(topic).removeAll(tags); //check first
    }

    @Override
    public void addTag(TagsTopic topic, ITag tag) {
        topicAndTags.get(topic).add(tag);
    }

    @Override
    public void delTag(TagsTopic topic, ITag tag) {
        topicAndTags.get(topic).remove(tag);

    }

    @Override
    public boolean hasTopic(TagsTopic topic) {
        return topicAndTags.containsKey(topic);
    }

    @Override
    public boolean hasTag(TagsTopic topic, ITag tag) {
        return topicAndTags.get(topic).contains(tag);
    }

    @Override
    public ITag getTag(TagsTopic topic, String tagRegistryName) {
        for (ITag tag : topicAndTags.get(topic)){
            if (tag.getRegistryName().equals(tagRegistryName)){return tag;}
        }
        return null;
    }
    //define food tag group
}

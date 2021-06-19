package com.imz.favourite_tags.tag;


import org.lwjgl.system.CallbackI;

import java.util.ArrayList;

public class FoodTags implements ITags{

    EnumTagGroup group ;
    ArrayList<ITag> tags;

    public FoodTags(EnumTagGroup group){
        this.group = group;
        tags = new ArrayList<>();
    }

    public FoodTags(EnumTagGroup group,ArrayList<ITag> tags){
        this.group = group;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "FoodTags{" +
                "group=" + group +
                ", tags=" + tags +
                '}';
    }

    @Override
    public EnumTagGroup getTagsGroup() {
        return group;
    }

    @Override
    public ArrayList<ITag> getAllTags() {
        return tags;
    }

    @Override
    public ITag getTag(String tagRegistryName) {
        for (ITag tag : tags){
            if (tag.getRegistryName().equals(tagRegistryName)){
                return tag;
            }
        }
        return null;
    }

    @Override
    public boolean hasTag(ITag tag) {
        for (ITag oneTag : tags){
            if (oneTag.getRegistryName().equals(tag.getRegistryName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasTag(String tagRegistryName) {
        for (ITag oneTag : tags){
            if (oneTag.getRegistryName().equals(tagRegistryName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addTags(ArrayList<ITag> tags) {
        return this.tags.addAll(tags);
    }

    @Override
    public boolean delTags(ArrayList<ITag> tags) {
        return this.tags.removeAll(tags);
    }

    @Override
    public boolean addTag(ITag tag) {
        return this.tags.add(tag);
    }

    @Override
    public boolean delTag(ITag tag) {
        return this.tags.remove(tag);
    }


    //define food tag group
}

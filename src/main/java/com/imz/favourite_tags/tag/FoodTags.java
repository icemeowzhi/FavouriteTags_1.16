package com.imz.favourite_tags.tag;


import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

import java.util.ArrayList;
import java.util.Objects;

public class FoodTags implements ITags{

    EnumTagGroup group ;
    ArrayList<ITag> tags;

    public FoodTags(){
        this.group = EnumTagGroup.NONE;
        tags = new ArrayList<>();
    }

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

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt("group", group.ordinal());
        ListNBT list = new ListNBT();
        for(ITag tag : tags){
            list.add(tag.serializeNBT());
        }
        compoundNBT.put("tags", list);
        return compoundNBT;
    }
    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        group = EnumTagGroup.values()[nbt.getInt("group")];
        ArrayList<ITag> newArr = new ArrayList<>();
        for (int i = 0; i < ((ListNBT) Objects.requireNonNull(nbt.get("tags"))).size() ; i++){
            FoodTag foodTag = new FoodTag();
            foodTag.deserializeNBT((CompoundNBT) ((ListNBT) Objects.requireNonNull(nbt.get("tags"))).get(i));
            newArr.add(foodTag);
        }
        tags = newArr;

        /*
        for (int i = 0; i < tags.size() ; i++){ //((ListNBT) Objects.requireNonNull(nbt.get("tags"))).size()
            tags.get(i).deserializeNBT((CompoundNBT) ((ListNBT) Objects.requireNonNull(nbt.get("tags"))).get(i));
        }

         */
    }


    //define food tag group
}

package com.imz.favourite_tags.capabilities;

import com.imz.favourite_tags.tag.ITags;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

import java.util.ArrayList;
import java.util.Objects;

public class PlayerTagCapability implements IPlayerTagCapability{
    private ArrayList<ITags> allTags;

    public PlayerTagCapability(ArrayList<ITags> allTags){
        this.allTags = allTags;
    }

    public PlayerTagCapability(ITags tags){
        ArrayList<ITags> allTags = new ArrayList<>();
        allTags.add(tags);
        this.allTags = allTags;
    }

    public PlayerTagCapability(){
        this.allTags = new ArrayList<>();
    }

    @Override
    public ArrayList<ITags> getAllTags() {
        return allTags;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        ListNBT list = new ListNBT();
        for (ITags tags : allTags){
            list.add(tags.serializeNBT());
        }
        compoundNBT.put("all_tags", list);
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {

        for (int i = 0; i< allTags.size() ; i++){ //((ListNBT) Objects.requireNonNull(nbt.get("all_tags"))).size()
            allTags.get(i).deserializeNBT((CompoundNBT) ((ListNBT) Objects.requireNonNull(nbt.get("all_tags"))).get(i));
        }


/*
        ArrayList<ITags> newArr = new ArrayList<>();
        for (int i = 0; i < ((ListNBT) Objects.requireNonNull(nbt.get("all_tags"))).size() ; i++){
            FoodTags foodTags = new FoodTags();
            foodTags.deserializeNBT((CompoundNBT) ((ListNBT) Objects.requireNonNull(nbt.get("all_tags"))).get(i));
            newArr.add(foodTags);
        }
        allTags = newArr;

 */

    }

}


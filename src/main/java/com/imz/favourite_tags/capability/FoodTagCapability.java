package com.imz.favourite_tags.capability;

import com.imz.favourite_tags.tag.*;
import net.minecraft.nbt.CompoundNBT;

import java.util.ArrayList;
import java.util.Objects;

public class FoodTagCapability implements IFoodTagCapability{

    FoodTags foodTags;

    public FoodTagCapability(FoodTags foodTags){
        this.foodTags = foodTags;
    }

    public FoodTagCapability(EnumTagGroup group, FoodTag foodTag){
        ArrayList<ITag> tags = new ArrayList<>();
        tags.add(foodTag);
        foodTags = new FoodTags(group, tags);
    }

    public FoodTagCapability(EnumTagGroup group){
        foodTags = new FoodTags(group, new ArrayList<>());
    }

    @Override
    public FoodTags getTags() {
        return foodTags;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.put("tags",foodTags.serializeNBT());
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        foodTags.deserializeNBT((CompoundNBT) Objects.requireNonNull(nbt.get("tags")));
    }
}

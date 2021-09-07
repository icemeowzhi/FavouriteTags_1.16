package com.imz.favourite_tags.capability.food_tag_capability;

import com.imz.favourite_tags.foodtag.FoodTag;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
public class FoodTagCapability implements IFoodTagCapability{
    List<FoodTag> foodTags;

    public FoodTagCapability(List<FoodTag> foodTags) {
        this.foodTags = foodTags;
    }

    public FoodTagCapability(FoodTag foodTag) {
        foodTags = Collections.singletonList(foodTag);
    }

    @Override
    public List<FoodTag> getFoodTags() {
        return foodTags;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        ListNBT listNBT = new ListNBT();
        for (FoodTag foodTag:foodTags){
            listNBT.add(foodTag.serializeNBT());
        }
        nbt.put("tags",listNBT);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        ListNBT listNBT = (ListNBT) nbt.get("tags");
        foodTags = new ArrayList<>();
        assert listNBT != null;
        for (INBT foodTagNBT:listNBT){
            FoodTag tag = new FoodTag((CompoundNBT) foodTagNBT);
            foodTags.add(tag);
        }

    }
}

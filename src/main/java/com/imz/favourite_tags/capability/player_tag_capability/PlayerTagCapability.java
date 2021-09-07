package com.imz.favourite_tags.capability.player_tag_capability;

import com.imz.favourite_tags.foodtag.FoodTag;
import com.imz.favourite_tags.foodtag.PlayerFoodTagState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

import java.util.HashMap;
import java.util.Map;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
public class PlayerTagCapability implements IPlayerTagCapability{
    Map<FoodTag, PlayerFoodTagState> foodLike;
    Map<FoodTag, PlayerFoodTagState> foodDislike;

    public PlayerTagCapability(Map<FoodTag, PlayerFoodTagState> foodLike, Map<FoodTag, PlayerFoodTagState> foodDislike) {
        this.foodLike = foodLike;
        this.foodDislike = foodDislike;
    }

    @Override
    public Map<FoodTag, PlayerFoodTagState> getLike() {
        return foodLike;
    }

    @Override
    public Map<FoodTag, PlayerFoodTagState> getDisLike() {
        return foodDislike;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();

        ListNBT foodLikeKey = new ListNBT();
        ListNBT foodLikeValue = new ListNBT();
        for (FoodTag foodTag: foodLike.keySet()){
            foodLikeKey.add(foodTag.serializeNBT());
            foodLikeValue.add(foodLike.get(foodTag).serializeNBT());
        }

        ListNBT foodDislikeKey = new ListNBT();
        ListNBT foodDislikeValue = new ListNBT();
        for (FoodTag foodTag: foodDislike.keySet()){
            foodDislikeKey.add(foodTag.serializeNBT());
            foodDislikeValue.add(foodDislike.get(foodTag).serializeNBT());
        }

        nbt.put("food_like_key",foodLikeKey);
        nbt.put("food_like_value",foodLikeValue);
        nbt.put("food_dislike_key",foodDislikeKey);
        nbt.put("food_dislike_value",foodDislikeValue);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        Map<FoodTag, PlayerFoodTagState> newFoodLike = new HashMap<>();
        ListNBT foodLikeKey = (ListNBT) nbt.get("food_like_key");
        ListNBT foodLikeValue = (ListNBT) nbt.get("food_like_value");

        assert foodLikeKey != null;
        assert foodLikeValue != null;
        for (int i = 0; i < foodLikeKey.size(); i++) {
            FoodTag key = new FoodTag(foodLikeKey.getCompound(i));
            PlayerFoodTagState value = new PlayerFoodTagState(foodLikeValue.getCompound(i));
            newFoodLike.put(key,value);
        }
        foodLike = newFoodLike;

        Map<FoodTag, PlayerFoodTagState> newFoodDislike = new HashMap<>();
        ListNBT foodDislikeKey = (ListNBT) nbt.get("food_dislike_key");
        ListNBT foodDislikeValue = (ListNBT) nbt.get("food_dislike_value");

        assert foodDislikeKey != null;
        assert foodDislikeValue != null;
        for (int i = 0; i < foodDislikeKey.size(); i++) {
            FoodTag key = new FoodTag(foodDislikeKey.getCompound(i));
            PlayerFoodTagState value = new PlayerFoodTagState(foodDislikeValue.getCompound(i));
            newFoodDislike.put(key,value);
        }
        foodDislike = newFoodDislike;
    }
}

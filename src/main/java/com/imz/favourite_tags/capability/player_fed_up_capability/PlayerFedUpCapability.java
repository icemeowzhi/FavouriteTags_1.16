package com.imz.favourite_tags.capability.player_fed_up_capability;

import com.imz.favourite_tags.foodtag.FoodTag;
import com.imz.favourite_tags.foodtag.PlayerFedUpState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

import java.util.HashMap;
import java.util.Map;

/**
 * @author icemeowzhi
 * @date 2021/9/5
 * @apiNote
 */
public class PlayerFedUpCapability implements IPlayerFedUpCapability{
    Map<FoodTag, PlayerFedUpState> foodTagFedUp;

    public PlayerFedUpCapability(Map<FoodTag, PlayerFedUpState> foodTagFedUp) {
        this.foodTagFedUp = foodTagFedUp;
    }

    @Override
    public Map<FoodTag, PlayerFedUpState> getFoodTagFedUp() {
        return foodTagFedUp;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();

        ListNBT fedUpKey = new ListNBT();
        ListNBT fedUpValue = new ListNBT();
        for (FoodTag foodTag: foodTagFedUp.keySet()){
            fedUpKey.add(foodTag.serializeNBT());
            fedUpValue.add(foodTagFedUp.get(foodTag).serializeNBT());
        }

        nbt.put("fed_up_key",fedUpKey);
        nbt.put("fed_up_value",fedUpValue);

        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        Map<FoodTag, PlayerFedUpState> newFedUpMap = new HashMap<>();
        ListNBT fedUpKey = (ListNBT) nbt.get("fed_up_key");
        ListNBT fedUpValue = (ListNBT) nbt.get("fed_up_value");

        assert fedUpKey != null;
        assert fedUpValue != null;
        for (int i = 0; i < fedUpKey.size(); i++) {
            FoodTag key = new FoodTag(fedUpKey.getCompound(i));
            PlayerFedUpState value = new PlayerFedUpState(fedUpValue.getCompound(i));
            newFedUpMap.put(key,value);
        }

        foodTagFedUp = newFedUpMap;
    }
}

package com.imz.favourite_tags.capability.player_fed_up_capability;

import com.imz.favourite_tags.foodtag.FoodTag;
import com.imz.favourite_tags.foodtag.PlayerFedUpState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.Map;

/**
 * @author icemeowzhi
 * @date 2021/9/5
 * @apiNote
 */
public interface IPlayerFedUpCapability extends INBTSerializable<CompoundNBT> {
    Map<FoodTag, PlayerFedUpState> getFoodTagFedUp();
}

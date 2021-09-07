package com.imz.favourite_tags.capability.player_tag_capability;

import com.imz.favourite_tags.foodtag.FoodTag;
import com.imz.favourite_tags.foodtag.PlayerFoodTagState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.Map;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
public interface IPlayerTagCapability extends INBTSerializable<CompoundNBT> {
    Map<FoodTag, PlayerFoodTagState> getLike();
    Map<FoodTag, PlayerFoodTagState> getDisLike();
}

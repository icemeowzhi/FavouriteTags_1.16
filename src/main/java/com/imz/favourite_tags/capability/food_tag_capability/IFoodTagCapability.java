package com.imz.favourite_tags.capability.food_tag_capability;

import com.imz.favourite_tags.foodtag.FoodTag;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.List;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
public interface IFoodTagCapability extends INBTSerializable<CompoundNBT> {
    List<FoodTag> getFoodTags();
}

package com.imz.favourite_tags.capabilities;

import com.imz.favourite_tags.tag.FoodTags;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface IFoodTagCapability extends INBTSerializable<CompoundNBT> {
    FoodTags getTags();
}

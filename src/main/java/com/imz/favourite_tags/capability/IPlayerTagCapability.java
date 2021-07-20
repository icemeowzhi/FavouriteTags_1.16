package com.imz.favourite_tags.capability;

import com.imz.favourite_tags.tag.ITags;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.ArrayList;

public interface IPlayerTagCapability extends INBTSerializable<CompoundNBT> {
    ArrayList<ITags> getAllTags();
}

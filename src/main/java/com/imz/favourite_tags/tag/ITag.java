package com.imz.favourite_tags.tag;


import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface ITag extends INBTSerializable<CompoundNBT> {
    //basic tag behaviour
    String getRegistryName();
    void setRegistryName(String registryName);

    String getDisplayName();
    void setDisplayName(String displayName);

    EnumTagRarity getTagRarity();
    void setTagRarity(EnumTagRarity tagLevel);

}

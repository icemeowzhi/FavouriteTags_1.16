package com.imz.favourite_tags.tag;


import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.INBTSerializable;

public interface ITag extends INBTSerializable<CompoundNBT> {
    //basic tag behaviour
    String getRegistryName();
    void setRegistryName(String registryName);

    TranslationTextComponent getDisplayName();

    EnumTagRarity getTagRarity();
    void setTagRarity(EnumTagRarity tagRarity);
    ITag withRarity(EnumTagRarity tagRarity);

    EnumTagGroup getGroup();
    void setGroup(EnumTagGroup group);

}

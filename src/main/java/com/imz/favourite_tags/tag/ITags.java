package com.imz.favourite_tags.tag;


import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.ArrayList;

public interface ITags extends INBTSerializable<CompoundNBT> {
    //basic tags behaviour

    EnumTagGroup getTagsGroup(); //group just effects on player,not on items.

    ArrayList<ITag> getAllTags();
    ITag getTag(String tagRegistryName);

    boolean hasTag(String tagRegistryName);
    boolean hasTag(ITag tag);
    boolean addTags(ArrayList<ITag> tags);
    boolean delTags(ArrayList<ITag> tags);

    boolean addTag(ITag tag);
    boolean delTag(ITag tag);

}

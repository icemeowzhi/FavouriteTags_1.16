package com.imz.favourite_tags.capabilities;

import com.imz.favourite_tags.tag.ITags;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;

import java.util.ArrayList;

public class PlayerTagCapability implements IPlayerTagCapability{
    private ArrayList<ITags> allTags;

    public PlayerTagCapability(ArrayList<ITags> allTags){
        this.allTags = allTags;
    }

    public PlayerTagCapability(ITags tags){
        ArrayList<ITags> allTags = new ArrayList<>();
        allTags.add(tags);
        this.allTags = allTags;
    }

    @Override
    public ArrayList<ITags> getAllTags() {
        return allTags;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.put("all_tags", (INBT) this.allTags);
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.allTags = (ArrayList<ITags>) nbt.get("all_tags");
    }
}


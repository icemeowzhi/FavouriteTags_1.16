package com.imz.favourite_tags.foodtag;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * @author icemeowzhi
 * @date 2021/9/5
 * @apiNote
 */
public class PlayerFedUpState implements INBTSerializable<CompoundNBT> {
    int currentFedUp;
    int maxFedUp;

    public PlayerFedUpState(int currentFedUp, int maxFedUp) {
        this.currentFedUp = currentFedUp;
        this.maxFedUp = maxFedUp;
    }

    public PlayerFedUpState(CompoundNBT nbt){
        deserializeNBT(nbt);
    }

    public int getCurrentFedUp() {
        return currentFedUp;
    }

    public void setCurrentFedUp(int currentFedUp) {
        this.currentFedUp = currentFedUp;
    }

    public int getMaxFedUp() {
        return maxFedUp;
    }

    public void setMaxFedUp(int maxFedUp) {
        this.maxFedUp = maxFedUp;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("current_fed_up", currentFedUp);
        nbt.putInt("max_fed_up",maxFedUp);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        currentFedUp = nbt.getInt("current_fed_up");
        maxFedUp = nbt.getInt("max_fed_up");
    }
}

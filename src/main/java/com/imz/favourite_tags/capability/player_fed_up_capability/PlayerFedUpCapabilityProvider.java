package com.imz.favourite_tags.capability.player_fed_up_capability;

import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.foodtag.FoodTag;
import com.imz.favourite_tags.foodtag.PlayerFedUpState;
import com.imz.favourite_tags.intance.TagInitializer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author icemeowzhi
 * @date 2021/9/5
 * @apiNote
 */
public class PlayerFedUpCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {
    private PlayerFedUpCapability playerFedUpCapability;
    private final PlayerEntity player;

    public PlayerFedUpCapabilityProvider(PlayerEntity player) {
        this.player = player;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CapabilityHandler.PLAYER_FED_UP_CAPABILITY ? LazyOptional.of(this::getOrCreateCapability).cast() : LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT() {
        return getOrCreateCapability().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        getOrCreateCapability().deserializeNBT(nbt);
    }

    @Nonnull
    PlayerFedUpCapability getOrCreateCapability(){
        if(playerFedUpCapability == null){

            Map<FoodTag, PlayerFedUpState> newFedUpMap = new HashMap<>();

            for (FoodTag foodTag:TagInitializer.getAllFoodTags()){
                newFedUpMap.put(foodTag,new PlayerFedUpState(0,50+new Random().nextInt(51)));
            }

            playerFedUpCapability = new PlayerFedUpCapability(newFedUpMap);

        }
        return playerFedUpCapability;
    }
}

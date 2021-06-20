package com.imz.favourite_tags.capabilities;

import com.imz.favourite_tags.tag.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

public class PlayerTagCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {
    private PlayerTagCapability playerTagCapability;
    private final PlayerEntity player;

    public PlayerTagCapabilityProvider(PlayerEntity playerIn){
        super();
        player = playerIn;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CapabilityHandler.PLAYER_TAG_CAPABILITY ? LazyOptional.of(this::getOrCreateCapability).cast() : LazyOptional.empty();
    }

    @Nonnull
    PlayerTagCapability getOrCreateCapability(){
        if (playerTagCapability == null){
            ITags like = TagsInitializer.createPlayerTags(EnumTagGroup.FOODS_LIKE);
            ITags dislike = TagsInitializer.createPlayerTags(EnumTagGroup.FOODS_DISLIKE);
            ArrayList<ITags> allTags =new ArrayList<>();
            allTags.add(like);
            allTags.add(dislike);
            playerTagCapability = new PlayerTagCapability(allTags);
        }
        return playerTagCapability;
    }


    @Override
    public CompoundNBT serializeNBT() {
        return getOrCreateCapability().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        getOrCreateCapability().deserializeNBT(nbt);
    }
}

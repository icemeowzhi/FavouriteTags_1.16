package com.imz.favourite_tags.capability;

import com.imz.favourite_tags.tag.FoodTags;
import com.imz.favourite_tags.tag.ITags;
import com.imz.favourite_tags.tag.TagsInitializer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FoodTagCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {
    private IFoodTagCapability foodTagCapability;
    private final ItemStack itemStack;

    public FoodTagCapabilityProvider(ItemStack itemStack){
        super();
        this.itemStack = itemStack;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CapabilityHandler.FOOD_TAG_CAPABILITY ? LazyOptional.of(() -> getOrCreateCapability(itemStack)).cast() : LazyOptional.empty();
    }

    @Nonnull
    IFoodTagCapability getOrCreateCapability(ItemStack itemStack){
        if (foodTagCapability == null){
            ITags tags = TagsInitializer.createItemTags(itemStack);
            foodTagCapability = new FoodTagCapability((FoodTags) tags);
        }
        return foodTagCapability;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return getOrCreateCapability(itemStack).serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        getOrCreateCapability(itemStack).deserializeNBT(nbt);
    }
}

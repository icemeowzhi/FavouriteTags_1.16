package com.imz.favourite_tags.capability.food_tag_capability;

import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.intance.TaggedFoodInitializer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
public class FoodTagCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {
    private IFoodTagCapability foodTagCapability;
    private final ItemStack itemStack;

    public FoodTagCapabilityProvider(ItemStack itemStack) {
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
            foodTagCapability = new FoodTagCapability(Arrays.asList(TaggedFoodInitializer.FOOD_TAG_MAP.get(itemStack.getItem())));
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

package com.imz.favourite_tags.capability.player_tag_capability;

import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.foodtag.FoodTag;
import com.imz.favourite_tags.foodtag.PlayerFoodTagState;
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
import java.util.List;
import java.util.Map;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
public class PlayerTagCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {

    private PlayerTagCapability playerTagCapability;
    private final PlayerEntity player;

    public PlayerTagCapabilityProvider(PlayerEntity player) {
        this.player = player;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CapabilityHandler.PLAYER_TAG_CAPABILITY ? LazyOptional.of(this::getOrCreateCapability).cast() : LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT() {
        return getOrCreateCapability().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        getOrCreateCapability().deserializeNBT(nbt);
    }

    /**
     * 1.阻止存在已经注册的标签，但是没有这个标签的食物的情况下将这个标签赋予玩家。
     * 2.保证tag的唯一性。
     */
    @Nonnull
    PlayerTagCapability getOrCreateCapability(){
        if (playerTagCapability == null){
            Map<FoodTag, PlayerFoodTagState> foodLike;
            Map<FoodTag, PlayerFoodTagState> foodDislike;
            List<FoodTag> ignoredTag = new ArrayList<>();

            //1.阻止存在已经注册的标签，但是没有这个标签的食物的情况下将这个标签赋予玩家。
            /*
            for (FoodTag foodTag : TagInitializer.getAllFoodTags()){
                boolean isValidTag = false;
                for (FoodTag[] tagsInFood : TaggedFoodInitializer.getFoodTagMap().values()){
                    for (FoodTag everyTagInFood : tagsInFood){
                        if (foodTag.match(everyTagInFood)){isValidTag = true;}
                    }
                }
                if (!isValidTag){ignoredTag.add(foodTag);}
            }

             */

            //2.保证tag的唯一性，生成tag。
            foodLike = PlayerTagCapabilityInitializer.createFoodLike(ignoredTag,player);
            ignoredTag.addAll(foodLike.keySet());
            foodDislike = PlayerTagCapabilityInitializer.createFoodDislike(ignoredTag);
            playerTagCapability = new PlayerTagCapability(foodLike,foodDislike);

        }
        return playerTagCapability;
    }
}

package com.imz.favourite_tags.capability.player_tag_capability;

import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.capability.player_fed_up_capability.IPlayerFedUpCapability;
import com.imz.favourite_tags.foodtag.EnumRarity;
import com.imz.favourite_tags.foodtag.FoodTag;
import com.imz.favourite_tags.foodtag.PlayerFoodTagState;
import com.imz.favourite_tags.intance.TagInitializer;
import com.imz.favourite_tags.util.Const;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nullable;
import java.util.*;

/**
 * @author icemeowzhi
 * @date 2021/9/5
 * @apiNote
 */
public class PlayerTagCapabilityInitializer {

    public static Map<FoodTag, PlayerFoodTagState> createFoodLike(@Nullable List<FoodTag> ignoredTag, PlayerEntity playerEntity){
        @SuppressWarnings("unchecked")
        List<FoodTag> allTags = (List<FoodTag>) ((ArrayList<FoodTag>) TagInitializer.getAllFoodTags()).clone();
        Random random = new Random();
        Map<FoodTag, PlayerFoodTagState> foodLike = new HashMap<>();
        LazyOptional<IPlayerFedUpCapability> playerFedUpCapabilityLazyOptional = playerEntity.getCapability(CapabilityHandler.PLAYER_FED_UP_CAPABILITY);

        if (ignoredTag != null){
            for (FoodTag foodTag:ignoredTag){
                allTags.remove(foodTag);
            }
        }

        List<FoodTag> allCategoryTag = new ArrayList<>();

        for (int i = 0; i < allTags.size(); i++) {
            if(allTags.get(i).getTagType() == FoodTag.EnumFoodTagType.CATEGORY){
                allCategoryTag.add(allTags.remove(i));
            }
        }

        int epic     = random.nextInt(Const.maxEpicCount+1);
        int rare     = random.nextInt(Const.maxRareCount+1);
        int uncommon = random.nextInt(Const.maxUncommonCount+1);
        int common   = random.nextInt(Const.maxCommonCount+1);

        for (int i = 0; i < epic; i++) {
            FoodTag foodTag =allTags.remove(random.nextInt(allTags.size()));
            foodLike.put(foodTag,
                    new PlayerFoodTagState(true, EnumRarity.EPIC,false));
            playerFedUpCapabilityLazyOptional.ifPresent((cap)-> {
                for (FoodTag foodTagInFedUpList:cap.getFoodTagFedUp().keySet()){
                    if (foodTag.match(foodTagInFedUpList)){
                        cap.getFoodTagFedUp().get(foodTagInFedUpList).setMaxFedUp(150);
                    }
                }
            });
        }

        //此处将type类加回
        allTags.addAll(allCategoryTag);

        for (int i = 0; i < rare; i++) {
            FoodTag foodTag = allTags.remove(random.nextInt(allTags.size()));
            foodLike.put(foodTag,
                    new PlayerFoodTagState(true, EnumRarity.RARE,false));
            playerFedUpCapabilityLazyOptional.ifPresent((cap)-> {
                for (FoodTag foodTagInFedUpList:cap.getFoodTagFedUp().keySet()){
                    if (foodTag.match(foodTagInFedUpList)){
                        cap.getFoodTagFedUp().get(foodTagInFedUpList).setMaxFedUp(150);
                    }
                }
            });
        }

        for (int i = 0; i < uncommon; i++) {
            FoodTag foodTag = allTags.remove(random.nextInt(allTags.size()));
            foodLike.put(foodTag,
                    new PlayerFoodTagState(true, EnumRarity.UNCOMMON,false));
            playerFedUpCapabilityLazyOptional.ifPresent((cap)-> {
                for (FoodTag foodTagInFedUpList:cap.getFoodTagFedUp().keySet()){
                    if (foodTag.match(foodTagInFedUpList)){
                        cap.getFoodTagFedUp().get(foodTagInFedUpList).setMaxFedUp(100+random.nextInt(51));
                    }
                }
            });
        }

        for (int i = 0; i < common; i++) {
            FoodTag foodTag = allTags.remove(random.nextInt(allTags.size()));
            foodLike.put(foodTag,
                    new PlayerFoodTagState(true, EnumRarity.COMMON,false));
            playerFedUpCapabilityLazyOptional.ifPresent((cap)-> {
                for (FoodTag foodTagInFedUpList:cap.getFoodTagFedUp().keySet()){
                    if (foodTag.match(foodTagInFedUpList)){
                        cap.getFoodTagFedUp().get(foodTagInFedUpList).setMaxFedUp(100+random.nextInt(21));
                    }
                }
            });
        }

        return foodLike;
    }

    public static Map<FoodTag, PlayerFoodTagState> createFoodDislike(@Nullable List<FoodTag> ignoredTag){
        @SuppressWarnings("unchecked")
        List<FoodTag> allTags = (List<FoodTag>) ((ArrayList<FoodTag>) TagInitializer.getAllFoodTags()).clone();
        Random random = new Random();
        Map<FoodTag, PlayerFoodTagState> foodDislike = new HashMap<>();

        if (ignoredTag != null){
            for (FoodTag foodTag:ignoredTag){
                allTags.remove(foodTag);
            }
        }

        int dislike = random.nextInt(Const.maxDislikeCount);

        for (int i = 0; i < dislike; i++) {
            foodDislike.put(allTags.remove(random.nextInt(allTags.size())),
                    new PlayerFoodTagState(false, EnumRarity.COMMON,false));
        }

        return foodDislike;
    }

}

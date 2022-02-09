package com.imz.favourite_tags.foodtag;

import com.google.common.collect.Lists;
import com.imz.favourite_tags.FavouriteTag;
import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.intance.TaggedFoodInitializer;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Map;

/**
 * @author icemeowzhi
 * @date 2021/9/28
 * @apiNote
 */

//TODO:cake support test
@Mod.EventBusSubscriber(modid = FavouriteTag.MODID)
public class CakeSupport {
    private static Map<FoodTag, PlayerFoodTagState> playerTagLike;
    private static Map<FoodTag, PlayerFoodTagState> playerTagDislike;
    private static List<FoodTag> cakeTag;
/*
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onSetup(FMLCommonSetupEvent event){
         cakeTag = Lists.newArrayList(TaggedFoodInitializer.getFoodTagMap().get(Items.CAKE));
    }

 */

    @SubscribeEvent
    public static void onCakeRightClicked(PlayerInteractEvent.RightClickBlock event){

        if (event.getWorld().getBlockState(event.getHitVec().getPos()).getBlock().equals(Blocks.CAKE)){
            if (event.getPlayer().canEat(false)){
                PlayerEntity playerEntity = (PlayerEntity) event.getEntity();
                playerEntity.getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY).ifPresent((cap)->{
                    playerTagLike = cap.getLike();
                    playerTagDislike = cap.getDisLike();
                });

                if (playerTagLike == null || playerTagDislike == null){
                    return;
                }

                cakeTag = Lists.newArrayList(TaggedFoodInitializer.getFoodTagMap().get(Items.CAKE));

                for (FoodTag itemTag: cakeTag){

                    for (FoodTag playerTag : playerTagLike.keySet()){
                        if (itemTag.match(playerTag)){
                            switch (playerTagLike.get(playerTag).rarity){
                                case EPIC:
                                    FoodTagEffectLogic.epicEffectStart(playerEntity);
                                    FoodTagEffectLogic.epicEffectFinish(playerEntity,2,0.1f);
                                    break;
                                case RARE:
                                    FoodTagEffectLogic.rareEffectStart(playerEntity);
                                    FoodTagEffectLogic.rareEffectFinish(playerEntity,2,0.1f);
                                    break;
                                case UNCOMMON:
                                    FoodTagEffectLogic.uncommonEffectStart(playerEntity);
                                    FoodTagEffectLogic.uncommonEffectFinish(playerEntity,2,0.1f);
                                    break;
                                case COMMON:
                                    FoodTagEffectLogic.commonEffectStart(playerEntity);
                                    FoodTagEffectLogic.commonEffectFinish(playerEntity,2,0f);
                                    break;
                                default:
                            }
                        }
                    }

                    for (FoodTag playerTag : playerTagDislike.keySet()){
                        if (itemTag.match(playerTag)){
                            FoodTagEffectLogic.badEffectStart(playerEntity);
                            FoodTagEffectLogic.badEffectFinish(playerEntity,2,0f);
                            return;
                        }
                    }
                }
            }
        }
    }
}

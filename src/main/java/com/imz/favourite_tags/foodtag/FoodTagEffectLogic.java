package com.imz.favourite_tags.foodtag;

import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.network.FoodStatSyncPack;
import com.imz.favourite_tags.network.NetworkHandler;
import com.imz.favourite_tags.network.SoundPack;
import com.imz.favourite_tags.util.CoolDown;
import com.imz.favourite_tags.util.RandomText;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.FoodStats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.*;

/**
 * @author icemeowzhi
 * @date 2021/9/3
 * @apiNote
 */
@Mod.EventBusSubscriber
public class FoodTagEffectLogic {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final CoolDown coolDown = new CoolDown(6000);//6000
    private static Map<FoodTag, PlayerFoodTagState> playerTagLike;
    private static Map<FoodTag, PlayerFoodTagState> playerTagDislike;
    private static List<FoodTag> foodTags;
    private static final Random random = new Random();
    //TODO:Logics
    //各种稀有度的效果
    //蛋糕等无进食速度设定的食物将直接调用start与finish方法
    public static void epicEffect(@Nullable LivingEntityUseItemEvent.Start startEvent,@Nullable LivingEntityUseItemEvent.Finish finishEvent){
        if (startEvent != null){
            PlayerEntity playerEntity = (PlayerEntity) startEvent.getEntity();

            //进食速度增加100%
            startEvent.setDuration((int) (startEvent.getDuration()*0.5));

            epicEffectStart(playerEntity);
        }
        if (finishEvent != null){
            PlayerEntity playerEntity = (PlayerEntity) finishEvent.getEntity();

            //回复额外50%饱食度
            int foodLevel = Objects.requireNonNull(finishEvent.getItem().getItem().getFood()).getHealing();
            float saturation = finishEvent.getItem().getItem().getFood().getSaturation();

            epicEffectFinish(playerEntity,foodLevel,saturation);
        }
    }

    public static void epicEffectStart(PlayerEntity playerEntity){

    }

    public static void epicEffectFinish(PlayerEntity playerEntity,int foodLevel,float saturation){
        //回复额外50%饱食度
        playerEntity.getFoodStats().addStats(foodLevel/2, saturation/2);

        //播放音效，给予随机三种状态，给予三十秒生命恢复，冷却5min
        if (!coolDown.isActive()){
            coolDown.startCoolDown();

            //播放音效
            NetworkHandler.INSTANCE.send(
                    PacketDistributor.PLAYER.with(
                            () -> (ServerPlayerEntity) playerEntity
                    ),
                    new SoundPack(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS,1f,1f));

            //给予随机三种状态
            EffectInstance effectInstance;
            switch (random.nextInt(3)){
                case 1:
                    effectInstance = new EffectInstance(Effects.SATURATION,
                            100,0,false,true,true);

                    break; case 2: effectInstance = new EffectInstance(Effects.LUCK,
                        2400,1,false,true,true);

                    break; default: effectInstance = new EffectInstance(Effects.ABSORPTION,
                        2400,0,false,true,true);
            }
            playerEntity.addPotionEffect(effectInstance);

            //生命恢复效果一分钟
            playerEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION,
                    600,0,false,true,true));

            playerEntity.sendStatusMessage(RandomText.getDefaultLike(true),true);
        }
    }


    //蛋糕等无进食速度设定的食物将直接调用start与finish方法
    public static void rareEffect(@Nullable LivingEntityUseItemEvent.Start startEvent,@Nullable LivingEntityUseItemEvent.Finish finishEvent){
        if (startEvent != null) {
            PlayerEntity playerEntity = (PlayerEntity) startEvent.getEntity();

            //进食速度增加50%
            startEvent.setDuration((int) (startEvent.getDuration()*0.66));

            rareEffectStart(playerEntity);
        }
        if (finishEvent != null) {
            PlayerEntity playerEntity = (PlayerEntity) finishEvent.getEntity();

            //回复额外50%饱食度
            int foodLevel = Objects.requireNonNull(finishEvent.getItem().getItem().getFood()).getHealing();
            float saturation = finishEvent.getItem().getItem().getFood().getSaturation();

            rareEffectFinish(playerEntity,foodLevel,saturation);
        }
    }

    public static void rareEffectStart(PlayerEntity playerEntity){

    }

    public static void rareEffectFinish(PlayerEntity playerEntity,int foodLevel,float saturation){
        //回复额外50%饱食度
        playerEntity.getFoodStats().addStats(foodLevel/2, saturation/2);

        //偶尔发送状态信息
        playerEntity.sendStatusMessage(RandomText.getDefaultLike(true),true);
    }


    //蛋糕等无进食速度设定的食物将直接调用start与finish方法
    public static void uncommonEffect(@Nullable LivingEntityUseItemEvent.Start startEvent,@Nullable LivingEntityUseItemEvent.Finish finishEvent){
        if (startEvent != null) {
            PlayerEntity playerEntity = (PlayerEntity) startEvent.getEntity();

            //进食速度增加50%
            startEvent.setDuration((int) (startEvent.getDuration()*0.66));

            uncommonEffectStart(playerEntity);
        }
        if (finishEvent != null) {
            PlayerEntity playerEntity = (PlayerEntity) finishEvent.getEntity();

            uncommonEffectFinish(playerEntity,0,0);
        }
    }

    public static void uncommonEffectStart(PlayerEntity playerEntity){

    }

    public static void uncommonEffectFinish(PlayerEntity playerEntity,int foodLevel,float saturation){

    }


    //蛋糕等无进食速度设定的食物将直接调用start与finish方法
    public static void commonEffect(@Nullable LivingEntityUseItemEvent.Start startEvent,@Nullable LivingEntityUseItemEvent.Finish finishEvent){
        if (startEvent != null) {
            PlayerEntity playerEntity = (PlayerEntity) startEvent.getEntity();

            //进食速度增加30%
            startEvent.setDuration((int) (startEvent.getDuration()*0.77));

            commonEffectStart(playerEntity);
        }
        if (finishEvent != null) {
            PlayerEntity playerEntity = (PlayerEntity) finishEvent.getEntity();

            commonEffectFinish(playerEntity,0,0);
        }
    }

    public static void commonEffectStart(PlayerEntity playerEntity){

    }

    public static void commonEffectFinish(PlayerEntity playerEntity,int foodLevel,float saturation){

    }


    //蛋糕等无进食速度设定的食物将直接调用start与finish方法
    public static void badEffect(@Nullable LivingEntityUseItemEvent.Start startEvent,@Nullable LivingEntityUseItemEvent.Finish finishEvent){
        if (startEvent != null) {
            PlayerEntity playerEntity = (PlayerEntity) startEvent.getEntity();

            //进食速度降低50%
            startEvent.setDuration((int) (startEvent.getDuration()*1.5));

            badEffectStart(playerEntity);
        }
        if (finishEvent != null) {
            PlayerEntity playerEntity = (PlayerEntity) finishEvent.getEntity();

            int foodLevel = Objects.requireNonNull(finishEvent.getItem().getItem().getFood()).getHealing();

            badEffectFinish(playerEntity,foodLevel,0,false);
        }
    }

    public static void badEffectStart(PlayerEntity playerEntity){

    }

    public static void badEffectFinish(PlayerEntity playerEntity,int foodLevel,float saturation,boolean isCake){
        boolean badEffect = false;
        List<ITextComponent> messages = new ArrayList<>();

        //有10%获得十秒反胃
        if (random.nextInt(10) == 1){
            badEffect = true;
            playerEntity.addPotionEffect(new EffectInstance(Effects.NAUSEA,
                    200,1,false,true,true));
        }

        //有30%不增加饱食度
        if (random.nextInt(10) < 3){
            if (!playerEntity.isCreative()){
                FoodStats foodStats = playerEntity.getFoodStats();
                foodStats.addStats(-foodLevel,0);

                //对非蛋糕类食物发同步包
                if (!isCake){
                    CompoundNBT nbt = new CompoundNBT();
                    foodStats.write(nbt);
                    NetworkHandler.INSTANCE.send(
                            PacketDistributor.PLAYER.with(
                                    () -> (ServerPlayerEntity) playerEntity
                            ),
                            new FoodStatSyncPack(nbt));
                }

                messages.add(RandomText.getNonHealMessage());
            }
        }

        if (badEffect){
            messages.add(RandomText.getDislike(true));
        }else if (random.nextInt(4)==1){
            messages.add(RandomText.getDislike(false));
        }

        for (ITextComponent message:messages){
            playerEntity.sendStatusMessage(message,true);
        }
    }


    @SubscribeEvent
    public static void onUseItemStart(LivingEntityUseItemEvent.Start event){

        if (event.getEntity().getEntityWorld().isRemote){return;}

        if (event.getEntity() instanceof PlayerEntity){
            ItemStack itemStack = event.getItem();
            PlayerEntity playerEntity = (PlayerEntity) event.getEntity();
            itemStack.getCapability(CapabilityHandler.FOOD_TAG_CAPABILITY).ifPresent((cap)->{
                foodTags = cap.getFoodTags();
            });
            playerEntity.getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY).ifPresent((cap)->{
                playerTagLike = cap.getLike();
                playerTagDislike = cap.getDisLike();
            });

            if (foodTags == null || playerTagLike == null || playerTagDislike == null){
                return;
            }

            for (FoodTag itemTag: foodTags){

                for (FoodTag playerTag : playerTagLike.keySet()){
                    if (itemTag.match(playerTag)){
                        switch (playerTagLike.get(playerTag).rarity){
                            case EPIC:
                                epicEffect(event,null);
                                break;
                            case RARE:
                                rareEffect(event,null);
                                break;
                            case UNCOMMON:
                                uncommonEffect(event,null);
                                break;
                            case COMMON:
                                commonEffect(event,null);
                                break;
                            default:
                        }
                    }
                }

                for (FoodTag playerTag : playerTagDislike.keySet()){
                    if (itemTag.match(playerTag)){
                        badEffect(event,null);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event){

        if (event.getEntity().getEntityWorld().isRemote){return;}

        if (event.getEntity() instanceof PlayerEntity){
            ItemStack itemStack = event.getItem();
            PlayerEntity playerEntity = (PlayerEntity) event.getEntity();
            itemStack.getCapability(CapabilityHandler.FOOD_TAG_CAPABILITY).ifPresent((cap)->{
                foodTags = cap.getFoodTags();
            });
            playerEntity.getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY).ifPresent((cap)->{
                playerTagLike = cap.getLike();
                playerTagDislike = cap.getDisLike();
            });

            if (foodTags == null || playerTagLike == null || playerTagDislike == null){
                return;
            }

            for (FoodTag itemTag: foodTags){

                for (FoodTag playerTag : playerTagLike.keySet()){
                    if (itemTag.match(playerTag)){
                        switch (playerTagLike.get(playerTag).rarity){
                            case EPIC:
                                epicEffect(null,event);
                                break;
                            case RARE:
                                rareEffect(null,event);
                                break;
                            case UNCOMMON:
                                uncommonEffect(null,event);
                                break;
                            case COMMON:
                                commonEffect(null,event);
                                break;
                            default:
                        }
                    }
                }

                for (FoodTag playerTag : playerTagDislike.keySet()){
                    if (itemTag.match(playerTag)){
                        badEffect(null,event);
                        return;
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event){
        coolDown.processCoolDown();
    }

}
